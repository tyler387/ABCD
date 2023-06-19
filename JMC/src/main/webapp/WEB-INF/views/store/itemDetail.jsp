<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<c:import url="../layout/header.jsp" />
<style type="text/css">
.container {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: center;
	align-items: stretch;
	flex-direction:row
}

#title{
	 font-size: 24px;
	 text-align: center;
	 margin-bottom:18px;
}

#price{
 	font-size: 18px;
 	margin-bottom: 100px;
 		display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: center;
	align-items: stretch;
	flex-direction:row
 	
}

.itemright{
	padding: 20px;
	margin-left: 100px;
	
}

.input-group{
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	align-items: stretch;
	flex-direction:row

	
}

#itemDetail{
	padding-left: 450px;
}

#qanBoard{
	padding-left: 450px
}

</style>



<body>
<h1>아이템 상세페이지</h1>

<div class="container">
	<div class="itemleft"><img src='/itemfile/${allItemDetail.itemFileDetailList[0].iStoredName}/' width="450px" height="450px" ></div>
	<div class="itemright">
		<div id="title"><b>${allItemDetail.itemDetail.itemTitle }</b></div>



			  <div><label for="lang">구매 옵션을 선택해 주세요</label></div>
				  <select name="option" id="option" >
				    <option value="${allItemDetail.itemDetail.itemPrice}" id="test" data-optionno='0'>${allItemDetail.itemDetail.itemTitle}</option>
				   	<c:forEach var="option2" items="${allItemDetail.itemOptionDetailList }">
				   	<option value="${allItemDetail.itemDetail.itemPrice+option2.extraCharge}" class="addOption" data-optionno='${option2.itemOptionno}'>${allItemDetail.itemDetail.itemTitle}+${option2.optionContent}</option>
					</c:forEach>
				  </select>
				<input type="submit" value="선택" id="click3" />

			
			<form id="sender">
			<div id="result">
				
				
			</div>

<!-- 			없다가 선택 버튼 클릭시 생기도록 해야 함 -->
			<div id="price">총 합계 :<span id="totalPrice">0</span></div>
			<hr>
			<input type="hidden" name="itemno" value="${allItemDetail.itemDetail.itemno}" readonly="readonly">
			<button id="btnBasket">장바구니 담기</button>
			<button id="btnBuyNow">바로구매 하기</button>
			</form>
		</div>
</div>
<hr>
<div id="itemDetail">
${allItemDetail.itemDetail.itemContent }

<h1>QnA</h1>

</div>
<div id="storeboard">
<c:import url="../store/storeBoard.jsp" />
</div>
<c:import url="../layout/footer.jsp" />



<script type="text/javascript">

	
var plus = "plus"
$(function() {
	

	$("#click3").click(function(){
		
		console.log("클릭클릭")
		console.log($("#option").val())
		var option2 = $("#option").val()
		var testtt = $("#option").html()
		var testtt2 = $("#option").html()
		console.log("무엇?",testtt2)
		if( option == '${allItemDetail.itemDetail.itemTitle }"'){
			testtt = 0
			console.log("Tetetet"+testtt)
		}		
		var total = "${allItemDetail.itemDetail.itemPrice}"
		
		total = total + testtt
		
// 		$("#result").html(option)
		$("#result").append(
			"<div>" + $("#option :selected").html() + "</div>"+
				"<input type='hidden' name='itemOptionno' value='"+$("#option :selected").attr("data-Optionno")+"' readonly='readonly'>"
		)
		$("#result").append(
				"<div class='price'>"
			+		"<b data-perPrice="+$("#option :selected").val()+">"
			+		$("#option :selected").val()
			+ 		"</b>원"
			+		"<div class='input-group' style='margin-left: auto;'>"
			+			"<input type='button' class='btnCount' value='-'/>"
			+			"<div class='resultNum'>1</div>"
			+			"<input type='button' class='btnCount'  value='+'/>"
			+		"</div>"	
			+		"<input type='hidden' name='sbItemCount' value='1' readonly='readonly'>"
			+	"</div>"	
		)
		
		var totalPrice = 0;
		for (var i = 0; i < $(".price").children('b').length; i++) {
			totalPrice += Number($(".price").children('b')[i].innerHTML)
		}
		$("#totalPrice").html(totalPrice)
		
	})
	<!-- 가격 + 수량 관련 -->

	
	
	$("#result").on("click", ".btnCount", function() {
		
			console.log("click됐나요?")
		
		if ($(this).val() == "+") {
			var count1 = $(this).parent().children("div").text();
			
			const perPrice = $(this).parent().parent().children('b').attr("data-perPrice")
			
		 
			console.log("뭐죠?", count1)
			console.log("뭐죠?1", $(this).parent().children("div").attr("data-perPrice"))
			console.log("각 가격 ", perPrice)
			count1++
			
			//각 상품의 갯수가 추가될때마다 count와의 곱으로 각 옵션마다의 총 합을 계산함
			console.log("추가됐나요?",perPrice*count1)
			var optionTotalPrice = perPrice*count1
			$(this).parent().children("div").text(count1);
			$(this).parent().parent().children('b').text(optionTotalPrice);
			$(this).parent().parent().children('input').val(count1);
			
		}
		
		if ($(this).val() == "-") {
			var count2 = $(this).parent().children("div").text();
			const perPrice = $(this).parent().parent().children('b').attr("data-perPrice")
			
			console.log("뭐죠3?", count2)
			
			if (count2 != '1') {
			console.log("뭐죠4?", count2)
				count2--
			}
			
			var optionTotalPrice = perPrice*count2
			
			$(this).parent().children("div").text(count2);
			$(this).parent().parent().children('b').text(optionTotalPrice);
			$(this).parent().parent().children('input').val(count2);
		}
		
		var totalPrice = 0;
		for (var i = 0; i < $(".price").children('b').length; i++) {
			totalPrice += Number($(".price").children('b')[i].innerHTML)
		}
		$("#totalPrice").html(totalPrice)
	})
	
	$("#btnBasket").click(function() {
		$("#sender").submit(function() {
			$("#sender").attr("action","./write/basket")
			$("#sender").attr("method","post")
		})
	})
	$("#btnBuyNow").click(function() {
		$("#sender").submit(function() {
			$("#sender").attr("action","./buynow")
			$("#sender").attr("method","get")
		})
	})


})
function count(type)  {
	console.log("오냐오냐오냐오냐");
	  // 결과를 표시할 element
	  const resultElement = $(".resultNum").html();
	  
	  // 현재 화면에 표시된 값
	  let number = resultElement.innerText;
	  number = parseInt(number)
	  // 더하기/빼기
	  if(type === 'plus') {
	    number = number + 1;
	  }else if(type === 'minus')  {
	    number = number - 1;
	  }
	  
	  // 결과 출력
	  resultElement.innerText = number;
	}
</script>