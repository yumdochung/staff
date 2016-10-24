<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty loginUser}">
	<jsp:forward page="login.do" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="js/staff.js"></script>
</head>
<body>
<h2> 회원 전용 페이지 </h2>
<form action="staff">
<input type="hidden" name="command" value="staff_logout">
<table>
	<tr>
		<td>
		안녕하세요. ${loginUser.snm}(${loginUser.sid })님
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그아웃"> &nbsp;
			<input type="button" value="회원정보변경"
				onclick="location.href='staff?command=staff_update_form&sid=${loginUser.sid }'">&nbsp;
			<input type="button" value="나의 정보보기"
				onclick="location.href='staff?command=staff_info_form&sid=${loginUser.sid }'">
		</td>
	</tr>
</table>
</form>
</body>
</html>