<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>