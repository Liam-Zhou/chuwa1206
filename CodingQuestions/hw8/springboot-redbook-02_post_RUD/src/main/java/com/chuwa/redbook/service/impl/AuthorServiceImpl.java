package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final ModelMapper modelMapper = new ModelMapper();


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createPost(@RequestBody AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        Author saved = authorRepository.save(author);
        return modelMapper.map(saved, AuthorDto.class);
    }

    @Override
    public List<AuthorDto> getAll() {
        return authorRepository.findAll().stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getByID(long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public AuthorDto updateById(long id, AuthorDto authorDto) {
        // 设置modelmapper不要将null移动到非null字段
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        Author author = authorRepository.findById(id).orElseThrow();
        // 保留原始id
        long originalID = author.getId();
        modelMapper.map(authorDto, author);
        // 重置原始id
        author.setId(originalID);
        Author saved = authorRepository.save(author);
        return modelMapper.map(saved, AuthorDto.class);
    }

    @Override
    public void deleteByID(long id) {
        authorRepository.deleteById(id);
    }


}
