package com.example.mongoblog.service.impl;

import com.example.mongoblog.Dto.BlogDto;
import com.example.mongoblog.model.GroceryItem;
import com.example.mongoblog.repository.ItemRepository;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    ItemRepository postRepository;

    @Override
    public BlogDto createPost(BlogDto blogDto) {
        GroceryItem newBlog = new GroceryItem(blogDto.getName(), blogDto.getContent());
        GroceryItem savedBlog = postRepository.save(newBlog);

        return new BlogDto(savedBlog.getName(), savedBlog.getContent());
    }
}
