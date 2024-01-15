package com.chuwa.redbook.controller;


import com.chuwa.redbook.DAO.AuthorRepository;
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
    AuthorService authorService;

    @QueryMapping
    List<AuthorDto> getAllAuthors() {
        return authorService.getAuthors();
    }

    @QueryMapping
    AuthorDto getAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    AuthorDto createAuthor(@Argument AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @MutationMapping
    String deleteAuthorById(@Argument Long id) {
        authorService.deleteAuthorById(id);
        return "Deleted";
    }





}
