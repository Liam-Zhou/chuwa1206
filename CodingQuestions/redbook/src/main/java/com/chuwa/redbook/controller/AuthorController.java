package com.chuwa.redbook.controller;


import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(this.authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(this.authorService.getAuthorById(id));

    }


    @PostMapping()
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){

        return new ResponseEntity<>(this.authorService.createAuthor(authorDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}") ResponseEntity<AuthorDto> updateAuthor(@PathVariable(name="id") long id, @RequestBody AuthorDto authorDto){
        AuthorDto updatedAuthor = this.authorService.updateAuthor(authorDto, id);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}") ResponseEntity<String> deleteAuthor(@PathVariable(name="id") long id){
        this.authorService.deleteAuthor(id);

        return ResponseEntity.ok("Author " + id + " deleted");
    }



}
