<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript" src="js/board.js"></script>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
	<form action="login.jhj" method="post">
		<table>
			<tr>
				<td colspan="2">
					<h2>사원 정보 관리 시스템</h2>
				</td>
			</tr>
			<tr>
				<td>
					ID
				</td>
				<td>
					<input type="text" name="sNo">
				</td>
			</tr>
			<tr>
				<td>
					PASSWORD
				</td>
				<td>
					<input type="password" name="userPwd">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="취소"> &nbsp;&nbsp;
					<input type="button" value="회원 가입" onclick="location.href='join.nhn'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>