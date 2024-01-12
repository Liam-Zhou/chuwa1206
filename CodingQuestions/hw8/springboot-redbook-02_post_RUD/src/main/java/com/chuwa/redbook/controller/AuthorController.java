package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("api/v1/author"))
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createPost(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.createPost(authorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getByID(@PathVariable("id") long id) {
        return new ResponseEntity<>(authorService.getByID(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateByID(@PathVariable("id") long id, @RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.updateById(id, authorDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") long id) {
        authorService.deleteByID(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}

