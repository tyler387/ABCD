<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<c:import url="../../main.jsp"/>

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

<div id="Alltitle" style="text-align: center; padding-top: 10px; padding-botton: 15px;">
<h1 class="innerTitle">QnA 관리</h1>
</div>

<form action="./filter" method="get">
<div class="input-group mb-12 ms-auto  justify-content-end"
	style="padding-right: 50px; padding-top: 15px; margin-bottom: 15px; width: 750px;">
	<label for="content" class="input-group-text">상태</label>&nbsp;
	<select name ="status" id="status" class="form-select" style="width:115px;">
		<option value="" selected>미선택</option>
		<option value="unprocessed">미처리</option>
		<option value="done">처리완료</option>
	</select>
	&nbsp;&nbsp;
	<select class=" form-select " name="filter" id="filter"
		style="width: 100px;">
		<option value="user_id" selected>아이디</option>
		<option value="user_name">이름</option>
		<option value="q_title">제목</option>
	</select> <label for="content" class="input-group-text">검색 </label> <input
		type="text" name="content" id="content">
	<button id="searchBtn" class="btn btn-secondary">검색하기</button>
</div>
</form>

<div id="list" class="admin1">
<div id="qnAList">
<table class="table table table-hover">
<tr class="table-secondary">
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
		<button onclick="location.href='./update?answerno=${ql.ANSWERNO}&questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'" class="btn btn-secondary">수정</button>
		<button class="btnDelete btn btn-secondary" onclick="location.href='./delete?answerno=${ql.ANSWERNO}&questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'">삭제</button>
	</td>
	</c:when>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'unprocessed'}">
	<td> 
		<button onclick="location.href='./write?questionno=${ql.QUESTIONNO}&curPage=${paging.curPage}'" class="btn btn-secondary">등록</button>
	</td>
	</c:when>
	</c:choose>
</tr>	
</c:forEach>

</table>

<c:import url="../../paging.jsp"/>

</div>
</div>
</div>
</body>
</html>