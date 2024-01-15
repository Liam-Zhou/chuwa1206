package com.chuwa.redbook.service.implement;

import com.chuwa.redbook.dao.AuthorRepository;
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
    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }

    private AuthorDto mapTODto(Author author){
        AuthorDto authorDto=new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setAge(author.getAge());
        authorDto.setName(author.getName());
        return authorDto;
    }

    private Author mapToEntity(AuthorDto authorDto){
        Author author=new Author();
        author.setName(authorDto.getName());
        author.setAge(authorDto.getAge());
        return author;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author toBeSaved=mapToEntity(authorDto);
        Author newauthor=authorRepository.save(toBeSaved);
        return mapTODto(newauthor);
    }

    @Override
    public List<AuthorDto> findAllAuthor() {
        List<AuthorDto> authors=authorRepository.findAll()
                .stream()
                .map(this::mapTODto)
                .toList();
        return authors;
    }

    @Override
    public AuthorDto findAuthorById(long id) {
        AuthorDto authorDto=authorRepository.findById(id)
                .map(this::mapTODto)
                .orElseThrow(()->new ResourceNotFoundException("authors","id",id));
        return authorDto;
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("authors","id",id));
        if(authorDto.getAge()!=0) author.setAge(authorDto.getAge());
        if(authorDto.getName()!=null) author.setName(authorDto.getName());
        Author newauthor=authorRepository.save(author);
        return mapTODto(newauthor);
    }

    @Override
    public String deleteAuthorById(long id) {
        Author author=authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("authors","id",id));
        authorRepository.delete(author);
        return "Delete Successfully";
    }
}
