package com.chuwa.redbook.services.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir)
    {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();

        PageRequest pageRequest= PageRequest.of(pageNo, pageSize, sort);

        Page<Post> pagePosts = this.postRepository.findAll(pageRequest);

        // get content for page object
        List<Post> posts = pagePosts.getContent();

        List<PostDto> postDtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse response = new PostResponse(postDtos, pageNo, pageSize, pagePosts.getTotalElements(), pagePosts.getTotalPages(), pagePosts.isLast());

        return response;

    }

    private PostDto mapToDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getDescription(), post.getContent());

    }

    @Override
    public PostDto getPostById(long id) {
        return convertEntityToDto(
                this.postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id))
        );
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = this.postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));
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
