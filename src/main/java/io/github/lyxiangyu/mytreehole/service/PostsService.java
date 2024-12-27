package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Posts;

import java.util.List;

public interface PostsService {

    void addPost(Integer userId, String content);
    void deletePost(Integer postId);
    List<Posts> getAllPosts();
    List<Posts> getPostsByContent(String content);
    Posts getPostById(Integer postId);  // 获取特定帖子的详细信息
    public Integer getUserIdByUsername(String username);
}
