package com.example.KafkaLab.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
	public NewTopic testTopicConfig()
	{
		return TopicBuilder.name("KafkaLabTopic")
				.partitions(3)
				.replicas(1)
				.build();
	}
}