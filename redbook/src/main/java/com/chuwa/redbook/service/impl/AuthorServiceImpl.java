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
    public AuthorDto createAuthor(AuthorDto authordto) {
        Author toBeSaved = convertDTOtoEntity(authordto);

        Author saved = this.authorRepository.save(toBeSaved);

        AuthorDto authorDto = convertEntityToDTO(saved);

        return authorDto;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return convertEntityToDTO(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        if(authorDto.getAge() > 0) {
            author.setAge(authorDto.getAge());
        }
        if(authorDto.getName() != null) {
            author.setName(authorDto.getName());
        }
        this.authorRepository.save(author);
        return convertEntityToDTO(author);
    }

    @Override
    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<AuthorDto> response = this.authorRepository.findAll().stream().map(author -> convertEntityToDTO(author)).collect(Collectors.toList());
        return response;
    }

    private static AuthorDto convertEntityToDTO(Author saved) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setAge(saved.getAge());
        authorDto.setName(saved.getName());
        authorDto.setId(saved.getId());
        return authorDto;
    }

    private static Author convertDTOtoEntity(AuthorDto authordto) {
        Author toBeSaved = new Author();
        toBeSaved.setAge(authordto.getAge());
        toBeSaved.setId(authordto.getId());
        toBeSaved.setName(authordto.getName());
        return toBeSaved;
    }
}
