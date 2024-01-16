package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDTOtoEntity(postDto);
        Post saved = this.postRepository.save(tobeSaved);

        return convertEntityToDTO(saved);
    }

    private static PostDto convertEntityToDTO(Post saved) {
        PostDto response = new PostDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setContent(saved.getContent());
        response.setDescription(saved.getDescription());
        return response;
    }

    private static Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(PostServiceImpl::convertEntityToDTO).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        return convertEntityToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        toBeUpdatePost.setDescription(postDto.getDescription());
        toBeUpdatePost.setContent(postDto.getContent());
        toBeUpdatePost.setTitle(postDto.getTitle());
        Post updatedPost = this.postRepository.save(toBeUpdatePost);
        return convertEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }
}
