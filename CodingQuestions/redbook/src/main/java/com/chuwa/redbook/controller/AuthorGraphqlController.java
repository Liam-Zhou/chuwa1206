package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.services.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorGraphqlController {
    private AuthorService authorService;

    public AuthorGraphqlController(AuthorService authorService) {
        this.authorService = authorService;
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
    public AuthorDto createAuthor(@Argument String name, @Argument String biography){
        biography = biography == null? "": biography;

        AuthorDto authorDto = new AuthorDto(name, biography);
        return this.authorService.createAuthor(authorDto);
    }

    @MutationMapping
    public AuthorDto updateAuthorById(@Argument long id, @Argument String name, @Argument String biography){
        AuthorDto authorDto = new AuthorDto(name, biography);
        AuthorDto updatedAuthor = this.authorService.updateAuthor(authorDto, id);

        return updatedAuthor;
    }

    @MutationMapping
    public boolean deleteAuthorById(@Argument long id){
        return this.authorService.deleteAuthor(id);
    }

}
