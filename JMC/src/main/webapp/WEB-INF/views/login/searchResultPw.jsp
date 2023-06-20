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

.searchbox{
	display:flex;
 	justify-content:center; 
	align-items: center;
	flex-direction:column;
	width:  680px;
	height:  750px;	
	margin-bottom: 350px;
	border: 1px solid #371e06;
	border-radius: 10px 10px 10px 10px;
	box-shadow: 5px 5px 15px;
	margin-top: 200px;	
}

.searchresult{
	display: flex;
/* 	align-items: center; */
	flex-direction: column;
	justify-content: center;
}

.searchresult p{
	font-size: 24px;
}
#resultForm{
	padding-top: 45px;
}

.Idresultbtn{
	font-family: '양진체';
	display :inline-block;
	background-color: #371e06;
	color: #fff;
	height: 50px;
	width: 350px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 20px;
	margin-right: 20px;
	margin-top: 75px;
	cursor: pointer;
}

label{
	font-size: 24px;
	font-weight: bold;
}

input[type=password]{
	 height:28px;
     width:320px;
     border-radius: 4px;
     font-size: 20px; 
     outline: none; 
     color : #371e06;
}

input:focus{
   border-color:#371e06;
   outline: none !important;
   box-shadow: 0 0 10px #371e06;
}

.inputbox2{
	padding-bottom: 30px;
}

.Idresultbtn:hover{
	background-color: #ffcca8;
}
</style>




<div class="container">
	<div class="searchbox">	
		<div class="nameBox"><h1 style="font-size: 35px;">새 비밀번호 설정</h1></div>
			<form action="/login/searchResultPw" method="post" id="resultForm"> 
				<input type="hidden" id="userno" name="userno" value="${userno}">
	
				<div class="searchresult">
		
				<label for="userPw">비밀번호</label>
				
				<div class="inputbox2">
					<input type="password" id="userPw" name="userPw">
				
					<div class="msgbox" style="padding-top:8px;">
						<span id="pwMSG" style="font-size: 17px;"></span>	
					</div>	
				</div>
				
				<div class="inputbox2">
					<label for="userPwchk" class="namebox2">비밀번호 재입력</label>
						
					<div>
						<input type="password" id="userPwchk" name="userPwchk">
					</div>	
					
					<div class="msgbox" style="padding-top:8px;">
						<span id="pwchk_msg" style="font-size: 17px;"></span>	
					</div>	
				</div>	
			
				<button class="Idresultbtn" id="Idresultbtn">확인</button>
			</div> 
			</form> 
	</div>
</div>


<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){

	// FIXME: 필요 스크립트 전개 영역
    let checkPW = RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/);

    const target = document.getElementById('Idresultbtn');
	$('#Idresultbtn').attr('disabled', true); // 초기에 버튼을 비활성화 상태로 설정
	
	$('#userPw').blur(function() {
		var userPw = $('#userPw').val();
	
		if(userPw === ''){	
			$('#pwMSG').html('비밀번호를 입력해 주세요');
			$('#pwMSG').css('color','red');
			$('#Idresultbtn').attr('disabled', true);
			return false;
			
		}else if(!checkPW.test(userPw)){
			$('#pwMSG').html('옳지않은 형식입니다.');
			$('#pwMSG').css('color','red');
			$('#Idresultbtn').attr('disabled', true);
			return false;
			
		}else if(checkPW.test(userPw)){  
			$('#pwMSG').html('');
			$('#pwMSG').css('color','#3f8ef7');
			$('#Idresultbtn').attr('disabled', false);
	    	return true;
		}
	}) //$('#userName').blur ed
	
	$('#userPwchk').blur(function() {
		var userPw = $('#userPw').val();
		var userPwChk = $('#userPwchk').val();
	
		if(userPw != userPwChk){	
			$('#pwchk_msg').html('비밀번호가 일치하지 않습니다.');
			$('#pwchk_msg').css('color','red');
			$('#Idresultbtn').attr('disabled', true);
			return false;
			
		}else if(userPwChk == ''){
			$('#pwchk_msg').html('비밀번호를 입력해주세요.');
			$('#pwchk_msg').css('color','red');
			$('#Idresultbtn').attr('disabled', true);
			return false;
		}else if(userPw === userPwChk){
			$('#pwchk_msg').html('비밀번호가 일치합니다');
			$('#pwchk_msg').css('color','#3f8ef7');
			$('#Idresultbtn').attr('disabled', false);
			return true;			
		}
	}) //$('#userPw_chk').blur ed


})

</script>
<c:import url="../layout/footer.jsp" />