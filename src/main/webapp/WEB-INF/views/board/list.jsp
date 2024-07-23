<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>게시판 목록</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 2px solid #ccc;
        }
        .add-icon {
            font-size: 24px;
            color: #000000; /* 색상 설정 */
            float: right; /* 오른쪽 정렬 */
            margin: 10px; /* 여백 설정 */
        }
        .add-icon:hover {
            color: #000000; /* 호버 시 색상 변경 */
        }
    </style>
</head>
<body>
<a href="/board/new" class="add-icon"><i class="fas fa-plus-circle"></i></a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작업</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board/${board.id}">${board.title}</a></td>
            <td>${board.username}</td>
            <td>
                <a href="/board/${board.id}/editBoard">Edit</a>
                <form action="/${board.id}/delete" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
