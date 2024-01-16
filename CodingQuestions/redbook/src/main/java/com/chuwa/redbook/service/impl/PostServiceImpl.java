package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entities.Post;
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

    private PostDto convertEntityToDTO(Post saved) {
        PostDto response = new PostDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());
        return tobeSaved;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //from Entity to DTO
        Post tobeSaved = convertDTOtoEntity(postDto);
        // save in repo
        Post saved = this.postRepository.save(tobeSaved);
        //from DTO to Entity
        return convertEntityToDTO(saved);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return this.postRepository.findAll()
                .stream().map(this::convertEntityToDTO)
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
        return convertEntityToDTO(this.postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        ));
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id)
        );
        if (postDto.getContent() != null) toBeUpdatePost.setContent(postDto.getContent());
        if (postDto.getDescription() != null) toBeUpdatePost.setDescription(postDto.getDescription());
        if (postDto.getTitle() != null) toBeUpdatePost.setTitle(postDto.getTitle());
        Post updatePost = this.postRepository.save(toBeUpdatePost);
        return convertEntityToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) { this.postRepository.deleteById(id); }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
