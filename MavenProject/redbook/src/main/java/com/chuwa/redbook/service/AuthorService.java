package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    List<AuthorDto> getAuthors();

    AuthorDto getAuthorById(Long id);

    AuthorDto updateAuthorById(AuthorDto authorDto, Long id);

    void deleteAuthorById(Long id);
}
