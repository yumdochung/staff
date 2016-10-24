<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/staff.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="/css/custom2.css" type="text/css"/>
<link rel="stylesheet" href="/css/jquery-ui.css" type="text/css"/>
<style type="text/css">
.insert_form input{
	width: 300px;
}
.insert_form th{
width: 180px;}
/* .btn {
	text-align: center
}
#print{
	font-size: 8pt;
} */
</style>
</head>
<body>
<div class="main_content">
<jsp:include page="/main/top.jsp"></jsp:include>
<div class="insert_form">
<h2>회원 가입</h2>
<form action="staff" method="post" name="frm">
<input type="hidden" name="command" value="staff_insert">
	<table style="width: 750px">
		<tr>
			<th> 이름		 </th>
			<td><input type="text" name="snm" size="20" ></td>
		</tr>
		<tr>
			<th> 아이디 	 </th>
			<td>
				<input type="text"	    name="sid"	size="20" >
				<input type="hidden"    name="reid"		size="20" >
				<input type="button"	value="중복체크"	onclick="idCheck()" style="width: 100px">
			</td>
		</tr>
		<tr>
			<th> 암  호 	</th>
			<td> <input type="password" name="spwd" size="20"></td>
		</tr>
		<tr height="30">
			<th width="80">암호 확인 </th>
			<td><input type="password" name="spwd_check" size="20"></td>
		</tr>
		<tr>
			<th>주민등록번호</th>
			<td> <input type="text" name="jumin" style="width: 145px;"> -
			     <input type="password" name="jumin" style="width: 145px;"> </td>
		</tr>
		
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="zipcode" class="inputText" readonly="readonly">
			<input type="button" value="우편번호검색" class="btn" style="width: 100px" onclick="Zipcode();"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" class="juso" id="addr1" name="addr1" readonly="readonly"></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><input type="text" class="juso" name="addr2"></td>
		</tr>
		<tr>
			<th> 이메일	</th>
			<td> <input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<th> 전화번호	</th>
			<td> <input type="text" name="sphone" size="20"></td>
		</tr>
<!-- 		<tr>
			<th> 등급		</th>
			<td>
				<input type="radio" name="admin" value="0" checked="checked"> 일반회원
				<input type="radio" name="admin" value="1"> 관리자
			</td>
		</tr> -->
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="확인" onclick="return joinCheck()" style="width: 100px">
			</td>
		</tr>
<%-- 		<tr><td colspan="2">${message }</td></tr> --%>
	</table>
</form>
</div>
<jsp:include page="/main/footer.jsp"></jsp:include>
<jsp:include page="/main/modal.jsp"></jsp:include>
</div>
</body>
</html>