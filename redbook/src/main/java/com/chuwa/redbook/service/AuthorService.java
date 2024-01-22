package com.chuwa.redbook.service;


import com.chuwa.redbook.payload.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthor();

    AuthorDto getAuthorById(long id);

    AuthorDto updateAuthor(AuthorDto authorDto, long id);

    void deleteAuthorById(long id);

}
