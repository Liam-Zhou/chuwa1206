package com.chuwa.mongoblog.service;


import com.chuwa.mongoblog.dao.PostRepository;
import com.chuwa.mongoblog.entity.Post;
import com.chuwa.mongoblog.exception.ResourceNotFoundException;
import com.chuwa.mongoblog.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post(postDto);
        Post newpost=postRepository.save(post);
        PostDto postResponse=new PostDto(newpost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts=postRepository.findAll();
        List<PostDto> postDtos=posts.stream().map(PostDto::new).toList();
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        PostDto postDto=postRepository.findById(id)
                .map(PostDto::new)
                .orElseThrow(()-> new ResourceNotFoundException("posts","id",id));

        return postDto;
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("posts","id",id));
        post.updatePost(postDto);
        postRepository.save(post);
        return new PostDto(post);
    }

    @Override
    public void removePostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("posts","id",id));
        postRepository.deleteById(id);
    }


}
