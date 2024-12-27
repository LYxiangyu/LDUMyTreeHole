package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Users> usersRowMapper = (rs, rowNum) -> {
        Users user = new Users();
        user.setUserId(rs.getInt("UserID"));
        user.setNickName(rs.getString("Nickname"));
        user.setEmail(rs.getString("Email"));
        user.setPasswordHash(rs.getString("PasswordHash"));
        return user;
    };

    @Override
    public void addUser(String nickName, String email,String passwordHash) {
        String sql = "insert into users(Nickname, Email, PasswordHash) values(?,?,?)";
        jdbcTemplate.update(sql,nickName,email,passwordHash);
    }
    @Override
    public void deleteUserById(int id){
        String sql = "delete from users where UserID = ?";
        jdbcTemplate.update(sql,id);
    };
    @Override
    public List<Users> getAllUserById(){
        String sql = "select * from users";
        return jdbcTemplate.query(sql, usersRowMapper);
    };
    @Override
    public void updateUserInformation(int id, String nickName,String email){
        String sql = "update users set Nickname = ? AND Email = ? WHERE UserID = ?";
        jdbcTemplate.update(sql,nickName,email,id);
    };
    @Override
    public void updateUserPassword(int id, String passwordHash){
        String sql = "update users set PasswordHash = ? where UserID = ?";
        jdbcTemplate.update(sql,passwordHash,id);
    };
    @Override
    public List<Users> getUserByNickName(String nickName) {
        String sql = "SELECT * FROM users WHERE nickname = ?";
        return jdbcTemplate.query(sql, new Object[]{nickName}, usersRowMapper);
    }

    @Override
    public Users  getUserByUsernameAndPassword(String nickName, String passwordHash){
        String sql = "select * from users where Nickname = ? and PasswordHash = ?";
        try {
            return jdbcTemplate.queryForObject(sql, usersRowMapper, nickName, passwordHash);
        } catch (EmptyResultDataAccessException e) {
            // 查询没有找到结果，返回 null
            return null;
        }
    };
}
