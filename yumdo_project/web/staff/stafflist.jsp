<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<title>회원 정보 페이지</title>
</head>
<body>
<div class="main_content">
<jsp:include page="../main/top.jsp"/>
<h2>회원 정보 페이지</h2>
<form action="staff" method="post" name="frm">
<table class="insert_form">
	<tr>
		<th>입사일</th>
		<th>이름</th>
		<th>연락처</th>
		<th>email</th>
	</tr>
	<tbody>
		<c:forEach var="staff" items="${staffList }">
	<%-- <tr class="${staff.sid}"> --%>
	<tr>
		<td>${staff.joindt}</td>
		<td>${staff.snm}</td>
		<td>${staff.sphone}</td>
		<td>${staff.email}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</form>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>