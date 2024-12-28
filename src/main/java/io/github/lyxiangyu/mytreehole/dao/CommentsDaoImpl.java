package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDaoImpl implements CommentsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Comments> commentsRowMapper = (rs, rowNum) -> {
        Comments comments = new Comments();
        comments.setCommentId(rs.getInt("CommentID"));
        comments.setPostId(rs.getInt("PostID"));
        comments.setUserId(rs.getInt("UserID"));
        comments.setContent(rs.getString("Content"));
        return comments;
    };

    @Override
    public void addComment(Integer postId, Integer userId, String comment) {
        String sql = "INSERT INTO Comments (PostID, UserID, Content) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, postId, userId, comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        String sql = "DELETE FROM Comments WHERE CommentID = ?";
        jdbcTemplate.update(sql, commentId);
    }

    @Override
    public void deleteCommentsByPostId(int postId) {
        String sql = "DELETE FROM comments WHERE PostID = ?";
        jdbcTemplate.update(sql, postId);
    }

    @Override
    public List<Comments> getAllComments() {
        String sql = "SELECT * FROM Comments";
        return jdbcTemplate.query(sql, commentsRowMapper);
    }

    @Override
    public List<Comments> getCommentsByPostId(Integer postId) {
        String sql = "SELECT * FROM Comments WHERE PostID = ?";
        return jdbcTemplate.query(sql, new Object[]{postId}, commentsRowMapper);
    }
}
