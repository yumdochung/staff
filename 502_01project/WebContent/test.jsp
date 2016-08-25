<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ad = request.getParameter("dong");

response.setContentType("text/html");
response.setCharacterEncoding("UTF-8");

String obj = "<table border='1'>"
  		+ "<tr><th>우편번호</th><th width='350px;'>주소</th></tr>"
		+ "<tr><td></td><td></td></tr>"
  		+ "</table>";
  out.print(obj);

%>