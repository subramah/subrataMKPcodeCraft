package com.codedecode.KafkaDemo.Controller;

import java.io.IOException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.KafkaDemo.model.User;
import com.codedecode.KafkaDemo.model.UserEvent;
import com.codedecode.KafkaDemo.model.UserSerializer;
import com.codedecode.KafkaDemo.service.UserKafkaProducer;

@RestController
@RequestMapping("/api/users")
public class UserController {

   
   
    @Autowired
    private  UserKafkaProducer userKafkaProducer;
    
   

    @PostMapping
    public void createUser(@RequestBody User user) throws IOException {
        // Save the user in the database

        // Publish a user created event to Kafka
    	UserEvent userEvent = new UserEvent(user.getId(), "CREATED", user);
    	
		userKafkaProducer.createUSer(userEvent);
       // kafkaTemplate.send("user-events",record);
    }
    

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable int userId, @RequestBody User user) {
        // Update the user in the database

        // Publish a user updated event to Kafka
    	UserEvent userEvent = new UserEvent(userId, "UPDATED", user);
       // kafkaTemplate.send("user-events", userEvent);
    }
}