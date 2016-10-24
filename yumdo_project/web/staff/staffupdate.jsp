<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<script type="text/javascript" src="js/staff.js"></script>
</head>
<body>
<div class="main_content">
<jsp:include page="../main/top.jsp"/>
<h2>회원 수정</h2>
<form action="staff" method="post" name="frm">
	<input type="hidden" name="command" value="staff_update">
	<table class="insert_form" style="width: 750px">
		<tr>
			<th> 이름 </th>
			<td> <input type = "text" name="snm" size="20" value="${st.snm}" readonly></td>
		</tr>
		<tr>
			<th> 아이디 </th>
			<td>
			<input type="text" name="sid" size="20" value="${st.sid}" readonly></td>
		</tr>
		<tr>
			<th> 암 &nbsp; 호 *</th>
			<td> <input type="password" name="spwd" size="20" style="width: 300px"></td>
		</tr>
		<tr >
			<th>암호 확인*</th>
			<td><input type="password" name="spwd_check" size="20" style="width: 300px"></td>
		</tr>
		
		
		<tr>
			<th>주민등록번호</th>
			<td> <input type="text" name="jumin" value="${st.jumin}" style="width: 145px;"> -
			     <input type="password" name="jumin" style="width: 145px;"> </td>
		</tr>
		
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="zipcode" class="inputText" value="${st.zipcode}" readonly="readonly" style="width: 300px" >
			<input type="button" value="우편번호검색" class="btn" style="width: 100px" onclick="Zipcode();"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" class="juso" id="addr1" name="addr1" value="${st.addr1}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><input type="text" class="juso" name="addr2" value="${st.addr2}"></td>
		</tr>
		
		
		
		
		<tr>
			<th> 이메일 </th>
			<td> <input type="text" name= "email" size="20" value="${st.email}"></td>
		</tr>
		<tr>
			<th> 전화번호 </th>
			<td> <input type="text" name= "sphone" size="20" value="${st.sphone}"></td>
		</tr>
		<%-- <tr>
			<th> 등급 </th>
			<td>
			<c:choose>
			 <c:when test="${st.admin == 0 }">
			 <input type="radio" name="admin" value="0" checked="checked"> 일반회원
			 <input type="radio" name="admin" value="1"> 관리자
			 </c:when>
			 <c:otherwise>
			 <input type="radio" name="admin" value="0" > 일반회원
			 <input type="radio" name="admin" value="1" checked="checked" > 관리자
			 </c:otherwise>
			 </c:choose>
			 </td>
		</tr> --%>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="확인" onclick="return joinCheck()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>