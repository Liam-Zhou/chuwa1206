package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
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
        Author author = mapToEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return mapToDto(savedAuthor);
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
        return mapToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
        author.setUsername(authorDto.getUsername());
        author.setIp(authorDto.getIp());
        author.setGender(authorDto.getGender());

        Author updateAuthor = authorRepository.save(author);
        return mapToDto(updateAuthor);
    }

    @Override
    public void deleteAuthor(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author","id",id));
        authorRepository.delete(author);

    }

    private AuthorDto mapToDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setGender(author.getGender());
        authorDto.setUsername(authorDto.getUsername());
        authorDto.setIp(author.getIp());

        return authorDto;
    }

    private Author mapToEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setUsername(authorDto.getUsername());
        author.setGender(authorDto.getGender());
        author.setIp(authorDto.getIp());
        return author;
    }
}
