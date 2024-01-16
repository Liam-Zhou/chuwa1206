package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @RequestMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<>(this.postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(this.postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        PostDto postResponse = this.postService.updatePost(postDto,id);

        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") long id){
        this.postService.deletePostById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
