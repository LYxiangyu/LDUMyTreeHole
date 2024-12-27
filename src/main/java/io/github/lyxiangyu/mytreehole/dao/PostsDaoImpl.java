package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostsDaoImpl implements PostsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Posts> postsRowMapper = (rs, rowNum) -> {
        Posts posts = new Posts();
        posts.setPostId(rs.getInt("PostID"));
        posts.setUserId(rs.getInt("UserID"));
        posts.setContent(rs.getString("Content"));
        return posts;
    };

    @Override
    public void addPosts(Integer userId, String content) {
        String sql = "INSERT INTO Posts (UserID, Content) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, content);
    }

    @Override
    public void deletePosts(Integer postId) {
        String sql = "DELETE FROM Posts WHERE PostID = ?";
        jdbcTemplate.update(sql, postId);
    }

    @Override
    public List<Posts> getAllPosts() {
        String sql = "SELECT * FROM Posts";
        return jdbcTemplate.query(sql, postsRowMapper);
    }

    @Override
    public List<Posts> getPostsByContent(String content) {
        String sql = "SELECT * FROM Posts WHERE Content LIKE ?";
        String searchContent = "%" + content + "%";
        return jdbcTemplate.query(sql, new Object[]{searchContent}, postsRowMapper);
    }

    @Override
    public Posts getPostById(Integer postId) {
        String sql = "SELECT * FROM Posts WHERE PostID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{postId}, postsRowMapper);
    }

    @Override
    public Integer findByUsername(String username){
        String sql = "SELECT UserID FROM Users WHERE Nickname = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            // 如果未找到结果，返回 null
            return null;
        }
    }
}
