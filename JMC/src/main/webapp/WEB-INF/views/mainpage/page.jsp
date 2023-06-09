<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   


<c:import url="../layout/header.jsp"/>

<style type="text/css">

.find_btn{
	text-align:center;
}
.find-btn1{
	display :inline-block;
}
.find-btn1{
	display :inline-block;
}


</style>

<div class="find-btn">


	<br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br>	
	
	
	<button type="button" class="btn btn-navy navbar-btn find btn1" onclick="location.href='/meeting/form'" >모임 등록</button>
	<button type="button" class="btn btn-grey navbar-btn find btn1" onclick="location.href='/meeting/meetinglist'">모임 신청</button>
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>

<c:import url="../layout/footer.jsp"/>