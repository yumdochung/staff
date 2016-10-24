<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<link rel="stylesheet" href="/css/slide.css" type="text/css"/>
<title>welcome to Mars</title>
<style type="text/css">
.table{width: 490px;border-radius:5px;border:1px solid #e1e1e1; background: #ddd;}
.table div{height: 23px;padding: 5px;}
.table span{float: left;text-align: center;}
</style>
</head>
<body>
<div class="main_content">
<jsp:include page="top.jsp"/>

	<!-- 슬라이드시작 -->
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
						<li><img src="img/main1.jpg" alt="image01" /></li>
						<li><img src="img/main2.jpg" alt="image02" /></li>
						<li><img src="img/main3.jpg" alt="image03" /></li>
						<li><img src="img/main4.jpg" alt="image04" /></li>
						<li><img src="img/main5.jpg" alt="image05" /></li>
					</ul>
				</div><!-- sp-content -->
				
			</div><!-- sp-slideshow -->
			
		</div>
		
		<!-- 슬라이드 끝 -->
	<h4 align="right"><a href="/notice?command=noticeList">notice list</a></h4>

	<div class="table" style="float:right">
	<div style="background: #fff;">
		<span style="width: 50px;">번호</span>
		<span style="width: 300px;">제목</span>
		<span style="width: 130px;">등록일</span></div>
	<c:forEach items="${notice}" var="result">
	<div>
		<span style="width: 50px;">${result.num }</span>
		<span style="width: 300px;text-align: left;"><a href="/notice?command=noticeDetail&num=${result.num }">${result.title}<c:if test="${result.replycount>0}">[${result.replycount }]</c:if></a></span>
		<span style="width: 130px;">${result.regdt}</span>
	</div>
	</c:forEach>
	</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>