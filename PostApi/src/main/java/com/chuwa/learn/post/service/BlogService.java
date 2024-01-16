package com.chuwa.learn.post.service;
import com.chuwa.learn.post.payload.BlogDto;


public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
}