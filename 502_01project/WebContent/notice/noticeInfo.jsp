<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javaScript">
$(document).ready(function(){
	  $('#button1').click(function(){ //button1을 클릭했을 경우
		  $.ajax({
				type: "POST",
				url: "notice.jhj?command=notice_reply",
				data: {
					no:$("#no").val(),
					reply:$("#replyin").val(),
					sno:$("#sno").val()
					},
				  success: function(mm){
					 $("#re").prepend($(mm));
					 }	  
			});
	  		$('#replyin').val("");
	  });
});
function del_event(no) {
	if (confirm("정말삭제하시겠습니까?")==true) {
		location.href="notice.jhj?command=notice_delete&no=" + no;
	} else {
		return;
	}
		
}
</script>

<style type="text/css">
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

.fl {
	float: right;
	margin-top: 10px;
	margin-right: 10px;
}

#tm {
	float: right;
	font-size: 8pt;
	color: #666666;
}

#replyin {
	width: 500px;
}

#replytb {
	table-layout: fixed;
	width: 850px;
	margin-bottom: 80px;
}
#replytb tr{
	border-bottom: 1px solid #eee;
}

#rp {
	word-break: break-all;
	white-space: pre-wrap;
	width:90%;
}

#rp_id {
	text-align:right;
	table-layout: fixed;
	width:10%;
}
</style>
</head>
<body>
<jsp:include page="../main/top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
		<h1>공지사항 내용</h1>
		<form method="post" action="notice.jhj?command=notice_update_form">
			<table>
				<tr>
					<th width="150px">제목</th>
					<td colspan="5" style="border-bottom: 1px solid #ddd">${noticeInfo.title }</td>
				</tr>
				<tr>
					<th width="150px">작성자</th>
					<td width="150px">${noticeInfo.sName }<input type="hidden"
						id="no" name="no" value="${noticeInfo.no }"> <input
						type="hidden" id="sno" name="sno" value="${sNo }">
					</td>
					<th width="150px">작성일</th>
					<td align="center">${noticeInfo.nRegDt }</td>
					<th width="150px">조회수</th>
					<td width="50px" align="center">${noticeInfo.cnt }</td>
				</tr>
				<tr>
					<th colspan="6">내용</th>
				</tr>
				<tr>
					<td colspan="6"><div style="min-height: 400px">${noticeInfo.content }</div></td>
				</tr>
			</table>
			<%
				String no = request.getParameter("no");
			%>
			<c:choose>
				<c:when test="${admin == 1000}">
					<input type="button" value="삭제" class="fl"
						onclick="del_event(<%=no%>);">
					<input type="submit" value="수정" class="fl">
				</c:when>
			</c:choose>
			<input type="button" value="목록" class="fl" onclick="history.go(-1)">

		</form>

		<div style="max-width: 850px;">
			<table id="replytb">
				<tr><td width="10%"></td><td></td></tr>
				<tr>
					<td colspan="2">
					<textarea rows="3" cols="100" id="replyin"></textarea> 
					<input type="button" id="button1" value="등록">
					</td>
				</tr>
				<tbody id="re"></tbody>
				<c:forEach var="reply" items="${noticerp}">
					<tr>
						<td id="rp_id">${reply.writer } : </td>
						<td id="rp">${reply.reply }<font id="tm">(${reply.regDt })</font></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>