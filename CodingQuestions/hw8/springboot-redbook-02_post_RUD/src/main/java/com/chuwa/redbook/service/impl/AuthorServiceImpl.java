package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private Author mapToEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        return author;
    }

    private AuthorDto mapToDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        AuthorDto savedAuthorDto = mapToDto(savedAuthor);
        return savedAuthorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors= authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(this::mapToDto).collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));;
        return mapToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setName(authorDto.getName());
        author.setId(authorDto.getId());

        Author updateAuthor = authorRepository.save(author);
        return mapToDto(updateAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }
}
