<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<script type="text/javascript">
	
	function fn_insert(){
		alert("신고가 완료되었습니다");
		var frm=document.getElementById('report'); 
		frm.submit();
		 setTimeout(function() {   
	             window.close();

	          }, 100);
		
	}
	
	</script>
	
		
	<h1>신고하기</h1>
	
	<form id="report" action="/meeting/report" method="post">
	
	<input type="hidden" name="meetingno" id="meetingno" value=${viewmeeting.meetingno }>
	<label>게시글 제목<input type="text" readonly="readonly" name="rmTitle" id="rmTitle" value="${viewmeeting.mname }"></label><br>
	<label>게시글 내용<input type="text" readonly="readonly" name="rmContent" id="rmContent" value="${viewmeeting.introduce }"></label><br>
	<label>신고사항<input type="text" name="rmOption" id="rmOption"></label>
	
	
	<button onclick="fn_insert()">신고하기</button>

	</form>
</body>
</html>