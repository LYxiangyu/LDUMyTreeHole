package io.github.lyxiangyu.mytreehole.entity;

import lombok.Data;

@Data
public class Users {
    private Integer userId;
    private String nickName;
    private String email;
    private String passwordHash;
}
