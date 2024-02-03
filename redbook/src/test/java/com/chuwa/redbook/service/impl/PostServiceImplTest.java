package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImplTest.class);

    @Mock
    private PostRepository postRepositoryMock;

    @InjectMocks
    private PostServiceImpl postService;

    @Spy
    private ModelMapper modelMapper;

    private PostDto postDto;
    private Post post;
    private final List<Post> allPost = new ArrayList<>();


    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    @BeforeEach
    void generateSinglePost() {
        logger.info("set up Post for each test");

        this.post = new Post();
        post.setId(1L);
        post.setTitle("Unit Test");
        post.setDescription("2024.2.1");
        post.setContent("postServiceImplTest");
        ModelMapper modelMapper = new ModelMapper();
        this.postDto = modelMapper.map(this.post, PostDto.class);

        allPost.add(post);
    }


    @Test
    void createPost() {
        // define the behavior
        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class))).thenReturn(post);

        // execute
        PostDto postResponse = postService.createPost(postDto);

        // assertions
        Assertions.assertNotNull(postResponse);
        Assertions.assertEquals(postDto.getTitle(), postResponse.getTitle());
        Assertions.assertEquals(postDto.getDescription(), postResponse.getDescription());
        Assertions.assertEquals(postDto.getContent(), postResponse.getContent());
    }

    @Test
    void getAllPost() {
        // define the behavior
        Mockito.when(postRepositoryMock.findAll()).thenReturn(allPost);

        // execute
        List<PostDto> response = postService.getAllPost();

        // assertions
        Assertions.assertNotNull(response);
        Assertions.assertEquals(allPost.size(), response.size());
    }

    @Test
    void getPostById() {
        // define behavior
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", post.getId()))
                .thenReturn(Optional.ofNullable(post));

        // execute1
        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(post.getId()));

        // execute2
        PostDto response = postService.getPostById(post.getId());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getId(), post.getId());
        Assertions.assertEquals(response.getTitle(), post.getTitle());
    }


    @Test
    void updatePost() {
        // define behavior
        Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class))).thenReturn(post);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", post.getId()))
                .thenReturn(Optional.ofNullable(post));

        // execute1
        Assertions.assertThrows(ResourceNotFoundException.class, () -> postService.updatePost(postDto, -1));

        // execute2
        PostDto response = postService.updatePost(postDto, 1);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getId(), post.getId());
        Assertions.assertEquals(response.getTitle(), post.getTitle());
    }

    @Test
    void deletePostById(){
        postService.deletePostById(1);
    }

}