package com.example.mongoblog.dao;

import com.example.mongoblog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
