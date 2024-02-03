package com.chuwa.redbook.controller;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.util.AppConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private PostDto postDto;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    private Post post;


//    @BeforeEach
//    void setUp() {
//        postDto = new PostDto();
//        postDto.setTitle("Test Title");
//        postDto.setDescription("Test Description");
//        postDto.setContent("Test Content");
//        post = postRepository.save(new Post(/*...*/));
//    }
    @BeforeEach
    void setUp() {
        Post toSave = new Post();
        toSave.setId(1L); // id is auto-generated
        toSave.setTitle("test4");
        toSave.setDescription("test description");
        toSave.setContent("test content"); // Make sure this is not null
        toSave.setCreateDateTime(LocalDateTime.now());
        toSave.setUpdateDateTime(LocalDateTime.now());
        post = postRepository.save(toSave);
    }

    @Test
    public void whenCreatePost_thenStatus201() throws Exception {
        // Create a new PostDto object
        PostDto postDto = new PostDto();
        postDto.setTitle("New Post for test");
        postDto.setDescription("New Post Description");
        postDto.setContent("New Post Content");

        // Convert the PostDto object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String postDtoJson = objectMapper.writeValueAsString(postDto);

        // Perform the POST request and verify the results
        mockMvc.perform(post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoJson))
                .andExpect(status().isCreated()) // Verify the status code is 201
                .andExpect(jsonPath("$.title").value("New Post for test"))
                .andExpect(jsonPath("$.description").value("New Post Description"))
                .andExpect(jsonPath("$.content").value("New Post Content"));
    }

    @Test
    void whenGetAllPosts_thenStatus200() throws Exception {
        mockMvc.perform(get("/api/v1/posts")
                        .param("pageNo", AppConstants.DEFAULT_PAGE_NUMBER)
                        .param("pageSize", AppConstants.DEFAULT_PAGE_SIZE)
                        .param("sortBy", AppConstants.DEFAULT_SORT_BY)
                        .param("sortDir", AppConstants.DEFAULT_SORT_DIR))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists());
    }

    @Test
    void whenGetPostById_thenStatus200() throws Exception {
        mockMvc.perform(get("/api/v1/posts/{id}", 11))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("test5"))
                .andExpect(jsonPath("$.description").value("test description"))
                .andExpect(jsonPath("$.content").value("test content"));
    }


    @Test
    void whenUpdatePostById_thenStatus200() throws Exception {
        // Given
        PostDto postDto = new PostDto();
        postDto.setTitle("Updated Title");
        postDto.setDescription("Updated Description");
        postDto.setContent("Updated Content");

        // When
        ObjectMapper objectMapper = new ObjectMapper();
        String postDtoJson = objectMapper.writeValueAsString(postDto);

        // Then
        mockMvc.perform(put("/api/v1/posts/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoJson)) // The JSON content is provided here
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Title"));
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void whenDeletePost_thenStatus200() throws Exception {
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        comments.forEach(comment -> commentRepository.delete(comment));

        mockMvc.perform(delete("/api/v1/posts/{id}", post.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/posts/{id}", post.getId()))
                .andExpect(status().isNotFound());
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
