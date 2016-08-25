<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Mars</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/comm.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- <script src="../js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="../css/jquery-ui.css"> -->
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
	
		<p style="font-size: 25pt; font-weight: 10px; font-face:Century; text-shadow: 2px 2px 2px gray; margin-top: 0px; margin-bottom: 0px; text-align: center;">
		Welcome to Mars have a good time
		</p><br>
		<table style="margin-left: auto;">
			<tr>
				<td align="left" width="300px">공지사항</td>
				
				
				<c:choose>
						<c:when test="${ck=='0' }">
							<td align="right"><a href="notice.jhj?command=notice_list">more</a></td>
						</c:when>
						<c:otherwise>
							<td align="right">more</td>
						</c:otherwise>
					</c:choose>
			</tr>
			<c:forEach items="${notice }" var="notice">
				<tr>
					<c:choose>
						<c:when test="${ck=='0' }">
							<td><a href="notice.jhj?command=notice_info&no=${notice.no }">${notice.title }</a></td>
						</c:when>
						<c:otherwise>
							<td>${notice.title }</td>
						</c:otherwise>
					</c:choose>
					<td>(${notice.nRegDt })</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="modal.jsp"></jsp:include>
</body>
</html>