# 🚀 Kafka Lab -- Spring Boot + Apache Kafka (Dockerized)

> Event-driven microservice demo using Spring Boot and Apache Kafka
> (Confluent Docker). Demonstrates REST-triggered message publishing,
> asynchronous consumer processing, and containerized Kafka setup.

------------------------------------------------------------------------

## 📌 Overview

This project demonstrates how to integrate **Spring Boot** with **Apache
Kafka** to build an event-driven backend system.

Flow:

Client → REST API → Kafka Producer → Kafka Topic → Kafka Consumer

The consumer processes messages asynchronously once published to the
topic.

------------------------------------------------------------------------

## 🏗 Architecture

Client\
↓\
Controller\
↓\
KafkaProducerService\
↓\
Kafka Topic\
↓\
KafkaConsumerService

------------------------------------------------------------------------

## 🛠 Tech Stack

-   Java 17
-   Spring Boot
-   Spring Kafka
-   Apache Kafka
-   Confluent Kafka Docker Image
-   Maven
-   Docker

------------------------------------------------------------------------

## 📂 Project Structure

src/main/java/com/learn/kafkademo1

-   controller/MessageController.java
-   service/KafkaProducerService.java
-   service/KafkaConsumerService.java
-   KafkaDemo1Application.java

------------------------------------------------------------------------

## 🐳 Kafka Setup (Docker)

### Start Zookeeper

``` bash
docker run -d --name zookeeper   -p 2181:2181   -e ZOOKEEPER_CLIENT_PORT=2181   confluentinc/cp-zookeeper
```

### Start Kafka

``` bash
docker run -d --name kafka   -p 9092:9092   -e KAFKA_ZOOKEEPER_CONNECT=host.docker.internal:2181   -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092   -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1   confluentinc/cp-kafka
```

------------------------------------------------------------------------

## 📌 Create Kafka Topic

``` bash
docker exec -it kafka bash

kafka-topics --create   --topic KafkaLabTopic   --bootstrap-server localhost:9092   --partitions 1   --replication-factor 1
```

List topics:

``` bash
kafka-topics --list --bootstrap-server localhost:9092
```

------------------------------------------------------------------------

## ⚙️ Application Configuration

### application.properties

``` properties
spring.kafka.bootstrap-servers=localhost:9092

# Producer
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer

# Consumer
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
```

------------------------------------------------------------------------

## 🚀 Run Application

``` bash
mvn spring-boot:run
```

------------------------------------------------------------------------

## 📤 API Usage

### Send Message

POST /api/send?message=HelloKafka

Example:

``` bash
curl -X POST "http://localhost:8080/api/send?message=HelloKafka"
```

Expected Console Output:

Sent: HelloKafka\
Received: HelloKafka

------------------------------------------------------------------------

## 🖥 Kafka CLI Commands

### List Topics

``` bash
kafka-topics --list --bootstrap-server localhost:9092
```

### Produce Message

``` bash
kafka-console-producer --topic KafkaLabTopic --bootstrap-server localhost:9092
```

### Consume Messages

``` bash
kafka-console-consumer --topic KafkaLabTopic --bootstrap-server localhost:9092 --from-beginning
```

------------------------------------------------------------------------

## ⚠️ Common Issues

### KafkaTemplate Bean Not Found

Make sure you added:

``` xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

### SerializationException

If you see:

No type information in headers and no default type provided

You are mixing JSON deserializer with String messages.

Fix: - Use StringSerializer + StringDeserializer - Or configure
JsonDeserializer properly

------------------------------------------------------------------------

## 🎯 Learning Outcomes

-   Event-driven architecture
-   Asynchronous processing
-   Kafka producer/consumer pattern
-   Consumer groups & offsets
-   Dockerized Kafka setup
-   Spring Boot + Kafka integration

------------------------------------------------------------------------

## 👨‍💻 Author

Mohamed Salah\
Software Engineer || Backend Developer
