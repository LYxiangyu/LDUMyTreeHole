package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.dao.AdminsDao;
import io.github.lyxiangyu.mytreehole.entity.Admins;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsServiceImpl implements AdminsService {

    private final AdminsDao adminsDao;

    // 使用构造器注入
    public AdminsServiceImpl(AdminsDao adminsDao) {
        this.adminsDao = adminsDao;
    }

    @Override
    public void addAdmin(Integer userId) {
        adminsDao.addAdmins(userId);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminsDao.deleteAdmins(adminId);
    }

    @Override
    public List<Admins> getAllAdmins() {
        return adminsDao.getAllAdmins();
    }

    @Override
    public Boolean validateAdmin(String nickName){
        Admins admins = adminsDao.getAdmins(nickName);
        return admins != null;
    };
}
