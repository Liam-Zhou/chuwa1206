package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author toBeSaved = new Author();
        toBeSaved.setName(authorDto.getName());
        Author save = this.authorRepository.save(toBeSaved);
        AuthorDto response = convertEntityToDTO(save);

        return response;
    }


    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = this.authorRepository.findAll();
        List<AuthorDto> response = authors.stream()
                .map(author -> convertEntityToDTO(author)).collect(Collectors.toList());
        return response;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Optional<Author> author = Optional.ofNullable(this.authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id)));

        AuthorDto authorDto = convertEntityToDTO(author.get());

        return authorDto;
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author updatedAuthor = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if (authorDto.getName() != null) {
            updatedAuthor.setName(authorDto.getName());
        }

        Author save = this.authorRepository.save(updatedAuthor);
        AuthorDto response = convertEntityToDTO(save);
        return response;
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    private AuthorDto convertEntityToDTO(Author save) {
        AuthorDto response = new AuthorDto();
        response.setId(save.getId());
        response.setName(save.getName());
        return response;
    }
}
