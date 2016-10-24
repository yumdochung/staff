<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<title></title>
</head>
<body>
<div class="main_content">
<jsp:include page="/main/top.jsp"/>
	<h1>공지사항</h1>
	<table class="insert_form">
		<tr>
			<th style="width: 80px;">번 &nbsp; 호</th>
			<th style="width: 450px">제 &nbsp; 목 </th>
			<th style="width: 100px; text-align: center;">작성일</th>
			<th style="width: 80px">조 &nbsp; 회</th>
		</tr>
		<c:forEach var="notice" items="${noticeList }" >
			<tr class="record">
				<td align="center">${notice.num }</td>
				<td>
					<a href="notice?command=noticeDetail&num=${notice.num}">${notice.title }
					<c:if test="${notice.replycount > 0}">
						<font style="font-size: 8px">[${notice.replycount }]</font>
					</c:if>
					</a>
				</td>
				<td align="center">${notice.regdt }</td>
				<td align="center">${notice.readcount}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${loginUser.admin eq '1'}">
	<input type="button" class="cancel" value="등록" onclick="location.href='notice?command=noticeInertForm'" style="background: #6799FF">
	</c:if>
	<div style="width: 1000px;margin: 0 auto;text-align: center;margin-top: 20px;color: #666;font-size: 13px;">
	<c:if test="${block > 1}">
		<a href="notice?command=noticeList&curPage=${prevPage}">[이전]</a>
	</c:if>
		<c:forEach var="i" begin="${firstPage }" end="${lastPage }">
			<a href="notice?command=noticeList&curPage=${i }">${i }</a>
		</c:forEach>
	<c:if test="${block < totalBlock}">
		<a href="notice?command=noticeList&curPage=${nextPage}">[다음]</a>
	</c:if>
	</div>
<jsp:include page="/main/footer.jsp"/>
</div>
</body>
</html>