package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

public interface AuthorService  {
    AuthorDto createAuthor(AuthorDto authordto);

    AuthorDto getAuthorById(long id);

    AuthorDto updateAuthorById(AuthorDto authorDto, long id);

    void deleteAuthorById(long id);

    List<AuthorDto> getAllAuthors();
}
