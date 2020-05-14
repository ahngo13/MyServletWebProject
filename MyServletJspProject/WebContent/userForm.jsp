<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 등록</h2>
	<form action="userInsert.do" method="post">
		<input type="hidden" name="cmd" value="user_insert">
		UserID : <input type="text" name="userid"><br>
		name : <input type="text" name="name"><br>
		gender : <select name="gender">
			<option value="남">남자</option>
			<option value="여">여자</option>
		</select><br>
		city : <select name="city">
					<c:forEach var="cityName" items="${sessionScope.cityList}">
						<option value="${cityName}">${cityName}</option>
					</c:forEach>
				</select>
		<br>
		<input type="submit" value="저장하기">
	</form>
</body>
</html>