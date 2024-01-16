package com.example.CassandraBlog.controller;

import com.example.CassandraBlog.payload.PostDto;
import com.example.CassandraBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost() {
        return new ResponseEntity<>(this.postService.getAllPost(), HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") UUID id) {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") UUID id) {
        PostDto response = this.postService.updatePostById(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") UUID id) {
        this.postService.deletePostById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
