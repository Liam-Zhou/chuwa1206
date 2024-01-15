package com.example.CassandraBlog.service;


import com.example.CassandraBlog.entity.Post;
import com.example.CassandraBlog.repository.PostRepository;
import com.example.CassandraBlog.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDtotoEntity(postDto);
        tobeSaved.setId(UUID.randomUUID());

        Post saved = this.postRepository.save(tobeSaved);
        PostDto response = convertEntitytoDto(saved);
        return response;
    }

    private static Post convertDtotoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());
        return tobeSaved;
    }

    private static PostDto convertEntitytoDto(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setContent(saved.getContent());
        response.setTitle(saved.getTitle());
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
    public List<PostDto> getAllPost() {
        
        // Entity --> DTO
        List<Post> posts = (List<Post>) this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(PostServiceImpl::convertEntitytoDto).collect(Collectors.toList());
        return postDtos;

    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertEntitytoDto(post);
    }


    @Override
    public PostDto updatePostById(PostDto postDto, UUID id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if (postDto.getContent() != null) {
            toBeUpdatePost.setContent(postDto.getContent());

        }
        toBeUpdatePost.setDescription(postDto.getDescription());
        toBeUpdatePost.setTitle(postDto.getTitle());
        Post updatedPost = this.postRepository.save(toBeUpdatePost);
        return convertEntitytoDto(updatedPost);
    }

    @Override
    public void deletePostById(UUID id) {
        this.postRepository.deleteById(id);
    }


}
