<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setContentType("text/html");
response.setCharacterEncoding("utf-8");
String ss = request.getParameter("content");

out.print("<tr><td>이름 : "+ss+"<span style='font-size: 13px; margin-right: 0px;'><a href='#'>삭제</a>(2015-07-31 12:03)</span></td></tr>");
%>
