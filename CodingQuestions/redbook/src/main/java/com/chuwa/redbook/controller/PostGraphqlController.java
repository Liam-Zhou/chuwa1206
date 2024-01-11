package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.services.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class PostGraphqlController {
    private PostService postService;

    public PostGraphqlController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto getPostById(@Argument long id){
        return this.postService.getPostById(id);
    }

    @QueryMapping
    public List<PostDto> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto();

        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setContent(content);

        return this.postService.createPost(postDto);
    }



}
