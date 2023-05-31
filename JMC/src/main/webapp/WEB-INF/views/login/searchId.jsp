<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<h1>아이디 찾기</h1>

<p>등록된 이메일로 아이디 찾기</p>
<!-- <form action="/login/searchId" method="post" onsubmit="return submitCheck();"> -->
<div>
	<label for="userName">이름</label>
	<input type="text" id="userName" name="userName">
	<span id="msg"></span>
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
		<br>
		<input type="text" name="email_checknumber" id="email_checknumber" placeholder="인증번호를 입력해주세요">
		<button type="button" id="email_checkbtn" name="email_checkbtn">본인인증</button>
	</div>
	<div>	
		<span id="mail-check-warn"></span>
	</div>
	<a href="/login/searchResultId" id="submit"><button>다음</button></a>
</div>
<!-- </form> -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">





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
 $('#submit').click(function submitCheck() {
	if(!isCertification){
		alert('인증이 완료되지 않았습니다.');
		return false;
	}else{
		return true;
	}
})  

</script>

<c:import url="../layout/footer.jsp" />