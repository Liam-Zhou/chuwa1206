package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostGraphQLController {
    private PostService postService;
    public PostGraphQLController(PostService postService){
        this.postService=postService;
    }
    
    @QueryMapping
    public PostDto getPostById(@Argument long id){
        return postService.getPostById(id);
    }
    
    @QueryMapping
    public List<PostDto> getAllPost(){
        return postService.getAllPost();
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        return postService.createPost(new PostDto(content,description,title));
    }

    @MutationMapping
    public String removePostById(@Argument long id){
        postService.removePostById(id);
        return "successfully deleted";
    }
}
