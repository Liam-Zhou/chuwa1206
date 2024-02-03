package com.chuwa.redbook.controller;

import com.chuwa.redbook.entities.Comment;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.CommentService;
import com.chuwa.redbook.service.PostService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PostControllerTest {
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private CommentService commentService;

    private PostDto postDto;

    @BeforeEach
    void setUp() {
        postDto = PostDto.builder()
                .id(1L)
                .title("test")
                .description("test desc")
                .content("test content")
                .build();
    }
    @Test
    public void testGetAllPosts() throws Exception {
        List<PostDto> postDtos = new ArrayList<>();
        postDtos.add(postDto);
        Mockito.when(postService.getAllPosts()).thenReturn(postDtos);
        ResultActions response = mockMvc.perform(get("/api/v1/posts"));
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(postDtos.size())));
    }
}
