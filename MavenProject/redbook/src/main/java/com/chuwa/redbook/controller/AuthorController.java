package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto, @PathVariable Long id) {
        return new ResponseEntity<>(authorService.updateAuthorById(authorDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
