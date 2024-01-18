package com.example.redbook.cassandra.dao;

import com.example.redbook.cassandra.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;


public interface PostRepository extends  CassandraRepository<Post, UUID>{
}
