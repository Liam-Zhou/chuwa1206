package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(String id);
    PostDto updatePost(String id, PostDto postDto);
    void deletePost(String id);
}
