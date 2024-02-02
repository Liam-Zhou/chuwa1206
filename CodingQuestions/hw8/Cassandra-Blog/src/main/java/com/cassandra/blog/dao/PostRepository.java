package com.cassandra.blog.dao;

import com.cassandra.blog.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends CassandraRepository<Post, UUID> {
    // Spring Data provides CRUD methods out-of-the-box
}
