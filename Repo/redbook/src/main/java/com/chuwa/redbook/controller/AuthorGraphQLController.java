package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@Controller
public class AuthorGraphQLController {
    private AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name,@Argument String gender,@Argument String account){
        AuthorDto createdAuthorDto = new AuthorDto();
        createdAuthorDto.setName(name);
        createdAuthorDto.setAccount(account);
        createdAuthorDto.setGender(gender);
        return this.authorService.createAuthor(createdAuthorDto);
    }
    @QueryMapping
    public List<AuthorDto> getAllAuthors(){
        return this.authorService.getAllAuthors();
    }
    @QueryMapping
    public AuthorDto getAuthorById(@Argument long id){
        return this.authorService.getAuthorById(id);
    }
    @MutationMapping
    public AuthorDto updateAuthorById(@Argument long id,@Argument String name,@Argument String gender,@Argument String account){
        AuthorDto updatedAuthorDto = new AuthorDto();
        updatedAuthorDto.setName(name);
        updatedAuthorDto.setAccount(account);
        updatedAuthorDto.setGender(gender);
        return this.authorService.updateAuthorById(updatedAuthorDto,id);
    }
    @MutationMapping
    public String deleteAuthorById(@Argument long id){
        this.authorService.deleteAuthorById(id);
        return "Deleted Successful";
    }
}
