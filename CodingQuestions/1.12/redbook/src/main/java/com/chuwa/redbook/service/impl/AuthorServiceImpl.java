package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.DAO.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author tobeSaved = convertDtoToEntity(authorDto);
        Author saved = authorRepository.save(tobeSaved);
        return convertEntityToDto(saved);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorServiceImpl::convertEntityToDto)
                .toList();
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author tobeUpdated = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if (authorDto.getAge() != 0) {
            tobeUpdated.setAge(authorDto.getAge());
        }
        if (authorDto.getName() != null) {
            tobeUpdated.setName(authorDto.getName());
        }
        if (authorDto.getBiography() != null) {
            tobeUpdated.setBiography(authorDto.getBiography());
        }
        Author updated = authorRepository.save(tobeUpdated);

        return convertEntityToDto(updated);
    }

    @Override
    public void deleteAuthorById(long id) {
        authorRepository.deleteById(id);
    }

    public static AuthorDto convertEntityToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setAge(author.getAge());
        authorDto.setBiography(author.getBiography());

        return authorDto;
    }

    public static Author convertDtoToEntity(AuthorDto authorDto) {
        Author author = new Author();

        author.setName(authorDto.getName());
        author.setAge(authorDto.getAge());
        author.setBiography(authorDto.getBiography());

        return author;
    }
}
