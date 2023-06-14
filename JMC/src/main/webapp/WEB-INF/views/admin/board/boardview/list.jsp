<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

<style>
table {
    margin-left:auto; 
    margin-right:auto;
}

table, td, th {
    border-collapse : collapse;
    text-align: center; 
}

div.admin1 {
        height: 650x;
      	padding-left: 60px;
    width: 98%;
        
}

.innerTitle {
	margin: 0 auto;
	border-radius: 30px; 
	background-color : #03a9f46e; 
	width: 600px;  
	text-align: center; 
	padding-bottom: 5px;
}

</style>

<c:import url="../../main.jsp"/>
<div id="Alltitle" style="text-align: center; padding-top: 10px;">
<c:choose>
	<c:when test="${boardOption eq 'notice'}">
	<h1 class="innerTitle">공지사항 관리</h1>
	</c:when>
	<c:when test="${boardOption eq 'event'}">
	<h1 class="innerTitle">이벤트 관리</h1>
	</c:when>
</c:choose>
</div>

<%-- mt : ${boardOption} --%> 

<div id="list" class="admin1">
<table class="table table table-hover">
<tr class="table-secondary">
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
		<button onclick="location.href='./update?boardOption=${boardOption}&adminBoardno=${bl.ADMIN_BOARDNO}&curPage=${paging.curPage}'" class="btn btn-secondary">수정</button>
		<button onclick="location.href='./delete?boardOption=${boardOption}&adminBoardno=${bl.ADMIN_BOARDNO}&curPage=${paging.curPage}'" class="btn btn-secondary">삭제</button>
<%-- 		<button class="btnDelete" data-boardno="${bl.ADMIN_BOARDNO}">삭제</button> --%>
	</td>
</tr>	
</c:forEach>

</table>

<c:import url="../../paging.jsp"/>

</div>

<div>
<a href="./write?curPage=${paging.curPage}" ><button  class="btn btn-secondary">글작성</button></a>
</div>
</div>
</div>
</body>
</html>