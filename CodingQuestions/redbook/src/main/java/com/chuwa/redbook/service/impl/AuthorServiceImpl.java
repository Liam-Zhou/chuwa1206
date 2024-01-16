package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entities.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
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
        Author tobeSaved = convertFromDtoToEntity(authorDto);
        Author saved = this.authorRepository.save(tobeSaved);
        return convertFromEntityToDto(saved);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return this.authorRepository.findAll()
                .stream().map(this::convertFromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        return convertFromEntityToDto(this.authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "id", id)
        ));
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author toBeUpdated = this.authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author", "id", id)
        );
        if (authorDto.getName() != null) toBeUpdated.setName(authorDto.getName());
        return convertFromEntityToDto(this.authorRepository.save(toBeUpdated));
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
