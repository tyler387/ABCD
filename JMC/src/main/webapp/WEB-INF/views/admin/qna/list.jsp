<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>QnA 관리</h1>
<hr>

<div>
<select name ="filter">
   <option value = "user_id" selected>아이디</option>
   <option value = "user_name">이름</option>
   <option value = "grade">등급</option>
</select>

검색 : <input type="text" name="content">
<button>검색하기</button>
</div>

<div id="qnaList">
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
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'processed'}">
	<td>처리완료</td>
	</c:when>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'unprocessed'}">
	<td>미처리</td>
	</c:when>
	</c:choose>
	<td>${ql.WRITEDATE}</td>
	<c:choose>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'processed'}">
	<td> 
		<button onclick="location.href='./update?answerno=${ql.ADMIN_BOARDNO}'">수정</button>
		<button onclick="location.href='./delete?answerno=${ql.ADMIN_BOARDNO}'">삭제</button>
	</td>
	</c:when>
	<c:when test="${not empty ql.QSTATUS and ql.QSTATUS eq 'unprocessed'}">
	<td> 
		<button onclick="location.href='./update?answerno=${ql.ADMIN_BOARDNO}'">등록</button>
		<button onclick="location.href='./delete?answerno=${ql.ADMIN_BOARDNO}'">삭제</button>
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