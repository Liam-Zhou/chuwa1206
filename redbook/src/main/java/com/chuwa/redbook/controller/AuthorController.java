package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable long id) {
        AuthorDto response = this.authorService.getAuthorById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto, @PathVariable long id) {
        AuthorDto response = this.authorService.updateAuthorById(authorDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable long id) {
        this.authorService.deleteAuthorById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
         return new ResponseEntity<>(this.authorService.getAllAuthors(), HttpStatus.OK);
    }

}
