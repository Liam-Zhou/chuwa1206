package com.example.redbook.controller;

import com.example.redbook.payload.CommentDto;
import com.example.redbook.service.CommentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommentGralQLController {
    private CommentService commentService;

    public CommentGralQLController(CommentService commentService) {
        this.commentService = commentService;
    }

    @QueryMapping
    public CommentDto getCommentById(@Argument Long id, @Argument Long postId) {
        return this.commentService.getCommentById(id, postId);
    }

    @MutationMapping
    public CommentDto createComment(@Argument Long postId, @Argument String name, @Arguments String body) {
        CommentDto commentDto = new CommentDto();
        commentDto.setName(name);
        commentDto.setBody(body);

        return this.commentService.createComment(postId, commentDto);
    }
}
