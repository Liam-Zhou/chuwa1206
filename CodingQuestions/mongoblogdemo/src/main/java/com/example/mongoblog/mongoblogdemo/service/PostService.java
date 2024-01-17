package com.example.mongoblog.mongoblogdemo.service;

import com.example.mongoblog.mongoblogdemo.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
