package com.example.mongoblog.service;

import com.example.mongoblog.payload.BlogDto;

public interface BlogService {

    BlogDto createBlog(BlogDto blogDto);
}
