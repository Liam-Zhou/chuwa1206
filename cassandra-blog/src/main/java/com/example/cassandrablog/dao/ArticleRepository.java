package com.example.cassandrablog.dao;

import com.example.cassandrablog.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
