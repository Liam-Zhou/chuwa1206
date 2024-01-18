package com.chuwa.cassandrablog.service;


import com.chuwa.cassandrablog.payload.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(UUID id);
    PostDto updateById(PostDto postDto, UUID id);
    void deleteById(UUID id);
}
