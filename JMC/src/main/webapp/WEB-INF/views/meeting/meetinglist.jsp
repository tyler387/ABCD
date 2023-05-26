<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />

<style type="text/css">



.yellow{
  background-color:#f5f5dc;
  width:250px;
  height:50px;
  margin-bottom:5px;
  	
}

</style>

<h1>모임 신청</h1>

<button>캘린더</button>
<button>지도</button><br>
<c:forEach var = "meeting" items="${meetinglist }">

<div class="yellow" onclick="location.href='/meeting/view?meetingno=${meeting.meetingno}'">
<table>

<tr>
<th>모임 이름</th>
<th>총 모임 인원</th>
<th>참가비</th>
</tr>


<tr>
<td>${meeting.mname}</td>
<td>${meeting.headCount}</td>
<td>${meeting.fee}</td>
</tr>


</table>
</div>
</c:forEach>


<c:import url="../layout/footer.jsp" />