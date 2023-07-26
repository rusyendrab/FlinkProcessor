package com.flink.serd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flink.domain.PosInvoice;
import org.apache.flink.api.common.serialization.AbstractDeserializationSchema;

import java.io.IOException;


public class PosDeserializationSchema extends AbstractDeserializationSchema<PosInvoice> {

    private static final long serialVersionUID = 1L;

    private transient ObjectMapper objectMapper;

    @Override
    public void open(InitializationContext context) {
        objectMapper = JsonMapper.builder().build().registerModule(new JavaTimeModule());
    }

    @Override
    public PosInvoice deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, PosInvoice.class);
    }

}
