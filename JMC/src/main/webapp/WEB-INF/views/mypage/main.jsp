<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />

<style type="text/css">

.aside{
    display: flex;
    flex-direction: column;
    margin-top: 150px;
    margin-left: 190px;
    padding-top: 30px;
    /* padding-left: 70px; */
    margin-bottom: 850px;
    list-style-type: none;
    width: 240px;
    height: 1000px;
    background-color: #c0c0c0;
    font-size: 25px;
}

.list2 a{
	width:25px;
}

.profile{
	text-align: center;		
}
img{
	border-radius: 50%;
	width:180px; 
	height:180px;
}

/* .mypage ul { */
/*   list-style-type: none; */
/*   padding: 0px; */
/*   margin: 0px; */
/*   width: 100px; */
/*   background: #FF6347; */
/*   height: 100%; */
/* /*   position: fixed; */ 
/* } */


/* .mypage li a { */
/*   text-decoration: none; */
/*   padding: 10px; */
/*   display: block; */
/*   color: #000; */
/*   font-weight: bold; */
/* } */

/* .mypage li a:hover { */
/*   background: #333; */
/*   color: #fff; */
/* } */

/* .mypage li a.home { */
/*   background : #333; */
/*   color: #fff; */
/*   width:250px; */
/*   margin-top: 250px; */
/*   margin-left: 150px; */
  
/* } */


/* .cd1 { */
/*   margin-left: 120px; */
/* } */

</style>
<div class="aside">

<div class="profile">
	<img src="/resources/image/keszthelyi-timi-ezUDjYy17EA-unsplash.jpg">

<div class="idshow">
${userId} 
</div>

</div>
<ul>
  <li><a class="home"></a></li>
  

  <li><a href="#">My</a></li>
  
  	<ul class="list2">
  		<li><a href="#">프로필수정</a></li>
  		<li><a href="#">회원 정보</a></li>
  	</ul>
  	
  <li><a href="#">모임</a></li>
  
  	<ul class="list2">
  		<li><a href="#">모임 현황</a></li>
  		<li><a href="#">종료된 모임</a></li>
  	</ul>
  	
  <li><a href="#">구매</a></li>
  
  	<ul class="list2">
  		<li><a href="#">장바구니</a></li>
  		<li><a href="#">결제 내역</a></li>
  	</ul>
  	
  <li><a href="#">친구</a></li>
  <li><a href="#">커뮤니티</a></li>
  <li><a href="#">공지사항</a></li>
 
</ul>
</div>

<c:import url="../layout/footer.jsp" />