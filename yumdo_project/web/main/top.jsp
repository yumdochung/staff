<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="height: 50px;position:relative;background: #efefef;border: 1px solid #e1e1e1; border-radius:5px;">
	<div class="logo" onclick="location.href='/main'">Mars</div>
	<div style="position: relative;margin-left: 20px;float: left;">
	<ul class="nav">
		<li><a href="../staff?command=staff_list">회원 목록</a></li>
		<li><a href="/project?command=project_list">프로젝트</a></li>
		<li><a href="/notice?command=noticeList">공지사항</a></li>
	</ul>
	</div>
	<div style="float: right;">
	<ul class="nav">
		<c:if test="${loginUser eq null }">
		<li><a href="/staff?command=staff_login_form">로그인</a></li>
		<li><a href="/staff?command=staff_insert_form">회원가입</a></li>
		</c:if>
		<c:if test="${loginUser ne null }">
		<li><a href="/staff?command=staff_logout">로그아웃</a></li>
		<li><a href="/staff?command=staff_info_form&sid=duaehcjd">내정보보기</a></li>
		</c:if>
	</ul>
	</div>
</div>
