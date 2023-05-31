<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function() {

// 	$("#list").on("click", ".btnDelete", function() {
// 		console.log($(this).attr("data-boardno"));
		
// 		$.ajax({
// 			type: "GET",
// 			data: {boardno:$(this).attr("data-boardno")},
// 			url: "./delete",
// 			success: function () {
// 				console.log("AJAX 처리 성공")
// 			},
// 			error: function() {
// 				console.log("AJAX 처리 실패")
// 			}
// 		})
		
// 	})
	
	
})

</script>

</head>
<body>
<c:choose>
	<c:when test="${boardOption eq 'notice'}">
	<h1>공지사항 관리</h1>
	</c:when>
	<c:when test="${boardOption eq 'event'}">
	<h1>이벤트 관리</h1>
	</c:when>
</c:choose>
<hr>
mt : ${boardOption}
<div id="list">
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
		<button onclick="location.href='./update?boardOption=${boardOption}&adminBoardno=${bl.ADMIN_BOARDNO}&curPage=${paging.curPage}'">수정</button>
		<button onclick="location.href='./delete?boardOption=${boardOption}&adminBoardno=${bl.ADMIN_BOARDNO}&curPage=${paging.curPage}'">삭제</button>
<%-- 		<button class="btnDelete" data-boardno="${bl.ADMIN_BOARDNO}">삭제</button> --%>
	</td>
</tr>	
</c:forEach>

</table>

<c:import url="./paging.jsp"/>

</div>

<div>
<a href="./write?curPage=${paging.curPage}"><button>글작성</button></a>
</div>
</body>
</html>