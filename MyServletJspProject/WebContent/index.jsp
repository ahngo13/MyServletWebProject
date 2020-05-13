<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이 주석은 소스보기에서 보여요 -->
	<%-- 이 주석은 소스보기에서 안보여요
	내장객체(implicit object)
	out : PrinterStream --%>
	<%
		Date myDate = new Date();
		out.println(myDate);
	%>
	<h2>현재 날짜는 <%=myDate %></h2>
	<ul>
		<li><h4><a href="userlist.do?cmd=user_list">사용자 리스트</a></h4></li>
		<li><h4><a href="userForm.do?cmd=user_form">사용자 등록</a></h4></li>
	</ul>
</body>
</html>