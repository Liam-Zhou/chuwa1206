package com.example.redbook;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.schemabuilder.KeyspaceOptions;
import com.datastax.driver.core.schemabuilder.SchemaBuilder;
import com.datastax.driver.core.schemabuilder.SchemaStatement;
import org.apache.cassandra.db.Keyspace;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestkeySpace {
    Session sessoin;
    @Before
    public void init() {
        String host = "localhost";
        int port = 9042;
        Cluster cluster = Cluster.builder()
                .addContactPoint(host)
                .withPort(port)
                .build();
        sessoin = cluster.connect();
    }

    @Test
    public void findKeySpace() {
        List<KeyspaceMetadata> keyspaces = sessoin.getCluster().getMetadata().getKeyspaces();
        for (KeyspaceMetadata keyspace: keyspaces) {
            System.out.println(keyspace.getName());
        }
    }

    @Test
    public void createKeySpace() {
        Map<String, Object> replication = new HashMap<>();
        replication.put("class", "SimpleStrategy");
        replication.put("replication_factor", 1);

        KeyspaceOptions options = SchemaBuilder.createKeyspace("post")
                .ifNotExists()
                .with()
                .replication(replication);
        // Create a table based on the Post class
        SchemaStatement schemaStatement = SchemaBuilder.createTable("post", "posts")
                .ifNotExists()
                .addPartitionKey("id", DataType.uuid())
                .addColumn("title", DataType.text())
                .addColumn("description", DataType.text())
                .addColumn("content", DataType.text())
                .addColumn("createDateTime", DataType.timestamp())
                .addColumn("updateDateTime", DataType.timestamp());

        // Execute the keyspace creation
        sessoin.execute(options);

        // Pause for a moment to allow the keyspace creation to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Execute the table creation
        sessoin.execute(schemaStatement);
    }

}
