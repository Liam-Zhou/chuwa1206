package com.chuwa.redbook.integration;

import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    private Post post;

    @BeforeEach
    void setUp() {
        Post toSave = new Post(1L,
                "test1",
                "test description",
                "test content",
                LocalDateTime.now(),
                LocalDateTime.now());
        post = postRepository.save(toSave);
    }

    @AfterEach
    void tearDown() {
        postRepository.delete(post);
    }

    @Test
    @WithMockUser(roles = {"ADMIN", "USER"})
    void testCreatePost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setTitle("test2");
        postDto.setDescription("test description 2");
        postDto.setContent("test content 2");

        ObjectMapper objectMapper = new ObjectMapper();

        String postDtoJson = objectMapper.writeValueAsString(postDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("test2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test description 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("test content 2"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String responseBody = response.getContentAsString();
        Long postId = JsonPath.parse(responseBody).read("$.id", Long.class);
        postRepository.deleteById(postId);
    }

    @Test
    void testGetPostById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/{id}", post.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("test1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("test content"));
    }

    @Test
    void testGetAllPosts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].title").value("test1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].description").value("test description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].content").value("test content"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testUpdatePostById() throws Exception {

        PostDto updateDto = modelMapper.map(post, PostDto.class);
        updateDto.setContent("update - " + updateDto.getContent());
        updateDto.setCreateDateTime(null);
        updateDto.setUpdateDateTime(null);

        ObjectMapper objectMapper = new ObjectMapper();
        String updateDtoJson = objectMapper.writeValueAsString(updateDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/{id}", post.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateDtoJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("test1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("test description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("update - " + post.getContent()));

    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeletePost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/posts/{id}", post.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/{id}", post.getId()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
