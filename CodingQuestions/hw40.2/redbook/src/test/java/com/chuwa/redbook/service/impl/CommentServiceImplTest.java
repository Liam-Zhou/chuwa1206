package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CommentServiceImpl commentService;
    private Post post;
    private Comment comment;
    private CommentDto commentDto;

    @BeforeEach
    void setUp() {
        post = new Post(1L,
                "Game",
                "Bad Game",
                "This is a bad game",
                LocalDateTime.now(),
                LocalDateTime.now());
        comment = new Comment(1L, "test", "test@test.com", "I agree");
        commentDto = modelMapper.map(comment, CommentDto.class);
        comment.setPost(post);
    }

    @Test
    void testCreateComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        CommentDto response = commentService.createComment(1L, commentDto);
        assertNotNull(response);
        assertEquals(commentDto.getId(), response.getId());
        assertEquals(commentDto.getName(), response.getName());
        assertEquals(commentDto.getEmail(), response.getEmail());
        assertEquals(commentDto.getBody(), response.getBody());
    }

    @Test
    void testCreateComment_ResourceNotFound() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> comments = List.of(comment);
        Mockito.when(commentRepository.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(comments);

        List<CommentDto> response = commentService.getCommentsByPostId(1L);

        assertNotNull(response);
        assertEquals(comments.get(0).getId(), response.get(0).getId());
        assertEquals(comments.get(0).getName(), response.get(0).getName());
        assertEquals(comments.get(0).getEmail(), response.get(0).getEmail());
        assertEquals(comments.get(0).getBody(), response.get(0).getBody());
    }

    @Test
    void testGetCommentById() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        CommentDto response = commentService.getCommentById(1L, 1L);

        assertNotNull(response);
        assertEquals(comment.getId(), response.getId());
        assertEquals(comment.getName(), response.getName());
        assertEquals(comment.getEmail(), response.getEmail());
        assertEquals(comment.getBody(), response.getBody());
    }

    @Test
    void testGetCommentById_ResourceNotFound_Post() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testGetCommentById_ResourceNotFound_Comment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentById(1L, 1L));
    }

    @Test
    void testGetCommentById_BlogAPIException() {
        Post wrongPost = new Post(2L,
                "Game",
                "Bad Game",
                "This is a bad game",
                LocalDateTime.now(),
                LocalDateTime.now());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(wrongPost));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        comment.setPost(post);

        assertThrows(BlogAPIException.class, () -> commentService.getCommentById(2L, 1L));
    }

    @Test
    void testUpdateComment() {
        String body = "UPDATED - " + comment.getBody();
        commentDto.setBody(body);

        Comment update = new Comment();
        update.setId(commentDto.getId());
        update.setName(commentDto.getName());
        update.setEmail(commentDto.getEmail());
        update.setBody(commentDto.getBody());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));
        Mockito.when(commentRepository.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(update);

        CommentDto response = commentService.updateComment(1L, 1L, commentDto);

        assertNotNull(response);
        assertEquals(commentDto.getId(), response.getId());
        assertEquals(commentDto.getName(), response.getName());
        assertEquals(commentDto.getEmail(), response.getEmail());
        assertEquals(commentDto.getBody(), response.getBody());
    }

    @Test
    void testUpdateComment_ResourceNotFound_Post() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testUpdateComment_ResourceNotFound_Comment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testUpdateComment_BlogAPIException() {
        Post wrongPost = new Post(2L,
                "Game",
                "Bad Game",
                "This is a bad game",
                LocalDateTime.now(),
                LocalDateTime.now());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(wrongPost));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        comment.setPost(post);

        assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testDeleteComment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));

        commentService.deleteComment(1L, 1L);

        Mockito.verify(commentRepository, Mockito.times(1)).delete(comment);
    }

    @Test
    void testDeleteComment_ResourceNotFound_Post() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_ResourceNotFound_Comment() {
        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_BlogAPIException() {
        Post wrongPost = new Post(2L,
                "Game",
                "Bad Game",
                "This is a bad game",
                LocalDateTime.now(),
                LocalDateTime.now());

        Mockito.when(postRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(wrongPost));
        Mockito.when(commentRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        comment.setPost(post);

        assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));
    }
}

