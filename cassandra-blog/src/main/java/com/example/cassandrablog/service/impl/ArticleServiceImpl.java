package com.example.cassandrablog.service.impl;

import com.chuwa.redbook.service.impl.RecourceNotFoundException;
import com.example.cassandrablog.dao.ArticleRepository;
import com.example.cassandrablog.entity.Article;
import com.example.cassandrablog.payload.ArticleDto;
import com.example.cassandrablog.service.ArticleService;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        Article article = convertDtoToEntity(articleDto);
        Article save = this.articleRepository.save(article);
        ArticleDto response = convertEntityToDto(save);

        return response;
    }

    private ArticleDto convertEntityToDto(Article save) {
        ArticleDto response = new ArticleDto();
        response.setId(save.getId());
        response.setContent(save.getContent());
        response.setTitle(save.getTitle());

        return response;
    }

    private Article convertDtoToEntity(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        return article;
    }

    @Override
    public List<ArticleDto> getAllArticle() {
        Iterable<Article> articlesIte = this.articleRepository.findAll();
        Stream<Article> stream = StreamSupport.stream(articlesIte.spliterator(), false);
        List<Article> articles = stream.collect(Collectors.toList());
        List<ArticleDto> res = articles.stream()
                .map(article -> convertEntityToDto(article))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public ArticleDto updateArticle(ArticleDto articleDto, long id) {
        Article article = this.articleRepository.findById(id).orElseThrow(() -> new RecourceNotFoundException("Article", "id", id));

        if(articleDto.getTitle() != null)
            article.setTitle(articleDto.getTitle());
        if(articleDto.getContent() != null)
            article.setContent(articleDto.getContent());
        Article saved = this.articleRepository.save(article);
        return convertEntityToDto(saved);
    }

    @Override
    public void deleteArticle(long id) {
        this.articleRepository.deleteById(id);
    }
}
