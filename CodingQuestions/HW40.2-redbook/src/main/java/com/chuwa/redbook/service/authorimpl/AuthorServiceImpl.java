package com.chuwa.redbook.service.authorimpl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourcesNotFoundException;
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
        AuthorDto authorResponse = mapToDTO(savedAuthor);

        return authorResponse;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(author -> mapToDTO(author)).collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        return mapToDTO(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());

        Author updatedAuthor = authorRepository.save(author);
        return mapToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }

    private AuthorDto mapToDTO(Author author) {
        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setEmail(authorDto.getEmail());

        return authorDto;
    }

    private Author mapToEntity(AuthorDto authorDto) {
        Author author = new Author();

        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());

        return author;
    }

}
