<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAMANCHU</title>
<style type="text/css">

header{
  position: sticky;
  top: 0;
  backdrop-filter: blur(30px);
  background: black;
  color: white;
  padding-left: 120px; 
  padding-right: 40px; 
  display: flex; 
  justify-content: flex-end;
  align-items: center;
}

header a{
	color : white;
	padding : 20px;
}

*{
  list-style: none;
}
a {
  text-decoration: none;
  color: black;
}

#header #menu{
  position:relative; 
  /* z-index: 99;  */
  padding-top : 12px;
  background-color: white;
  height: 50px;
  text-align: center;
}

#header [class*="main"] {
  background-color: white;
  border-radius: 5px 5px 5px 5px;
}

#header [class*="main"] ul {
  border-radius: 5px 5px 5px 5px;
  border: 1px solid black;
}
#header .main1{
  padding-left: 0px;
  height: 100%;
  width: 1600px;
  margin: 0 auto;
  display: inline-block;
}
#header .main1>li {
  float: left;
  width: 15%;
  line-height: 50px;
  position: relative;
  
}
#header .main1>li:hover .main2 {
  left: 0;
}
#header .main1>li a {
  display: block;
  font-size: 22px;
}
#header .main1>li a:hover {
  font-weight: bold;
}
#header .main2 {
  width:110%;
  position: absolute;
  top: 50px;
  left: -9999px;
  width: 100%;
  padding: 0px;
}
#header .main1>li:hover {
  border-bottom: 5px solid black;
}
#header .main2 li:hover {
  border-left: 5px solid black;
}

#header .main2>li {
  position: relative;
}
#header .main2>li:hover .main3 {
  left: 100%;
}
#header .main2>li a {
  border-radius: 10px;
  margin: 10px;
}

.footer html, body {
   height: 100%;
   padding: 0px;
   margin: 0px;
 }

.footer header {
   height: 60px;
   background-color: #e9eaed;
}

 #wrap {
  min-height: calc(100% - 120px);
}


 .footer {
   height: 300px;
   background-color: black;
   text-align: center;
   padding-top: 70px;
   color: white;
 }


</style>
</head>

<body>

<div id="header">
<header>
<c:if test="${role eq 'admin'}">
	<a href="/admin/main">관리자페이지</a>
</c:if>
<%-- <c:if test="${empty login}"> --%>
<!-- 	<a href="/login/login">로그인</a> -->
<%-- </c:if>	 --%>
<c:if test="${not empty login}">
	<a href="/login/logout">로그아웃</a>
	<a href="/mypage/main">마이페이지</a>
	<a href="#">알람</a>
</c:if>
<c:if test="${empty socialId and empty login}">
	<a href="/login/login">로그인</a>
</c:if>	
<c:if test="${not empty socialId}">
	<a href="/login/logout">로그아웃</a>
	<a href="/mypage/main">마이페이지</a>
	<a href="#">알람</a>
</c:if>

</header>

<div id="menu">
  <ul class="main1">
    <li style="border: none;"><a href="/login/main">JAMANCHU</a>
    </li>
    <li><a href="#">회사소개</a></li>
    <li style="border: none;"><a href="#">모임</a>
       <ul class="main2">
        <li><a href="/meeting/form">모임 등록</a></li>
        <li><a href="#">모임 신청</a></li>
      </ul>
    </li>
    <li><a href="#">커뮤니티</a></li>
    <li><a href="#">스토어</a></li>
    <li><a href="#">고객센터</a></li>
    </ul>
</div>
</div>

