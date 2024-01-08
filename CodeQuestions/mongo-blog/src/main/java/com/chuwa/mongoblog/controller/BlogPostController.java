package com.chuwa.mongoblog.controller;

import com.chuwa.mongoblog.dao.BlogPostRepository;
import com.chuwa.mongoblog.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BlogPostController {
    @Autowired
    private BlogPostRepository repository;

    @PostMapping("/blogposts")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost){
        return repository.save(blogPost);
    }
}
