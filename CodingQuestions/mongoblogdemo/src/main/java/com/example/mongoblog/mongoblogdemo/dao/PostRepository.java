package com.example.mongoblog.mongoblogdemo.dao;

import com.example.mongoblog.mongoblogdemo.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,Long> {

    @Query
    List<Post> findPostById(long id);
}
