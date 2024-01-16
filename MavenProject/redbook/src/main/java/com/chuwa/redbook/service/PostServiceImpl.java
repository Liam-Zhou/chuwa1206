package com.chuwa.redbook.service;

import com.chuwa.redbook.DAO.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDtotoEntity(postDto);

        Post saved = this.postRepository.save(tobeSaved);
        PostDto response = convertEntitytoDto(saved);
        return response;
    }

    private static Post convertDtotoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());
        return tobeSaved;
    }

    private static PostDto convertEntitytoDto(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setContent(saved.getContent());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        return response;
    }

    private static Post convertDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setContent(postDto.getContent());
        tobeSaved.setDescription(postDto.getDescription());
        return tobeSaved;
    }

    @Override
    public List<PostDto> getAllPost() {
        
        // Entity --> DTO
        List<Post> posts = this.postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(PostServiceImpl::convertEntitytoDto).collect(Collectors.toList());
        return postDtos;

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertEntitytoDto(post);
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(PostServiceImpl::convertEntitytoDto).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getNumberOfElements());
        postResponse.setTotalPage(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;


    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if (postDto.getContent() != null) {
            toBeUpdatePost.setContent(postDto.getContent());

        }
        toBeUpdatePost.setDescription(postDto.getDescription());
        toBeUpdatePost.setTitle(postDto.getTitle());
        Post updatedPost = this.postRepository.save(toBeUpdatePost);
        return convertEntitytoDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }


}
