<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    	
	
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
<br>

<div id="pagingDivTag">
<c:import url="../../filterpaging.jsp" />
</div>