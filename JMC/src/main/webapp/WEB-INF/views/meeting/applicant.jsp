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
  text-align: center;
}	

.checkend{
	font-family: '양진체';
	display :inline-block;
	background-color: #0a0a23;
	color: #fff;
	height: 50px;
	width: 100px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 20px;
	margin-top: 50px;
	
	
}

.app{
	margin-bottom: 20px;

}



</style>

</head>


<body>
	
	
	<h2>모집자 정보</h2>
	<div class="app">닉네임:${applicantuser.userNick }</div>
	<div class="app">나이: ${age }</div>
	<div class="app">성별: 
	<c:if test="${applicantuser.gender eq 'M' }">
	남자
	</c:if>
	<c:if test="${applicantuser.gender eq 'F' }">
	여자
	</c:if>
	
	</div>
	
	
	<button class="checkend" onclick="window.close()">확인 완료</button>
	
</body>
</html>