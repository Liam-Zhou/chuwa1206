package com.example.mongoblog.service;

import com.example.mongoblog.Dto.BlogDto;
import com.example.mongoblog.model.GroceryItem;
import com.example.mongoblog.repository.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */
public interface PostService {

    BlogDto createPost(BlogDto postDto);

}
