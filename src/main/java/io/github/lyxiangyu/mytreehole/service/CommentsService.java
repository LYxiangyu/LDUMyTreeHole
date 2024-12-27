package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Comments;

import java.util.List;

public interface CommentsService {

    void addComment(Integer postId, Integer userId, String comment);
    void deleteComment(Integer commentId);
    List<Comments> getAllComments();
    List<Comments> getCommentsByPostId(Integer postId);
}
