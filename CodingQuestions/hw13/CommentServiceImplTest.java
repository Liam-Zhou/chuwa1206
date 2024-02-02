package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.payload.CommentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;
    private CommentDto commentDto;
    private Post post;
    private final Long postId = 1L;
    private final Long commentId = 1L;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setId(postId);
        post.setTitle("Sample Post Title");
        post.setDescription("Sample Post Description");
        post.setContent("Sample Post Content");

        comment = new Comment();
        comment.setId(commentId);
        comment.setBody("Sample comment body");
        comment.setPost(post);

        commentDto = new CommentDto();
        commentDto.setId(commentId);
        commentDto.setBody("Sample comment body");
    }

    @Test
    void givenCommentDto_whenCreateComment_thenReturnSavedCommentDto() {
        given(postRepository.findById(anyLong())).willReturn(Optional.of(post));
        given(commentRepository.save(any(Comment.class))).willReturn(comment);

        CommentDto savedCommentDto = commentService.createComment(postId, commentDto);

        assertNotNull(savedCommentDto);
        assertEquals(commentDto.getBody(), savedCommentDto.getBody());
    }

    @Test
    void givenPostId_whenGetCommentsByPostId_thenReturnCommentsList() {
        given(commentRepository.findByPostId(postId)).willReturn(Collections.singletonList(comment));
        List<CommentDto> commentDtos = commentService.getCommentsByPostId(postId);

        assertNotNull(commentDtos);
        assertFalse(commentDtos.isEmpty());
        assertEquals(1, commentDtos.size());
    }

    @Test
    void givenPostIdAndCommentId_whenGetCommentById_thenReturnCommentDto() {
        given(postRepository.findById(anyLong())).willReturn(Optional.of(post));
        given(commentRepository.findById(anyLong())).willReturn(Optional.of(comment));

        CommentDto foundCommentDto = commentService.getCommentById(postId, commentId);

        assertNotNull(foundCommentDto);
        assertEquals(comment.getBody(), foundCommentDto.getBody());
    }

    @Test
    void givenPostIdAndCommentId_whenUpdateComment_thenReturnUpdatedCommentDto() {
        given(postRepository.findById(anyLong())).willReturn(Optional.of(post));
        given(commentRepository.findById(anyLong())).willReturn(Optional.of(comment));
        given(commentRepository.save(any(Comment.class))).willReturn(comment);

        CommentDto updatedCommentDto = commentService.updateComment(postId, commentId, commentDto);

        assertNotNull(updatedCommentDto);
        assertEquals(commentDto.getBody(), updatedCommentDto.getBody());
    }

    @Test
    void givenPostIdAndCommentId_whenDeleteComment_thenNothing() {
        given(postRepository.findById(anyLong())).willReturn(Optional.of(post));
        given(commentRepository.findById(anyLong())).willReturn(Optional.of(comment));
        willDoNothing().given(commentRepository).delete(any(Comment.class));

        assertDoesNotThrow(() -> commentService.deleteComment(postId, commentId));
    }

    // You can also add tests to check for the exception scenarios such as when a post or comment is not found
}
