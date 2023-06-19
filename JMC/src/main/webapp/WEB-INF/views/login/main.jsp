<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function () {
	if (${not empty adminAccess or adminAccess}) {
		alert("관리자 권한이 존재하지 않아 접근할수 없습니다!")
	}else if(${not empty statusAccess or statusAccess}){
		alert("해당 아이디는 접근할수 없는 상태입니다, 관리자에게 문의 바랍니다")
	}
	
})
</script>

<c:remove var="adminAccess" scope="session"/>
<c:remove var="loginAccess" scope="session"/>
<c:remove var="statusAccess" scope="session"/>

<style type="text/css">


.main {	filter: blur(3px);
		z-index: 100;


}

.mainpage {
	height: 1200px;
}


.all {
	height: 1000px;
	text-align: center;
	position: absolute;
	top:50%;
	right: 20%;
}

.title{

	font-family: '양진체';
	color: white;
	font-size: 40px;
	margin-bottom: 50px;
} 


.content {

	font-family: '양진체';
	color: black;
	font-size: 40px;
	margin-bottom: 50px;
}


@font-face {
    font-family: '양진체';
    src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); 
    font-weight: normal;
    font-style: normal;
}


.find-btn{
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 50px auto;
	text-align:center;
}
.find-btn1{
	font-family: '양진체';
	display :inline-block;
	background-color: #0a0a23;
	color: #fff;
	height: 50px;
	width: 300px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 20px;
	margin-right: 20px;
	
}
.find-btn2{
	font-family: '양진체';
	display :inline-block;
	background-color: gray;
	color: #fff;
	height: 50px;
	width: 300px;
	background: gray;	
	border-radius: 20px;
	border: none;
	font-size: 20px;
}

.find-btn1:hover{
	background-color: #ffcca8;


}

.find-btn2:hover{
	background-color: #E2E2E2;
}

</style>




<div class="mainpage">
<img src="../resources/image/프로젝트 메인페이지.jpg" class="main">

<div class="all">

<div class="imgbackground">
<div class="title">
'세상에 나쁜 위스키는 없다. 좋은 위스키와 더 좋은 위스키가 있을뿐이다.'
</div>
<div class="content">
모임을 통해 다양한 위스키를 접해보세요.
</div>
</div>


<div class="find-btn">


	<button type="button" class="find-btn1" onclick="location.href='/meeting/form'" >모임 등록</button>
	<button type="button" class="find-btn2" onclick="location.href='/meeting/meetingcal'">모임 신청</button>
	
	
</div>


</div>

</div>

<c:import url="../layout/footer.jsp"/> 

