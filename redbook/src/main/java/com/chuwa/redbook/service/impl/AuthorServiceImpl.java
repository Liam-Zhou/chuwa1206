package com.chuwa.redbook.service.impl;


import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author tobeSaved = convertDTOtoEntity(authorDto);
        Author saved = this.authorRepository.save(tobeSaved);

        return convertEntityToDTO(saved);
    }

    private AuthorDto convertEntityToDTO(Author saved) {
        AuthorDto response = new AuthorDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        return response;
    }

    private Author convertDTOtoEntity(AuthorDto authorDto) {
        Author tobeSaved = new Author();
        tobeSaved.setName(authorDto.getName());
        tobeSaved.setEmail(authorDto.getEmail());
        return tobeSaved;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = this.authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(author -> convertEntityToDTO(author)).collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return convertEntityToDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author tobeUpdatedAuthor = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if (authorDto.getName() != null) {
          tobeUpdatedAuthor.setName(authorDto.getName());
        }
        if (authorDto.getEmail() != null) {
         tobeUpdatedAuthor.setEmail(authorDto.getEmail());
        }

        Author updatedAuthor = this.authorRepository.save(tobeUpdatedAuthor);

        return convertEntityToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        this.authorRepository.delete(author);
    }
}

