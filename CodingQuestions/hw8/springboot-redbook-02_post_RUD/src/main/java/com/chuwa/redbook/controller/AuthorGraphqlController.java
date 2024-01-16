package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorGraphqlController {
    private final AuthorService authorService;

    public AuthorGraphqlController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<AuthorDto> getAllAuthor(){
        return authorService.getAll();
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument String description,
                                  @Argument String gender) {
        AuthorDto author = new AuthorDto();
        author.setName(name);
        author.setDescription(description);
        author.setGender(gender);

        return authorService.createPost(author);
    }

    @QueryMapping
    public AuthorDto getAuthorByID(@Argument long id) {
        return authorService.getByID(id);
    }

    @MutationMapping
    public AuthorDto updateAuthor(@Argument String name, @Argument String description,
                                @Argument String gender, @Argument long id) {
        AuthorDto author = new AuthorDto();
        author.setName(name);
        author.setDescription(description);
        author.setGender(gender);
        return authorService.updateById(id, author);
    }

    @MutationMapping
    public String deleteAuthor(@Argument long id) {
        authorService.deleteByID(id);
        return "successfully deleted";
    }

}
