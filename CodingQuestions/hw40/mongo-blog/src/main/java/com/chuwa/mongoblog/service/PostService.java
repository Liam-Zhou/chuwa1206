package com.chuwa.mongoblog.service;



import com.chuwa.mongoblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

     PostDto getPostById(long id);
     PostDto updatePostById(PostDto postDto, long id);
     void removePostById(long id);
}
