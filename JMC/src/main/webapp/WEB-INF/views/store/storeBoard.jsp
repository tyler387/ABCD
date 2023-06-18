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

 table {
    width: 1020px;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 3px solid #444444;
  }
td{
	cursor: pointer;
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

		<c:choose>
			<c:when test="${itemQnAQList.IQ_STATUS eq 'unprocessed'}">
				<td style="width: 15%;" id="status">답변대기</td>	
			</c:when>
			<c:when test="${itemQnAQList.IQ_STATUS eq 'done'}">
				<td style="width: 15%;" id="status">답변완료</td>
			</c:when>
		</c:choose>	
		<td style="width: 45%;" id="trcontent" data-userno ="${itemQnAQList.USERNO }" data-qnano="${itemQnAQList.ITEM_QNANO }">${itemQnAQList.IQ_TITLE }</td>
		<td style="width: 15%;" id="trWriter">${itemQnAQList.USER_ID }</td>
		<td style="width: 25%;" id="trdate">${itemQnAQList.IQ_WRITE_DATE }</td>
${itemQnAQList.USERNO }
${itemQnAQList.ITEM_QNANO }
</tr>
</c:forEach>

</table>
<!-- 	 <input type="button" value="문의하기" onclick="showPopup();" /> -->
	<div class= "qnabtn" style="padding-top: 30px; padding-left: 850px;">
		<c:import url="../store/boardWrite2.jsp" />
	</div>

</div>
<script type="text/javascript">

var userno = null;
var item_qnano = null;

// $("#trcontent").click(function(){
$(document).on("click", "#trcontent", function() {
	console.log("td 버튼 클릭됨")
	userno = $(this).attr("data-userno");
	item_qnano = $(this).attr("data-qnano");
	console.log(userno);
	console.log(item_qnano);
// 	(this).
	var data	 =[];
	var data2 = [];
	
	


	//----------------------------------------
})
	


</script>
