package com.chuwa.redbook.dao.mongo;

import com.chuwa.redbook.entity.PostMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// For MongoDB
@Repository
public interface PostMongoRepository extends MongoRepository<PostMongo, String> {
    // MongoDB-specific operations
}