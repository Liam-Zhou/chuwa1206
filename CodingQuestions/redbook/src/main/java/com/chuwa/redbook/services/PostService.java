package com.chuwa.redbook.services;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;


public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
