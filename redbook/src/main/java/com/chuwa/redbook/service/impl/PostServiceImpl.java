package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
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

        //from DTO to Entity
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
        //from Entity to DTO
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost() {
        //Entity --> DTO
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
        //#1, get original Post
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //#2, update data
        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }

        if(postDto.getDescription() != null){
            //If this is another Entity
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        if(postDto.getTitle() != null){
            toBeUpdatePost.setTitle(postDto.getTitle());
        }

        //#3, re-save the updated Post entity
        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return convertEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }
}
