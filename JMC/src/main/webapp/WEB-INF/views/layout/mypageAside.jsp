<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">

 div.row {
  display: flex;
  margin-top: 200px;
  margin-left: 230px;
  margin-bottom: 300px;       
}
div.left {
  width: 300px;
  float: left;
  box-sizing: border-box;
  border: 3px #371e06 groove;
  border-radius: 10px 10px 10px 10px;
/*   background: #d1d1d1; */
  margin-right: 30px;
  height: 800px;
}

div.right {
  width: 70%;
  float: right;
  box-sizing: border-box;
  border: 3px #371e06 groove;
  border-radius: 10px 10px 10px 10px;
/*   background: #ece6cc; */
  margin-right: 150px;
  padding-left: 15px;
  padding-top: 10px;
}
.profile{
	display:flex;
	justify-content:center;
	align-items:center;

}
img{
	width:150px;
	height: 150px;
	border-radius: 70%;
	margin-top: 30px;

}
.userInfo{
	display:flex;
	justify-content:center;
	align-items:center;
}

.userMenu{
	font-size: 22px;
	
}
.list1{
	margin-top : 20px;
	padding-bottom: 15px;
}
.list2{
	padding-bottom: 13px;
}

.dropdown{
	display: inline-block;
	margin: 0;
	pause: 0;
	position: relative;
}
.dropdown .list2 {
	display: none;
/* 	position: absolute; */
	left: 60px;
	top: 20px;
}
.dropdown .list1:hover>.list2 {
	display: block;
}

.list3{
	padding-top:10px;
	padding-bottom: 15px;
}
.list3:hover{
	border-left: 3px solid #371e06;
	padding-left: 5px;
}

</style>
 <div class="row">
  <div class="left">
  
  <div class='profile'>
  	<div>
  		<a href="/mypage/profileMain"><img src="/userProfile/${profileStoredName}"></a> 
  	</div>
  </div>
  	<div class="userInfo">
  		${userId }
  	</div>
  
  <div class="userMenu">
  <ul class="dropdown">

  <li class="list1"><a href="/mypage/main">My</a>
  
  	<ul class="list2">
  		<li class="list3"><a href="/mypage/profileMain">프로필수정</a></li>
  		<li class="list3"><a href="/mypage/userInfo">회원 정보</a></li>
  	</ul>
  </li>
  <li class="list1"><a href="#">모임</a>
  
  	<ul class="list2">
  		<li class="list3"><a href="#">모임 현황</a></li>
  		<li class="list3"><a href="#">종료된 모임</a></li>
  	</ul>
  </li>	
  <li class="list1"><a href="#">구매</a>
  
  	<ul class="list2">
  		<li class="list3"><a href="#">장바구니</a></li>
  		<li class="list3"><a href="#">결제 내역</a></li>
  	</ul>
  	</li>
  <li class="list1"><a href="/mypage/friendList">친구</a></li>
  <li class="list1"><a href="#">커뮤니티</a></li>
  <li class="list1"><a href="#">공지사항</a></li>
 
</ul>
</div>
