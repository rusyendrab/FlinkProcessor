package com.flink.common;

public class Constants {
    public static final String TOPIC = "events";
    public static final String BROKERS = "localhost:9092";
    public static final String GroupId = "events-group";
    public static final String partitionDiscoveryInterval = "partition.discovery.interval.ms";
    public static final String partitionDiscoveryIntervalMS = "10000";
    public static final String KafkaPosInvoiceSource = "PosInvoiceSource";
    public static final String postgressURL = "jdbc:postgresql://localhost:5432/pos";
    public static final String postgressDriver = "org.postgresql.Driver";
    public static final String postgressUser = "docker";
    public static final String postgressPassword = "docker";
    public static final String jobName = "Kafka2postgres";

}
