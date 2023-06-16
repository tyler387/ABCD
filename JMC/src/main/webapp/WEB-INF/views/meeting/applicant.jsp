<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

@font-face {
    font-family: '양진체';
    src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); 
    font-weight: normal;
    font-style: normal;
}

body {
  background: beige;
  font-family: '양진체';
}	




</style>

</head>


<body>
	
	
	<h2>모집자 정보</h2>
	<div class="nick">닉네임:${applicantuser.userNick }</div>
	<div class="age">나이: ${applicantuser.birth }</div>
	<div class="gender">성별: 
	<c:if test="${applicantuser.gender eq 'M' }">
	남자
	</c:if>
	<c:if test="${applicantuser.gender eq 'F' }">
	여자
	</c:if>
	
	</div>
	
	
	<button onclick="window.close()">확인 완료</button>
	
</body>
</html>