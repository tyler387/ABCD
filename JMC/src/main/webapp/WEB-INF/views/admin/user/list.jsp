<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<h1>유저 수정 페이지</h1>

<form action="./filter" method="post">
<select name ="filter">
   <option value = "user_id" selected>아이디</option>
   <option value = "user_name">이름</option>
   <option value = "grade">등급</option>
</select>

검색 : <input type="text" name="content">
<button>검색하기</button>
</form>
<table>
<tr>
	<th>아이디</th>
	<th>상태</th>
	<th>이름</th>
	<th>닉네임</th>
	<th>생일</th>
	<th>성별</th>
	<th>폰번호</th>
</tr>
<c:forEach var="users" items="${users }">
<tr>
	<th>${users.userId }</th>
	<th><input type="checkbox" name="status" value="${status }" checked disabled></th>
	<th>${users.userName }</th>
	<th>${users.userNick }</th>
	<th>${users.birth }</th>
	<th>${users.userId }</th>
	<th>${users.userId }</th>
	<th><button>수정</button><button>탈퇴</button></th>
</tr>
</c:forEach>
</table>
<c:import url="./paging.jsp" />
