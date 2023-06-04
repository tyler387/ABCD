<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
    margin-left:auto; 
    margin-right:auto;
}

table, td, th {
    border-collapse : collapse;
    border : 1px solid black;
    text-align: center; 
}
</style>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>



</head>
<body>
</form>
<table>
<tr>
	<th>회원번호</th>
	<th>아이디</th>
	<th>이름</th>
	<th>등급</th>
	<th>닉네임</th>
	<th>가입일</th>
	<th>관리</th>
</tr>
<c:forEach var="users" items="${userfilter }">
<tr>
	<th>${users.userno }</th>
	<th>${users.userId }</th>
	<th>${users.userName }</th>
	<th><c:choose>
		<c:when test="${users.grade eq '1'}">차가움</c:when>
		<c:when test="${users.grade eq	'2'}">보통</c:when>
		<c:when test="${users.grade eq '3'}">따듯함</c:when>
	</c:choose>  </th>
	<th>${users.userNick }</th>
	<th>${users.joinDate }</th>
		<th><a href="./update?userno=${users.userno }"><button>블랙리스트</button></a>
	<a href="./stop?userno=${users.userno }"><button>회원정지</button></a></th>
</tr>
</c:forEach>
</table>
<br><br><br>

<c:import url="./paging.jsp" />