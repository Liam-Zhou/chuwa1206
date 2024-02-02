package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostJpaDto;
import com.chuwa.redbook.service.PostJpaService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PostController {

    @Autowired
    private PostJpaService postJpaService;

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody PostJpaDto postDto) {
        try {
            PostJpaDto postResponse = postJpaService.createPost(postDto);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            String error = "A post with the same information already exists.";
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

}
