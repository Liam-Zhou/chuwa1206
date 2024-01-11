package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorGraphQLController {
    @Autowired
    private AuthorService authorService;
    @MutationMapping
    public AuthorDto createAuthor(@Argument String name) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(name);
        return this.authorService.createAuthor(authorDto);
    }
    @QueryMapping
    public AuthorDto getAuthorById(@Argument long id) {
        return this.authorService.getAuthorById(id);
    }

    @QueryMapping
    public List<AuthorDto> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }
}
