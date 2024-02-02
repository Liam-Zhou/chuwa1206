package com.example.hw8.service.Impl;

import com.example.hw8.dao.PostRepository;
import com.example.hw8.entity.Post;
import com.example.hw8.payload.PostDto;
import com.example.hw8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        PostDto response = convertEntityToDTO(saved);

        return response;
    }

    private PostDto convertEntityToDTO(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> convertEntityToDTO(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return convertEntityToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }

        if(postDto.getDescription() != null){
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        if(postDto.getTitle() != null){
            toBeUpdatePost.setTitle(postDto.getTitle());
        }

        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return convertEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }
}
