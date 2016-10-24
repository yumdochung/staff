<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
</head>
<body>
<div class="main_content">
<jsp:include page="../main/top.jsp"/>
<h2>사원 정보</h2>
<form action="staff" method="post" name="frm">
<table class="insert_form">
	<tr>
		<th>이름</th>
		<td>${loginUser.snm}</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>${loginUser.sid}</td>
	<tr>
		<th>직급</th>
		<td>${loginUser.jobcd}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${loginUser.sphone}</td>
	</tr>
	<tr>
		<th>email</th>
		<td>${loginUser.email}</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" value="정보수정"
				onclick="location.href='staff?command=staff_update_form&sid=${loginUser.sid }'">
		</td>
	</tr>
</table>
</form>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>