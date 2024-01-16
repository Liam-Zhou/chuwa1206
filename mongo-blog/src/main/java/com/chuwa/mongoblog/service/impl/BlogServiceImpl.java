package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.BlogRepository;
import com.chuwa.mongoblog.entity.Blog;
import com.chuwa.mongoblog.payload.BlogDto;
import com.chuwa.mongoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setContent(blogDto.getContent());
        blog.setTitle(blogDto.getTitle());
        blog.setId(UUID.randomUUID());

        Blog saved = blogRepository.save(blog);

        BlogDto response = new BlogDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setContent(saved.getContent());

        return response;
    }
}
