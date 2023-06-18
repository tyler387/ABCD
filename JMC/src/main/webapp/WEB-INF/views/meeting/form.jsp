<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:import url="../layout/header.jsp" />

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style type="text/css">


[type="radio"]{
	vertical-align: middle;

}

label{
	vertical-align: middle;
}

.mname {
	width: 400px;
}

.postcode {
	width: 295px;

}

.post {
	width: 400px;


}
b {
	display: block;
}

input {
	height: 30px;
	border: 1px solid black;
	border-radius: 10px;
	background-color: white;
}

textarea{
	border-radius: 10px;

}

.meeting-join {
	margin-bottom: 50px;
}

.meeting-pre {
	margin-bottom: 10px;
}

.meeting-pre1 {
	margin-bottom: 10px;
}

.meeting {
	width: 600px;
	margin: 0 auto;
	font-family: '양진체';
}

.meetingform {
	border-radius: 20px;
	box-shadow: 0 2px 12px 0 rgb(100 100 100/ 16%), 0 2px 17px 0
		rgb(200 200 200/ 20%);
	padding: 20px;
	margin-bottom: 50px;
	text-align: center;
	background-color: beige;
}

.meetingpre {
	border-radius: 20px;
	box-shadow: 0 2px 12px 0 rgb(100 100 100/ 16%), 0 2px 17px 0
		rgb(200 200 200/ 20%);
	margin-bottom: 50px;
	text-align: center;
	padding: 20px;
	background-color: beige;
}

.meetingbtn {
	height: 50px;
	width: 300px;
	border-radius: 20px;
	background: orange;
	color: #fff;
	border: none;
	font-size: 20px;
	font-family: '양진체';
}

.btndiv {
	text-align: center;
	margin-bottom: 100px;
}

h1 {
	text-align: center;
}

.meetingbtn:hover {
	background-color: #ffcca8;
}

.meeting-loc {
 	swidth: 295px;
	margin-bottom : 10px;
}

</style>



<h1>모임 등록</h1>
	
	
	<div class="meeting"> 
	
	
	<form action="/meeting/form" method="post">
	
	<div class="meetingform">
	
	<h4>모임의 정보를 등록해 주세요</h4>
	
	<div class="meeting-join">
	
	<div class="meeting-join"><label><b>모임 명</b><input class="mname" type="text" id="mname" name="mname" placeholder="모임 이름"></label></div>
	<div class="meeting-loc"><label><b>모임 지역</b><input class="postcode" type="text" id="sample6_postcode" name="loc"  placeholder="우편번호"></label>
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></div>
	<div class="meeting-loc"><input class="post" type="text" id="sample6_address" name="loc1" placeholder="도로명주소"></div>
	<div class="meeting-loc"><input class="post" type="text" id="sample6_extraAddress" name="loc2" placeholder="참고항목"></div>
	<div class="meeting-loc"><input class="post" type="text" id="sample6_detailAddress" name="loc3" placeholder="상세주소"></div>
	<div class="meeting-join"><label><b>모임 날짜</b><input type="datetime-local" id="meetingDate" name="meetingDate"></label></div>
	<div class="meeting-join"><label><b>참가비</b><input type="text" id="fee" name="fee" placeholder="원"></label></div>
	<div class="meeting-join"><label><b>인원 수</b><input type="number" id="headCount" name="headCount" min="2"  max="10" placeholder="명"></label></div>
	<div class="meeting-join"><label><b>모임 소개</b><textarea rows="10px" cols="50px" id="introduce" name="introduce" placeholder="모임 소개 및 주의 사항"></textarea></label></div>
	
	
	
	</div>
   
	</div>	
	
	<div class="meetingpre">
	<h4>선호하는 친구 타입(선택)</h4>
	
	<div class="meeting-pre"><b>성별</b></div>
	<div class="meeting-pre1">
	<label>남자</label><input type="radio" value="man" name="gender">
	<label>여자</label><input type="radio" value="woman" name="gender">		
	<label>무관</label><input type="radio" value="none" name="gender" checked="checked">
	</div>
	
	<div class="meeting-pre"><b>나이</b></div>
	<div class="meeting-pre1">
	<input type="number" id="minage" name="minage" min="20" max="99" value="20">
	~
	<input type="number" id="maxage" name="maxage" min="20" max="99" value="99" >
	</div>
	
	<div class="meeting-pre"><b>추가 태그</b></div>
	
	<div class="meeting-pre">
	<label>흡연 여부:</label>
	<label>무관</label><input type="radio" id="smokenomatter" name="smoke" value="nomatter" checked="checked">
	<label>가능</label><input type="radio" id="smokeyes" name="smoke" value="yes">
	<label>불가능</label><input type="radio" id="smokeno" name="smoke" value="no">
	</div>
	
	
	<label>동반자 여부:</label>
	<label>무관</label><input type="radio" id="smokenomatter" name="friend" value="nomatter" checked="checked">
	<label>가능</label><input type="radio" id="friendyes" name="friend" value="yes">
	<label>불가능</label><input type="radio" id="friendno" name="friend" value="no">
	
	
	
	</div>
	
	<div class="btndiv"><button class="meetingbtn">등록하기</button></div>
	
	</form>		
	
	
	</div>
	
<script>

// 	if(document.getElementById("smoke").checked) {
// 		document.getElementById("smokehidden").disabled = true;
// 	}
	
// 	if(document.getElementById("friend").checked) {
// 		document.getElementById("friendhidden").disabled = true;
// 	}
	
	
	$('input[type="text"]').keydown(function() {
	 	if (event.keyCode === 13) {
    	event.preventDefault();
  		};
	});
	
	
	
    function sample6_execDaumPostcode() {
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
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

<c:import url="../layout/footer.jsp" />
