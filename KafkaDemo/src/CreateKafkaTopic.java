import org.apache.kafka.clients.admin.AdminClientConfig;
import java.util.Collections;
import java.util.Properties;


public class CreateKafkaTopic {

    public static void main(String[] args) {
        String topicName = "your_topic";
        int partitions = 3;
        short replicationFactor = 1;

        createTopic(topicName, partitions, replicationFactor);
    }
    public static void createTopic(String topicName, int partitions, short replicationFactor) {
        Properties adminProperties = new Properties();
        adminProperties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        try (AdminClient adminClient = AdminClient.create(adminProperties)) {
            // 创建主题
            NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic " + topicName + " created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
