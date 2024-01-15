package com.chuwa.cassandrablog.service.impl;

import com.example.redbook.cassandra.dao.PostRepository;
import com.example.redbook.cassandra.entity.Post;
import com.example.redbook.cassandra.exception.ResourceNotFoundException;
import com.example.redbook.cassandra.payload.PostDto;
import com.example.redbook.cassandra.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post toBeSaved = mapToEntity(postDto);

        Post saved = this.postRepository.save(toBeSaved);

        return mapToDto(saved);
    }

    private PostDto mapToDto(Post saved) {
        PostDto postDto = new PostDto();

        postDto.setId(saved.getId());
        postDto.setTitle(saved.getTitle());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();

        post.setId(UUID.randomUUID());
        post.setTitle(postDto.getTitle());

        return post;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = this.postRepository.findAll();

        return postList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(UUID id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updateById(PostDto postDto, UUID id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        }

        Post saved = this.postRepository.save(post);

        return mapToDto(saved);
    }

    @Override
    public void deleteById(UUID id) {
        this.postRepository.deleteById(id);
    }
}
