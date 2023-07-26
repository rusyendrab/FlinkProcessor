package com.flink;

import com.flink.common.Constants;
import com.flink.mapper.PosMapper;
import com.flink.serd.PosDeserializationSchema;
import com.flink.domain.PosInvoice;
import com.flink.domain.PosInvoiceFlat;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.util.List;
/**
 * This service connects to Kafka topic pulls messages from stream, flattens the incoming JSON message
 * and stores into Postgres database.
 * */
public class Main extends Constants {
    public static void main(String[] args) throws Exception{
        /**
         * Get Stream Execution Environment and create Kafka Source to read messages from Kafka Source
         * */
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        KafkaSource<PosInvoice> source =
                KafkaSource.<PosInvoice>builder()
                        .setBootstrapServers(Constants.BROKERS)
                        .setProperty(partitionDiscoveryInterval, partitionDiscoveryIntervalMS)
                        .setTopics(TOPIC)
                        .setGroupId(GroupId)
                        //.setStartingOffsets(OffsetsInitializer.earliest())
                        .setStartingOffsets(OffsetsInitializer.latest())
                        .setValueOnlyDeserializer(new PosDeserializationSchema())
                        .build();

        DataStreamSource<PosInvoice> kafkaPosi =
                env.fromSource(source, WatermarkStrategy.noWatermarks(), KafkaPosInvoiceSource);
        /**
         * Read JSON message from Kafka Topic and pass on the message to processElement method
         * In Process Element method convert the incoming Point of Sale(POS) Incoming JSON message
         * Flatten the message.
         *  JSON have Point of sale Invoice details.
         *      Address Object
         *      List of Line items objects
         * Flatten the message to one single flat message.
         *  - Flattened Address object is added to message
         *  - For each LineItem object create a new message with all message details. pos invoice, address and each line item as one message
         *  - One input message will be converted to many messages, count equal to the number of line items.
         *  - In process Element add each of the flattened message to collector
         *  - All the flattened messages are kafkaPosiFlat which is used in JdbcSink to add messages to Postgress database.
         * */
        SingleOutputStreamOperator<PosInvoiceFlat> kafkaPosiFlat = kafkaPosi.process(
                new ProcessFunction<PosInvoice, PosInvoiceFlat>() {
                    @Override
                    public void processElement(PosInvoice posInvoice, ProcessFunction<PosInvoice,
                            PosInvoiceFlat>.Context context,
                                               Collector<PosInvoiceFlat> collector) throws Exception {

                        List<PosInvoiceFlat> posInvoiceFlatList = new PosMapper().flattenPosInvoice(posInvoice);
                        posInvoiceFlatList.forEach(item -> collector.collect(item) );
                    }
                });
        /**
         * JdbcSink Connector to store records in Postgress database
         * */
        kafkaPosiFlat.addSink(JdbcSink.sink(
                "insert into poslineitem (InvoiceNumber,CreatedTime,StoreID,PosID,CashierID," +
                        "CustomerType,CustomerCardNo,TotalAmount," +
                        "NumberOfItems,PaymentMethod,TaxableAmount,CGST,SGST,CESS,DeliveryType," +
                        "AddressLine,City,State,PinCode,ContactNumber,ItemCode,ItemDescription,ItemPrice,ItemQty,TotalValue) " +
                        "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                (statement, event) -> {
                    statement.setString(1, event.getInvoiceNumber());
                    statement.setInt(2, event.getCreatedTime().intValue());
                    statement.setString(3, event.getStoreID());
                    statement.setString(4, event.getPosID());
                    statement.setString(5, event.getCashierID());
                    statement.setString(6, event.getCustomerType());
                    statement.setString(7, event.getCustomerCardNo());
                    statement.setDouble(8, event.getTotalAmount());
                    statement.setInt(9, event.getNumberOfItems());
                    statement.setString(10, event.getPaymentMethod());
                    statement.setDouble(11, event.getTaxableAmount());
                    statement.setDouble(12, event.getCGST());
                    statement.setDouble(13, event.getSGST());
                    statement.setDouble(14, event.getCESS());
                    statement.setString(15, event.getDeliveryType());
                    statement.setString(16, event.getAddressLine());
                    statement.setString(17, event.getCity());
                    statement.setString(18, event.getState());
                    statement.setString(19, event.getPinCode());
                    statement.setString(20, event.getContactNumber());
                    statement.setString(21, event.getItemCode());
                    statement.setString(22, event.getItemDescription());
                    statement.setDouble(23, event.getItemPrice());
                    statement.setInt(24, event.getItemQty());
                    statement.setDouble(25, event.getTotalValue());
                },
                JdbcExecutionOptions.builder()
                        .withBatchSize(1000)
                        .withBatchIntervalMs(200)
                        .withMaxRetries(5)
                        .build(),
                new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
                        .withUrl(postgressURL)
                        .withDriverName(postgressDriver)
                        .withUsername(postgressUser)
                        .withPassword(postgressPassword)
                        .build()
        ));
        env.execute(jobName);
    }
}