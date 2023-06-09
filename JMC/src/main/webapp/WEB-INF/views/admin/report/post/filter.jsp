
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
<h1>신고 게시글 관리 페이지</h1>

<form action="./filter" method="post">
<div class="input-group mb-12 ms-auto  justify-content-end"
	style="padding-right: 50px; padding-top: 15px; margin-bottom: 15px; width: 600px;">
		<select name ="filter" id="filter" class=" form-select" style="width: 100px;">
		   <option value = "user_id" selected>아이디</option>
		   <option value = "user_name">이름</option>
		   <option value = "grade">등급</option>
		</select>
		<label for="content" class="input-group-text">검색 </label>
		<input type="text" name="content" id="content">
		<button id="searchBtn" type="submit" class="btn btn-secondary btn-sm">검색하기</button>
</div> 
</form>
<table>
<tr>
	<th>글번호</th>
	<th>신고자 아이디 --</th>
	<th>신고자 이름</th>
	<th>피신고자</th>
	<th>제목</th>
	<th>신고분류</th>
	<th>처리상태</th>
	<th>작성일</th>
</tr>
<c:forEach var="report" items="${reportB }">
<tr>
	<th>${report.REPORTNO }</th>
	<th>${report.USER_ID }</th>
	<th>${report.USER_NAME }</th>
	<th>${report.R_USER_NAME }</th>
	<th><a href="./postview?reportno=${report.REPORTNO }">${report.TITLE }</a></th>
	<th>${report.REPORT_OPTION}</th>
	<th><c:choose>
		<c:when test="${report.STATUS eq 'processed'}"> 승인</c:when>
		<c:when test="${report.STATUS eq	'unprocessed'}">미승인</c:when>
	</c:choose>  </th>
	<th>${report.WRITE_DATE }</th>
</tr>
</c:forEach>
</table>
<br><br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/mg/list"><button>유저수정 페이지</button></a>
<c:import url="./paging.jsp" />