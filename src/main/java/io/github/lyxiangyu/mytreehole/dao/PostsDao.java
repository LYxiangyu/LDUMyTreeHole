package io.github.lyxiangyu.mytreehole.dao;

import io.github.lyxiangyu.mytreehole.entity.Posts;

import java.util.List;

public interface PostsDao {
    void addPosts(Integer userId, String content);
    void deletePosts(Integer postId);
    List<Posts> getAllPosts();
    List<Posts> getPostsByContent(String content);
}
