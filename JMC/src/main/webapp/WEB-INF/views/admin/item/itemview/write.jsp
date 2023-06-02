<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="../../main.jsp"/>


<script>
$(function() {
	
	$("#btnOption").click(function() {
		console.log("Option Add Button Click Event Occured"")
		
		$("#addedOption").append("<>")
		
	})
	
	
	
})
</script>

<div id="itemWriteForm">
<form action="write" method="post" enctype="mutipart/form-data">

<a><h1>판매 상품 신규 등록</h1></a>



<span>상품 기본 정보</span>
<div id="itemWriteInput">

<label>상품명</label>
<input type="text" id="itemTitle" name="itemTitle"><br>

<hr>

<label>가격 입력</label>
<input type="text" id="itemPrice" name="itemPrice"><br>
<hr>

<div>
<label>상품 옵션 추가</label>
<!--  -->
<img id="btnOption" alt="optionAddIcon" src="/resources/image/optionAddIcon.png" style="width:15px">
<div id="addedOption">

</div>
</div>

<hr>
<label>상품 내용 입력</label>
<textarea id="itemContent" name="itemContent"></textarea><br>
<hr>
<button>상품 등록</button>
</div>

</form>
</div>

<!-- <div class="아이콘 저작권"> -->
<!-- <a href="https://www.flaticon.com/kr/free-icons/-" title="...을 더한 아이콘">...을 더한 아이콘  제작자: kliwir art - Flaticon</a> -->
<!-- <a href="https://www.flaticon.com/kr/free-icons/" title="실패한 아이콘">실패한 아이콘  제작자: rizky maulidhani - Flaticon</a> -->
<!-- </div> -->

</div>
</div>
</body>
</html>