package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);

    <PostResponse> PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
