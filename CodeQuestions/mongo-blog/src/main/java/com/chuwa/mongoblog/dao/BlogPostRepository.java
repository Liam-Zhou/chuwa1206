package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
}
