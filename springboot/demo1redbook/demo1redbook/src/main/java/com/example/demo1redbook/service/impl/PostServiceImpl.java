package com.example.demo1redbook.service.impl;

import com.example.demo1redbook.entity.Post;
import com.example.demo1redbook.dao.PostRepository;
import com.example.demo1redbook.payload.PostDto;
import com.example.demo1redbook.payload.PostResponse;
import com.example.demo1redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
/**
 * @author Alex D.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepository.save(post);

        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());

        return postResponse;
    }

    @Override
    public PostResponse getAllPost() {
        Sort sort = sortDir;
        PageRequest
    }
}
