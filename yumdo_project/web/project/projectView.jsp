<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h1> 프로젝트 상세보기 </h1>
	<table class="insert_form">
		<tr>
			<th> 작성자 </th> <td> ${project.snm}</td>
			<th> 기간 </th> <td> ${project.startterm} ~ ${project.endterm}</td>
		</tr>
		<tr>
			<th> 사용 스킬</th>
			<td colspan="3"> ${project.skill}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${project.title }</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td colspan="3"><pre>${project.content }</pre></td>
		</tr>
	</table>
	<br> <br>
	<input type="button" value="프로젝트 수정" onclick="open_win('project?command=project_checkpass_form&num=${project.num}','update')">
	<input type="button" value="프로젝트 삭제" onclick="open_win('project?command=project_checkpass_form&num=${project.num}','delete')">
	<input type="button" value="프로젝트 리스트" onclick="location.href='project?command=project_list'">
	<input type="button" value="프로젝트 등록" onclick="location.href='project?command=project_write_form'">
</div>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>