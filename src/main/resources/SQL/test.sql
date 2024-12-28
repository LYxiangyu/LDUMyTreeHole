SELECT UserID FROM Users WHERE Nickname = 'xiangyu2233';

SELECT p.PostID, p.Content AS PostContent, c.CommentID, c.Content AS CommentContent
FROM posts p
         LEFT JOIN comments c ON p.PostID = c.PostID
WHERE p.UserID = 1
ORDER BY p.PostDate DESC
LIMIT 5 OFFSET 0;

SELECT * FROM posts WHERE UserID = 1;
SELECT * FROM comments;
