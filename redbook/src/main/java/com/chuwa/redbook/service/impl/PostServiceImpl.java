package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public PostDto createPost(PostDto postDto) {
        postDto.getAuthorId().map(id -> authorService.createAuthorIfNotExist(id));

        Post tobeSaved = convertDTOtoEntity(postDto);
        Post saved = this.postRepository.save(tobeSaved);
        return convertEntitytoDTO(saved);
    }

    private PostDto convertEntitytoDTO(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription((saved.getDescription()));
        response.setContent(saved.getContent());
        response.setAuthorId(saved.getAuthor().map(Author::getId).orElse(null));
        return response;
    }

    private Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription((postDto.getDescription()));
        tobeSaved.setContent(postDto.getContent());

        Author author = postDto.getAuthorId()
                        .flatMap(id -> this.authorRepository.findById(id))
                        .orElse(null);
        tobeSaved.setAuthor(author);
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost(){
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(this::convertEntitytoDTO).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page object
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(this::convertEntitytoDTO).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(postResponse.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(long id){
        return convertEntitytoDTO(this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }
        toBeUpdatePost.setContent(postDto.getContent());

        // should check null for the other two
        toBeUpdatePost.setDescription((postDto.getDescription()));
        toBeUpdatePost.setTitle(postDto.getTitle());


        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return convertEntitytoDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }


}
