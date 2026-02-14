package com.example.KafkaLab.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class Consumer {
Logger logger = Logger.getLogger(Consumer.class.getName());

@KafkaListener(topics = "KafkaLabTopic", groupId = "kafka-lab-group")
	public void consume(String message) {
		logger.info("Received message: "+message+ "from topic: KafkaLabTopic");
		System.out.println(  "Consumed message: " + message);
	}
}