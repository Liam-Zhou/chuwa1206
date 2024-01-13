package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto createdAuthorDto = this.authorService.createAuthor(authorDto);
        return ResponseEntity.ok(createdAuthorDto);
    }
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        List<AuthorDto> authorDtos = this.authorService.getAllAuthors();
        return ResponseEntity.ok(authorDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id")long id){
        AuthorDto authorDto = this.authorService.getAuthorById(id);
        return ResponseEntity.ok(authorDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto,@PathVariable(name = "id")long id){
        AuthorDto updatedAuthorDto = this.authorService.updateAuthorById(authorDto,id);
        return ResponseEntity.ok(updatedAuthorDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable(name = "id")long id){
        this.authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Deleted Successful");
    }
}
