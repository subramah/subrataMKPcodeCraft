package com.codedecode.KafkaDemo.service;

import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.codedecode.KafkaDemo.model.UserEvent;
import com.codedecode.KafkaDemo.model.UserSerializer;

@Service
public class UserKafkaProducer {

//	@Autowired
//	 private  KafkaTemplate<String, UserEvent> kafkaTemplate;
	
	
//	public void sendMessageToTopic(String message) {
//		kafkaTemplate.send("CodeDecodeTopic", message);
//	}
//
//	public void sendUserMessageToTopic(String message) {
//		kafkaTemplate.send("user-events", message);
//	}
	
	private final Producer<String, byte[]> producer;
	private final String topic;
	
	public UserKafkaProducer() {
		
		Properties props = new Properties();
		//props.put(ProducerConfig.CLIENT_ID_CONFIG, props);
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Set your Kafka broker(s)
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.ByteArraySerializer");
		//this.kafkaTemplate = null;
 
		this.producer = new KafkaProducer<>(props);
		this.topic = "user-events";
	}

	public void createUSer(UserEvent userEvent) throws IOException {
		// TODO Auto-generated method stub
		 byte[] employeeBytes = new UserSerializer().serialize(userEvent);
		ProducerRecord<String, byte[]> record = new ProducerRecord<>(topic, employeeBytes);
		producer.send(record);
		
	}
	
	
	
}
