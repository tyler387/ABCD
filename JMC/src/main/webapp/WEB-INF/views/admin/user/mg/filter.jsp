<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
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
	<th>${users.birth }</th>
	<th>${users.userId }</th>
	<th>${users.phone }</th>
	<th>${users.joinDate }</th>
	<th><a href="./update?userno=${users.userno }"><button>수정</button></a>
	<a href="./withdraw?userno=${users.userno }"><button>탈퇴</button></a></th>
</tr>
</c:forEach>
</table>
<br><br><br>
<c:import url="./paging.jsp" />
</div>
