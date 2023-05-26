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


	



<c:choose>
<c:when test="${sessionScope.userId eq null}">
<a>로그인 후 이용 가능!!</a><br>
<button onclick="location.href='/login/login'">로그인</button>
</c:when>
<c:when test="${sessionScope.userId ne null }">
<c:forEach var="list" items="${list }">
<a href="./chatroom?roomid=${list.chatno }"></a>
</c:forEach>
</c:when>
</c:choose>
</body>
</html>