<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css">


.label{
	display: flex;
	text-align: center;
	flex-direction: column;	
}

.deleteform{
	display:flex;
	justify-content:center; 
	align-items: center;
	flex-direction:column;
	height:  500px;	
	border: 1px solid #371e06;
	border-radius: 10px 10px 10px 10px;
	box-shadow: 5px 5px 15px;
	margin : 100px 20px;
}

</style>

  </div>
  
      <div class="right">
      <div class="deleteform">
      <div class="label">
	      <h1>회원탈퇴를 하면 서비스를 더이상 이용하실 수 없습니다.</h1>
	      <h3>탈퇴를 진행하시겠습니까?</h3>
      </div>
      <form action="/mypage/delete" method="post">
        <div class="userleave">
        	<div><input type="hidden" id="userno" name="userno" value="${user.userno}"></div>
			
			<div class="box1">
			
				<div class="labelbox"><label for="userId">아이디</label></div>
				
				<div class="box2">
					<input type="text" name="userId" id="userId">
				</div>	
				
				<div class="msgbox" style="padding-top:8px;">
					<span id="id_msg" style="font-size: 17px;"></span>	
				</div>	
			</div>
			 
			
			<div class="box1">
			
				<div class="labelbox"><label for="userPw">현재 패스워드</label></div>	
				
				<div class="box2">
					<input type="password" name="userPw" id="userPw">
				</div>
				<div class="msgbox" style="padding-top:8px;">
					<span id="pw_msg" style="font-size: 17px;"></span>	
				</div>	
				
			</div>
			
			
			<div class="box1">
			
				<div class="labelbox"><label for="userPw_chk">패스워드 확인</label></div>
				
				<div class="box2">
					<input type="password" name="userPw_chk" id="userPw_chk">
				</div>
				
				<div class="msgbox" style="padding-top:8px;">
					<span id="pwchk_msg" style="font-size: 17px;"></span>	
				</div>	
				
			</div>
			        	
        	
        	
        	 <a href="/login/main"><button>회원탈퇴</button></a> 
        	
        	</div>
        	</form>
        </div>	
        </div>
      </div>
  
    </div>
    
<script>
    
    $(document).ready(function(){

    	// FIXME: 필요 스크립트 전개 영역
        let checkID = RegExp(/^[a-zA-Z0-9]{6,20}$/);
        let checkPW = RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/);

    	$('#userId').blur(function() {
    		var userId = $('#userId').val();
    	
    		if(userId === ''){
    			$('#id_msg').html('아이디를 입력해 주세요');	
    			$('#id_msg').css('color','red');
//     			$("#userId").focus();
    			return false;

    		}
    	})
    	
    	$('#userPw').blur(function() {
    		var userPw = $('#userPw').val();
    	
    		if(userPw === ''){	
    			$('#pw_msg').html('비밀번호를 입력해 주세요');
    			$('#pw_msg').css('color','red');
//     			$("#userPw").focus();
    			return false;
    		}else if(!checkPW.test(userPw)){
    			$('#pw_msg').html('대소문자,특수문자 포함한 8자리~15자리로 입력해주세요');
    			$('#pw_msg').css('color','red');
//     			$("#userPw").focus();
    			return false;
    			
    		}else if(checkPW.test(userPw)){
    			$('#pw_msg').html("사용가능한 비밀번호입니다.")
            	$('#pw_msg').css("color", "#3f8ef7");                           
//             	$("#userPw_chk").focus();
            	return true;
    		}
    	}) //$('#userPw').blur ed
    	
    	$('#userPw_chk').blur(function() {
    		var userPw = $('#userPw').val();
    		var userPwChk = $('#userPw_chk').val();
    	
    		if(userPw != userPwChk){	
    			$('#pwchk_msg').html('비밀번호가 일치하지 않습니다.');
    			$('#pwchk_msg').css('color','red');
//     			$("#userPw_chk").focus();
    			return false;
    		}else if(userPwChk == ''){
    			$('#pwchk_msg').html('비밀번호를 입력해주세요.');
    			$('#pwchk_msg').css('color','red');
    			return false;
    		}else if(userPw === userPwChk){
    			$('#pwchk_msg').html('비밀번호가 일치합니다');
    			$('#pwchk_msg').css('color','#3f8ef7');
//     			$("#userName").focus();
    			return true;			
    		}
    	}) //$('#userPw_chk').blur ed
    	
 })//$(document).ready ed
</script>

<c:import url="../layout/footer.jsp" />