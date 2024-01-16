package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

    PostDto getPostById(long id);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatePostById(PostDto postDto, long id);



    void deletePostById(long id);
}
