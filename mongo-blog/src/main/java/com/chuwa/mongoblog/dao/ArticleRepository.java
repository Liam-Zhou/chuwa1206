package com.chuwa.mongoblog.dao;

import com.chuwa.mongoblog.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, Long> {
}
