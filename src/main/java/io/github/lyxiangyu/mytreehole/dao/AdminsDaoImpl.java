package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Admins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminsDaoImpl implements AdminsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    private RowMapper<Admins> adminsRowMapper = (rs, rowNum) -> {
        Admins admins = new Admins();
        admins.setAdminId(rs.getObject("AdminID", Integer.class));
        admins.setUserId(rs.getObject("UserID", Integer.class));
        return admins;
    };

    @Override
    public void addAdmins(Integer userId){
        String sql = "insert into admins values(?,?)";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void deleteAdmins(Integer adminId){
        String sql = "delete from admins where AdminID=?";
        jdbcTemplate.update(sql, adminId);
    }

    @Override
    public List<Admins> getAllAdmins(){
        String sql = "select * from admins";
        return jdbcTemplate.query(sql, adminsRowMapper);
    }

    @Override
    public Admins getAdmins(String nickName){
        String sql = "select * from admins JOIN treeholedb.users u on u.UserID = admins.UserID  where Nickname=?";
        try {
            return jdbcTemplate.queryForObject(sql, adminsRowMapper, nickName);
        } catch (EmptyResultDataAccessException e) {
            // 查询没有找到结果，返回 null
            return null;
        }
    }
}
