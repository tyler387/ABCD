<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${applicantuser.userNick }
	
	<h2>기본정보</h2>
	나이: ${applicantuser.birth }<br>
	지역: ${applicantuser.addr1 }<br>
	소개: ${applicantview.applicantContent }<br>
	
	
	<button onclick="window.close()">확인 완료</button>
	
</body>
</html>