package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Users;

import java.util.List;

public interface UsersDao {
    void addUser(String nickName, String email,String passwordHash);
    void deleteUserById(int id);
    List<Users> getAllUserById();
    void updateUserInformation(int id, String nickName, String email);
    void updateUserPassword(int id, String passwordHash);

    Users getUserByUsernameAndPassword(String nickName, String passwordHash);
    List<Users> getUserByNickName(String nickName);  // 返回一个用户列表，可能有多个用户

    int countPostsByUserId(int userId); // 统计某个用户发布的帖子数量
    int countCommentsReceivedByUserId(int userId); // 统计某个用户收到的评论数量
    int countCommentsPostedByUserId(int userId); // 统计某个用户发布的评论数量
}
