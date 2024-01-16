package com.example.redbook.controller;

import com.example.redbook.payload.dto.PostDto;
import com.example.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostGraphQLController {

    private PostService postService;

    public PostGraphQLController(PostService postService) { this.postService = postService; }

    @QueryMapping
    public PostDto getPostById(@Argument Long id) { return this.postService.getPostById(id); }

    @QueryMapping
    public List<PostDto> getAllPosts() {
        System.out.println("post");
        return this.postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content) {
        PostDto postDto = new PostDto();

        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setContent(content);

        return this.postService.createPost(postDto);
    }


}
