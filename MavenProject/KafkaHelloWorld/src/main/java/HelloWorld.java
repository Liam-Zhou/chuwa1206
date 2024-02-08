import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.info("Hello World");
        // Set Kafka broker properties
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // Create AdminClient
        try (AdminClient adminClient = AdminClient.create(properties)) {
            // Define the topic name, number of partitions, and replication factor
            String topicName = "test-topic";
            int numPartitions = 3;
            short replicationFactor = 1; // Change this as per your requirement

            // Create NewTopic object
            NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);

            // Create topic
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic created successfully.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error creating topic: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
