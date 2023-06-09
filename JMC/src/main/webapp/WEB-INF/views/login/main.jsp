<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp"/>

<style type="text/css">

.find-btn{
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 50px auto;
	text-align:center;
}
.find-btn1{
	display :inline-block;
	background-color: #0a0a23;
	color: #fff;
	height: 50px;
	width: 300px;
	background: orange;
	border-radius: 20px;
	
}
.find-btn2{
	display :inline-block;
	background-color: gray;
	color: #fff;
	height: 50px;
	width: 300px;
	background: gray;	
	border-radius: 20px;
}

.find-btn1:hover{
	background-color: #ffcca8;


}

.find-btn2:hover{
	background-color: #E2E2E2;
}

</style>

로그인 상태 : ${login} 


<div class="find-btn">


	<br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br>	
	
	
	<button type="button" class="find-btn1" onclick="location.href='/meeting/form'" >모임 등록</button>
	<button type="button" class="find-btn2" onclick="location.href='/meeting/meetingcal'">모임 신청</button>
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>


<c:import url="../layout/footer.jsp"/> 