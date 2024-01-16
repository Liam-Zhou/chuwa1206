package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorGraphQLController {
    private AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public AuthorDto getAuthorById(@Argument long id) {
        return this.authorService.getAuthorById(id);
    }

    @QueryMapping
    public List<AuthorDto> getAllAuthor() {
        return this.authorService.getAllAuthors();
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument String email) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName(name);
        authorDto.setEmail(email);

        return this.authorService.createAuthor(authorDto);
    }
}
