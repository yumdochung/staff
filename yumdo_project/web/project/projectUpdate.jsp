<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/project.js"></script>
</head>
<body>
<div class="main_content">
<jsp:include page="../main/top.jsp"/>
<div id="wrap" align="center">
<input type="hidden" name="sid" value="${loginUser.sid}">
	<h1> 프로젝트 수정 </h1>
	<form name="frm" method="post" action="project">
	<input type="hidden" name="command" value="project_update">
	<input type="hidden" name="num" value="${project.num}">
	<table class="insert_form">
		<tr>
			<th>작성자</th>
			<td><input type="text" size="12" name="name" value="${loginUser.snm}" readonly>
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" size="12" name="pass" >
			*필수 (게시물 수정 삭제시 필요합니다.)</td>
		</tr>
		
		<tr>
			<th>기간</th>
			<td><input type="text" size="30" maxlength="50" name="startterm" value="${project.startterm}"> ~ 
				<input type="text" size="30" maxlength="50" name="endterm" value="${project.endterm}">
			</td>
		</tr>
		
		<tr>
			<th>사용 스킬</th>
			<td><input type="text" size="30" name="skill" value="${project.skill}"></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" size="70" name="title" value="${project.title}"></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content" >${project.content}</textarea></td>
		</tr>
	</table>
	<br><br>
	<input type = "submit" value = "등록" onclick="return projectCheck()">
	<input type = "reset" value = "다시 작성">
	<input type = "button" value = "목록" onclick="location.href='project?command=project_list'">
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>