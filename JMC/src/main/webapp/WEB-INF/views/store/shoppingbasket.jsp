<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
$(function() {

	$("#bknolist").click(function() {
		

		})
	
})
</script>
<script type="text/javascript">
function deletingBook(bookname){
	var sbItemcount = 
	
    }

</script>
<script type="text/javascript">

$(function(){
	
	
// 	$("#bkupdateBtn").click(function() {
// 		let myform = document.getElementById('testForm');
// 		formData = new FormData(myform);
// 		basketno = formData.get('basketno');
// 		sbItemCount = formData.get('sbItemcount');
// // 		basketno = $("#bkupdate").val();
// 		console.log(basketno);
// 		console.log(sbItemCount);
// 		$.ajax({
// 			type: "post"
// 			, url: "./shoppingBasketList"
// 			, data:  {basketno : basketno, sbItemCount: sbItemCount}
// 			, dataType: "html" 
// 			, success: function( res ) {
// 				console.log("AJAX 성공")
// 				$("#result").html(res)
				
// 			}
// 			, error: function() {
// 				console.log("AJAX 실패")
// 			}
// 		})
// 	})
	
	

	$('#commentbtn').on('click', function(){
    	//값들의 갯수 -> 배열 길이를 지정
		var grpl = $("input[name=bkno]").length;
		//배열 생성
		var grparr = new Array(grpl);
		//배열에 값 주입
		for(var i=0; i<grpl; i++){                          
			grparr[i] = $("input[name=bkno]").eq(i).val();
	        alert(grparr[i]);
	    }
	});
});
</script>

</head>
<body>
<h1>장바구니</h1>
<hr>

<div id="result">
<form method="post" action="./shoppingbasket">
<input type="hidden" value="256" name="userno">

<button>장바구니 보기</button>
</form>

<form method="post" action="/payment/main">
<table class="table table table-hover">
<tr class="table-secondary">
	<th>인덱스</th>
	<th>상품이름</th>
	<th>갯수</th>
	<th>가격</th>
	<th>관리</th>
</tr>	
<c:forEach var="list" items="${list }" varStatus="status" >
<input type="hidden" value="${list.BASKETNO }" id="bkno" name="basketno">
<tr>
	<th><c:out value="${status.index}" /></th> 
	<th>${list.ITEM_TITLE }</th>
	<th>
		<input type="text" value="${list.SB_ITEM_COUNT }" name="sbItemcount">
		<input type="hidden" value="${list.BASKETNO }" name="basketno">${list.SB_ITEM_COUNT }
		<button type="button" class="btn btn-secondary" id="bkupdateBtn">수정</button>
	</th>
	<th>${list.ITEM_PRICE * list.SB_ITEM_COUNT }</th>
	<th><button type="button" class="btn btn-secondary" id ="deletebtn" onClick="window.location.reload()">삭제</button></th>
</tr>
</c:forEach> 
</table>

<button id="commentbtn">결제하기</button>
<!-- <button value="bkno" name="bknolist" id="bknolist">결제하기</button> -->
</form>
</div>
</body>
</html>