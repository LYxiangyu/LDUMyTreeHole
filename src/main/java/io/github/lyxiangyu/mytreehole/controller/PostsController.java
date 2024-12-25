package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Posts;
import io.github.lyxiangyu.mytreehole.service.PostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;

    // 构造器注入
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    // 添加帖子
    @PostMapping("/add")
    public void addPost(@RequestParam Integer userId, @RequestParam String content) {
        postsService.addPost(userId, content);
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
    @GetMapping("/search")
    public List<Posts> getPostsByContent(@RequestParam String content) {
        return postsService.getPostsByContent(content);
    }
}
