<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	padding-top: 5px;
	padding-bottom: 15px;
	width: 380px;
}

.userInfo-btn{
	margin-bottom: 30px;
	

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
	
			<div class="">
				<input type="text" name="userNick" id="userNick">
			</div>	
	    </div>

 

		<div class="box1">
		
			<div class="labelbox"><label for="userPw">패스워드</label></div>	
			
			<div class="box2">
				<input type="password" name="userPw" id="userPw">
			</div>
			
		</div>


		<div class="box1">
		
			<div class="labelbox"><label for="userPw_chk">패스워드 확인</label></div>
			
			<div class="box2">
				<input type="password" name="userPw_chk" id="userPw_chk">
			</div>

		</div>


<div class="box1">

	<div class="labelbox"><label for="userName">이름</label></div>
	<div class="box2"><input type="text" name="userName" id="userName" disabled value="${loginInfo.userName}"></div>
	
</div>


<div class="box1">

	<div class="labelbox"><label for="birth">생년월일</label></div>		
	<div class="box2"><input type="text" name="birth" id="birth" disabled value="${loginInfo.birth}"></div>	
	
</div>


<div class="box1">

	<div class="labelbox"><label>성별</label></div>	
	
	<div class="select">
		<input type="radio" id="select" name="gender" disabled value="${loginInfo.gender}"><label for="select">남자</label>	
	</div>
</div>

<div class="box1">
	<div>
		<div class="labelbox"><label>이메일</label></div>	
		
		<div class="box2">
			<input type="text" name="email" id="userEmail1">
			
			<select name="email" id="userEmail2">
				<option>@naver.com</option>
				<option>@google.com</option>
				<option>@daum.net</option>
				<option>@hanmail.com</option>
			</select>
			</div>
		</div>
</div>


<div class="box1">

	<div class="labelbox"><label for="phone">휴대전화</label></div>	
	
	<div class="box2">
		<select name="phone" id="phone1">
				<option>SKT</option>
				<option>KT</option>
				<option>LG</option>
				<option>SKT알뜰폰</option>
				<option>KT알뜰폰</option>
				<option>LG알뜰폰</option>
			</select>
		<input type="tel" name="phone" id="phone">
	</div>
</div>


<div class="box1">

	<div class="labelbox"><label>주소</label></div>	
	
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
<div class="userInfo-btn">
        <button>저장</button>
        <a href="/mypage/delete"><input type="button" value="회원탈퇴"></a> 
 		<a href="/mypage/main"><input type="button" value="취소"></a>
  </div>
  </form>
       
      </div>
   </div>
   
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
   
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