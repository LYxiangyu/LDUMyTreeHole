package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Posts;
import io.github.lyxiangyu.mytreehole.service.CommentsService;
import io.github.lyxiangyu.mytreehole.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller

public class IndexController {

    private final PostsService postsService;
    // 构造器注入
    public IndexController(PostsService postsService, CommentsService commentsService) {
        this.postsService = postsService;
    }

    @ModelAttribute("users")  // 从 session 获取 user 数据
    public String getUserFromSession(@SessionAttribute(required = false) String users) {
        return users;  // 返回用户信息，或者为空
    }
    @ModelAttribute("isAdmin")
    public String getIsAdminFromSession(@SessionAttribute(required = false) String isAdmin) {
        return isAdmin;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String showLoginPage() {
        return "/admin";
    }

    @GetMapping("/search")
    public String getPostsByContent(@RequestParam String content, Model model) {
        List<Posts> posts = postsService.getPostsByContent(content);
        // 将搜索结果传递到 search.html 页面
        model.addAttribute("posts", posts);
        model.addAttribute("searchContent", content);  // 传递搜索的关键词，方便在页面显示
        // 返回 search 页面
        return "search";  // 这里返回的是 "search.html" 页面
    }

}
