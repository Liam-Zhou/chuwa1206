package com.chuwa.redbook.services.impl;

import com.chuwa.redbook.dao.AuthorRepo;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = this.authorRepo.findAll();
        var result = authors.stream()
                .map(author -> convertEntityToDto(author))
                .collect(Collectors.toList());

        return result;
    }


    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author(authorDto.getName(), authorDto.getBiography());
        var savedAuthor = this.authorRepo.save(author);

        return convertEntityToDto(savedAuthor);

    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());

        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = this.authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        if (authorDto.getName() != null){
            author.setName(authorDto.getName());
        }
        if (authorDto.getBiography() != null){
            author.setBiography(authorDto.getBiography());
        }

        var updatedAuthor = this.authorRepo.save(author);
        return convertEntityToDto(updatedAuthor);
    }

    @Override
    public boolean deleteAuthor(long id) {
        Author author = this.authorRepo.findById(id).orElse(null);
        if (author == null){
            return false;
        }
        this.authorRepo.deleteById(id);

        return true;
    }

    private AuthorDto convertEntityToDto(Author author) {
        AuthorDto authorDto = new AuthorDto(author.getId(), author.getName(), author.getBiography());

        return authorDto;

    }

}
