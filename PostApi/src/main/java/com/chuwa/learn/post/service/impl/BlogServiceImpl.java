package com.chuwa.learn.post.service.impl;

import com.chuwa.learn.post.dao.BlogRepository;
import com.chuwa.learn.post.entity.Blog;
import com.chuwa.learn.post.payload.BlogDto;
import com.chuwa.learn.post.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog tobeSaved = new Blog();
        tobeSaved.setId(blogDto.getId());
        tobeSaved.setContent(blogDto.getContent());
        tobeSaved.setTitle(blogDto.getTitle());
        tobeSaved.setDescription(blogDto.getDescription());
        Blog saved = this.blogRepository.save(tobeSaved);

        BlogDto response = new BlogDto();
        response.setId(saved.getId());
        response.setContent(saved.getContent());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());

        return response;
    }
}
