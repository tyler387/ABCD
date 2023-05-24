<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp"/>


<style type="text/css">

 form{
  display: grid;
  place-items: center;
  min-height: 60vh;
  padding-top: 60px;
  padding-bottom: 100px;

}

input[type=text],[type=password]{

	 height:40px;
     width:400px;
     border-radius: 4px;
     font-size: 20px; 
     outline: none; 
}


.input_box{
	font-size: 20px;
	text-align: left;
}

.btn {
	border: 2px solid #333 ;
	background-color: #333;
	border-radius : 7px;
	color: #fff;
	width: 400px;
	height : 50px;
	font-size: 20px;
	font-weight : bold;
	display: block;
	margin: auto;
}

.loginBtn{
	padding-top: 10px;
}
.forget a{
	text-decoration-line: none;	
	font-size: 20px;
	text-align: center;
}

.kakaobtn img{
	width: 400px;
	height: 50px;
	padding-bottom: 30px;
}

</style>

<div class="container">
<form action="" method="post">
	
	<div>
		<h1 style="font-size: 68px;">Login</h1>
	</div>
	
	<div class="input_box">
		<label for="userid"></label>
		<input type="text" name="userid" id="userid" placeholder=" ID"><br>
	</div>

	<div class="input_box">
		<label for="userpw"></label>
		<input type="password" name="userpw" id="userpw"placeholder=" PASSWORD"><br>
	</div>
	
	<div class="input_box">
		<label for="autologin"></label>
		<input type="checkbox">자동 로그인
	</div>
	
	<br>
	
	<div class="forget">
		<a href="#">아이디 찾기</a> | <a href="#">비밀번호 찾기</a> | <a href="#">회원가입</a>
		
	</div>
	<br>

	<div class="loginbtn">
		<button class="btn">Login</button><br>

	
	<div class="kakaobtn">
 		<a href="https://kauth.kakao.com/oauth/authorize?client_id=e711b32da569918789a178e0f371949d&redirect_uri=http://localhost:8888/oauth/kakao&response_type=code">
            <img src="/resources/image/kakao_login_medium_wide.png">
        </a>
	</div>
	</div>
</form>
</div>
<c:import url="../layout/footer.jsp"/> 