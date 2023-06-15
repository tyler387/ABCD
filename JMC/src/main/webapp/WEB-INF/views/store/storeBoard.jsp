<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style>
  #qanBoard{
  
	padding-left: 450px
}
</style>
<body>
<div id="qnaBoard">
<table>
<thead>
	<tr>
		<th style="width: 20%;">답변상태</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 20%;">작성자</th>
		<th style="width: 15%;">작성일</th>
	</tr>
</thead>
</table>
<!-- 	 <input type="button" value="문의하기" onclick="showPopup();" /> -->
	<div class= "reportbtn">
		<c:import url="../store/boardWrite2.jsp" />
	</div>

</div>

