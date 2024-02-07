/**
 * @author Alex D.
 */
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.errors.TopicExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;

public class TopicCreation {
    private static final Logger log = LoggerFactory.getLogger(TopicCreation.class);
    private static final String TOPIC_NAME = "topic1";
    private static final String BOOTSTRAP_SERVERS = "172.18.66.235:9092";

    public static void main(String[] args) {
        log.info("create a topic");

        Properties adminProps = new Properties();
        adminProps.put(org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        try (AdminClient adminClient = AdminClient.create(adminProps)) {
            // Create a new topic with replication factor 1 and 1 partition
            NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, (short) 1);
            adminClient.createTopics(Collections.singletonList(newTopic));
        } catch (TopicExistsException e) {
            System.out.println("Topic already exists: " + TOPIC_NAME);
        }
    }
}
