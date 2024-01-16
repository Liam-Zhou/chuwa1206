package com.chuwa.redbook.services;


import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    public List<AuthorDto> getAllAuthors();

    public AuthorDto createAuthor(AuthorDto authorDto);

    public AuthorDto getAuthorById(long id);

    public AuthorDto updateAuthor(AuthorDto authorDto, long id);

    public boolean deleteAuthor(long id);
}
