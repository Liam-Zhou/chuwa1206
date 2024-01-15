package com.chuwa.cassandrablog.controller;

import com.example.redbook.cassandra.payload.PostDto;
import com.example.redbook.cassandra.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(this.postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(this.postService.getAllPosts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(this.postService.getPostById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updateById(@RequestBody PostDto postDto, @PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(this.postService.updateById(postDto, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id) {
        this.postService.deleteById(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }
}
