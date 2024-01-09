package com.example.mongoblog.service.impl;

import com.example.mongoblog.dao.BlogRepository;
import com.example.mongoblog.entity.Blog;
import com.example.mongoblog.payload.BlogDto;
import com.example.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog newBlog = new Blog((blogDto.getName()), blogDto.getContent());
        Blog savedBlog = blogRepository.save(newBlog);

        return new BlogDto(savedBlog.getName(), savedBlog.getContent());
    }
}
