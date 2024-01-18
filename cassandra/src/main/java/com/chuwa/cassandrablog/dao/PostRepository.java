package com.chuwa.cassandrablog.dao;


import com.chuwa.cassandrablog.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;


public interface PostRepository extends CassandraRepository<Post, UUID> {
}
