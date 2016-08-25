<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {	width: 110px;float: right;margin-right: 0px;}
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


a {
	text-decoration: none;	
	color : black;			
}
</style>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
<div style="width: 850px; margin: 0 auto;">
		<h2>공지사항 리스트 </h2>
		<p>
<%-- 		<c:choose>
		<c:when test="${admin == 1000}"> --%>
		<a href="notice.jhj?command=notice_insert_form"> 게시글 등록 </a>
<%-- 		</c:when>
		</c:choose> --%>
		</p>
		<table class="join_tbl">

			<tr>
				<th style="width: 80px;">
					번 &nbsp; 호
				</th>
				<th style="width: 450px">
					제 &nbsp; 목 
				</th>
				<th style="width: 100px; text-align: center;">
					작성일
				</th>
				<th style="width: 80px">
					조 &nbsp; 회
				</th>
			</tr>
			<c:forEach var="notice" items="${noticeList }" >
				<tr class="record">
					<td align="center">
						${notice.no }
					</td>
					<td>
						<a href="notice.jhj?command=notice_info&no=${notice.no }">
							${notice.title } 
							<c:choose>
							<c:when test="${notice.comcnt > 0}">
							<font style="font-size: 8px">[${notice.comcnt }]</font>
							</c:when>
						</c:choose>
						</a>
						<c:choose>
							<c:when test="${notice.latest == '1' }">
								<img src="img/new.gif">								
							</c:when>
						</c:choose>
					</td>
						
					<td align="center">
						${notice.nRegDt }
					</td>
					<td align="center">
						${notice.cnt }
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${block > 1}">
			<a href="notice.jhj?command=notice_list&curPage=${prevPage}">[이전]</a>
		</c:if>
			<c:forEach var="i" begin="${firstPage }" end="${lastPage }">
				<a href="notice.jhj?command=notice_list&curPage=${i }">${i }</a>
			</c:forEach>
		<c:if test="${block < totalBlock}">
			<a href="notice.jhj?command=notice_list&curPage=${nextPage}">[다음]</a>
		</c:if>
	</div>
	
</body>

</html>
<jsp:include page="../main/footer.jsp"></jsp:include>