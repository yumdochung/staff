<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/js/notice.js"></script>
<script type="text/javascript">
	var num = "${noticeDto.num}";
	var user = "${loginUser.sid}";
</script>
<title></title>
</head>
<body>
<div class="main_content">
<jsp:include page="/main/top.jsp"/>
		
	<table class="insert_form">
		<tr>
			<th>제목</th>
			<td colspan="3">${noticeDto.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${noticeDto.snm}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${noticeDto.regdt}</td>
			<th>조회수</th>
			<td>${noticeDto.readcount}</td>
		</tr>
		<tr>
			<th style="height: 300px;">내용</th>
			<td colspan="3">${noticeDto.content}</td>
		</tr>
	</table>
	<c:if test="${loginUser.sid eq noticeDto.sid}">
	<input class="cancel" id="delete_notice" type="button" value="삭제">
	<input type="submit" value="수정" onclick="location.href='notice?command=noticeUpdateForm&num=${noticeDto.num}'" style="margin-left: 20px;">
	</c:if>
	<div style="height: 55px;">
	<input type="button" value="목록" onclick="location.href='notice?command=noticeList'" style="background: #aaa;color: #fff;width: 100px;height: 35px;border: 0;margin-top: 20px;float: right;
	cursor: pointer;">
	</div>
	
	<div style="margin-top: 20px;text-align: center;">
		<form id="frm">
		<input type="hidden" name="sid" value="${loginUser.sid}">
		<input type="hidden" name="num" value="${noticeDto.num}">
		<textarea id="replyin" name="content" style="width: 800px;height: 40px;border: 1px solid #ccc;"></textarea> 
		<input type="button" id="button1" value="등록" style="width: 100px;height: 46px;float: right;cursor: pointer;">
		</form>
	</div>
	<c:forEach var="reply" items="${replyDto}">
	<div style="position: relative;width: 1000px;float: left;">
	<form id="re_del">
	<input type="hidden" name="notice_num" value="${noticeDto.num}">
	<input type="hidden" name="num" value="${reply.num}">
		<div style="float: left;margin-right: 20px;">${reply.snm }</div>
		<div style="float: left;">${reply.content }
			<c:if test="${loginUser.sid eq reply.sid}">
				<a id="reply_update" data-num="${reply.num}" data-content="${reply.content}">수정</a>
				<a id="reply_delete">삭제</a>
			</c:if>
		</div>
		<div style="float: right;">${reply.regdt}</div>
	</form>
	</div>
	</c:forEach>
	
<jsp:include page="/main/footer.jsp"/>
</div>
</body>
</html>