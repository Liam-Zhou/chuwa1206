package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.BlogDto;


public interface BlogService {
    BlogDto createBlog(BlogDto blogDto);
}
