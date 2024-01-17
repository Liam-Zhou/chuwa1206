package com.example.mongoblog.mongoblogdemo.service.impl;

import com.example.mongoblog.mongoblogdemo.dao.PostRepository;
import com.example.mongoblog.mongoblogdemo.entity.Post;
import com.example.mongoblog.mongoblogdemo.payload.PostDto;
import com.example.mongoblog.mongoblogdemo.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post postToSave = new Post();

        postToSave.setTitle(postDto.getTitle());
        postToSave.setContent(postDto.getContent());
        postToSave.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(postToSave);

        PostDto newPostDto = new PostDto();
        newPostDto.setContent(savedPost.getContent());
        newPostDto.setDescription(savedPost.getDescription());
        newPostDto.setTitle(savedPost.getTitle());

        return newPostDto;
    }

}
