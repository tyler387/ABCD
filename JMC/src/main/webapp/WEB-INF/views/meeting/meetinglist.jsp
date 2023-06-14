<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="meetinglist">

<h1><img src="https://www.greenlight.co.kr/pc/public/img/i_super_join.png">모임 목록</h1>
<c:forEach var = "meeting" items="${meetinglist }">
<div class="meetingbox" onclick="location.href='/meeting/view?meetingno=${meeting.meetingno}'">

<table>

<tr>
<th>모임 이름</th>
<th>모임 인원</th>
<th>참가비</th>
<th>조회수</th>
</tr>


<tr>
<td>${meeting.mname}</td>
<td>${meeting.headCount}</td>
<td>${meeting.fee}</td>
<td>${meeting.hit}</td>
</tr>

</table>
</div>
</c:forEach>
</div>
</div>





