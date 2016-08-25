<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/comm.js"></script>	
  </head>
  <c:choose>
  <c:when test="${ck =='2'}"><body onload="alert('아이디와 비밀번호를 확인하세요');"></c:when>
  <c:otherwise><body></c:otherwise>
  </c:choose>
  <p style="text-align: center;
    background: #e1e1e1;
    margin: 0;
    padding: 0;">
 <div class="container">  
    <nav class="navbar navbar-default" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="main.jhj">사원 관리 시스템</a>
      </div>
     
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">사원 정보 <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="staff.jhj?command=staff_list">사원 목록</a></li>
              <li><a href="staff.jhj?command=staff_insert_form">사원 등록</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">프로젝트 정보 <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="pjtCtrl.jhj?command=project_list">프로젝트 목록</a></li>
              <li><a href="pjtCtrl.jhj?command=project_insert_form">프로젝트 등록</a></li>
            </ul>
          </li>
          <li class="nav" >
            <a href="notice.jhj?command=notice_list">공지사항</a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
         <c:choose>
        	<c:when test="${ck =='1'}">
        	<li class="nav">
        	<a onclick="loginform();">로그인 </a>
        	</li>
          	</c:when>
          	<c:when test="${ck =='0'}">
        	<li class="nav">
          		<a class="glyphicon glyphicon-user" aria-hidden="true" href="staff.jhj?command=staff_info&sno=${sNo }">${sNo }님 </a>
          	</li>
          	<li class="nav">
          	<a href="staff.jhj?command=logout">로그아웃 </a>
          	</li>
          	</c:when>
          	<c:otherwise>
          	<li class="nav">
        	<a onclick="loginform();">로그인 </a>
        	</li>
        	</c:otherwise>
        	</c:choose>
        </ul>
			        
      </div><!-- /.navbar-collapse -->
    </nav>
</div>
</body>
</html>