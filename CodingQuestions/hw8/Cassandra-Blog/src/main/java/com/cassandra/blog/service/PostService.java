package com.cassandra.blog.service;

import com.cassandra.blog.payload.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(UUID id);
    List<PostDto> getAllPosts();
    PostDto updatePost(UUID id, PostDto postDto);
    void deletePost(UUID id);
}
