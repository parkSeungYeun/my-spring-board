<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시물 상세보기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
            line-height: 1.6;
        }
        h1 {
            color: #000000;
        }
        div, form {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px 0 rgba(0,0,0,0.1);
        }
        p, strong {
            margin: 10px 0;
            display: block;
        }
        input[type="text"], textarea, input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #000000;
            color: white;
            cursor: pointer;
            width: auto;
            float: right;
        }
        input[type="submit"]:hover {
            background-color: #333333;
        }
        .input-container {
            clear: both;
            overflow: hidden;
        }
        .comments {
            margin-top: 20px;
        }
    </style>
    <html>
    <head>
        <title>게시물 상세보기</title>
        <link rel="stylesheet" href="style.css"> <!-- 스타일시트 링크 -->
    </head>
    <body>
    <h1>게시물 상세보기</h1>
    <div>
        <strong>제목:</strong> ${board.title}<br>
        <strong>내용:</strong> <p>${board.content}</p>
        <strong>작성자:</strong> ${board.username}<br>
        <strong>작성일:</strong> <c:out value="${board.createdAt}"/><br>
    </div>

    <!-- 댓글 작성 폼 -->
    <h2>댓글 작성</h2>
    <form action="/comment/add" method="post">
        <input type="hidden" name="boardId" value="${board.id}" />
        <textarea name="content" required="required" placeholder="댓글을 입력하세요"></textarea><br>
        <button type="submit">댓글 등록</button>
    </form>

    <!-- 댓글 목록 -->
    <h2>댓글</h2>
    <c:if test="${not empty board.comments}">
        <ul>
            <c:forEach items="${board.comments}" var="comment">
                <li><strong>${comment.username}:</strong> ${comment.content} <i>${comment.createdAt}</i>
                    <form action="/comment/${comment.id}/${board.id}/delete" method="post" style="display:inline;">
                        <button type="submit">Delete</button>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty board.comments}">
        <p>댓글이 없습니다.</p>
    </c:if>

    <a href="./list">목록으로 돌아가기</a>
    </body>
    </html>