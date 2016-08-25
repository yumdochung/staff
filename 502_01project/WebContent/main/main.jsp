<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Mars</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/comm.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- <script src="../js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="../css/jquery-ui.css"> -->

        <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div style="width: 850px; margin: 0 auto;">
	
	<!-- 여기서부터는 슬라이드 css -->
	<div class="container">
			<div class="sp-slideshow">
			
				<input id="button-1" type="radio" name="radio-set" class="sp-selector-1" checked="checked" />
				<label for="button-1" class="button-label-1"></label>
				
				<input id="button-2" type="radio" name="radio-set" class="sp-selector-2" />
				<label for="button-2" class="button-label-2"></label>
				
				<input id="button-3" type="radio" name="radio-set" class="sp-selector-3" />
				<label for="button-3" class="button-label-3"></label>
				
				<input id="button-4" type="radio" name="radio-set" class="sp-selector-4" />
				<label for="button-4" class="button-label-4"></label>
				
				<input id="button-5" type="radio" name="radio-set" class="sp-selector-5" />
				<label for="button-5" class="button-label-5"></label>
				
				<label for="button-1" class="sp-arrow sp-a1"></label>
				<label for="button-2" class="sp-arrow sp-a2"></label>
				<label for="button-3" class="sp-arrow sp-a3"></label>
				<label for="button-4" class="sp-arrow sp-a4"></label>
				<label for="button-5" class="sp-arrow sp-a5"></label>
				
				<div class="sp-content">
					<div class="sp-parallax-bg"></div>
					<ul class="sp-slider clearfix">
						<li><img src="../img/main1.jpg" alt="image01" /></li>
						<li><img src="../img/main2.jpg" alt="image02" /></li>
						<li><img src="../img/main3.jpg" alt="image03" /></li>
						<li><img src="../img/main4.jpg" alt="image04" /></li>
						<li><img src="../img/rudfl.jpg" alt="image05" /></li>
					</ul>
				</div><!-- sp-content -->
				
			</div><!-- sp-slideshow -->
			
			<p class="note">Placeholder text from <a href="http://hipsteripsum.me">http://hipsteripsum.me</a></p>
		</div>
		
<!-- 		여기까지 슬라이드 css끝 -->
		
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