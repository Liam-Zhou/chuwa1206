package com.example.mongodbpost.dao;

import com.example.mongodbpost.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

