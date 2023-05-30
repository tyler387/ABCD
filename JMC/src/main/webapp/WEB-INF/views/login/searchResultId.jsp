<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />


<div>아이디 찾기</div>

<c:choose>
	<c:when test="${empty userId }">
	 <p>조회된 아이디가 없습니다</p>
	</c:when>
	<c:otherwise>
	<p>아이디는 ${userId } 입니다.</p>
	</c:otherwise>

</c:choose>

<div>
	<a href="./login">로그인</a>
	<a href="./searchPw">비밀번호 찾기</a>
</div>

<c:import url="../layout/footer.jsp" />