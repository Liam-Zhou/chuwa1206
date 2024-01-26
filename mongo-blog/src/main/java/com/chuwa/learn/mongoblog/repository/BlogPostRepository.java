package com.chuwa.learn.mongoblog.repository;


import com.chuwa.learn.mongoblog.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
}