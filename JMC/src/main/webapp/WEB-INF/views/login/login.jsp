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
<form action="/login/login" method="post">

	<div>
		<h1 style="font-size: 68px;">Login</h1>
	</div>
	
	<div class="input_box">
		<label for="userId"></label>
		<input type="text" name="userId" id="userId" placeholder=" ID"><br>
	</div>

	<div class="input_box">
		<label for="userPw"></label>
		<input type="password" name="userPw" id="userPw"placeholder=" PASSWORD"><br>
	</div>
	
	<div class="input_box">
		<label for="saveId"></label>
		<input type="checkbox" name="saveId" id="saveId">아이디 저장
	</div>
	
	<br>
	
	<div class="forget">
		<a href="/login/searchId" id="findId">아이디 찾기</a> | <a href="/login/searchPw">비밀번호 찾기</a> | <a href="/login/join">회원가입</a>
		
	</div>
	<br>

	<div class="loginbtn">
		<button class="btn">Login</button><br>
	</div>
	
	<div class="kakaobtn">
 		<a href="https://kauth.kakao.com/oauth/authorize?client_id=e711b32da569918789a178e0f371949d&redirect_uri=http://localhost:8888/oauth/kakao&response_type=code">
            <img src="/resources/image/kakao_login_medium_wide.png">
        </a>
	</div>
</form>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		
		//저장된 쿠키값을 id에 저장해준다. 쿠키값이 없으면 공백처리된다.
		var userLoginId = getCookie('userLoginId');
		$('#userId').val(userLoginId);
		
		//아이디 값이 쿠키에 저장되어 있으면 체크
		if($('#userId').val() != ""){
			
			// ID 저장하기를 체크 상태로 두기.
			$("#saveId").attr("checked", true); 
		}
		
		// 아이디 저장하기 -> 아이디가 저장되면 (해당 메소드 요소에 변화 생기면)
		$('#saveId').change(function() {
			
			// #saveId에 체크가 되면
			if($('#saveId').is(':checked')){
				var userInputId = $("#userId").val();
				//7일동안 쿠키 저장 setCookie(쿠키 설정할 이름,value,exdays)
				 setCookie("userLoginId", userInputId, 30);
			}else{ 
				// ID 저장하기 체크 해제 시,
	            deleteCookie("userLoginId");
	        }
		})
		
		// 아이디 저장하기가  눌린상태에서, ID를 입력한 경우
	     $("#userId").keyup(function(){
	     	if($("#saveId").is(":checked")){  //checked true
	            var userLoginId = $("#userId").val();
	            setCookie("userLoginId", userInputId, 30); // 30일 동안 쿠키 보관
	        }
	    });
		
		function setCookie(cookieName, value, exdays){
		    var exdate = new Date();
		    exdate.setDate(exdate.getDate() + exdays);
		    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
		    document.cookie = cookieName + "=" + cookieValue;
		}
		 
		function deleteCookie(cookieName){
		    var expireDate = new Date();
		    expireDate.setDate(expireDate.getDate() - 1);
		    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
		}
		 
		function getCookie(cookieName) {
		    cookieName = cookieName + '=';
		    var cookieData = document.cookie;
		    var start = cookieData.indexOf(cookieName);
		    var cookieValue = '';
		    if(start != -1){
		        start += cookieName.length;
		        var end = cookieData.indexOf(';', start);
		        if(end == -1)end = cookieData.length;
		        cookieValue = cookieData.substring(start, end);
		    }
		    return unescape(cookieValue);
		}
		
	});
	
/* 	$('#findId').click(function() {
		
	} */


</script>


<c:import url="../layout/footer.jsp"/> 