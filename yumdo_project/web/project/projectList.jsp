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
</head>
<body>
<div class="main_content">
<jsp:include page="../main/top.jsp"/>
<div id="wrap" align="center">
<h1> 프로젝트 리스트 </h1>
<table class="insert_form">
	<tr>
		<td colspan="5" style="border: white; text-align: right">
			<a href="project?command=project_write_form">프로젝트 등록</a>
		</td>
	</tr>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th></tr>
	<c:forEach var="project" items="${projectList }" >
	<tr class="record">
		<td>${project.num }</td>
		<td>
			<a href="project?command=project_view&num=${project.num}">
				${project.title}
			</a>
		</td>
		<td>${project.snm}</td>
		<td>${project.regdt}</td>
		<td>${project.readcount}</td>
	</tr>
	</c:forEach>
</table>
</div>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>