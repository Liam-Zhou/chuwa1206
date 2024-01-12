package com.chuwa.mongoblog.dao;


import com.chuwa.mongoblog.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, Long> {
    List<Post> findByContent(String content);

}
