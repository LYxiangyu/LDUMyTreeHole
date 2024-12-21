CREATE DATABASE TreeHoleDB;
USE TreeHoleDB;

-- 创建用户表
CREATE TABLE Users (
                       UserID INT AUTO_INCREMENT PRIMARY KEY,          -- 用户唯一标识
                       Nickname VARCHAR(50) NOT NULL,                 -- 用户昵称
                       RegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 注册时间
                       Email VARCHAR(100) UNIQUE,                     -- 用户邮箱（可选，用于找回账号等功能）
                       PasswordHash VARCHAR(255) NOT NULL            -- 用户密码（加密存储）
);

-- 创建帖子表
CREATE TABLE Posts (
                       PostID INT AUTO_INCREMENT PRIMARY KEY,         -- 帖子唯一标识
                       UserID INT,                                    -- 发布者用户ID（外键）
                       Content TEXT NOT NULL,                         -- 帖子内容
                       PostDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 发布时间
                       FOREIGN KEY (UserID) REFERENCES Users(UserID)  -- 外键约束
);

-- 创建评论表
CREATE TABLE Comments (
                          CommentID INT AUTO_INCREMENT PRIMARY KEY,      -- 评论唯一标识
                          PostID INT,                                    -- 所属帖子ID（外键）
                          UserID INT,                                    -- 评论者用户ID（外键）
                          Content TEXT NOT NULL,                         -- 评论内容
                          CommentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 评论时间
                          FOREIGN KEY (PostID) REFERENCES Posts(PostID)  -- 外键约束
                              ON DELETE CASCADE,                         -- 帖子被删除时级联删除评论
                          FOREIGN KEY (UserID) REFERENCES Users(UserID)  -- 外键约束
);

-- 创建管理员表
CREATE TABLE Admins (
                        AdminID INT AUTO_INCREMENT PRIMARY KEY,        -- 管理员唯一标识
                        UserID INT UNIQUE,                             -- 对应用户ID（外键，与用户表关联）
                        FOREIGN KEY (UserID) REFERENCES Users(UserID)  -- 外键约束
);