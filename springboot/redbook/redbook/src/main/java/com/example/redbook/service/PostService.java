package com.example.redbook.service;

import com.example.redbook.payload.PostDto;
/**
 * @author Alex D.
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
}
