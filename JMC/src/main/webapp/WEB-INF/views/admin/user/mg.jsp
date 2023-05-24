<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>유저 수정 페이지</h1>

<form action="admin/user/filter" method="post">
검색 : <input type="text" name="filter">
<button>검색하기</button>
</form>
<table>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>닉네임</th>
	<th>생일</th>
	<th>성별</th>
	<th>폰번호</th>
</tr>
<c:forEach var="users" items="${users }">
<tr>
	<th>${users.userId }</th>
	<th>${users.userName }</th>
	<th>${users.userNick }</th>
	<th>${users.birth }</th>
	
</tr>
</c:forEach>
</table>
</body>
</html>