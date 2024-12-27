package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.dao.UsersDao;
import io.github.lyxiangyu.mytreehole.dao.UsersDaoImpl;
import io.github.lyxiangyu.mytreehole.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;
    private final UsersDaoImpl usersDaoImpl;

    // 使用构造器注入
    public UsersServiceImpl(UsersDao usersDao, UsersDaoImpl usersDaoImpl) {
        this.usersDao = usersDao;
        this.usersDaoImpl = usersDaoImpl;
    }

    @Override
    public void addUser(String nickName, String email, String passwordHash) {
        usersDao.addUser(nickName, email, passwordHash);
    }

    @Override
    public void deleteUserById(int id) {
        usersDao.deleteUserById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUserById();
    }

    @Override
    public void updateUserInformation(int id, String nickName, String email) {
        usersDao.updateUserInformation(id, nickName, email);
    }

    @Override
    public void updateUserPassword(int id, String passwordHash) {
        usersDao.updateUserPassword(id, passwordHash);
    }

    @Override
    public Boolean validateUser(String nickName, String passwordHash){
        Users users = usersDao.getUserByUsernameAndPassword(nickName, passwordHash);
        return users != null;
    }
    @Override
    public List<Users> getUserByNickName(String nickName) {
        return usersDaoImpl.getUserByNickName(nickName); // 调用 Dao 层的方法获取数据
    }
// 新增统计功能

    /**
     * 统计某个用户发布的帖子数量、收到的评论数量、发布的评论数量
     * @param userId 用户ID
     * @return 包含统计信息的字符串
     */
    public String getUserStatistics(int userId) {
        int postCount = usersDaoImpl.countPostsByUserId(userId);
        int receivedCommentsCount = usersDaoImpl.countCommentsReceivedByUserId(userId);
        int postedCommentsCount = usersDaoImpl.countCommentsPostedByUserId(userId);

        return String.format("用户发布了 %d 个帖子，收到 %d 个评论，发布了 %d 条评论。",
                postCount, receivedCommentsCount, postedCommentsCount);
    }

}
