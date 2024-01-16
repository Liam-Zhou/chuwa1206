package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    List<PostDto> getAllPostsJPQL();

    PostDto getPostByIdJPQLIndexParameter(long id, String title);

    PostDto getPostByIdJPQLNamedParameter(long id, String title);

    PostDto getPostByIdSQLIndexParameter(long id, String title);

    PostDto getPostByIdSQLNamedParameter(long id, String title);
}
