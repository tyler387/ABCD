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

<div id="Alltitle" style="text-align: center; padding-top: 10px;">
	<h1 class="innerTitle">Q&A 글수정</h1>
</div>

<div id="questionDetail">
	<table class="table table-bordered">
		<tr>
			<th class="table-info text-center">문의 번호</th>
			<td>${qnAQADetail.get("qnAQDetail").get("QUESTIONNO")}</td>
			<th class="table-info text-center">문의 작성일</th>
			<td>${qnAQADetail.get("qnAQDetail").get("WRITEDATE")}</td>
		</tr>
		<tr>
			<th class="table-info text-center">문의 회원</th>
			<td colspan="3">${qnAQADetail.get("qnAQDetail").get("USERID")}</td>
		</tr>
		<tr>
			<th class="table-info text-center">문의 제목</th>
			<td colspan="3">${qnAQADetail.get("qnAQDetail").get("QTITLE")}</td>
		</tr>
		<tr>
			<th class="table-info text-center" colspan="4">문의 내용</th>
		</tr>
		<tr>
			<td colspan="4">${qnAQADetail.get("qnAQDetail").get("QCONTENT")}</td>
		</tr>
		<tr>

		</tr>
	</table>
</div>

<hr>

<div id="answerForm" class="input-group">
<form action="./update" method="post">
<input type="hidden" name="answerno" value='${qnAQADetail.get("qnAADetail").ANSWERNO}'>
<input type="hidden" name="curPage" value='${curPage}'>
<div class="row">
<div class="input-group mb-3 ms-auto d-block">
<label for="" class="input-group-text w-100">답변 내용</label>
<textarea name="aContent" placeholder="답변을 작성하시오" class="form-control w-100">${qnAQADetail.get("qnAADetail").ACONTENT}</textarea>
</div>
</div>
<button class="btn btn-secondary ">답변수정</button>
<button type="button" id="btnCalcel" class="btn btn-secondary">취소</button>
</form>
</div>

</div>
</div>
</div>
</body>
</html>