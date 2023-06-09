<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	
	<script type="text/javascript">
	
	function fn_join(){
		alert("모임 신청이 완료되었습니다");
		var frm=document.getElementById('join'); 
		frm.submit();
		 setTimeout(function() {   
	             window.close();

	          }, 100);
		
	}
	
	</script>
	
<body>

	<h1>닉네임 </h1>	
	
	<form id="join" action="/meeting/join" method="post">
	
	<label>한줄 신청창</label>
	<input type="hidden" name="meetingno" id="meetingno" value=${viewmeeting.meetingno }>
	<input type="text" id="applicantContent" name="applicantContent">
	
	
	<button onclick="fn_join()">모임 신청</button>
	
	</form>
	
</body>
</html>