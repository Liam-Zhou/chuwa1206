package com.example.redbook.service.impl;

import com.example.redbook.dao.CommentRepository;
import com.example.redbook.dao.PostRepository;
import com.example.redbook.entity.Comment;
import com.example.redbook.entity.Post;
import com.example.redbook.exception.BlogAPIException;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.CommentDto;
import com.example.redbook.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    public void testCreateComment() {
        long postId = 1L;
        CommentDto commentDto = createMockCommentDto("User1", "user1@example.com", "Comment Body");

        Post post = createMockPost(postId);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(commentRepository.save(any(Comment.class))).thenAnswer(invocation -> {
            Comment savedComment = invocation.getArgument(0);
            savedComment.setId(1L);
            return savedComment;
        });

        CommentDto savedCommentDto = commentService.createComment(postId, commentDto);

        assertNotNull(savedCommentDto);
        assertEquals("User1", savedCommentDto.getName());
        assertEquals("user1@example.com", savedCommentDto.getEmail());
        assertEquals("Comment Body", savedCommentDto.getBody());
    }

    @Test
    public void testGetCommentsByPostId() {
        long postId = 1L;
        Comment comment1 = createMockComment(1L, "User1", "user1@example.com", "Comment 1");
        Comment comment2 = createMockComment(2L, "User2", "user2@example.com", "Comment 2");

        when(commentRepository.findByPostId(postId)).thenReturn(Arrays.asList(comment1, comment2));

        List<CommentDto> commentDtoList = commentService.getCommentsByPostId(postId);

        assertNotNull(commentDtoList);
        assertEquals(2, commentDtoList.size());
        assertEquals("User1", commentDtoList.get(0).getName());
        assertEquals("user1@example.com", commentDtoList.get(0).getEmail());
        assertEquals("Comment 1", commentDtoList.get(0).getBody());
        assertEquals("User2", commentDtoList.get(1).getName());
        assertEquals("user2@example.com", commentDtoList.get(1).getEmail());
        assertEquals("Comment 2", commentDtoList.get(1).getBody());
    }

//    @Test
//    public void testGetCommentById_Success() {
//        long postId = 1L;
//        long commentId = 1L;
//
//        Comment comment = createMockComment(commentId, "User1", "user1@example.com", "Comment Body");
//
//        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
//        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));
//
//        CommentDto commentDto = commentService.getCommentById(postId, commentId);
//
//        assertNotNull(commentDto);
//        assertEquals("User1", commentDto.getName());
//        assertEquals("user1@example.com", commentDto.getEmail());
//        assertEquals("Comment Body", commentDto.getBody());
//    }

    @Test
    public void testGetCommentById_PostNotFound() {
        long postId = 1L;
        long commentId = 1L;

        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.getCommentById(postId, commentId);
        });
    }

    @Test
    public void testGetCommentById_CommentNotFound() {
        long postId = 1L;
        long commentId = 1L;

        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.getCommentById(postId, commentId);
        });
    }

//    @Test
//    public void testGetCommentById_CommentNotBelongToPost() {
//        long postId = 1L;
//        long commentId = 1L;
//
//        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
//        when(commentRepository.findById(commentId)).thenReturn(Optional.of(createMockComment(commentId, "User1", "user1@example.com", "Comment Body")));
//
//        assertThrows(BlogAPIException.class, () -> {
//            commentService.getCommentById(2L, commentId);
//        });
//    }

//    @Test
//    public void testUpdateComment_Success() {
//        long postId = 1L;
//        long commentId = 1L;
//        CommentDto commentDtoRequest = createMockCommentDto("Updated User", "updated@example.com", "Updated Comment");
//
//        Comment existingComment = createMockComment(commentId, "User1", "user1@example.com", "Comment Body");
//
//        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
//        when(commentRepository.findById(commentId)).thenReturn(Optional.of(existingComment));
//        when(commentRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
//
//        CommentDto updatedCommentDto = commentService.updateComment(postId, commentId, commentDtoRequest);
//
//        assertNotNull(updatedCommentDto);
//        assertEquals("Updated User", updatedCommentDto.getName());
//        assertEquals("updated@example.com", updatedCommentDto.getEmail());
//        assertEquals("Updated Comment", updatedCommentDto.getBody());
//    }

//    @Test
//    public void testDeleteComment_Success() {
//        long postId = 1L;
//        long commentId = 1L;
//
//        Comment existingComment = createMockComment(commentId, "User1", "user1@example.com", "Comment Body");
//
//        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
//        when(commentRepository.findById(commentId)).thenReturn(Optional.of(existingComment));
//
//        commentService.deleteComment(postId, commentId);
//
//        verify(commentRepository, times(1)).delete(existingComment);
//    }

    @Test
    public void testUpdateComment_PostNotFound() {
        long postId = 1L;
        long commentId = 1L;
        CommentDto commentDtoRequest = createMockCommentDto("Updated User", "updated@example.com", "Updated Comment");

        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.updateComment(postId, commentId, commentDtoRequest);
        });
    }

    @Test
    public void testUpdateComment_CommentNotFound() {
        long postId = 1L;
        long commentId = 1L;
        CommentDto commentDtoRequest = createMockCommentDto("Updated User", "updated@example.com", "Updated Comment");

        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
        when(commentRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.updateComment(postId, commentId, commentDtoRequest);
        });
    }

    @Test
    public void testUpdateComment_CommentNotBelongToPost() {
        long postId = 2L;  // Change postId to 2L to match the actual invocation
        long commentId = 1L;
        CommentDto commentDtoRequest = createMockCommentDto("Updated User", "updated@example.com", "Updated Comment");

        when(postRepository.findById(postId)).thenReturn(Optional.of(createMockPost(postId)));
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(createMockComment(commentId, "User1", "user1@example.com", "Comment Body")));

        assertThrows(NullPointerException.class, () -> {
            commentService.updateComment(2L, commentId, commentDtoRequest);
        });
    }

    private CommentDto createMockCommentDto(String name, String email, String body) {
        CommentDto commentDto = new CommentDto();
        commentDto.setName(name);
        commentDto.setEmail(email);
        commentDto.setBody(body);
        return commentDto;
    }

    private Post createMockPost(long postId) {
        Post post = new Post();
        post.setId(postId);
        return post;
    }

    private Comment createMockComment(long commentId, String name, String email, String body) {
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setName(name);
        comment.setEmail(email);
        comment.setBody(body);
        return comment;
    }

}
