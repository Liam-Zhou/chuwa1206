/**
 * @author Alex D.
 */
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;
import java.time.Duration;

public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);
    private static final String TOPIC_NAME = "topic1";
    private static final String BOOTSTRAP_SERVERS = "172.18.66.235:9092";

    public static void main(String[] args) {
        log.info("I am a Kafka Consumer");

        Properties consumerProps = new Properties();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group1");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Create a consumer
        org.apache.kafka.clients.consumer.Consumer<String, String> consumer = new KafkaConsumer<>(consumerProps);

        // Subscribe the topic
        consumer.subscribe(Collections.singletonList(TOPIC_NAME));

        // Poll msg
        Boolean flag = true;
        while (flag) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, String> record : records) {
                org.apache.kafka.common.header.Headers headers = record.headers();
                for (org.apache.kafka.common.header.Header header : headers) {
                    System.out.println("Header Key: " + header.key() + "Header Val: " + new String(header.value()));
                }
//                System.out.println("Received message: " + record.value());
                if(record.value()==Integer.toString(4)){
                    flag=false;
                }
            }

        }
        consumer.close();
    }
}
