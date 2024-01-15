package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Author;
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

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument int age){
        AuthorDto authorDto=new AuthorDto();
        authorDto.setName(name);
        authorDto.setAge(age);
        AuthorDto returnedAuthorDto=authorService.createAuthor(authorDto);
        return returnedAuthorDto;
    }

    @MutationMapping
    public AuthorDto updateAuthor(@Argument long id, @Argument String name, @Argument int age){
        AuthorDto authorDto=new AuthorDto();
        authorDto.setAge(age);
        authorDto.setName(name);
        return authorService.updateAuthor(authorDto, id);
    }

    @MutationMapping
    public String deleteAuthorById(@Argument long id){
        authorService.deleteAuthorById(id);
        return "delete successfully";
    }

    @QueryMapping
    public List<AuthorDto> findAllAuthor(){
        return authorService.findAllAuthor();
    }

    @QueryMapping
    public AuthorDto findAuthorById(@Argument long id){
        return authorService.findAuthorById(id);
    }



}
