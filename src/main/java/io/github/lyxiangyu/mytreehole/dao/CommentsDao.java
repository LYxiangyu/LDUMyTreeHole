package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Comments;

import java.util.List;

public interface CommentsDao {

    void addComment(Integer postId, Integer userId, String comment);
    void deleteComment(Integer commentId);
    List<Comments> getAllComments();  // 获取所有评论
    List<Comments> getCommentsByPostId(Integer postId);  // 根据帖子ID获取评论
}
