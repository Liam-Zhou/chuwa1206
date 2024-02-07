import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;

import java.util.Arrays;

public class KafkaHeadersExample {
    public static void main(String[] args) {
        String topic = "your_topic";
        String key = "your_key";
        String value = "your_value";

        // 创建 Header
        Header header = new RecordHeader("headerKey", "headerValue".getBytes());

        // 使用 Header 创建 ProducerRecord
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, null, key, value, Arrays.asList(header));

        System.out.println("Producer Record with Headers: " + record.headers());
    }
}
