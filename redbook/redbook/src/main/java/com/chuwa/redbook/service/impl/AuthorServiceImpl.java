package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author tobeUpdated = convertFromDtoToEntity(authorDto);
        Author saved = this.authorRepository.save(tobeUpdated);
        AuthorDto response = convertFromEntityToDto(saved);
        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authorList = this.authorRepository.findAll();

        List<AuthorDto> authorDtoList = authorList.stream().map(author -> convertFromEntityToDto(author)).collect(Collectors.toList());
        return authorDtoList;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return convertFromEntityToDto(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if (authorDto.getName() != null) {
            author.setName(authorDto.getName());
        }

        Author saved = this.authorRepository.save(author);
        return convertFromEntityToDto(saved);
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    private AuthorDto convertFromEntityToDto(Author saved) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName(saved.getName());
        authorDto.setId(saved.getId());

        return authorDto;
    }

    private Author convertFromDtoToEntity(AuthorDto authorDto) {
        Author author = new Author();

        author.setId(authorDto.getId());
        author.setName(authorDto.getName());

        return author;
    }
}
