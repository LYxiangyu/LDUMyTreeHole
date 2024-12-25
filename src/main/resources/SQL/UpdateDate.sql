
INSERT INTO treeholedb.users(Nickname, Email, PasswordHash)
VALUES
    ('Eren Joker',null,123456),
    ('Satoru Gojo',null,1234678),
    ('Hoshino Ai',null,163204),
    ('Black Mamba',null,2020126);

INSERT INTO treeholedb.admins (UserID)
VALUES
    (4);

INSERT INTO treeholedb.posts(UserID, Content)
VALUES
    (4,'孩子们，我回来了！');

INSERT INTO treeholedb.comments(PostID, UserID, Content)
VALUES
    (1,2,'孩子们我回不来了！')
