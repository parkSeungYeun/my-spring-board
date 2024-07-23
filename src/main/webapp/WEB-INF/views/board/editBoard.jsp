<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시글 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            padding: 20px;
        }
        form {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px 0 rgba(0,0,0,0.1);
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>게시글 수정</h1>
<form action="/board/${board.id}/editBoard" method="post">
    <input type="hidden" name="id" value="${board.id}">

    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${board.title}" required>

    <label for="content">내용:</label>
    <textarea id="content" name="content" required>${board.content}</textarea>

    <label for="username">작성자:</label>
    <input type="text" id="username" name="username" value="${board.username}" readonly>


    <input type="submit" value="게시글 수정">
</form>
<a href="/board/list">목록으로 돌아가기</a>
</body>
</html>
