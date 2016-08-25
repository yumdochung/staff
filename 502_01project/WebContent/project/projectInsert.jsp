<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	background-color: #e6e6e6
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
</style>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
<div style="width: 850px; margin: 0 auto;">
<h2>프로젝트 등록</h2>
<form method="post" action="pjtCtrl.jhj?command=project_insert2_form">
<table>
<tr>
<th width="150px">사번</th>
<td><input type="text" name="writer" value="${sNo }" readonly="readonly" style="width: 700px"></td>
</tr>
<tr>
<th width="150px">프로젝트 명</th>
<td><input type="text" name="prjtnm" style="width: 700px"></td>
</tr>
<tr>
<th width="150px">기간</th>
<td align="center"><input type="text" name="startdt" style="width: 250px">
&nbsp;&nbsp;&nbsp; ~ &nbsp;&nbsp;&nbsp;<input type="text" name="enddt" style="width: 250px">
</td>
</tr>
<tr>
<th width="150px">발주처</th>
<td><input type="text" name="ordernm" style="width: 700px"></td>
</tr>
<tr>
<th width="150px">스킬</th>
<td><textarea name="prjtskill" style="height: 100px"></textarea>
</td>
</tr>
<tr>
<th width="150px">상세내용</th>
<td><textarea name="prjtcontent" style="height: 300px"></textarea>
</td>
</tr>
</table>
<input type="button" value="취소" onclick="location.href='pjtCtrl.jhj?command=project_list'" style="float: right;margin-top: 10px; margin-right: 10px">
<input type="submit" value="다음" style="float: right; margin-top: 10px; margin-right: 10px">
</form>
</div>
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>