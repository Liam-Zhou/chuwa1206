package com.example.mongodbpost.service;
import com.example.mongodbpost.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
}

