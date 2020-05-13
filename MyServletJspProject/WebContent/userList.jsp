<%-- <%@page import="jdbc.user.vo.UserVO"%>
<%@page import="java.util.List"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
	<%-- List<UserVO> users = (List<UserVO>)request.getAttribute("userList");
	
		/* out.println(users); */
		for(int i = 0; i < users.size(); i++){
			out.println(users.get(i).getName());
			out.println(users.get(i).getUserid());
			out.println(users.get(i).getGender());
			out.println(users.get(i).getCity());
		} 
		
		
	--%>
	
	<table border="1">
		<tr>
			<th>아이디</th><th>이름</th><th>성별</th><th>주소</th>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.userid}</td><td>${user.name}</td><td>${user.gender}</td><td>${user.city}</td>
		</tr>
		</c:forEach>
		<hr/>		
	</table>
	
	<%-- EL(Expression Language) --%>
	${userList}
</body>
</html>