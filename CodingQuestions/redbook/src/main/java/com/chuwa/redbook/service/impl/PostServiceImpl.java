package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entities.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

//    private PostDto convertEntityToDTO(Post saved) {
//        PostDto response = new PostDto();
//        response.setId(saved.getId());
//        response.setTitle(saved.getTitle());
//        response.setDescription(saved.getDescription());
//        response.setContent(saved.getContent());
//        return response;
//    }
//
//    private Post convertDTOtoEntity(PostDto postDto) {
//        Post tobeSaved = new Post();
//        tobeSaved.setTitle(postDto.getTitle());
//        tobeSaved.setDescription(postDto.getDescription());
//        tobeSaved.setContent(postDto.getContent());
//        return tobeSaved;
//    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //from Entity to DTO
        Post tobeSaved = modelMapper.map(postDto, Post.class);
        // save in repo
        Post saved = this.postRepository.save(tobeSaved);
        //from DTO to Entity
        return modelMapper.map(saved, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return this.postRepository.findAll()
                .stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getAllPostsPaginate(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postsDto = posts.stream().map(this::mapToDTO).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postsDto);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        return modelMapper.map(this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)), PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if (postDto.getContent() != null) toBeUpdatePost.setContent(postDto.getContent());
        if (postDto.getDescription() != null) toBeUpdatePost.setDescription(postDto.getDescription());
        if (postDto.getTitle() != null) toBeUpdatePost.setTitle(postDto.getTitle());
        Post updatePost = this.postRepository.save(toBeUpdatePost);
        return modelMapper.map(updatePost, PostDto.class);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }
}
