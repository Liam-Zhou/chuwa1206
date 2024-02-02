package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostMongoDto;
import com.chuwa.redbook.service.PostMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Diana
 */
@RestController
@RequestMapping("/api/v1")
public class PostMongoController {

    @Qualifier("postMongoServiceImpl")
    @Autowired
    private PostMongoService postService;

    @PostMapping("/posts_mongo")
    public ResponseEntity<?> createPost(@RequestBody PostMongoDto postDto) {
        try {
            PostMongoDto postResponse = postService.createPost(postDto);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            String error = "A post with the same information already exists.";
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
