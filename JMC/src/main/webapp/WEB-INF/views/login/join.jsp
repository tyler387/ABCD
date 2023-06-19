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

.joinForm{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding-bottom: 300px;
	padding-top: 100px;
  	min-height: 100vh;  
}

.labelbox{
	font-size: 24px;
	font-weight: bold;
}

input{
	width: 400px;
	height: 25px;
	border: 0;
    border: 1px #371e06 solid;
    border-radius: 4px;
    outline: none; 
}

.btn{
	font-family: '양진체';
	display :inline-block;
	background-color: #371e06;
	color: #fff;
	height: 40px;
	width: 390px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 18px;
	margin-right: 20px;
	cursor: pointer;
}
.btn:hover{
	background-color: #ffcca8;
}

.box1{
	display: flex;
	flex-direction:column;  
	justify-content: flex-start;
	padding-top: 5px;
	padding-bottom: 15px;
	width: 380px;
}


.box2{
	display: flex;
	justify-content: flex-start;
	padding-top: 5px;
	padding-bottom: 15px;
}

.box2 #userEmail1{
	width: 380px;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px; 
}
.box2 #userEmail2{
	width: 150px;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px; 
}

input#userId{
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px; 
}



input#email_checknumber{
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px; 
	width: 170px; 
}

input[type=button]{
	font-family: '양진체';
	display :inline-block;
	background-color: #371e06;
	color: #fff;
	height: 40px;
	width: 100px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 18px;
	margin-right: 20px;
	cursor: pointer;
	
}

input[type=button]:hover{
	background-color: #ffcca8;
}

.select{
	padding: 15px 10px;
}
.select input[type=text]{
	border-radius : 7px;
}
.select input[type=date]{
	border-radius : 7px;
}
.select input[type=password]{
	border-radius : 7px;
}
.select input[type=radio]{
	display: none;
}
.select input[type=number]{
	border-radius : 7px;
}
.select input[type=radio]+label{
	border-radius : 7px;
	display: inline-block;
	cursor: pointer;
	height: 35px;
	width: 173px;
	border: 1px solid orange;
	line-height:  24px;
	text-align: center;
	font-weight: bold;
	font-size: 22px;
}
.select input[type=radio]+lable{
	background-color: orange;
	color :#333;
}
.select input[type=radio]:checked+label{
	background-color: orange;
	color: #fff;
}


.box2 input:focus{
   border-color:#371e06;
   outline: none !important;
   box-shadow: 0 0 10px #371e06;
}
.box1 input:focus+label{
 	color: #371e06;
}

.box3 input:focus{
   border-color:#371e06;
   outline: none !important;
   box-shadow: 0 0 10px #371e06;
}

.selectOption {
  box-sizing: border-box;
  width: 200px;
  padding: 4px;
  font-size: 14px;
  border-radius: 6px;
  height: 34px;
  font-size: 18px;
}

.option {
  padding: 4px;
  font-size: 14px;
  color: black;
  background: white;
}
.option:hover {
	border-color:#371e06;
   outline: none !important;
   box-shadow: 0 0 10px #371e06;
}



</style>
</head>
<body>
<div id="continner">

<form class="joinForm" action="/login/join" method="post" > 
	<h1 style="font-size:63px;">JAMANCHU</h1> 

<div class="box1">

	<div class="labelbox"><label for="userId">아이디*</label></div>
	
	<div class="box2">
		<input type="text" name="userId" id="userId">
		<input type="button" id="idbtn" name="idbtn" onclick="idcheck()" value="중복확인">
	</div>	
	
	
	<div class="msgbox">
		<span id="id_msg" style="font-size: 17px;"></span>	
	</div>	
</div>
 

<div class="box1">

	<div class="labelbox"><label for="userPw">패스워드*</label></div>	
	
	<div class="box2">
		<input type="password" name="userPw" id="userPw">
	</div>
	<div class="msgbox">
		<span id="pw_msg" style="font-size: 17px;"></span>	
	</div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label for="userPw_chk">패스워드 확인*</label></div>
	
	<div class="box2">
		<input type="password" name="userPw_chk" id="userPw_chk">
	</div>
	
	<div class="msgbox">
		<span id="pwchk_msg" style="font-size: 17px;"></span>	
	</div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label for="userName">이름*</label></div>
	
	<div class="box2">
		<input type="text" name="userName" id="userName">
	</div>
	<div class="msgbox">
		<span id="name_msg" style="font-size: 17px;"></span>	
	</div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label for="birth">생년월일*</label></div>
		
	<div class="box2">
		<input type="date" name="birth" id="birth">
	</div>	
	<div class="msgbox">
		<span id="birthMsg" style="font-size: 17px;"></span>	
	</div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label>성별*</label></div>	
	
	<div class="select">
		<input type="radio" id="select" name="gender" value="M"><label for="select">남자</label>	
		<input type="radio" id="select2" name="gender" value="F"><label for="select2">여자</label>
	</div>
	<div class="msgbox">
		<span id="genderMsg" style="font-size: 17px;"></span>	
	</div>	
	
</div>

<div class="box1">
	<div>
		<div class="labelbox"><label>이메일*</label></div>	
		
		<div class="box2">
			<input type="text" name="email" id="userEmail1">
			
			</div>
			<div class="msgbox">
				<span id="emailMsg" style="font-size: 17px;"></span>	
			</div>	
			<div class="box3">
				<input type="text" name="email_checknumber" id="email_checknumber" placeholder="인증번호를 입력해주세요">
				<input type="button" id="emailbtn" name="emailbtn" value="본인인증">
			</div>
			<div style="padding-top:8px;">
				<span id="emailNumMsg" style="font-size: 17px;"></span>
			</div>
		</div>
	
<!-- 	<div class="msgbox"><span id="mail-check-warn"></span></div> -->
	
</div>


<div class="box1">

	<div class="labelbox"><label for="phone">휴대전화*</label></div>	
	
	<div class="box2">
		<select class="selectOption" name="phone" id="phone1">
				<option class="option">SKT</option>
				<option class="option">KT</option>
				<option class="option">LG</option>
		</select>
		<input type="tel" name="phone" id="phone">
	</div>
		<div class="msgbox" style="padding-top:8px;">
		<span id="phoneMsg" style="font-size: 17px;"></span>	
	</div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label>주소*</label></div>	
	
	<div class="box2">
		<input type="text" name="addr1" id="addr1" placeholder="우편번호">
		<input type="button" onclick="findAddress()" value="우편번호 찾기">
	</div>	
	<div class="box2">
		<input type="text" name="addr2" id="addr2" placeholder="도로명주소">
	</div>
	<div class="box2">
		<input type="text" name="addr3" id="addr3" placeholder="상세주소">
		<input type="text" id="addr4" placeholder="참고항목">
	</div>
</div>

<button class="btn" id="submit">JOIN</button>


 </form>  
</div>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

// //이메일주소 가져오기
// $("#userEmail1").blur(function(){ email();});

// $("#userEmail2").change(function(){ email(); });




// function email() {
// const emailF = $("#userEmail1").val();
// const middle = $("#middle").text();
// const address = $("#userEmail2").val();

// if(emailF != "" && address != "") {
//    $("#email").val(emailF + middle + address);
// }
// };


$(document).ready(function(){

	// FIXME: 필요 스크립트 전개 영역
    let checkID = RegExp(/^[a-z0-9]{6,20}$/);
    let checkPW = RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/);
    let checkName = RegExp(/^[가-힣]{2,}$/);
    let checkPhone = RegExp(/^\d{3}\d{3,4}\d{4}$/);        
    let checkEmail = RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
         
    const target = document.getElementById('submit');
	$('#submit').attr('disabled', true); // 초기에 버튼을 비활성화 상태로 설정

	$('#userId').blur(function() {
		var userId = $('#userId').val();
	
		if(userId === ''){
			$('#id_msg').html('아이디를 입력해 주세요');	
			$('#id_msg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(!checkID.test(userId)) {
			$('#id_msg').html("소문자,숫자를 포함한 6자리~20자리로 입력해주세요.");
			$('#id_msg').css('color','red');
			$('#submit').attr('disabled', true);   
            return false;
            
        }else if(checkID.test(userId)){
        	$('#id_msg').html("");
        	$('#submit').attr('disabled', false);
        	return true;
        }

    }); //$('#userId').blur end
		
	$('#userPw').blur(function() {
		var userPw = $('#userPw').val();
	
		if(userPw === ''){	
			$('#pw_msg').html('비밀번호를 입력해 주세요');
			$('#pw_msg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
		}else if(!checkPW.test(userPw)){
			$('#pw_msg').html('대소문자,특수문자 포함한 8자리~15자리로 입력해주세요');
			$('#pw_msg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(checkPW.test(userPw)){
			$('#pw_msg').html("")                         
			$('#submit').attr('disabled', false);
        	return true;
		}
	}) //$('#userPw').blur ed
	
	$('#userPw_chk').blur(function() {
		var userPw = $('#userPw').val();
		var userPwChk = $('#userPw_chk').val();
	
		if(userPw != userPwChk){	
			$('#pwchk_msg').html('비밀번호가 일치하지 않습니다.');
			$('#pwchk_msg').css('color','red');
// 			$("#userPw_chk").focus();
			return false;
		}else if(userPwChk == ''){
			$('#pwchk_msg').html('비밀번호를 입력해주세요.');
			$('#pwchk_msg').css('color','red');
			return false;
		}else if(userPw === userPwChk){
			$('#pwchk_msg').html('비밀번호가 일치합니다');
			$('#pwchk_msg').css('color','#3f8ef7');
// 			$("#userName").focus();
			return true;			
		}
	}) //$('#userPw_chk').blur ed
	
	$('#userName').blur(function() {
		var userName = $('#userName').val();
	
		if(userName === ''){	
			$('#name_msg').html('이름을 입력해 주세요');
			$('#name_msg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(!checkName.test(userName)){
			$('#name_msg').html('옳지않은 형식입니다.');
			$('#name_msg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else{  
			$('#name_msg').html('');
			$('#name_msg').css('color','#3f8ef7');
			$('#submit').attr('disabled', false);
	    	return true;
		}
	}) //$('#userName').blur ed
	
	
	
	$('#phone').blur(function() {
		var phone = $('#phone').val();
	
		if(phone === ''){	
			$('#phoneMsg').html('핸드폰 번호를 입력해주세요');
			$('#phoneMsg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(!checkPhone.test(phone)){
			$('#phoneMsg').html('옳지않은 형식입니다.');
			$('#phoneMsg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(checkPhone.test(phone)){  
			$('#phoneMsg').html('');
 			$('#phoneMsg').css('color','#3f8ef7');
 			 $('#submit').attr('disabled', false);
        	return true;
		}
	}) //$('#phone').blur ed
	
	$('#userEmail1').blur(function() {
		var email = $('#userEmail1').val();
	
		if(email === ''){	
			$('#emailMsg').html('이메일을 입력해주세요');
			$('#emailMsg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(!checkEmail.test(email)){
			$('#emailMsg').html('옳지않은 형식입니다.');
			$('#emailMsg').css('color','red');
			$('#submit').attr('disabled', true);
			return false;
			
		}else if(checkEmail.test(email)){  
			$('#emailMsg').html('');
			$('#emailMsg').css('color','#3f8ef7');
			$('#submit').attr('disabled', false);
	    	return true;
		}
	}) //$('#userName').blur ed
	


})//$(document).ready ed


 function idcheck() {	
	
	var userId = $('#userId').val();

	$.ajax({
	    type : 'post',           // 타입 (get, post, put 등등)
	    url : '/login/idcheck',   // 요청할 서버url
	    dataType : 'json',       // 데이터 타입 (html, xml, json, text 등등)
	    data : {userId:userId} , // 보낼 데이터 (Object , String, Array)
	    success : function(res) { // 결과 성공 콜백함수
	        if(res > 0){
	        	$('#id_msg').html('이미 사용중인 아이디입니다.');
	        	$('#id_msg').css('color','red');
	        }else{
	        	$('#id_msg').html("사용가능한 아이디입니다.")
	         	$('#id_msg').css("color", "#3f8ef7");    
	        }
	    	console.log(res);
	    },
	    error : function() { // 결과 에러 콜백함수
	        alert('서버요청 실패');
	    }
	}) // ajax end		
 }	
 	// 주소 api
function findAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addr4").value = extraAddr;
            
            } else {
                document.getElementById("addr4").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('addr1').value = data.zonecode;
            document.getElementById("addr2").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr3").focus();
        }
    }).open();
}

$(document).ready(function(){
	// 이메일 인증
	var code = ""; // 인증번호 저장을 위한 코드
	var isCertification = false; // 인증 여부 변수
	const checkInput = $('#email_checknumber'); // 인증번호 입력하는 곳

	$('#emailbtn').click(function() {
		const email = $('#userEmail1').val() 
// 		+ $('#userEmail2').val(); // 이메일 주소값 얻어오기!
		console.log('완성된 이메일: ' + email); // 이메일 오는지 확인
		
		
		$.ajax({
			type: 'GET',
			url: '/login/mailCheck?email=' + email, // GET 방식이라 Url 뒤에 email을 뭍힐 수 있다.
			dataType: 'text',
			success: function(data) {
				/* console.log('data: ' + data); */
				//
				code = data;
				isCertification = true; // 인증이 완료되었음을 표시
				alert('인증번호가 전송되었습니다.');
				$('#submit').attr('disabled', false);
			},
			error : function() { // 결과 에러 콜백함수
				alert('서버요청 실패');
			}      
		}); // end ajax
	}); // end send email

	// 인증번호 비교 
	// blur -> focus가 벗어나는 경우 발생
	$('#email_checknumber').blur(function () {
		const inputCode = $('#email_checknumber').val();
		const resultMsg = $('#emailNumMsg');

		if (!isCertification) {
			resultMsg.html('인증이 완료되지 않았습니다.');
			resultMsg.css('color', 'red');
		} else if (inputCode === code) {
			resultMsg.html('인증번호가 일치합니다.');
			resultMsg.css('color', 'green');
			$('#emailbtn').attr('disabled', true);
			$('#userEamil1').attr('readonly', true);
// 			$('#userEamil2').attr('readonly', true);
			$('#userEmail1').attr('onFocus', 'this.initialSelect = this.selectedIndex');
 			$('#userEmail1').attr('onChange', 'this.selectedIndex = this.initialSelect');
 			checkInput.attr('disabled', true); // 인증번호 입력이 가능하도록 속성 변환
		} else if (inputCode === '') {
			resultMsg.html('인증번호를 입력해주세요.');
			resultMsg.css('color', 'red');
		} else {
			resultMsg.html('인증번호가 불일치합니다. 다시 확인해주세요!.');
			resultMsg.css('color', 'red');
		}
	});

	// 인증번호가 다르면 submit 안되게
	$('#submit').click(function() {
		if (!isCertification) {
			alert('인증이 완료되지 않았습니다.');
			return false;
		} else {
			return true;
		}
	});
});

		
		
</script>

<c:import url="../layout/footer.jsp" />


