package com.example.cassandrablog.controller;

import com.example.cassandrablog.payload.ArticleDto;
import com.example.cassandrablog.service.ArticleService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getAllArticles(){
        List<ArticleDto> articles = this.articleService.getAllArticle();
        return ResponseEntity.ok(articles);
    }

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        ArticleDto article = this.articleService.createArticle(articleDto);
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable(name="id") long id, @RequestBody ArticleDto articleDto) {
        ArticleDto res = this.articleService.updateArticle(articleDto, id);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable long id) {
        this.articleService.deleteArticle(id);
        return new ResponseEntity("successfully delete", HttpStatusCode.valueOf(200));
    }
}

