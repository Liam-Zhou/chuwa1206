package com.chuwa.redbook.services.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.services.PostService;
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
        Post post = convertDTOtoEntity(postDto);

        Post saved = this.postRepository.save(post);

        // from DTO to Entity
        PostDto postResponse = convertEntityToDto(saved);
        return postResponse;

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        var result = posts.stream()
                .map(post -> convertEntityToDto(post))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public PostDto getPostById(long id) {
        return convertEntityToDto(
                this.postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException())
        );
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = this.postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
        if (postDto.getContent() != null){
            post.setContent(postDto.getContent());
        }

        if (postDto.getDescription() != null){
            post.setDescription(postDto.getDescription());
        }

        if (postDto.getTitle() != null){
            post.setTitle(postDto.getTitle());

        }

        Post updatedPost = this.postRepository.save(post);
        return convertEntityToDto(updatedPost);
    }

    @Override
    public void deletePost(long id) {
        getPostById(id);
        this.postRepository.deleteById(id);
    }

    private static PostDto convertEntityToDto(Post saved) {
        PostDto postResponse = new PostDto();
        postResponse.setId(saved.getId());
        postResponse.setTitle(saved.getTitle());
        postResponse.setDescription(saved.getDescription());
        postResponse.setContent(saved.getContent());
        return postResponse;
    }

    private static Post convertDTOtoEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


}
