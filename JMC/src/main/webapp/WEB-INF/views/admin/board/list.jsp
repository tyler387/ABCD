<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${boardOption eq 'notice'}">
	<h1>공지사항</h1>
	</c:when>
	<c:when test="${boardOption eq 'event'}">
	<h1>이벤트</h1>
	</c:when>
</c:choose>
<hr>
mt : ${boardOption}
<div>
<table>
<tr>
	<th>번호</th>
	<th>관리자 아이디</th>
	<th>제목</th>
	<th>작성일</th>
	<th>관리</th>
</tr>

<c:forEach var="bl" items="${boardList}">
<tr>
	<td>${bl.ADMIN_BOARDNO}</td>
	<td>${bl.USER_ID}</td>
	<td>${bl.TITLE}</td>
	<td>${bl.WRITE_DATE}</td>
	<td> 
		<button>수정</button>
		<button>삭제</button>
	</td>
</tr>	
</c:forEach>

</table>

<c:import url="./paging.jsp"/>

</div>

<div>
<a href="./noticeWrite"><button>글작성</button></a>
</div>
</body>
</html>