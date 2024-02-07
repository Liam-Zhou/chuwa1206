import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    private static final Logger logger = LoggerFactory.getLogger(ProducerDemo.class);

    public static void main(String[] args) {
        logger.info("this is Kafka Demo Producer...");
        // a list of ports to init connection to kafka cluster -> "host:port,host:port,..."
        String bootstrapServers = "localhost:9092";

        // create producer properties: bsServer, serializer for keys and values
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // create a producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test-topic", "hello world");
        Header header1 = new RecordHeader("header-key1", "header-value1".getBytes());
        ProducerRecord<String, String> recordWithHeaders = new ProducerRecord<>(
                "test-topic", null, "message with headers", "key",
                new RecordHeaders().add(header1));
        // send(async)/flush(sync)/close - async
        producer.send(producerRecord);
        producer.send(recordWithHeaders);
        producer.flush();
        producer.close();
    }
}
