package com.example.redbook;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;

import org.apache.kafka.common.header.Header;
import java.util.Collections;
import java.util.Properties;

public class KafkaTest {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC_NAME = "first_topic";

    public static void main(String[] args) {
        // Configure properties for Kafka
        Properties producerProperties = createProducerProperties();
        Properties consumerProperties = createConsumerProperties();

        // Create a Kafka topic
        createTopic();

        // Produce a message with headers
        produceMessage(producerProperties, "Hello, Kafka!", "HeaderKey", "HeaderValue");

        // Consume messages with headers
        consumeMessages(consumerProperties);
    }

    private static Properties createProducerProperties() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }

    private static Properties createConsumerProperties() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    private static void createTopic() {
        try (AdminClient adminClient = AdminClient.create(createProducerProperties())) {
            NewTopic newTopic = new NewTopic(TOPIC_NAME, 3, (short) 1);
            adminClient.createTopics(Collections.singletonList(newTopic));
        }
    }

    private static void produceMessage(Properties properties, String message, String headerKey, String headerValue) {
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, null, message);

            // Add header to the record
            record.headers().add(headerKey, headerValue.getBytes());

            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully! Topic: " + metadata.topic() +
                            ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                } else {
                    exception.printStackTrace();
                }
            });
        }
    }

    private static void consumeMessages(Properties properties) {
        try (Consumer<String, String> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(TOPIC_NAME));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                records.forEach(record -> {
                    Iterable<Header> headers = record.headers();
                    headers.forEach(header -> {
                        System.out.println("Header Key: " + header.key() +
                                ", Header Value: " + new String(header.value()));
                    });

                    System.out.println("Received message: " +
                            "Topic: " + record.topic() +
                            ", Partition: " + record.partition() +
                            ", Offset: " + record.offset() +
                            ", Key: " + record.key() +
                            ", Value: " + record.value());
                });
            }
        }
    }
}
