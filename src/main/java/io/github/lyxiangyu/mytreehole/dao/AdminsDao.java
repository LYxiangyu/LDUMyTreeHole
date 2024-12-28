package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Admins;

import java.util.List;
import java.util.Map;

public interface AdminsDao {
    void addAdmins(Integer userId);
    void deleteAdmins(Integer adminId);
    List<Admins> getAllAdmins();
    int getUserCount();
    int getPostCount();
    int getCommentCount();
    Admins getAdmins(String nickName);
    List<Map<String, Object>> getPostsAndCommentsByUserId(int userId);
    int getTotalUserCount();

}
