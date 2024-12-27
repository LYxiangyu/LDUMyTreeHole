package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Admins;

import java.util.List;
import java.util.Map;

public interface AdminsService {

    void addAdmin(Integer userId);

    void deleteAdmin(Integer adminId);

    List<Admins> getAllAdmins();

    Boolean validateAdmin(String nickName);

    Map<String, Integer> getStats();
}
