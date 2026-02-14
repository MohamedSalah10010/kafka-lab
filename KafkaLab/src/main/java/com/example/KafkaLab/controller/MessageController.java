package com.example.KafkaLab.controller;

import com.example.KafkaLab.service.consumer.Consumer;
import com.example.KafkaLab.service.producer.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	private Producer producer;
	public MessageController(Producer producer) {
		this.producer = producer;

	}

	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		producer.sendMessage("KafkaLabTopic",message);
		return ResponseEntity.ok().body(message);
	}


}