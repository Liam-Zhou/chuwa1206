package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
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
        Author tobeSaved = convertDtoToEntity(authorDto);
        Author saved = this.authorRepository.save(tobeSaved);

        AuthorDto response = convertEntityToDto(saved);
        return response;
    }

    private static AuthorDto convertEntityToDto(Author saved) {
        AuthorDto response = new AuthorDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setAccount(saved.getAccount());
        response.setGender(saved.getGender());
        return response;
    }

    private static Author convertDtoToEntity(AuthorDto authorDto) {
        Author tobeSaved = new Author();
        tobeSaved.setName(authorDto.getName());
        tobeSaved.setAccount(authorDto.getAccount());
        tobeSaved.setGender(authorDto.getGender());
        return tobeSaved;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = this.authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(AuthorServiceImpl::convertEntityToDto).collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author= this.authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Author","id",id));
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author author= this.authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Author","id",id));
        author.setName(authorDto.getName());
        author.setGender(authorDto.getGender());
        author.setAccount(authorDto.getAccount());

        Author uodatedAuthor = this.authorRepository.save(author);
        return convertEntityToDto(uodatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }
}
