package io.github.lyxiangyu.mytreehole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller

public class IndexController {
    @ModelAttribute("users")  // 从 session 获取 user 数据
    public String getUserFromSession(@SessionAttribute(required = false) String users) {
        return users;  // 返回用户信息，或者为空
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
