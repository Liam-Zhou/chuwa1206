package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;

import java.util.List;

public interface AuthorService {




    AuthorDto createPost(AuthorDto authorDto);

    List<AuthorDto> getAll();

    AuthorDto getByID(long id);

    AuthorDto updateById(long id, AuthorDto authorDto);

    void deleteByID(long id);
}
