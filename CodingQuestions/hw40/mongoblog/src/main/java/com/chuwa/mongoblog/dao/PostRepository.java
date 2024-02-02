package com.chuwa.mongoblog.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,Long> {

    @Query
    List<Post> findPostById(long id);
}