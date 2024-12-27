package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Comments;
import io.github.lyxiangyu.mytreehole.entity.Posts;
import io.github.lyxiangyu.mytreehole.service.CommentsService;
import io.github.lyxiangyu.mytreehole.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final CommentsService commentsService;

    // 构造器注入
    public PostsController(PostsService postsService, CommentsService commentsService) {
        this.postsService = postsService;
        this.commentsService = commentsService;
    }

    // 添加帖子
    @PostMapping("/add")
    public ResponseEntity<String> addPost(@RequestParam("username") String username, @RequestParam("content") String content) {
        // 检查参数是否为空
        if (username == null || username.trim().isEmpty()) {
            System.out.println("username 不能为空！");
        }
        if (content == null || content.trim().isEmpty()) {
            System.out.println("content 不能为空！");
        }

        // 根据 username 查找 userId
        Integer userId = postsService.getUserIdByUsername(username);
        if (userId == null) {
            System.out.println(username);
            System.out.println("用户名无效");
        }

        // 添加帖子
        postsService.addPost(userId, content);
        return ResponseEntity.ok("帖子添加成功");
    }


    // 删除帖子
    @DeleteMapping("/delete/{postId}")
    public void deletePost(@PathVariable Integer postId) {
        postsService.deletePost(postId);
    }
    // 获取所有帖子
    @GetMapping("/all")
    public List<Posts> getAllPosts() {
        return postsService.getAllPosts();
    }
    // 根据内容查找帖子
}

