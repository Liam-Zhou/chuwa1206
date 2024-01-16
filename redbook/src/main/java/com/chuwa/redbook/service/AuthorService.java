package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(long id);

    void deleteAuthorById(long id);

    AuthorDto updateAuthorById(AuthorDto authorDto, long id);
}
