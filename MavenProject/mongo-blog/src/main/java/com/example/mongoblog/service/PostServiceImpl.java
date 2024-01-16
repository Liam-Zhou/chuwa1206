package com.example.mongoblog.service;

import com.example.mongoblog.model.Post;
import com.example.mongoblog.payload.PostDto;
import com.example.mongoblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post saved = postRepository.save(new Post(postDto.getTitle(), postDto.getDescription(), postDto.getContent()));
        return new PostDto(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getContent());
    }
}
