package com.example.CassandraBlog.service;

import com.example.CassandraBlog.payload.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

    PostDto getPostById(UUID id);

    PostDto updatePostById(PostDto postDto, UUID id);

    void deletePostById(UUID id);
}
