package com.example.cassandrablog.service;

import com.example.cassandrablog.payload.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto createArticle(ArticleDto articleDto);
    List<ArticleDto> getAllArticle();
    ArticleDto updateArticle(ArticleDto articleDto, long id);
    void deleteArticle(long id);

}
