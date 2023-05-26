<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="../layout/header.jsp" />


<script type="text/javascript">

	function reportpopup() {
		var popUrl = "/meeting/report?mname=${viewmeeting.mname}&introduce=${viewmeeting.introduce}&meetingno=${viewmeeting.meetingno}"
		var popOption = "top=10, left=10, width=300, height=100, status=no, menubar=no, toolbar=no, resizable=no";
		window.open(popUrl,popOption);
	}
	
// 	function applicantpopup() {
// 		var popUrl1 = "/meeting/applicant?userno=${applicantview.userno}";
// 		var popOption1 = "top=10, left=10, width=300, height=100, status=no, menubar=no, toolbar=no, resizable=no";
// 		window.open(popUrl1,popOption1);

// 	}
	
</script>

<h1>모임 상세</h1>

<a onclick="reportpopup();"><button>신고하기</button></a>

<table>
<tr>
	<th>모임 이름</th>	
	<th>총 모임 인원</th>
	<th>참가비</th>
	<th>모임 소개</th>
	<th>모임 시간</th>
	<th>추가 태그</th>
</tr>

<tr>
	<td>${viewmeeting.mname}</td>
	<td>${viewmeeting.headCount}</td>
	<td>${viewmeeting.fee }</td>
	<td>${viewmeeting.introduce }</td>
	<td>${viewmeeting.meetingDate }</td>
	
</tr>

</table>

<a onclick="window.open('/meeting/join')"><button>모임 신청</button></a>


<c:forEach var = "applicantnick" items="${applicantnick }">

<!-- <table onclick="applicantpopup();"> -->
<table>
		<tr>
		<th>닉네임</th>
		</tr>
	
		<tr>
		<td><a onclick="window.open('/meeting/applicant?userno=${applicantnick.userno}' )" >${applicantnick.userNick}</a></td>
		
		</tr>
		
</table>

</c:forEach>


<br><br><br><br>



<c:import url="../layout/footer.jsp" />
