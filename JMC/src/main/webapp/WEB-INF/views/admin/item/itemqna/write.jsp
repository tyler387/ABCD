<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#btnCalcel").click(function() {
		history.go(-1)
	})
	
})


</script>

<style type="text/css">
#allAnswerPage{
	
    width: 1000px;
    margin: 15px auto;
}

td.content div{
	min-height: 200px;
}

#aContent{
	min-height: 200px;
	resize: none;
}	
</style>

<c:import url="../../main.jsp"/>

<div id="allAnswerPage">

<div id="Alltitle" style="text-align: center; padding-top:10px; padding-bottom: 10px;">
	<h1 class="innerTitle">Q&A 답변등록</h1>
</div>

<div id="questionDetail">
<table class="table table-bordered">
			<tr>
				<th class="table-info">문의 번호</th>
				<td>${qnAQDetail.ITEM_QNANO}</td>
				<th class="table-info">문의 작성일</th>
				<td>${qnAQDetail.WRITE_DATE}</td>
			</tr>
			<tr>
				<th class="table-info">문의자 아이디</th>
				<td >${qnAQDetail.USER_ID}</td>
				<th class="table-info">문의자 이름</th>
				<td >${qnAQDetail.USER_NAME}</td>
			</tr>
			<tr>
				<th class="table-info">문의 상품명</th>
				<td colspan="3">${qnAQDetail.ITEM_TITLE}</td>
			</tr>
			<tr>
				<th class="table-info">문의 제목</th>
				<td colspan="3">${qnAQDetail.IQ_TITLE}</td>
			</tr>
			<tr>
				<th class="table-info" colspan="4">문의 내용</th>
				
			</tr>
			<tr>
				<td class="content" colspan="4"><div>${qnAQDetail.IQ_CONTENT}</div></td>
			</tr>
		</table>
</div>

<hr>

<div id="answerForm">
<form action="./write" method="post">
<input type="hidden" name="itemQnano" value="${qnAQDetail.ITEM_QNANO}">
<input type="hidden" name="curPage" value="${curPage}">
<div class="input-group mb-3" style="">
<label class="input-group-text">답변 내용</label>
<textarea id="iaContent" name="iaContent" placeholder="답변을 작성하시오" class="form-control"></textarea>
</div>
<button class="btn btn-secondary">답변등록</button>
<button type="button" id="btnCalcel" class="btn btn-secondary">취소</button>
</form>
</div>

</div>
</div>
</div>
</body>
</html>