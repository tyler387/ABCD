<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<style type="text/css">
form{
	display:grid; 
	justify-content: center;
	align-items: center; 
	/* display: flex;
  	justify-content: center;
  	align-items: center;
 	min-height: 100vh; */
 	 
	font-weight: bold;
	width: 1000px;
	height: 100%;
	padding-top: 100px;
    padding-bottom: 100px;
    margin: 0 auto;
    font-size: 23px;
}

.input1,.input2{
	padding-bottom: 15px;
}

input{
	width: 350px;
	height: 30px;
}

.btn {
	border: 2px solid #333 ;
	background-color: #333;
	border-radius : 7px;
	color: #fff;
	width: 355px;
	height : 35px;
	font-size: 20px;
	font-weight : bold;
	display: block;
/*  margin: 0 auto; */

}
 .btn1 {
	border: 1px solid #333 ;
	background-color: #333;
	border-radius : 7px;
	color: #fff;
	width: 70px;
	height : 28px; 
	font-size: 15px; 
	font-weight : bold;
	display: block;
	 margin: 0 auto; 

} 
.input3{
	padding: 0px 0px 0px 0px;
    margin: 0px 0px 0px 0px;
}
.btn1{
	padding: 0px 0px 0px 0px;
    margin: 0px 0px 0px 0px;
}
.select {
    padding: 15px 10px;
}
.select input[type=radio]{
    display: none;
}
.select input[type=radio]+label{
    display: inline-block;
    cursor: pointer;
    height: 28px;
    width: 166px;
    border: 1px solid #333;
    line-height: 24px;
    text-align: center;
    font-weight:bold;
    font-size:13px;
   
}
.select input[type=radio]+label{
    background-color: #fff;
    color: #333;
}
.select input[type=radio]:checked+label{
    background-color: #333;
    color: #fff;
}




</style>
</head>
<body>
<form action="" method="post">
<h1 style="font-size:63px;">JAMANCHO</h1> 

<div class="input1">
	<label for="userid">아이디*</label>
	<div class="input3">
		<input type="text" name="userid" id="userid">
		<button class="btn1">중복확인</button>
	</div>
	
</div>


<div class="input1">
		<label for="userpw">패스워드*</label>
	<div class="input2">
		<input type="password" name="userpw" id="userpw">
	</div>
</div>


<div class="input1">
	<label for="userpw_chk">패스워드 확인*</label>
	<div class="input2">
		<input type="password" name="userpw_chk" id="userpw_chk">
	</div>
</div>


<div class="input1">
	<label for="username">이름*</label>
	<div class="input2">
		<input type="text" name="userpw_chk" id="userpw_chk">
	</div>
</div>


<div class="input1">
	<label for="birth">생년월일*</label>
	<div class="input">
		<input type="text" name="birth" id="birth">
	</div>	
</div>


<div class="input1">
	<label for="gender">성별*</label>
	<div class="select">
		<input type="radio"  id="select" name="shop"><label for="select">남자</label>
		<input type="radio" id="select2" name="shop"><label for="select2">여자</label>
	</div>	
</div>

<div class="input1">
	<label for="email">이메일*</label>
	<div class="input3">
		<input type="text" name="email" id="email">
		<button class="btn1">인증</button>
	</div>	
</div>


<div class="input1">
	<label for="phone">휴대전화*</label>
	<div class="input2">
		<input type="tel" name="phone" id="phone">
	</div>
</div>


<div class="input1">
	<label for="addr1">주소*</label> 
	<div class="input3">
		<input type="text" name="addr1" id="addr1" placeholder="우편번호">
		<button class="btn1">검색</button><br>
		<input type="text" name="addr2" id="addr2" placeholder="도로명주소"><br>
		<input type="text" name="addr3" id="addr3" placeholder="상세주소"><br>
	</div>	
</div>

<button class="btn">가입하기</button><br>

</form>
<c:import url="../layout/footer.jsp" />