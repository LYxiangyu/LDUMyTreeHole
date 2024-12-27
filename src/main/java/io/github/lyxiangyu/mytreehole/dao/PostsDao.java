package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Posts;

import java.util.List;

public interface PostsDao {
    void addPosts(Integer userId, String content);
    void deletePosts(Integer postId);
    List<Posts> getAllPosts();  // 获取所有帖子
    List<Posts> getPostsByContent(String content); // 根据内容查找帖子
    Posts getPostById(Integer postId);  // 获取特定帖子的详细信息
}
