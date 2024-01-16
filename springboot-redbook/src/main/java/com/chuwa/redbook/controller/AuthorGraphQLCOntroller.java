package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Controller
public class AuthorGraphQLController {

    private AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument Integer age, @Argument String biography) {
        AuthorDto tobeSaved = new AuthorDto();

        tobeSaved.setName(name);
        if (age != null) {
            tobeSaved.setAge(age);
        }
        if (biography != null) {
            tobeSaved.setBiography(biography);
        }

        return authorService.createAuthor(tobeSaved);
    }

    @QueryMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public AuthorDto getAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public String deleteAuthorById(@Argument Long id) {
        authorService.deleteAuthorById(id);
        return "Delete Successfully";
    }
}