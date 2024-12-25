package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Comments;

import java.util.List;

public interface CommentsService {

    // 添加评论
    void addComment(Integer postId, Integer userId, String comment);

    // 删除评论
    void deleteComment(Integer commentId);

    // 获取所有评论
    List<Comments> getAllComments();

    // 根据评论ID获取评论
    Comments getCommentById(Integer commentId);
}
