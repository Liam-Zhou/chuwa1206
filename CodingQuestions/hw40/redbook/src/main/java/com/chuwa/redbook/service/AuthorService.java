package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    List<AuthorDto> findAllAuthor();
    AuthorDto findAuthorById(long id);
    AuthorDto updateAuthor(AuthorDto authorDto,long id);
    String deleteAuthorById(long id);

}
