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
    private static Author convertDtoToEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        return author;
    }

    private static AuthorDto convertEntityToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = convertDtoToEntity(authorDto);
        Author saved = this.authorRepository.save(author);
        return convertEntityToDto(saved);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return this.authorRepository.findAll()
                .stream()
                .map(AuthorServiceImpl::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return convertEntityToDto(author);
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author toBeUpdateAuthor = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if (authorDto.getName() != null) {
            toBeUpdateAuthor.setName(authorDto.getName());
        }
        Author updatedAuthor = this.authorRepository.save(toBeUpdateAuthor);
        return convertEntityToDto(updatedAuthor);
    }
}
