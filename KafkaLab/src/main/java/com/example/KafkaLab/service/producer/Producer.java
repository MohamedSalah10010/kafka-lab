package com.example.KafkaLab.service.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private  KafkaTemplate<String, String> kafkaTemplate;

	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String topic, String message) {
		logger.info("Sending message: {} to topic: {}", message, topic);
		kafkaTemplate.send(topic, message);
	}

}