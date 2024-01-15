package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDTO;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import com.chuwa.redbook.utils.AppConstants;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDTO getAuthorById(Long id) {
        AuthorDTO authorDTO = new AuthorDTO();

        Optional<Author> author = this.authorRepository.findById(id);

        authorDTO.setId(author.map(Author::getId).orElse(null));
        authorDTO.setName(author.map(Author::getName).orElse("Anoumous"));
        authorDTO.setLevel(author.map(Author::getName).orElse("visitor"));

        return authorDTO;
    }

    @Override
    public AuthorDTO createAuthorIfNotExist(Long id) {
        if(!authorRepository.existsById(id)){
            Author authorToBeSaved = new Author();
            String strId = String.valueOf(id);
            if(strId.length() > AppConstants.DEFAULT_DANGLING_ID_LENGTH){
                strId = strId.substring(strId.length() - AppConstants.DEFAULT_DANGLING_ID_LENGTH);
            }
            authorToBeSaved.setId(id);
            authorToBeSaved.setName("User" + strId);
            authorToBeSaved.setLevel("newbie");

            authorRepository.save(authorToBeSaved);
            return convertEntitytoDTO(authorToBeSaved);
        }
        else{
            return convertEntitytoDTO(authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "not found by id", id)));
        }

    }

    @Override
    public AuthorDTO convertEntitytoDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setLevel(author.getLevel());
        return authorDTO;
    }

    @Override
    public Author convertDTOtoEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setLevel(author.getLevel());
        author.setName(author.getName());
        return author;
    }
}
