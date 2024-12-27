package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Admins;

import java.util.List;

public interface AdminsService {

    void addAdmin(Integer userId);

    void deleteAdmin(Integer adminId);

    List<Admins> getAllAdmins();

    Boolean validateAdmin(String nickName);
}
