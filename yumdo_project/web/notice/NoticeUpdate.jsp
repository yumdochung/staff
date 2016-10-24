<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<title>Mars 공지사항 등록</title>
</head>
<body>
<div class="main_content">
<jsp:include page="/main/top.jsp"/>
	<h1>공지사항 등록</h1>
	<form action="/notice" method="post">
	<input type="hidden" name="command" value="noticeUpdate">
	<input type="hidden" name="num" value="${dto.num}">
	<table class="insert_form">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" placeholder="제목을 입력하세요" value="${dto.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" placeholder="내용을 입력하세요">${dto.content}</textarea></td>
		</tr>
	</table>
	<input class="cancel" type="button" value="취소" onclick="location.href='notice?command=noticeList'">
	<input type="submit" value="수정">
	</form>
<jsp:include page="/main/footer.jsp"/>
</div>
</body>
</html>