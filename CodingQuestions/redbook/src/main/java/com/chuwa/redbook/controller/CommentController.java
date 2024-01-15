package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.CommentDto;
import com.chuwa.redbook.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value="postId") long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public CommentDto getCommentById(@PathVariable(value="postId") long postId, @PathVariable(value="commentId") long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return commentDto;
    }

    @PostMapping("/{postId}/comments")
    public CommentDto createComment(@PathVariable(value="postId") long postId, @RequestBody CommentDto commentDto){
        return this.commentService.createComment(postId, commentDto);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public CommentDto updateComment(@PathVariable(value="postId") long postId, @PathVariable(value="commentId") long commentId, @RequestBody CommentDto commentDto){
        return this.commentService.updateComment(postId, commentId, commentDto);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable(value="postId") long postId, @PathVariable(value="commentId") long commentId){
        commentService.deleteComment(postId, commentId);
    }

}
