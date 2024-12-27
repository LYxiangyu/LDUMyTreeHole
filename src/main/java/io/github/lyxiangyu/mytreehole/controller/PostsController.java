package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Comments;
import io.github.lyxiangyu.mytreehole.entity.Posts;
import io.github.lyxiangyu.mytreehole.service.CommentsService;
import io.github.lyxiangyu.mytreehole.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String getPostsByContent(@RequestParam String content, Model model) {
        List<Posts> posts = postsService.getPostsByContent(content);

        // 将搜索结果传递到 search.html 页面
        model.addAttribute("posts", posts);
        model.addAttribute("searchContent", content);  // 传递搜索的关键词，方便在页面显示
        // 返回 search 页面
        return "search";  // 这里返回的是 "search.html" 页面
    }
}

