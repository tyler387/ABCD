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

<style>
#allAnswerRevisePage{
	
    width: 1000px;
    margin: 15px auto;
}


</style>

<c:import url="../../main.jsp"/>

<div id="allAnswerRevisePage">

	<div id="Alltitle"
		style="text-align: center; padding-top: 10px; padding-bottom: 10px;">
		<h1 class="innerTitle">Q&A 답변수정</h1>
	</div>

	<div id="questionDetail">
		<table class="table table-bordered">
			<tr>
				<th class="table-info">문의 번호</th>
				<td>${itemQnAQADetail.itemQnAQ.ITEM_QNANO}</td>
				<th class="table-info">문의 작성일</th>
				<td>${itemQnAQADetail.itemQnAQ.WRITE_DATE}</td>
			</tr>
			<tr>
				<th class="table-info">문의자 아이디</th>
				<td>${itemQnAQADetail.itemQnAQ.USER_ID}</td>
				<th class="table-info">문의자 이름</th>
				<td>${itemQnAQADetail.itemQnAQ.USER_NAME}</td>
			</tr>
			<tr>
				<th class="table-info">문의 상품명</th>
				<td colspan="3">${itemQnAQADetail.itemQnAQ.ITEM_TITLE}</td>
			</tr>
			<tr>
				<th class="table-info">문의 제목</th>
				<td colspan="3">${itemQnAQADetail.itemQnAQ.IQ_TITLE}</td>
			</tr>
			<tr>
				<th class="table-info" colspan="4">문의 내용</th>

			</tr>
			<tr>
				<td class="content" colspan="4"><div>${itemQnAQADetail.itemQnAQ.IQ_CONTENT}</div></td>
			</tr>
		</table>
	</div>

	<hr>

	<div id="answerForm">
		<form action="./update" method="post">
			<input type="hidden" name="mgrItemno"
				value="${itemQnAQADetail.itemQnAA.MGR_ITEMNO}">  
			<input type="hidden"
				name="curPage" value="${curPage}">

			<div class="input-group mb-3" style="">
				<label class="input-group-text">답변 내용</label>
				<textarea id="iaContent" name="iaContent" placeholder="답변을 작성하시오"
					class="form-control">${itemQnAQADetail.itemQnAA.IA_CONTENT}</textarea>
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