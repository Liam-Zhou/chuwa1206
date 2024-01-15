package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import com.chuwa.redbook.service.PostService;
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
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDtoToEntity(postDto);

        Post saved = this.postRepository.save(tobeSaved);
        //Entity to DTO
        PostDto response = convertEntityToDto(saved);

        return response;
    }

    private static PostDto convertEntityToDto(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private static Post convertDtoToEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        //DTO to Entity
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();

        List<PostDto> postDtos = posts.stream().map(post -> convertEntityToDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertEntityToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Put", "id", id));

        if (postDto.getTitle() != null) {
            toBeUpdatePost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            toBeUpdatePost.setContent(postDto.getContent());
        }
        if (postDto.getDescription() != null) {
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        Post updatedPost = this.postRepository.save(toBeUpdatePost);
        return convertEntityToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public PostResponse getAllPostsWithPageInfo(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> convertEntityToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());

        return postResponse;
    }

}