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
	<th><a href="./update?userno=${users.userno }"><button>수정</button></a>
	<a href="./withdraw?userno=${users.userno }"><button>탈퇴</button></a></th>
	
</tr>
</c:forEach>
</table>
<br><br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/mg/list"><button>유저수정 페이지</button></a>
</body>
</html>