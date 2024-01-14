package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(this.authorService.getAllAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name="id") long id) {
        return ResponseEntity.ok(this.authorService.getAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(this.authorService.createAuthor(authorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updatedAuthorById(@RequestBody AuthorDto authorDto, @PathVariable(name="id") long id) {
        return ResponseEntity.ok(this.authorService.updateAuthor(authorDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable(name="id") long id) {
        this.authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Delete Successful", HttpStatusCode.valueOf(201));
    }

}
