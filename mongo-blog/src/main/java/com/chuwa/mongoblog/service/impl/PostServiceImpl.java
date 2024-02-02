package com.chuwa.mongoblog.service.impl;

import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.payload.PostDto;
import com.chuwa.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = new Post();

        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setTitle(postDto.getTitle());

        Post saved = this.postRepository.save(tobeSaved);

        PostDto response = new PostDto();

        response.setContent(saved.getContent());
        response.setTitle(saved.getTitle());
        response.setId(saved.getId());

        return response;
    }
}
