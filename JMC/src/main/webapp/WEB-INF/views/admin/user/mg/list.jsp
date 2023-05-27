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
<h1>유저 수정 페이지</h1>

<!-- <form action="./filter" method="post"> -->
<form>
<select name ="filter">
   <option value = "user_id" selected>아이디</option>
   <option value = "user_name">이름</option>
   <option value = "grade">등급</option>
</select>

검색 : <input type="text" name="content">
<button id="searchBtn">검색하기</button>
</form>

<div class="itemone">
<table>
<tr>
	<th>아이디</th>
	<th>상태</th>
	<th>이름</th>
	<th>닉네임</th>
	<th>생일</th>
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
	<th>${users.birth }</th>
	<th>${users.userId }</th>
	<th>${users.phone }</th>
	<th>${users.joinDate }</th>
	<th><a href="./update?userno=${users.userno }"><button>수정</button></a>
	<a href="./withdraw?userno=${users.userno }"><button>탈퇴</button></a></th>
</tr>
</c:forEach>
</table>
</div>
<script type="text/javascript">
$('#searchBtn').click(function(){
	
	 var data = {
		        "데이터1": 데이터1,
		        "데이터2": 데이터2,
		        "데이터3": 데이터3,
		    }
	
  $.ajax({
      url: "./filter.jsp",
      type: "POST",
      data: form,
      success: function(data){
   	    $('#itemone').html(data);
      },
      error: function(){
          alert("simpleWithObject err");
      }
  });
});
</script> 

<br><br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/mg/list"><button>유저수정 페이지</button></a>

<c:import url="./paging.jsp" />
