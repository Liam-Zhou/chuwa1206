package com.example.redbook.controller;

import com.example.redbook.payload.dto.PostDto;
import com.example.redbook.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class PostControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostService postService;

    @BeforeEach
    public void setUp() {
        // Create a post in the database before each test
        PostDto postDto = new PostDto();
        postDto.setTitle("Test Post");
        postDto.setDescription("Test Description");
        postDto.setContent("Test Content");

        postService.createPost(postDto);
    }

    @Test
    public void testGetPostById() {
        // Assuming the service returns a real result from the database
        long postId = 1L;
        PostDto postDto = postService.getPostById(postId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send GET request and get the response
        ResponseEntity<PostDto> responseEntity = restTemplate.exchange(
                "/api/v1/posts/{id}", HttpMethod.GET, entity, PostDto.class, postId);

        // Validate the HTTP status code
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Validate the response content
        PostDto responsePostDto = responseEntity.getBody();
        assertThat(responsePostDto).isNotNull();
        assertThat(responsePostDto.getId()).isEqualTo(postDto.getId());
        assertThat(responsePostDto.getTitle()).isEqualTo(postDto.getTitle());
        assertThat(responsePostDto.getDescription()).isEqualTo(postDto.getDescription());
        assertThat(responsePostDto.getContent()).isEqualTo(postDto.getContent());
    }
}
