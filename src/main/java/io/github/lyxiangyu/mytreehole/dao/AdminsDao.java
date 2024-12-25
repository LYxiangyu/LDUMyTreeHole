package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Admins;

import java.util.List;

public interface AdminsDao {
    void addAdmins(Integer userId);
    void deleteAdmins(Integer adminId);
    List<Admins> getAllAdmins();
}
