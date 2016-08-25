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
	border: none;
}

legend {
	display: none;
}

img {
	border: none;
	width: 130px;
	height: 180px;
}

.join_tbl {
	width: 850px;
	border-collapse: collapse;
	border-spacing: 0;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	font-size: 15px;
	font-family: dotum;
	margin-bottom: 30px;
	margin-top: 30px;
}

.join_tbl th {
	text-align: left;
	padding: 5px 10px;
	border-bottom: 1px solid #ddd;
	color: #3f93c7;
	background-color: #e6e6e6
}

.join_tbl td {
	padding: 5px 15px;
	border-bottom: 1px solid #ddd
}

.join_tbl td .inputText {
	width: 100px;
	border: 1px solid #ccc
}

.join_tbl td .zipcode {
	width: 45px;
	border: 1px solid #ccc
}

.join_tbl td .juso {
	width: 220px;
	border: 1px solid #ccc
}

.join_tbl td .hp {
	width: 30px;
	border: 1px solid #ccc
}

.join_tbl td .select {
	width: 100px;
	border: 1px solid #ccc
}

.join_tbl td .btn {
	border: 1px solid #ccc;
	padding: 3px 5px;
	font-size: 11px;
	font-family: dotum;
	margin-left: 3px;
	border-radius: 5px;
}

.join_tbl td span {
	color: #888
}

.join_tbl textarea {
	width: 95%;
	height: 80px;
	border: 1px solid #ccc;
	padding: 10px
}

.btn {
	text-align: center
}
</style>
<script type="text/javascript">
</script>
</head>

<body>
<jsp:include page="../main/top.jsp"></jsp:include>
<div style="margin: 0 auto; width: 850px;">
<h2>프로젝트 목록</h2>
<form method="post" action="pjtCtrl.jhj?command=project_search">
<table class="join_tbl">
<tr>
<th>I D</th>
<td><input type="text" name="writer" class="inputText"></td>
<th>등록일</th>
<td><input type="text" name="startdt1" class="inputText">~
<input type="text" name="startdt2" class="inputText">
</td>
</tr>
<tr>
<th>프로젝트명</th>
<td><input type="text" name="prjtnm" class="inputText"></td>
<td colspan="2" align="right">
<input type="submit" value="조회" class="inputText" style="margin-right: 110px">
</td>
</tr>
</table>
<table class="join_tbl">
<tr>
<th style="width: 80px">순번</th><th>프로젝트명</th><th style="width: 130px" align="center">마감일</th><th style="width: 130px" align="center">등록일</th><th style="width: 150px">상태</th>
</tr>
<c:forEach var="prjt" items="${prjt }" varStatus="status">
	<tr>
		<td>
			${status.count }
		</td>
		<td>
			<a href="pjtCtrl.jhj?command=project_info&prjtno=${prjt.prjtno }">${prjt.prjtnm }</a>
		</td>
		<td>
			${prjt.enddt }
		</td>
		<td>
			${prjt.regdt }
		</td>
		<td>
			${prjt.status }
		</td>
	</tr>
</c:forEach>
</table>
</form>
<c:if test="${block > 1}">
			<a href="pjtCtrl.jhj?command=project_list&curPage=${prevPage}">[이전]</a>
		</c:if>
			<c:forEach var="i" begin="${firstPage }" end="${lastPage }">
				<a href="pjtCtrl.jhj?command=project_list&curPage=${i }">${i }</a>
			</c:forEach>
		<c:if test="${block < totalBlock}">
			<a href="pjtCtrl.jhj?command=project_list&curPage=${nextPage}">[다음]</a>
		</c:if>
</div>
<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>