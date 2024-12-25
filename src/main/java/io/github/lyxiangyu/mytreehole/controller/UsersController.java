package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Users;
import io.github.lyxiangyu.mytreehole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

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
