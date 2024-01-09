package com.example.mongoblog.controller;


import com.example.mongoblog.payload.BlogDto;
import com.example.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping()
    public BlogDto createBlog(@RequestBody BlogDto blogDto){
        return this.blogService.createBlog(blogDto);
    }

}
