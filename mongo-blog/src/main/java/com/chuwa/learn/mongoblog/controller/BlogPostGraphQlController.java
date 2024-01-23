package com.chuwa.learn.mongoblog.controller;

import com.chuwa.learn.mongoblog.model.BlogPost;
import com.chuwa.learn.mongoblog.service.BlogPostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public class BlogPostGraphQlController {
    private BlogPostService blogPostService;

    public BlogPostGraphQlController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @MutationMapping
    public BlogPost createPost(BlogPost blogPost){
        this.blogPostService.createBlogPost(blogPost);
        return blogPost;
    }
}
