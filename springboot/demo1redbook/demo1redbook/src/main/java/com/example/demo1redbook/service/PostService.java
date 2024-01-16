package com.example.demo1redbook.service;

import com.example.demo1redbook.payload.PostDto;
import com.example.demo1redbook.payload.PostResponse;

/**
 * @author Alex D.
 */
public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPost();
}
