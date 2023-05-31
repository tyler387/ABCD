<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#searchBtn").click(function() {
		
		 $.ajax({
		type: "post"
		, url: "./filter"
		, data:  {filter : $("#filter").val(), content : $("#content").val()}
		, dataType: "html" 
		, success: function( res ) {
			console.log("AJAX 성공")
			$("#qnAList").html(res)
		}
		, error: function() {
			console.log("AJAX 실패")
		}
	})
	
	//AJAX로 구현하려 고민중... 안하는게 좋을것 같음..
// 	$("#btnDelete").click(function() {
		
// 		 $.ajax({
// 				type: "post"
// 				, url: "./delete"
// 				, data:  {answerno: $(this).attr("data-answerno"), curPage:}
// 				, dataType: "html" 
// 				, success: function( res ) {
// 					console.log("AJAX 성공")
// 					$("#qnAList").html(res)
// 				}
// 				, error: function() {
// 					console.log("AJAX 실패")
// 				}
		
// 		})
// 	})
	
})
</script>
</head>
<body>

<h1>QnA 관리</h1>
<hr>

<div class="text-end" style="padding-right: 50px; padding-top: 15px; margin-bottom:15px;">
<select name ="filter" id="filter">
   <option value="user_id" selected>아이디</option>
   <option value="user_name">이름</option>
   <option value="q_title">제목</option>
   <option value="q_status">처리상태</option>
</select>

검색 : <input type="text" name="content" id="content">
<button id="searchBtn">검색하기</button>


</div> 

<div id="qnAList">
<table>
<tr>
	<th>번호</th>
	<th>문의자 아이디</th>
	<th>제목</th>
	<th>처리상태</th>
	<th>작성일</th>
	<th>관리</th>
</tr>

<c:forEach var="ql" items="${qnAQList}">
<tr>
	<td>${ql.QUESTIONNO}</td>
	<td>${ql.USERID}</td>
	<td>${ql.QTITLE}</td>
	<c:choose>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'done'}">
	<td>처리완료</td>
	</c:when>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'unprocessed'}">
	<td>미처리</td>
	</c:when>
	</c:choose>
	<td>${ql.WRITEDATE}</td>
	<c:choose>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'done'}">
	<td> 
		<button onclick="location.href='./update?answerno=${ql.ANSWERNO}&questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'">수정</button>
		<button class="btnDelete" onclick="location.href='./delete?answerno=${ql.ANSWERNO}&questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'">삭제</button>
	</td>
	</c:when>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'unprocessed'}">
	<td> 
		<button onclick="location.href='./write?questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'">등록</button>
	</td>
	</c:when>
	</c:choose>
</tr>	
</c:forEach>

</table>

<c:import url="../../layout/paging.jsp"/>

</div>

</body>
</html>