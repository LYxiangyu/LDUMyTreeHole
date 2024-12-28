package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Admins;
import io.github.lyxiangyu.mytreehole.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @PostMapping("/add")
    public void addAdmin(@RequestParam Integer userId) {
        adminsService.addAdmin(userId);
    }

    @DeleteMapping("/delete/{adminId}")
    public void deleteAdmin(@PathVariable Integer adminId) {
        adminsService.deleteAdmin(adminId);
    }

    @GetMapping("/all")
    public List<Admins> getAllAdmins() {
        return adminsService.getAllAdmins();
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getStats() {
        return ResponseEntity.ok(adminsService.getStats());
    }

    @GetMapping("/posts-comments")
    public ResponseEntity<Map<String, Object>> getPostsAndComments(
            @RequestParam int userId
    ) {
        return ResponseEntity.ok(adminsService.getPostsAndComments(userId));
    }

    // 删除帖子
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId) {
        try {
            adminsService.deletePost(postId);
            return ResponseEntity.ok("帖子删除成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除帖子失败");
        }
    }

    // 删除评论
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable int commentId) {
        try {
            adminsService.deleteComment(commentId);
            return ResponseEntity.ok("评论删除成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除评论失败");
        }
    }

}
