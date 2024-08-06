package com.codedecode.KafkaDemo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.codedecode.KafkaDemo.model.UserEvent;

@Service
public class UserEventConsumer {

    @KafkaListener(topics = "user-events", groupId = "user-group")
    public void consumeUserEvent(@Payload String userEvent) {
        // Process the user event (e.g., update internal state, trigger other actions)
        System.out.println("Received user event: " + userEvent);
    }
}

