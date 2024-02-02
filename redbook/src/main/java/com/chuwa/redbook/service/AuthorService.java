package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;

public interface AuthorService {
    AuthorDTO getAuthorById(Long id);

    AuthorDTO createAuthorIfNotExist(Long id);

    AuthorDTO convertEntitytoDTO(Author author);

    Author convertDTOtoEntity(AuthorDTO authorDTO);
}
