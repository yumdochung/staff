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

input {
	font-size: 15pt;
	border: 1px solid #ccc;
	height: 30px;
}

textarea {
	font-size: 15pt;
	width: 850px;
	height: 350px;
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
		<h1>공지사항 수정</h1>
		<form method="post" action="notice.jhj?command=notice_update">
			<table>
				<tr>
					<th width="150px">제목</th>
					<td><input type="text" name="title" style="width: 700px"
						value="${update.title }"></td>
				</tr>
				<tr>
					<th colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content">${update.content }</textarea>
						<input type="hidden" name="no" value="${update.no }">
					</td>
				</tr>
			</table>
			<input type="button" value="취소" onclick="history.go(-1)"
				style="float: right; margin-top: 10px; margin-right: 10px">
			<input type="submit" value="수정"
				style="float: right; margin-top: 10px; margin-right: 10px">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>