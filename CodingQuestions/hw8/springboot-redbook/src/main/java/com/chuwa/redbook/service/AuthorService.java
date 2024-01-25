package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

import java.util.List;

public interface AuthorService {
    AuthorDto findById(Long id);
    AuthorDto create(AuthorDto authorDto);
    AuthorDto update(Long id, AuthorDto authorDto);
    void delete(Long id);
    List<AuthorDto> getAllAuthors(); // Return list of AuthorDto
}


