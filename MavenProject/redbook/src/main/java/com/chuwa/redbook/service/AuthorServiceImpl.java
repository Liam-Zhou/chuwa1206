package com.chuwa.redbook.service;

import com.chuwa.redbook.DAO.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;

    private static Author toAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        return author;
    }

    private static AuthorDto toAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author toSaved = toAuthor(authorDto);
        Author saved = authorRepository.save(toSaved);
        return toAuthorDto(saved);
    }

    @Override
    public List<AuthorDto> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(AuthorServiceImpl::toAuthorDto).collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author", "id", id));
        return toAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, Long id) {
        Author toUpdated = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Author", "id", id));
        toUpdated.setName(authorDto.getName());
        Author updataed = authorRepository.save(toUpdated);
        return toAuthorDto(updataed);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
