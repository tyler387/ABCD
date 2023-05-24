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
<h1>필터된 유저 목록 페이지</h1>

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
	<th>이름</th>
	<th>닉네임</th>
	<th>생일</th>
	<th>성별</th>
	<th>폰번호</th>
	<th>관리</th>
</tr>
<c:forEach var="users" items="${userfilter }">
<tr> 
	<th>${users.userId }</th>
	<th>${users.userName }</th>
	<th>${users.userNick }</th>
	<th>${users.birth }</th>
	<th>${users.userId }</th>
	<th>${users.userId }</th>
	<th><button>수정</button><button>탈퇴</button></th>
	
</tr>
</c:forEach>
</table>

</body>
</html>