package com.example.mongoblog.repository;

import com.example.mongoblog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{title:'?0'}")
    Post findByName(String name);

    @Query(value="{description:'?0'}", fields="{'title' : 1, 'content' : 1}")
    List<Post> findAll(String category);

    public long count();

}