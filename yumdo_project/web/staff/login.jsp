<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회 원 관 리 </title>
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<script type="text/javascript" src="js/staff.js"></script>
</head>
<body>
<div class="main_content">
<jsp:include page="/main/top.jsp"></jsp:include>
<div class="login_form">

<form action="staff" method="post" name="frm">
<input type="hidden" name="command" value="staff_login">
			<div><span style="font-size: 17px;font-weight: bold;">아이디</span><input type="text" name="sid" value="${sid}" style="float: right;width: 200px;padding: 5px;border: 1px solid #e1e1e1;border-radius:5px"></div>
			<div><span style="font-size: 17px;font-weight: bold;">암호</span><input type="password" name="spwd" style="float: right;width: 200px;padding: 5px;border: 1px solid #e1e1e1;border-radius:5px"></div>
			<div style="text-align: center;">
				<input type="submit" value="로그인" onclick="return loginCheck()">
				<input type="button" onclick="location.href='staff?command=staff_insert_form'" value="회원가입">
			</div>
</form>
</div>
<jsp:include page="/main/footer.jsp"></jsp:include>
</div>
</body>
</html>