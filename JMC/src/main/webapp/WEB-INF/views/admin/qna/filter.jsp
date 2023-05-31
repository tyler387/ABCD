<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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