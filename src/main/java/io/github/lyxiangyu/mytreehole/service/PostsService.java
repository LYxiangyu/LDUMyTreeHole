package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.entity.Posts;

import java.util.List;

public interface PostsService {

    // 添加帖子
    void addPost(Integer userId, String content);

    // 删除帖子
    void deletePost(Integer postId);

    // 获取所有帖子
    List<Posts> getAllPosts();

    // 根据内容查找帖子
    List<Posts> getPostsByContent(String content);
}
