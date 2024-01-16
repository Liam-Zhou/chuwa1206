package com.example.mongoblog.service;

import com.example.mongoblog.payload.GroceryItemDto;

public interface PostService {
    GroceryItemDto createPost(GroceryItemDto postDto);
}
