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
	
	$("#searchBtn").click(function() {
		
		filter = $("#filter").val();
		content = $("#content").val();
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공")
				$("#resultt").html(res)
				filter = $("#filter").val();
				
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	})

	
// 	$(document).on("click",  ".number", function() {
	$(".number").click(function() {
		
		curPage = $(this).html();
		console.log("페이징 넘버", curPage)
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공 , 페이징 숫자버튼")
				$("#resultt").html(res)
				filter = $("#filter").val();
				
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})

// 	$(document).on("click", ".first", function() {
	$(".first").click(function() {	
	
		curPage = 1
		
		console.log(" 페이징 첫페이지 및 curpage", curPage)
		
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})
	
// 	$(document).on("click", ".beforelist", function() {
	$(".beforelist").click(function() {	
		curPage = startPage-pageCount;
		
		console.log(" 이전 페이지리스트 및 curpage", curPage)
		
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})
	
// 	$(document).on("click", ".before", function() {
		$(".before").click(function() {	
		
		curPageBack = curPage - 1;
		
		console.log("현재페이지", ${paging.curPage })
		console.log(" 이전 페이지 및 curpage", curPage)
		
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPageBack}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})
	

// 	$(document).on("click", ".next", function() {
	$(".next").click(function() {

		curPage = curPage + 1;
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})
	
	
	
// 	$(document).on("click", ".nextlist", function() {
		$(".nextlist").click(function() {

			curPage = startPage+pageCount;
		
		console.log("현재페이지", ${paging.curPage })
		console.log(" 이전 페이지 및 curpage", curPage)
		
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})
	

// 	$(document).on("click", ".end", function() {
	$(".end").click(function() {

		curPage = totalPage;
		
		console.log("엔드페이지", curPage);
		
		$.ajax({
			type: "post"
			, url: "./filter1"
			, data:  {filter : filter, content : content, curPage : curPage}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공, 페이징 첫페이지")
				$("#resultt").html(res)
				filter = $("#filter").val();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
		
	})

})
	 

// 	$(document).on("click", ".end", function() {

// 		curPageBack = totalPage;
		
// 		console.log("현재페이지", ${paging.curPage })
// 		console.log(" 이전 페이지 및 curpage", curPage)
		
		
// 		$.ajax({
// 			type: "post"
// 			, url: "./filter1"
// 			, data:  {filter : filter, content : content, curPage : curPageBack}
// 			, dataType: "html" 
// 			, success: function( res ) {
// 				console.log("AJAX 성공, 페이징 첫페이지")
// 				$("#result").html(res)
// 				filter = $("#filter").val();
// 				curPage -= 1;
// 			}
// 			, error: function() {
// 				console.log("AJAX 실패")
// 			}
// 		})
		
// 	})
		
// 		$(".clicker").click(function() {
// 			console.log("dkdkdkdk")
// 		})
		
// 		$(".clicker").click(function() {
			
// 			curPage = $(this).html()
			
// 			console.log("뭐지?", curPage)
			
			
// 			$.ajax({
// 				type: "post"
// 				, url: "./filter1"
// 				, data:  {filter : filter, content : content, curPage: 3 }
// 				, dataType: "html" 
// 				, success: function( res ) {
// 					console.log("AJAX 성공")
// 					$("#result").html(res)
// 					filter = $("#filter").val();
// 				}
// 				, error: function() {
// 					console.log("AJAX 실패")
// 				}
// 			})
			
// 		})
		
		
		//a 태그 살리면서 AJAX 넣는 방법 - 아직 고민중, 미구현
	// 	if(content != null && !cotent.equasl("")){
	// 		a태그 속성지우기 
			
	// 		ajax 클릭 이벤트 삽입
	// 	}
		
</script>
<div id="resultt">
	<c:import url="../../main.jsp"></c:import>
	
	
	<div id="Alltitle" style="text-align: center; padding-top: 10px;">
		<h1  style="margin: 0 auto;border-radius: 30px; background-color : #03a9f46e; width: 600px;  text-align: center; padding-bottom: 5px;">
			유저 수정 페이지
		</h1>
	</div>
	<!-- <form action="./filter" method="post"> -->
<div class="text-end" style="padding-right: 50px; padding-top: 15px; margin-bottom:15px;">
	<select name ="filter" id="filter">
	   <option value = "user_id" selected>아이디</option>
	   <option value = "user_name">이름</option>
	   <option value = "grade">등급</option>
	</select>
	
	검색 : <input type="text" name="content" id="content">
	<button id="searchBtn" type="button" class="btn btn-secondary btn-sm">검색하기</button>
</div> 
	
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
<c:forEach var="users" items="${userfilter }">
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
	<a href="./withdraw?userno=${users.userno }&curPage=${paging.curPage}"><button type="button" class="btn btn-secondary" id = "deletebtn" onClick="window.location.reload()">탈퇴</button></a></th>
</tr>
</c:forEach>
</table>


<div id="pagingDivTag">
<c:import url="../../filterpaging.jsp" />
</div>

</div>	
	
</div>
</div>
</body>
</div>
</html>

