package com.chuwa.learn.mongoblog.controller;

import com.chuwa.learn.mongoblog.model.BlogPost;
import com.chuwa.learn.mongoblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.createBlogPost(blogPost);
    }
}