package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.dao.CommentsDao;
import io.github.lyxiangyu.mytreehole.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public void addComment(Integer postId, Integer userId, String comment) {
        commentsDao.addComment(postId, userId, comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentsDao.deleteComment(commentId);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsDao.getAllComments();
    }

    @Override
    public List<Comments> getCommentsByPostId(Integer postId) {
        return commentsDao.getCommentsByPostId(postId);
    }
}
