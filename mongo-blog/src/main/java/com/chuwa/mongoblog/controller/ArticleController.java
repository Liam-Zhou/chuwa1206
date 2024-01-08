package com.chuwa.mongoblog.controller;



import com.chuwa.mongoblog.payload.ArticleDto;
import com.chuwa.mongoblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDto> createPost(@RequestBody ArticleDto articleDto) {
        ArticleDto response = this.articleService.createArticle(articleDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
