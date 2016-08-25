<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

legend {
	display: none
}

img {
	border: none
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

.join_tbl tr .A {
	text-align: center;
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
	width: 120px;
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

h2 {
	margin: 20px 0
}

.tab-content {
	padding: 10px 0;
}
</style>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
	<h2>사원 정보 목록</h2>
	<form method="post" action="staff.jhj?command=staff_select_by_keyword">
		<table class="join_tbl">
			<tr>
				<th>I D</th>
				<td><input type="text" name="sno" class="inputText"></td>
				<th>입사일</th>
				<td><input type="text" name="joindt1" class="inputText">~
					<input type="text" name="joindt2" class="inputText"></td>
			</tr>
			<tr>
				<th>사원명</th>
				<td><input type="text" name="sname" class="inputText"></td>
				<td colspan="2" align="right"><input type="submit" value="조회"
					class="inputText"></td>
			</tr>
		</table>
		<table class="join_tbl">
			<tr>
				<th>순번</th>
				<th>사원명</th>
				<th>직급</th>
				<th>등록일</th>
			</tr>
		<c:forEach var="staff" items="${staffList}" varStatus="i">
				<tr>
					<td>
						${i.count}
					</td>
					<td>
						<a href="staff.jhj?command=staff_info&sno=${staff.sNo }">${staff.sName}</a>
					</td>
					<td>
						<c:choose>
							<c:when test="${staff.jobCd == '0000' }">
								사원
							</c:when>
							<c:when test="${staff.jobCd == '0001' }">
								주임
							</c:when>
							<c:when test="${staff.jobCd == '0002' }">
								대리
							</c:when>
							<c:when test="${staff.jobCd == '1001' }">
								과장
							</c:when>
							<c:when test="${staff.jobCd == '1002' }">
								차장
							</c:when>
							<c:when test="${staff.jobCd == '1003' }">
								부장
							</c:when>
							<c:when test="${staff.jobCd == '2001' }">
								상무
							</c:when>
							<c:when test="${staff.jobCd == '3001' }">
								대표
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						${staff.regDt}
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${block > 1}">
			<a href="staff.jhj?command=staff_list&curPage=${prevPage}">[이전]</a>
		</c:if>
			<c:forEach var="j" begin="${firstPage }" end="${lastPage }">
				<a href="staff.jhj?command=staff_list&curPage=${j }">${j }</a>
			</c:forEach>
		<c:if test="${block < totalBlock}">
			<a href="staff.jhj?command=staff_list&curPage=${nextPage}">[다음]</a>
		</c:if>

	</form>
	</div> 
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>