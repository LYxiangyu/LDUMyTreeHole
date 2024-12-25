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
    public void addComment(Integer postId, Integer userId ,String comment){
        String sql = "insert into comments (PostID, UserID, Content) values (?,?,?)";
        jdbcTemplate.update(sql, postId, userId, comment);
    };
    @Override
    public void deleteComment(Integer commentId){
        String sql = "delete from comments where CommentID = ?";
        jdbcTemplate.update(sql, commentId);
    };
    @Override
    public List<Comments> getAllComment(){
        String sql = "select * from comments";
        return jdbcTemplate.query(sql, commentsRowMapper);
    };
}
