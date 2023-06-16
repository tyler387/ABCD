<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">

table {
		width: 1020px;
}
thead {
	
    height: 100px;
}

#status{
	text-align: center;
}
#trWriter{
	text-align: center;
}
#trdate{
	text-align: center;
}

</style>

<body>
<div id="qnaBoard" style="padding-left: 450px; padding-bottom: 60px;">
<table>
<thead>
	<tr>
		<th style="width: 15%;">답변상태</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 25%;">작성일</th>
	</tr>
</thead>

<c:forEach var="itemQnAQList" items="${itemQnAQList }">
<tr>

	
		<td style="width: 15%;" id="status">${itemQnAQList.IQ_STATUS }</td>
		<td style="width: 45%;" id="trcontent">${itemQnAQList.IQ_TITLE }</td>
		<td style="width: 15%;" id="trWriter">${itemQnAQList.USER_ID }</td>
		<td style="width: 25%;" id="trdate">${itemQnAQList.WRITE_DATE }</td>
	
</tr>
</c:forEach>

</table>
<!-- 	 <input type="button" value="문의하기" onclick="showPopup();" /> -->
	<div class= "qnabtn" style="padding-top: 30px; padding-left: 850px;">
		<c:import url="../store/boardWrite2.jsp" />
	</div>

</div>

