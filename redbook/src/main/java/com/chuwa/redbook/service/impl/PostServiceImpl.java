package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostJPQLRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
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
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostJPQLRepository postJPQLRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post tobeSaved = convertDTOtoEntity(postDto);
        Post saved = this.postRepository.save(tobeSaved);

        //from DTO to Entity
        PostDto response = convertEntityToDTO(saved);

        return response;
    }

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
        //from Entity to DTO
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        return tobeSaved;
    }
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equals(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> pagePosts = postRepository.findAll(pageRequest);
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(this::convertEntityToDTO).toList();
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPostsJPQL() {
        return postJPQLRepository.getAllPostsWithJPQL().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(long id, String title) {
        return convertEntityToDTO(postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title));
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(long id, String title) {
        return convertEntityToDTO(postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title));
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(long id, String title) {
        return convertEntityToDTO(postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title));
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(long id, String title) {
        return convertEntityToDTO(postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title));
    }

    @Override
    public List<PostDto> getPosts() {
        //Entity --> DTO
        List<Post> posts = this.postRepository.findAll();

        return posts
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return convertEntityToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //#1, get original Post
        Post toBeUpdatePost = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //#2, update data
        if(postDto.getContent() != null){
            toBeUpdatePost.setContent(postDto.getContent());
        }

        if(postDto.getDescription() != null){
            //If this is another Entity
            toBeUpdatePost.setDescription(postDto.getDescription());
        }

        if(postDto.getTitle() != null){
            toBeUpdatePost.setTitle(postDto.getTitle());
        }

        //#3, re-save the updated Post entity
        Post updatedPost = this.postRepository.save(toBeUpdatePost);

        return convertEntityToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        this.postRepository.deleteById(id);
    }
}
