<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">

 div.row {
        display: flex;
        margin-top: 200px;
        margin-left: 150px;
        margin-bottom: 300px;       
}
div.left {
  width: 300px;
  float: left;
  box-sizing: border-box;
  background: #d1d1d1;
  margin-right: 30px;
}

div.right {
  width: 70%;
  float: right;
  box-sizing: border-box;
  background: #ece6cc;
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

</style>
 <div class="row">
  <div class="left">
  
  <div class='profile'>
  	<div>
  		<a href="#"><img src="/resources/image/keszthelyi-timi-ezUDjYy17EA-unsplash.jpg"></a> 
  	</div>
  </div>
  	<div class="userInfo">
  		${userId }
  	</div>
  
  <div class="userMenu">
  <ul>
  <li><a class="home"></a></li>

  <li><a href="/mypage/main">My</a></li>
  
  	<ul class="list2">
  		<li><a href="/mypage/profile">프로필수정</a></li>
  		<li><a href="/mypage/userInfo">회원 정보</a></li>
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
  	
  <li><a href="/mypage/friendList">친구</a></li>
  <li><a href="#">커뮤니티</a></li>
  <li><a href="#">공지사항</a></li>
 
</ul>
</div>

