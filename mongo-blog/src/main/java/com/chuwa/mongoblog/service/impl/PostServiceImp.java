package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setId(postDto.getId());
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());

        Post saved = postRepository.save(tobeSaved);

        PostDto response = new PostDto();
        response.setContent(saved.getContent());
        response.setDescription(saved.getDescription());
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        return response;
    }
}
