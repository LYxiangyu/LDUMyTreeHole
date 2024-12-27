package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Comments;
import io.github.lyxiangyu.mytreehole.service.CommentsService;
import io.github.lyxiangyu.mytreehole.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    private PostsService postsService;

    // 构造器注入
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    // 添加评论
    @PostMapping("/add")
    public void addComment(@RequestParam Integer postId, @RequestParam Integer userId, @RequestParam String content) {
        commentsService.addComment(postId, userId, content);
    }

    // 删除评论
    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        commentsService.deleteComment(commentId);
    }

    // 获取所有评论
    @GetMapping("/all")
    public List<Comments> getAllComments() {
        return commentsService.getAllComments();
    }

    // 根据帖子ID获取评论
    @GetMapping("/post/{postId}")
    public List<Comments> getCommentsByPostId(@PathVariable Integer postId) {
        return commentsService.getCommentsByPostId(postId);
    }

    @GetMapping("/getUserId")
    public ResponseEntity<Integer> getUserId(@RequestParam String username) {
        Integer userId = postsService.getUserIdByUsername(username);
        if (userId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(userId);
    }
}
