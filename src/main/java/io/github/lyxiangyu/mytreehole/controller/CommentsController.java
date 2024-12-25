package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Comments;
import io.github.lyxiangyu.mytreehole.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    // 添加评论
    @PostMapping("/add")
    public void addComment(@RequestParam Integer postId,
                           @RequestParam Integer userId,
                           @RequestParam String content) {
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

    // 根据评论ID获取评论
    @GetMapping("/{commentId}")
    public Comments getCommentById(@PathVariable Integer commentId) {
        return commentsService.getCommentById(commentId);
    }
}
