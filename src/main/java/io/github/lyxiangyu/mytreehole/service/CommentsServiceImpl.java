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
        return commentsDao.getAllComment();
    }

    @Override
    public Comments getCommentById(Integer commentId) {
        List<Comments> commentsList = commentsDao.getAllComment();
        for (Comments comment : commentsList) {
            if (comment.getCommentId().equals(commentId)) {
                return comment;
            }
        }
        return null; // 若没有找到，返回 null
    }
}
