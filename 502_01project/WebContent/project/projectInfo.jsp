<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3 {
	margin-bottom: 15px
}

fieldset {
	border: none
}

table {
	width: 850px;
	border-collapse: collapse;
	border-spacing: 0;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	font-size: 15px;
	font-family: dotum;
}

th {
	height: 30px;
	border-bottom: 1px solid #ddd;
	color: #3f93c7;
	background-color: #e6e6e6;
	text-align: center;
}
input{
	font-size: 15pt;
	border: 1px solid #ccc;
	height: 30px; 
}
textarea {
	font-size: 15pt;
	width: 698px;
	border: 1px solid #ccc;
}
button {
	font-size: 20pt;
 	padding: 15px;
}
td{
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
<div style="width: 850px; margin: 0 auto;">
<h2>프로젝트 정보</h2>
<form method="post" action="pjtCtrl.jhj?command=project_update_form">

<style type="text/css">
th {
	height: 30px;
	border-bottom: 1px solid #ddd;
	color: #3f93c7;
	background-color: #e6e6e6;
	text-align: center;
}
</style>

<table>
<tr>
<th width="150px">사번</th>
<td colspan="4">${prjt.writer }
<input type="hidden" name="prjtno" value="${prjt.prjtno }">
</td>
</tr>
<tr>
<th width="150px">프로젝트 명</th>
<td colspan="4">${prjt.prjtnm }</td>
</tr>
<tr>
<th width="150px">기간</th>
<td align="center"  colspan="4">
${prjt.startdt } &nbsp;&nbsp;&nbsp; ~ &nbsp;&nbsp;&nbsp; ${prjt.enddt }
</td>
</tr>
<tr>
<th width="150px">발주처</th>
<td colspan="4">${prjt.ordernm }</td>
</tr>
<tr>
<th width="150px">스킬</th>
<td colspan="4"><div style="min-height: 50px">${prjt.prjtskill }</div>

</td>
</tr>
<tr>
<th width="150px">상세내용</th>
<td colspan="4"><div style="min-height: 200px">${prjt.prjtcontent }</div>
</td>
</tr>
<tr>
<th width="150px" rowspan="${seq +1}">참여사원</th>
<th width="150px">사번</th><th>사원명</th><th>부서</th><th>역할</th>
</tr>
<c:forEach var="staff" items="${staff }" >
<tr style="text-align: center;">
<td>${staff.sno }</td><td>${staff.sname }</td><td>${staff.deptname }</td><td>${staff.rolecd }</td>
</tr>
</c:forEach>

</table>
<input type="button" value="삭제" onclick="location.href='pjtCtrl.jhj?command=project_delete&prjtno=${prjt.prjtno}'" style="float: right;margin-top: 10px; margin-right: 10px">
<input type="submit" value="수정" style="float: right; margin-top: 10px; margin-right: 10px">
<input type="button" value="목록" style="float: right; margin-top: 10px; margin-right: 10px" onclick="location.href='pjtCtrl.jhj?command=project_list'">
</form>
</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>