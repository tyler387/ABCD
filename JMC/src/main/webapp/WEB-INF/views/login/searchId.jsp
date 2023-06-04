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
.namebox{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 120px;
}

form{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: flex-start;
	margin-top: 59px;	
	padding-bottom: 280px;

	
	
}

label{
	font-size: 24px;
	font-weight: bold;
}

input[type=text]{
	 height:28px;
     width:320px;
     border-radius: 4px;
     font-size: 20px; 
     outline: none; 
}

input#userEmail1{
	margin-bottom: 10px;
}

div.inputId{
	padding-bottom: 30px;
}

select{
	 height:28px;
     width:200px;
     border-radius: 4px;
     font-size: 20px; 
     outline: none; 

}

div.nextBtn{
	padding-top: 20px;
}
button#nextbtn.btn{
    height: 30px;
    width: 88px;

}

</style>


<div class="container">
	
	<div class="namebox">
		<h1 style="font-size: 35px;">아이디 찾기</h1>
	</div>
	
 
 <form action="/login/searchId" method="post" onsubmit="return submitCheck();"> 
		<div class="inputId">
			<label for="userName">이름</label>
			<div>
				<input type="text" id="userName" name="userName">
			</div>
			<div>
				<span id="name_msg"></span>
			</div>
		</div>

	<div class="email-group">
		<label>이메일</label>
		
		<div class="input-group">
			<input type="text" name="email" id="userEmail1">		
			<select name="email" id="userEmail2">
				<option>@naver.com</option>
				<option>@google.com</option>
				<option>@daum.net</option>
				<option>@hanmail.com</option>
			</select>
		
			<div>
				<input type="text" name="email_checknumber" id="email_checknumber" placeholder="인증번호를 입력해주세요">
				<button type="button" id="email_checkbtn" name="email_checkbtn">본인인증</button>
				<span id="emailMSG"></span>
			</div>
		</div>
			
		<div><span id="mail-check-warn"></span></div>
	
		<div class='nextBtn'>
			<button class="btn" id="nextbtn">다음</button>
		</div>
	</div>
 </form> 
 </div>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

$('#userName').blur(function() {
	var userName = $('#userName').val();

	if(userName === ''){	
		$('#name_msg').html('이름을 입력해 주세요');
		$('#name_msg').css('color','red');
//			$("#userName").focus();
		return false;
	}else{  
		$('#name_msg').html('');
		$('#name_msg').css('color','#3f8ef7');
//     	$("#birth").focus();
    	return true;
	}
}) //$('#userName').blur ed



//이메일 인증
var code = ""; // 인증번호 저장을 위한 코드
var isCertification = false; // 인증 여부 변수

$('#email_checkbtn').click(function() {
  const email = $('#userEmail1').val() + $('#userEmail2').val(); // 이메일 주소값 얻어오기!
  console.log('완성된 이메일: ' + email); // 이메일 오는지 확인
  
  const checkInput = $('#email_checknumber'); // 인증번호 입력하는 곳
  
  $.ajax({
    type: 'GET',
    url: '/login/mailCheck?email=' + email, // GET 방식이라 Url 뒤에 email을 뭍힐 수 있다.
    dataType: 'text',
    success: function(data) {
      /* console.log('data: ' + data); */
      checkInput.attr('disabled', false); // 인증번호 입력이 가능하도록 속성 변환
      code = data;
      isCertification = true; // 인증이 완료되었음을 표시
      alert('인증번호가 전송되었습니다.');
    },
    error : function() { // 결과 에러 콜백함수
        alert('서버요청 실패');
    }      
  }); // end ajax
}); // end send email

// 인증번호 비교 
//// blur -> focus가 벗어나는 경우 발생
	$('#email_checknumber').blur(function () {
	const inputCode = $('#email_checknumber').val();
	const $resultMsg = $('#mail-check-warn');
	
	if(inputCode === code){
		$resultMsg.html('인증번호가 일치합니다.');
		$resultMsg.css('color','green');
		$('#email_checkbtn').attr('disabled',true);
		$('#userEamil1').attr('readonly',true);
		$('#userEamil2').attr('readonly',true);
		/* $('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
        $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect'); */
       
	}else{
		$resultMsg.html('인증번호가 불일치 합니다. 다시 확인해주세요!.');
		$resultMsg.css('color','red');
	}
})  


// 인증번호가 다르면 sumit 안되게
 $('#nextbtn').click(function submitCheck() {
	if(!isCertification){
		alert('인증이 완료되지 않았습니다.');
		return false;
	}else{
		return true;
	}
})  

</script>

<c:import url="../layout/footer.jsp" />