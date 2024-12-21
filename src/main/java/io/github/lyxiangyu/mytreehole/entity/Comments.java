package io.github.lyxiangyu.mytreehole.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comments {
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String content;
    private LocalDateTime commentTime;
}
