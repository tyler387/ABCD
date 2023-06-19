<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css">

#userInfoForm{
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	margin-top: 30px;

}

.box1{
	display: flex;
	flex-direction:column;  
	justify-content: flex-start;
	padding-top: 10px;
	padding-bottom: 15px;
	width: 380px;
}
.box2{
	margin-top: 15xp;
}

.userInfo-btn{
	margin-bottom: 30px;
}

input{
	width: 350px;
	height: 25px;
	border: 0;
    border: 1px #371e06 solid;
    border-radius: 4px;
    outline: none; 
}
.userbtn{
	border: 1px solid orange;
    background-color: orange;
    border-radius: 7px;
    color: #fff;
    width: 120px;
    height: 39px;
    font-size: 20px;
    cursor: pointer;
    margin-top: 40px;
    font-family: '양진체';


}
/* .userbtn:hover{ */
/* 	background-color: #ffcca8; */
/* } */
.btn{
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
.btn:hover{
	background-color: #ffcca8;
}
.addrinput{
	display: inline-block;
	width: 240px;
}
.box2 input:focus{
   border-color:#371e06;
   outline: none !important;
   box-shadow: 0 0 10px #371e06;
}
.box1 input:focus+label{
 	color: #371e06;
}



</style>

  </div>
      <div class="right">
      <div  style="font-size: 20px; padding-top: 38px; margin-left: 20px; "> 회원정보 수정</div>
       <div style="width:150px; margin-left: 18px;"><hr></div>
       
       <form action="/mypage/userInfo" method="post" id="userInfoForm">
       	<div><input type="hidden" id="userno" name="userno" value="${loginInfo.userno}"></div>
       	
       	<div class="box1">
       		<div class="labelbox"><label for="userId">아이디</label></div>
	
			<div class="">
				<input type="text" name="userId" id="userId" disabled value='${loginInfo.userId }'>
			</div>	
	    </div>
	    
	     <div class="box1">
       		<div class="labelbox"><label for="userNick">닉네임</label></div>
	
			<div class="box2">
				<input type="text" name="userNick" id="userNick" >
			</div>	
			
			<div class="msgbox" style="padding-top: 10px;">
				<span id="userNick_msg" style="font-size: 17px;"></span>	
			</div>
	    </div>

 

		<div class="box1">
		
			<div class="labelbox"><label for="userPw">패스워드</label></div>	
			
			<div class="box2">
				<input type="password" name="userPw" id="userPw" >
			</div>
			
			<div class="msgbox" style="padding-top: 10px;">
				<span id="pw_msg" style="font-size: 17px;"></span>	
			</div>	
			
		</div>


		<div class="box1">
		
			<div class="labelbox"><label for="userPw_chk">패스워드 확인</label></div>
			
			<div class="box2">
				<input type="password" name="userPw_chk" id="userPw_chk">
			</div>
			
			<div class="msgbox" style="padding-top: 10px;">
				<span id="pwchk_msg" style="font-size: 17px;"></span>	
			</div>	

		</div>


		<div class="box1">
		
			<div class="labelbox"><label for="userName">이름</label></div>
			<div class="box2"><input type="text" name="userName" id="userName" disabled value="${loginInfo.userName}"></div>
			
		</div>


		<div class="box1">
		
			<div class="labelbox"><label for="birth">생년월일</label></div>
			<fmt:formatDate value="${loginInfo.birth}" pattern="yyyy/MM/dd" var="birthday"/>
			<div class="box2"><input type="text" name="birth" id="birth" disabled value="${birthday}"></div>	
			
		</div>


		<div class="box1">
		
			<div class="labelbox"><label>성별</label></div>	
			
			<div class="select">
				<input type="text" id="select" name="gender" disabled value="${loginInfo.gender}">
			</div>
		</div>

		<div class="box1">
			<div>
				<div class="labelbox"><label>이메일</label></div>	
				
				<div class="box2">
					<input type="text" name="email" id="userEmail1">
				</div>
				
				<div class="msgbox" style="padding-top: 10px;">
					<span id="email_msg" style="font-size: 17px;"></span>	
				</div>	
			</div>
		</div>

		<div class="box1">
		
			<div class="labelbox"><label for="phone">휴대전화</label></div>	
			
			<div class="box2">
				<input type="tel" name="phone" id="phone">
			</div>
			<div class="msgbox" style="padding-top: 10px;">
				<span id="phoneMsg" style="font-size: 17px;"></span>
			</div>
		</div>
		
		
		<div class="box1">
		
			<div class="labelbox"><label>주소</label></div>	
			
			<div class="box2">
				<input type="text" name="addr1" id="addr1" placeholder="우편번호" class="addrinput">
				<input type="button" onclick="findAddress()" value="우편번호 찾기" class="btn">
			</div>	
			<div class="box2" style="padding-top:10px; ">
				<input type="text" name="addr2" id="addr2" placeholder="도로명주소">
			</div>
			<div class="box2" style="padding-top:5px;">
				<input type="text" name="addr3" id="addr3" placeholder="상세주소">
			</div>
			<div class="box2" style="padding-top:5px;">	
				<input type="text" id="addr4" placeholder="참고항목" >
			</div>
		</div>
		<div class="userInfo-btn">
		        <button class="userbtn" id="savebtn">저장</button>
		        <a href="/mypage/delete"><input type="button" class="userbtn" value="회원탈퇴"></a> 
		 		<a href="/mypage/main"><input type="button" class="userbtn" value="취소"></a>
		  </div>
 	 </form>
       
      </div>
   </div>
   
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

$(document).ready(function(){

	// FIXME: 필요 스크립트 전개 영역
    let checkPW = RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/);
    let checkPhone = RegExp(/^\d{3}\d{3,4}\d{4}$/);        
    let checkEmail = RegExp(/^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/);
    let checkNick = RegExp(/^[가-힣a-zA-Z0-9]{2,20}$/);
         
		const target = document.getElementById('savebtn');
		$('#savebtn').attr('disabled', true); // 초기에 버튼을 비활성화 상태로 설정
		
	$('#userPw').blur(function() {
	  var userPw = $('#userPw').val();

	  if (userPw === '') {
	    $('#pw_msg').html('비밀번호를 입력해 주세요');
	    $('#pw_msg').css('color', 'red');
	    $('#savebtn').attr('disabled', true); // 입력값이 없으므로 버튼을 비활성화
		return false;
	    
	  } else if (!checkPW.test(userPw)) {
	    $('#pw_msg').html('대소문자,특수문자 포함한 8자리~15자리로 입력해주세요');
	    $('#pw_msg').css('color', 'red');
	    $('#savebtn').attr('disabled', true); // 비밀번호 형식이 맞지 않으므로 버튼을 비활성화
		return false;
	  } else  {
	    $('#pw_msg').html("사용가능한 비밀번호입니다.");
	    $('#pw_msg').css("color", "#3f8ef7");
	    $('#savebtn').attr('disabled', false); // 비밀번호 형식이 맞으므로 버튼을 활성화
		return true;
	  }
		});
	
	$('#userPw_chk').blur(function() {
		var userPw = $('#userPw').val();
		var userPwChk = $('#userPw_chk').val();
	
		if(userPw != userPwChk){	
			$('#pwchk_msg').html('비밀번호가 일치하지 않습니다.');
			$('#pwchk_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
		}else if(userPwChk == ''){
			$('#pwchk_msg').html('비밀번호를 입력해주세요.');
			$('#pwchk_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
		}else if(userPw === userPwChk){
			$('#pwchk_msg').html('비밀번호가 일치합니다');
			$('#pwchk_msg').css('color','#3f8ef7');
			$('#savebtn').attr('disabled', false);
			return true;			
		}
	}) //$('#userPw_chk').blur ed
	
	$('#userEmail1').blur(function() {
		var email = $('#userEmail1').val();
	
		if(email === ''){	
			$('#email_msg').html('이메일을 입력해주세요');
			$('#email_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
		}else if(!checkEmail.test(email)){
			$('#email_msg').html('옳지않은 형식입니다.');
			$('#email_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
			
		}else if(checkEmail.test(email)){
			$('#email_msg').html("");                      
			$('#savebtn').attr('disabled', false);
        	return true;
		}
	}) //$('#userPw_chk').blur ed
	
	$('#phone').blur(function() {
		var phone = $('#phone').val();
	
		if(phone === ''){	
			$('#phoneMsg').html('핸드폰 번호를 입력해주세요');
			$('#phoneMsg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
			
		}else if(!checkPhone.test(phone)){
			$('#phoneMsg').html('옳지않은 형식입니다.');
			$('#phoneMsg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
			
		}else if(checkPhone.test(phone)){  
			$('#phoneMsg').html('');
 			$('#phoneMsg').css('color','#3f8ef7');
 			$('#savebtn').attr('disabled', false);
        	return true;
		}
	}) //$('#phone').blur ed
	
	$('#userNick').blur(function() {
		var userNick = $('#userNick').val();
	
		if(userNick === ''){	
			$('#userNick_msg').html('닉네임을 입력해 주세요');
			$('#userNick_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
		}else if(!checkNick.test(userNick)){
			$('#userNick_msg').html('2글자 이상의 닉네임을 입력해주세요');
			$('#userNick_msg').css('color','red');
			$('#savebtn').attr('disabled', true);
			return false;
			
		}else if(checkNick.test(userNick)){
			$('#userNick_msg').html("");                    
			$('#savebtn').attr('disabled', false);
        	return true;
		}
	}) //$('#userPw').blur ed

})//$(document).ready ed

   
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
   
   </script>

<c:import url="../layout/footer.jsp" />