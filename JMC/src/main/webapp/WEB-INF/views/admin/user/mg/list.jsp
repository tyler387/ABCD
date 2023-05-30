<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


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


</style>





<script type="text/javascript">
$(function() {
	
	var filter = 0 ; 
	var content = 0 ;
	
	$("#searchBtn").click(function() {
		
		filter = $("#filter").val();
		content = $("#content").val();
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content}
// 			, data:  {filter : $("#filter").val(), content : $("#content").val()}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공")
				$("#result").html(res)
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	})
	
	console.log("filter: ", filter)
	console.log("content: ", content)
})
</script>


<c:import url="../../main.jsp"></c:import>


<div id="Alltitle" style="text-align: center; padding-top: 10px;">
	<h1  style="margin: 0 auto;border-radius: 30px; background-color : #03a9f46e; width: 600px;  text-align: center; padding-bottom: 5px;">
		유저 수정 페이지
	</h1>
</div>

<!-- <form action="./filter" method="post"> -->
<p class="text-end" style="padding-right: 50px; padding-top: 15px;">
<select name ="filter" id="filter">
   <option value = "user_id" selected>아이디</option>
   <option value = "user_name">이름</option>
   <option value = "grade">등급</option>
</select>

검색 : <input type="text" name="content" id="content">
<button id="searchBtn" type="button" class="btn btn-secondary btn-sm">검색하기</button>
</p> 
<div id="result" class="admin1">
<table class="table table table-hover">
<tr class="table-secondary">
	<th>아이디</th>
	<th>상태</th>
	<th>이름</th>
	<th>닉네임</th>
	<th>생년원일</th>
	<th>성별</th>
	<th>폰번호</th>
	<th>가입일</th>
	<th>관리</th>
</tr>
<c:forEach var="users" items="${users }">
<tr>
	<th>${users.userId }</th>
	<th><c:choose>
		<c:when test="${users.status eq 'leave'}">탈퇴</c:when>
		<c:when test="${users.status eq	'active'}">정상</c:when>
		<c:when test="${users.status eq 'unactive'}">휴먼</c:when>
		<c:when test="${users.status eq 'blacklist'}">블랙리스트</c:when>
		<c:when test="${users.status eq 'block'}">정지</c:when>
	</c:choose>  </th>
	<th>${users.userName }</th>
	<th>${users.userNick }</th>
	<th><fmt:formatDate value="${users.birth }" pattern="yyyy-MM-dd"/></th>
	<th>${users.userId }</th>
	<th>${users.phone }</th>
	<th><fmt:formatDate value="${users.joinDate }" pattern="yyyy-MM-dd "/></th>
	<th><a href="./update?userno=${users.userno }"><button type="button" class="btn btn-secondary">수정</button></a>
	<a href="./withdraw?userno=${users.userno }"><button type="button" class="btn btn-secondary">탈퇴</button></a></th>
</tr>
</c:forEach>
</table>
<br>
<div>
<c:import url="./paging.jsp" />
</div>
</div>
</div>
</div>
</body>
</html>
