package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Users;

import java.util.List;

public interface UsersDao {
    void addUser(String nickName, String email,String passwordHash);
    void deleteUserById(int id);
    List<Users> getAllUserById();
    void updateUserInformation(int id, String nickName, String email);
    void updateUserPassword(int id, String passwordHash);
}
