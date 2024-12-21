package io.github.lyxiangyu.mytreehole.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Posts {
    private Integer postId;
    private Integer userId;
    private String content;
    private LocalDateTime postDate;
}
