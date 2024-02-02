package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorGraphQLController {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public AuthorDto getAuthorById(@Argument Long id) {
        return authorService.findById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument String bio) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(name);
        authorDto.setBio(bio);
        return authorService.create(authorDto);
    }

    @MutationMapping
    public AuthorDto updateAuthor(@Argument Long id, @Argument String name, @Argument String bio) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(id);
        authorDto.setName(name);
        authorDto.setBio(bio);
        return authorService.update(id, authorDto);
    }

    @MutationMapping
    public Boolean deleteAuthor(@Argument Long id) {
        authorService.delete(id);
        return true;
    }

    @QueryMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
