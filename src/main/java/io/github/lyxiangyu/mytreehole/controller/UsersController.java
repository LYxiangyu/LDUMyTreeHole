package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Users;
import io.github.lyxiangyu.mytreehole.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@SessionAttributes("users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginPage() {
        return "/login"; // 返回 login.html 页面
    }

    // 登录请求处理
    @PostMapping("/login")
    public String login(@RequestParam String nickName, @RequestParam String passwordHash, HttpSession session, Model model) {
        if (usersService.validateUser(nickName, passwordHash)) {
            session.setAttribute("user", nickName);  // 将用户信息存入 session
            model.addAttribute("user", nickName);  // 同步到 model 中，@SessionAttributes 会自动管理
            return "redirect:/index"; // 登录成功后重定向到首页
        } else {
            model.addAttribute("error", "密码或者账号不存在"); // 登录失败，加入错误信息
            return "login"; // 返回到 login.html 页面
        }
    }

    @PostMapping("/add")
    public void addUser(@RequestParam String nickName, @RequestParam String email, @RequestParam String passwordHash) {
        usersService.addUser(nickName, email, passwordHash);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        usersService.deleteUserById(id);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable int id, @RequestParam String nickName, @RequestParam String email) {
        usersService.updateUserInformation(id, nickName, email);
    }

    @PutMapping("/update-password/{id}")
    public void updateUserPassword(@PathVariable int id, @RequestParam String passwordHash) {
        usersService.updateUserPassword(id, passwordHash);
    }
}
