package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersService {

    void addUser(String nickName, String email, String passwordHash);

    void deleteUserById(int id);

    List<Users> getAllUsers();

    void updateUserInformation(int id, String nickName, String email);

    void updateUserPassword(int id, String passwordHash);

    Boolean validateUser(String nickName, String passwordHash);
    List<Users> getUserByNickName(String nickName);
    Map<String, Integer> getUserStats(int userId);
    Users getUserInfo(String username);
    boolean updateUserInfo(Users userDTO);
}
