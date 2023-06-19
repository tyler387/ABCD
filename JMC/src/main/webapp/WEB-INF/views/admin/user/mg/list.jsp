<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<c:import url="../../main.jsp"></c:import>
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
 
 	var curPage = ${paging.curPage};
	var totalCount = ${paging.totalCount};
 	var totalPage = ${paging.totalPage};
 	var listCount =${paging.listCount};
 	var pageCount = ${paging.pageCount};
 	var startPage = ${paging.startPage};
 	var endPage = ${paging.endPage};
 	var startno = ${paging.startno};
 	var endno = ${paging.endno};
 	
	var filter = null ; 
	var content = null ;
	$(function() {
		$("#content").keydown(function(e) {
	// 		console.log(e);
			if(e.keyCode == 13){
				$("#searchBtn").click();
			}
		})
	})
// 	$("#searchBtn").click(function() {
		
// 		filter = $("#filter").val();
// 		content = $("#content").val();
		
// 		$.ajax({
// 			type: "post"
// 			, url: "./filter1"
// 			, data:  {filter : filter, content : content}
// 			, dataType: "html" 
// 			, success: function( res ) {
// 				console.log("AJAX 성공")
// 				$("#resultt").html(res)
// 				filter = $("#filter").val();
				
// 			}
// 			, error: function() {
// 				console.log("AJAX 실패")
// 			}
// 		})
// 	})

// $("#deletebtn").click(function(){
// 			 if (confirm("정말 삭제하시겠습니까??") == true){ 
// 			     document.removefrm.submit();
// 				   location.reload();
// 			 }else{   //취소
// 			     return false;
// 			 }
// 			console.log("content: ", content)
// 	})
</script>
<div id="resultt">
	
	<div id="Alltitle" style="text-align: center; padding-top: 10px;">
		<h1  style="margin: 0 auto;border-radius: 30px; background-color : #03a9f46e; width: 600px;  text-align: center; padding-bottom: 5px;">
			회원 정보 관리
		</h1>
	</div>

<form action="./filter" method="post">
<div class="input-group mb-12 ms-auto  justify-content-end"
	style="padding-right: 50px; padding-top: 15px; margin-bottom: 15px; width: 750px;">
	
	<label for="content" class="input-group-text">상태</label>&nbsp;
	<select name ="status" id="status" class=" form-select" style="width: 115px;">
		<option value="" selected>미선택</option>
		<option value="active">정상</option>
		<option value="leave">탈퇴</option>
		<option value="unactive">휴먼</option>
		<option value="block">정지</option>
		<option value="blacklist">블랙리스트</option>
	</select>
	&nbsp;&nbsp;
		<select name ="filter" id="filter" class=" form-select" style="width: 100px;">
		   <option value = "user_id" selected>아이디</option>
		   <option value = "user_name">이름</option>
		   <option value = "user_nick">닉네임</option>
		   <option value = "phone">폰번호</option>
		   <option value = "grade">등급</option>
		</select>
		<label for="content" class="input-group-text">검색 </label>
		<input type="text" name="content" id="content">
		<button id="searchBtn" type="submit" class="btn btn-secondary btn-sm">검색하기</button>
</div> 
</form>
	
<div id="result" class="admin1">
	
<table class="table table table-hover">
<tr class="table-secondary">
	<th style="width: 278px;">아이디</th>
	<th>이름</th>
	<th>닉네임</th>
	<th>상태</th>
	<th>생년원일</th>
	<th>성별</th>
	<th>폰번호</th>
	<th>가입일</th>
	<th>관리</th>
</tr>
<c:forEach var="users" items="${userfilter }">
<tr>
	<th>${users.userId }</th>
	<th>${users.userName }</th>
	<th>${users.userNick }</th>
	<th><c:choose>
		<c:when test="${users.status eq 'leave'}">탈퇴</c:when>
		<c:when test="${users.status eq	'active'}">정상</c:when>
		<c:when test="${users.status eq 'unactive'}">휴먼</c:when>
		<c:when test="${users.status eq 'blacklist'}">블랙리스트</c:when>
		<c:when test="${users.status eq 'block'}">정지</c:when>
	</c:choose>  </th>
	<th><fmt:formatDate value="${users.birth }" pattern="yyyy-MM-dd"/></th>
	<th>${users.gender }</th>
	<th>${users.phone }</th>
	<th><fmt:formatDate value="${users.joinDate }" pattern="yyyy-MM-dd "/></th>
	<th><a href="./update?userno=${users.userno }"><button type="button" class="btn btn-secondary">수정</button></a>
	<a href="./withdraw?userno=${users.userno }&curPage=${paging.curPage}"><button type="button" class="btn btn-secondary" id ="deletebtn" onClick="window.location.reload()">탈퇴</button></a></th>
</tr>
</c:forEach>
</table>


<div id="pagingDivTag">
<c:import url="../../paging.jsp"/>
</div>

</div>	
	
</div>
</div>
</div>
</body>
</html>


