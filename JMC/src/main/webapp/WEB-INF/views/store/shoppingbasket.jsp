<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<c:import url="../layout/header.jsp"/>
<c:import url="../layout/mypageAside.jsp" />
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<style type="text/css">


label{
	vertical-align: middle;
}

.mname {
	width: 400px;
}

.postcode {
	width: 295px;

}

.post {
	width: 400px;


}
b {
	display: block;
}

input {
	height: 30px;
	border: 1px solid black;
	border-radius: 10px;
	background-color: white;
}

textarea{
	border-radius: 10px;

}

.meeting-join {
	margin-bottom: 50px;
}

.meeting-pre {
	margin-bottom: 10px;
}

.meeting-pre1 {
	margin-bottom: 10px;
}

.meeting {
	width: 600px;
	margin: 0 auto;
	font-family: '양진체';
}

.meetingform {
	width: 1000px;
    margin: auto;
	border-radius: 20px;
	box-shadow: 0 2px 12px 0 rgb(100 100 100/ 16%), 0 2px 17px 0
		rgb(200 200 200/ 20%);
	padding: 20px;
	margin-bottom: 50px;
	text-align: center;
	background-color: beige;
}

.meetingpre {
	border-radius: 20px;
	box-shadow: 0 2px 12px 0 rgb(100 100 100/ 16%), 0 2px 17px 0
		rgb(200 200 200/ 20%);
	margin-bottom: 50px;
	text-align: center;
	padding: 20px;
	background-color: beige;
}

.paymentBtn {
	height: 50px;
	width: 300px;
	border-radius: 20px;
	background: orange;
	color: #fff;
	border: none;
	font-size: 20px;
	font-family: '양진체';
}
.bsketbtn {
	height: 25px;
	width: 73px;
	border-radius: 10px;
	background: orange;
	color: #fff;
	border: none;
	font-size: 15px;
	font-family: '양진체';
}

.btndiv {
	text-align: center;
	margin-bottom: 100px;
}

h1 {
	text-align: center;
}

.meetingbtn:hover {
	background-color: #ffcca8;
}

.meeting-loc {

	margin-bottom : 10px;
}

.post[id~='sample']{
width: 295px;
}

table.txc-table {

width: 977px;
table-layout: fixed;
border : 1px solid black;
} 

table thead tr {

width: 100%;
}
</style>
<script type="text/javascript">

$(function(){
var userno = ${userno }
 
var price = 3000;
 
	$(function() {
  		<c:forEach var='i' items='${list}'>
//   		price += ${i.ITEM_PRICE * i.SB_ITEM_COUNT}
		<c:if test="${i.ITEM_OPTION.OPTION_CONTENT ne null }">price += ${(i.ITEM_PRICE + i.ITEM_OPTION.EXTRA_CHARGE) * i.SB_ITEM_COUNT}</c:if>
		<c:if test="${i.ITEM_OPTION.OPTION_CONTENT eq null }">price += ${i.ITEM_PRICE * i.SB_ITEM_COUNT}</c:if>
  		</c:forEach>
  	  	console.log("가격", price);
  		$("#totalPrice").html(price)
	  	})
	
	$(".sbItemCount").blur(function () {
		
		console.log("이건뭘까: ", $(this))

		$(this).siblings(".bkupdateBtn").attr("data-sbItemcount", $(this).val())
		
	})
	
	$(document).on("click",  ".bkupdateBtn", function() {
// 	$(".bkupdateBtn").click(function() {
		var basketno = $(this).attr("data-basketno");
		var sbItemCount = $(this).attr("data-sbItemcount");
		
		console.log("범인1:", basketno)
		console.log("범인2:", sbItemCount)
		
		$.ajax({
			type: "post"
			, url: "./shoppingBasketList"
			, data:  {basketno : basketno, sbItemCount: sbItemCount, userno : userno}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공")
				location.reload();
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	})
	
	
	$(document).on("click",  ".bkDeleteBtn", function() {
		var basketno = $(this).attr("data-basketno");
		var sbItemCount = $(this).attr("data-sbItemcount");
		
		console.log("범인1:", basketno)
		console.log("범인2:", sbItemCount)
		
		$.ajax({
			type: "post"
			, url: "./shoppingBasketDelete"
			, data:  {basketno : basketno, sbItemCount: sbItemCount, userno : userno}
			, dataType: "html" 
			, success: function( res ) {
				console.log("AJAX 성공")
				location.reload();
				
			}
			, error: function() {
				console.log("AJAX 실패")
			}
		})
	})
	
	

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
</div>
    <div class="right">
<h1>장바구니</h1>
<hr>
<div style="height: 30px;"></div>
<div class="meetingform">
<div id="result">
<form method="post" action="/payment/main">
<table class="table table table-hover txc-table" style="margin: auto;">
<tr class="table-secondary">
	<th>상품번호</th>
	<th>상품이름</th>
	<th>상품옵션</th>
	<th>상품사진</th>
	<th style="width: 150px;">갯수</th>
	<th>가격</th>
	<th>관리</th>
</tr>	
<c:forEach var="list" items="${list}" varStatus="status" >
<tr>
	<th class="cart_info_td">
	<input type="checkbox" name="cartArr" value="${list.BASKETNO }" data-cartNo="${list.BASKETNO }" checked>
	</th> 
	<th>${list.ITEM_TITLE }</th>	 
	<th><c:if test="${list.ITEM_OPTION.OPTION_CONTENT ne null }">${list.ITEM_OPTION.OPTION_CONTENT }</c:if>
	<c:if test="${list.ITEM_OPTION.OPTION_CONTENT eq null }"> 없음 </c:if></th>	 
	<th><img id="material" src="/itemfile/${list.I_STORED_NAME }/" width="85px" height="85px">
	</th>	  
	<th>
		<input type="text" value="${list.SB_ITEM_COUNT}" name="sbItemCount" class="sbItemCount" style="width: 35px;">
		<input type="hidden" value="${list.BASKETNO }" name="basketno" class="basketno" >
		<button type="button" class="btn btn-secondary bkupdateBtn bsketbtn"  data-sbItemCount="${list.SB_ITEM_COUNT}" data-basketno="${list.BASKETNO}">수량 수정</button>
	</th>
	<th class="perPrice">
	<c:if test="${list.ITEM_OPTION.OPTION_CONTENT ne null }">${(list.ITEM_PRICE + list.ITEM_OPTION.EXTRA_CHARGE) * list.SB_ITEM_COUNT}</c:if>
	<c:if test="${list.ITEM_OPTION.OPTION_CONTENT eq null }">${list.ITEM_PRICE * list.SB_ITEM_COUNT}</c:if>
	</th> 
	<th><button type="button" class="btn btn-secondary bkDeleteBtn bsketbtn" data-sbItemCount="${list.SB_ITEM_COUNT}" data-basketno="${list.BASKETNO}">상품 삭제</button></th>
</tr>
</c:forEach> 
<tr>
	<th></th>
	<th></th>
	<th></th> 
	<th></th> 
	<th colspan="3">배송비 3000원 + 총 금액 :<span id="totalPrice">0</span></th>
</tr> 
</table>
<br><br>
<button id="btnOrder" class ="paymentBtn"style="width: 200px; margin: auto;" type="button">선택 결제하기</button>
<!-- <button id="btnOrderAll" type="button">전체 결제하기</button> -->
<!-- <button value="bkno" name="bknolist" id="bknolist">결제하기</button> -->
</form>
</div>
</div>
</div>
</div>
<script type="text/javascript">
$(function() {
	   
	   //선택 주문
	   $("#btnOrder").click(function() {
	      console.log("선택주문 선택")
	      
	      var totalArr = $("input[name=cartArr]").length
	      var checked = $("input[name=cartArr]:checked").length

	      if(checked == 0) {
	         console.log("선택된 상품이 없습니다.")
	         alert("선택된 상품이 없습니다.")
	         return false;
	      } else {
	         
	         if(totalArr == checked) {
	            console.log("선택주문에서 전체주문으로 넘어감")
	            var chkArr = new Array();
	            $("input[name=cartArr]:checked").each(function() {
	               chkArr.push($(this).attr("data-cartNo"))
	            })
	            
	            console.log(chkArr)
	            location.href="/payment/main?basketno=" + chkArr;
	           //선택 항목이 전체가 아니라면   
	         } 
	         if(totalArr != checked) {
	            console.log("선택주문으로 넘어감")
	            
	            var chkArr = new Array();
	            
	            $("input[name=cartArr]:checked").each(function() {
	               chkArr.push($(this).attr("data-cartNo"))
	            })
	             
	            console.log(chkArr)
	            location.href="/payment/main?basketno=" + chkArr;
	         }
	      }
	   })
	   
})
</script>
<c:import url="../layout/footer.jsp" />
