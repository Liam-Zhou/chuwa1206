package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{post-id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "post-id") long id,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{post-id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value = "post-id") Long postId) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("/posts/{post-id}/comments/{comment-id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable(value = "post-id") Long postId,
                                                      @PathVariable(value = "comment-id") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{post-id}/comments/{comment-id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "post-id") Long postId,
                                                    @PathVariable(value = "comment-id") Long commentId,
                                                    @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{post-id}/comments/{comment-id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "post-id") Long postId,
                                                @PathVariable(value = "comment-id") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }



}
