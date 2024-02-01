package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.CommentRepository;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Comment;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.BlogAPIException;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.payload.PostDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplTest.class);

    @Mock
    private CommentRepository commentRepositoryMock;

    @Mock
    private PostRepository postRepositoryMock;

    @InjectMocks
    private CommentServiceImpl commentService;

    private CommentDto commentDto;

    private PostDto postDto;

    private Post post;

    private Comment comment;

    @BeforeAll
    static void beforeAll() {
        logger.info("Test starts");
    }
    private static Comment convertCommentDtoToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        return comment;
    }

    private static CommentDto convertEntityToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        return commentDto;
    }

    private PostDto convertEntityToPostDTO(Post saved) {
        PostDto response = new PostDto();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setContent(saved.getContent());
        return response;
    }

    private Post convertPostDTOtoEntity(PostDto postDto) {
        Post tobeSaved = new Post();
        //from Entity to DTO
        tobeSaved.setTitle(postDto.getTitle());
        tobeSaved.setDescription(postDto.getDescription());
        tobeSaved.setContent(postDto.getContent());

        return tobeSaved;
    }

    @BeforeEach
    void setUpComment() {
        logger.info("Set up comment for each test");
        comment = new Comment(1L, "a comment", "123@.com", "comment body");

        post = new Post(1L, "title", "description", "content", LocalDateTime.now(), LocalDateTime.now());
        postDto = convertEntityToPostDTO(post);
        comment.setPost(post);
        commentDto = convertEntityToCommentDto(comment);
    }

    @Test
    void testCreateComment() {
        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(comment);

        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        CommentDto commentResponse = commentService.createComment(1L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
    }

    @Test
    void testCreateComment_CommentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.createComment(1L, commentDto));
    }

    @Test
    void testGetCommentsByPostId() {
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        Mockito.when(commentRepositoryMock.findByPostId(ArgumentMatchers.anyLong()))
                .thenReturn(commentList);
        List<CommentDto> commentsRes = commentService.getCommentsByPostId(1L);
        CommentDto commentResponse = commentsRes.get(0);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
    }

    @Test
    void testGetCommentsById() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        CommentDto commentResponse = commentService.getCommentsById(1L, 1L);
        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
    }

    @Test
    void testGetCommentsById_postNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentsById(1L, 1L));
    }

    @Test
    void testGetCommentsById_commentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.getCommentsById(1L, 1L));
    }

    @Test
    void testGetCommentsById_commentPostMismatch() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Post newPost = new Post();
        newPost.setId(2L);
        comment.setPost(newPost);
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.getCommentsById(1L, 1L));
    }

    @Test
    void testUpdateComment() {
        commentDto.setBody("updated - " + commentDto.getBody());
        Comment updatedComment = convertCommentDtoToEntity(commentDto);
        updatedComment.setPost(post);
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));

        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(comment));

        Mockito.when(commentRepositoryMock.save(ArgumentMatchers.any(Comment.class)))
                .thenReturn(updatedComment);

        CommentDto commentResponse = commentService.updateComment(1L, 1L, commentDto);

        Assertions.assertNotNull(commentResponse);
        Assertions.assertEquals(commentDto.getBody(), commentResponse.getBody());
        Assertions.assertEquals(commentDto.getEmail(), commentResponse.getEmail());
        Assertions.assertEquals(commentDto.getName(), commentResponse.getName());
        Assertions.assertEquals(commentDto.getId(), commentResponse.getId());
    }

    @Test
    void testUpdateComment_postNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testUpdateComment_commentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testUpdateComment_commentPostMismatch() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Post newPost = new Post();
        newPost.setId(2L);
        comment.setPost(newPost);
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.updateComment(1L, 1L, commentDto));
    }

    @Test
    void testDeleteComment() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Mockito.doNothing().when(commentRepositoryMock).delete(ArgumentMatchers.any(Comment.class));

        commentService.deleteComment(1L, 1L);
        Mockito.verify(commentRepositoryMock, Mockito.times(1)).delete(ArgumentMatchers.any(Comment.class));
    }

    @Test
    void testDeleteComment_postNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Post", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_commentNotFound() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenThrow(new ResourceNotFoundException("Comment", "id", 1L));
        Assertions.assertThrows(ResourceNotFoundException.class, () -> commentService.deleteComment(1L, 1L));
    }

    @Test
    void testDeleteComment_commentPostMismatch() {
        Mockito.when(postRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(post));
        Post newPost = new Post();
        newPost.setId(2L);
        comment.setPost(newPost);
        Mockito.when(commentRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(comment));
        Assertions.assertThrows(BlogAPIException.class, () -> commentService.deleteComment(1L, 1L));
    }
}