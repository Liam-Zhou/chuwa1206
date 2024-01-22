package com.example.redbook.service.impl;

import com.example.redbook.dao.PostRepo;
import com.example.redbook.entity.Post;
import com.example.redbook.payload.PostDto;
import com.example.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex D.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post postTobeSaved = new Post();
        // the incoming PostDto does not have id;
        // so we don't set id;
        postTobeSaved.setTitle(postDto.getTitle());
        postTobeSaved.setDescription(postDto.getDescription());
        postTobeSaved.setContent(postDto.getContent());

        // do the communication with db in postRepo.
        Post saved = this.postRepo.save(postTobeSaved);

        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());

        return response;
    }
}
