import java.util.Properties;

public class KafkaPropertiesConfig {


    public static void main(String[] args) {
        Properties kafkaProperties = getKafkaProperties();
        System.out.println("Kafka Properties: " + kafkaProperties);
    }

    public static Properties getKafkaProperties() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return properties;
    }
}
