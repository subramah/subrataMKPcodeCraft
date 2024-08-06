package com.codedecode.KafkaDemo.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserSerializer {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	 
    public byte[] serialize(UserEvent userEvent) throws IOException {
        return objectMapper.writeValueAsBytes(userEvent);
    }
}
