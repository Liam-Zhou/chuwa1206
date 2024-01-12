package com.chuwa.cassandrablog.dao;

import com.chuwa.cassandrablog.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PostRepository extends CassandraRepository<Post, String> {

}
