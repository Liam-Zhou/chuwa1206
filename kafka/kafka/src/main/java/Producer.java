/**
 * @author Alex D.
 */
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;

import java.util.Properties;

public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC_NAME = "topic1";
    private static final String BOOTSTRAP_SERVERS = "172.18.66.235:9092";


    public static void main(String[] args) {
        log.info("I am a Kafka Producer");

        // create Producer properties
        Properties producerProps = new Properties();
        producerProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a producer
        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(producerProps);

        // Produce msg
        for (int i = 0; i < 5; i++) {
            String message = "Message " + i;
            // Create headers
            Headers headers = new RecordHeaders();
            headers.add(new RecordHeader("HeaderKey", ("HeaderValue " + i).getBytes()));

            // Create a ProducerRecord with headers
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, null, message, Integer.toString(i), headers);

            // Send
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Message sent successfully. Offset: " + metadata.offset());
                    } else {
                        System.err.println("Error sending message: " + exception.getMessage());
                    }
                }
            });
        }
        producer.close();
    }
}
