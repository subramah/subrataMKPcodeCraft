package com.caps.scb.streams;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

public class KafkaStreamsExample {
    public static void main(String[] args) {
        // Set up properties
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-example");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

     // Create a StreamsBuilder
        StreamsBuilder builder = new StreamsBuilder();

        // Define the stream processing topology
        String inputTopic = "topic-sccb";  // Change this to your actual input topic
        KStream<String, String> inputStream = builder.stream(inputTopic);
        KStream<String, String> outputStream = inputStream.mapValues(value -> {
            String uppercaseValue = value.toUpperCase();
           // log.info("Received message: {}, Uppercase: {}", value, uppercaseValue);
            return uppercaseValue;
        });

        outputStream.to(inputTopic);  // Ensure the output topic is set correctly, could be the same or different topic

        // Build KafkaStreams object
        Topology topology = builder.build();
        KafkaStreams streams = new KafkaStreams(topology, config);

        // Start the KafkaStreams application
        streams.start();
        
        // Add a shutdown hook to gracefully close the application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    }


