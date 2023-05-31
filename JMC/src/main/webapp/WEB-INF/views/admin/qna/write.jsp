<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#btnCalcel").click(function() {
		history.go(-1)
	})
	
})


</script>
</head>
<body>

<div id="questionDetail">
<table>
<tr>
<th>문의 번호<th>
<td>${qnAQDetail.QUESTIONNO}</td>
</tr>
<tr>
<th>문의 회원<th>
<td>${qnAQDetail.USERID}</td>
</tr>
<tr>
<th>문의 제목<th>
<td>${qnAQDetail.QTITLE}</td>
</tr>
<tr>
<th>문의 내용<th>
<td>${qnAQDetail.QCONTENT}</td>
</tr>
<tr>
<th>문의 작성일<th>
<td>${qnAQDetail.WRITEDATE}</td>
</tr>
</table>
</div>

<hr>

<div id="answerForm">
<form action="./write" method="post">
<input type="hidden" name="questionno" value="${qnAQDetail.QUESTIONNO}">
<input type="hidden" name="curPage" value="${curPage}">
<label for="">답변 내용</label>
<textarea name="aContent" placeholder="답변을 작성하시오"></textarea><br><br>
<button>답변등록</button>
<button type="button" id="btnCalcel">취소</button>
</form>
</div>

</body>
</html>