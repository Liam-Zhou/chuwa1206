package com.chuwa.learn.post.controller;
import com.chuwa.learn.post.payload.BlogDto;
import com.chuwa.learn.post.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto){
        BlogDto response = this.blogService.createBlog(blogDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}