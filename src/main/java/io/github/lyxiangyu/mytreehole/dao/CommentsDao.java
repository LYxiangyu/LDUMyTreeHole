package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Comments;

import java.util.List;

public interface CommentsDao {
    void addComment(Integer postId, Integer userId ,String comment);
    void deleteComment(Integer commentId);
    List<Comments> getAllComment();
}
