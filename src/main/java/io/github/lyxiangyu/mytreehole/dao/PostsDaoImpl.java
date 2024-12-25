package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void  addPosts(Integer userId, String content){
        String sql = "insert into posts (PostID, UserID, Content) values (?, ?, ?)";
        jdbcTemplate.update(sql, userId, content);
    };

    @Override
    public void deletePosts(Integer postId){
        String sql = "delete from posts where PostID = ?";
        jdbcTemplate.update(sql, postId);
    };

    @Override
    public List<Posts> getAllPosts() {
        String sql = "select * from posts";
        return jdbcTemplate.query(sql, postsRowMapper);
    }

    @Override
    public List<Posts> getPostsByContent(String content) {
        String sql = "SELECT * FROM Posts WHERE Content LIKE ?";
        String searchContent = "%" + content + "%"; // 使用 % 进行模糊匹配
        return jdbcTemplate.query(sql, new Object[]{searchContent}, postsRowMapper);
    }

}
