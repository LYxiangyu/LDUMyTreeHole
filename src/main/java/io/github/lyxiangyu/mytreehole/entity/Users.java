package io.github.lyxiangyu.mytreehole.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Users {
    private Integer userId;
    private String nickName;
    private LocalDateTime registrationDate;
    private String email;
    private String passwordHash;
}
