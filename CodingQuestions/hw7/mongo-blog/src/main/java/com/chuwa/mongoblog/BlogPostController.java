package com.chuwa.mongoblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository repository;

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return repository.save(blogPost);
    }
}