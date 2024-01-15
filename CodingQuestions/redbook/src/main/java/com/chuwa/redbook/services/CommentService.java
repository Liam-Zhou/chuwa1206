package com.chuwa.redbook.services;

import com.chuwa.redbook.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId, long comment);
    CommentDto updateComment(long postId, long commentId, CommentDto commentdto);

    void deleteComment(long postId, long commentId);
}
