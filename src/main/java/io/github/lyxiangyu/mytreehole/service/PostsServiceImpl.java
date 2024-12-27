package io.github.lyxiangyu.mytreehole.service;

import io.github.lyxiangyu.mytreehole.dao.PostsDao;
import io.github.lyxiangyu.mytreehole.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsDao postsDao;

    @Override
    public void addPost(Integer userId, String content) {
        postsDao.addPosts(userId, content);
    }

    @Override
    public void deletePost(Integer postId) {
        postsDao.deletePosts(postId);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postsDao.getAllPosts();
    }

    @Override
    public List<Posts> getPostsByContent(String content) {
        return postsDao.getPostsByContent(content);
    }

    @Override
    public Posts getPostById(Integer postId) {
        return postsDao.getPostById(postId);
    }
}
