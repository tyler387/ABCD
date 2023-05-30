<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />

<div>찾고자 하는 비밀번호의 아이디를 입력하세요</div>
<div>
	<input type="text" id="userId" name="userId">
</div>
<div>
	<a href="./searchResultPw"><button>다음</button></a>
</div>

<c:import url="../layout/footer.jsp" />