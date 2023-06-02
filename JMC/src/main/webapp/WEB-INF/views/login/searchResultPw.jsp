<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />

<style type="text/css">

.container{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

form{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: flex-start;
	margin-top: 89px;	
	padding-bottom: 280px;

}
</style>




<div class="container">

<form action="/login/searchResultPw" method="post"> 

	<div class="nameBox">
		<h1 style="font-size: 35px;">새 비밀번호 설정</h1>
	</div>

	<div class="inputbox1">
		<input type="hidden" id="userno" name="userno" value="${userno}">
	</div> 	
	
	<label for="namebox">비밀번호</label>
	
	<div class="inputbox2">
		<input type="password" id="userPw" name="userPw">
	</div>
	
	<label class="namebox2">비밀번호 재입력</label>
		
	<div>
		<input type="password" id="userPwchk" name="userPwchk">
	</div>	


<a href="./login"><button>확인</button></a>

</form> 

</div>
<c:import url="../layout/footer.jsp" />