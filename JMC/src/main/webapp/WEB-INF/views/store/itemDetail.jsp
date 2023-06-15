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



			<form action="#">
			  <div><label for="lang">구매 옵션을 선택해 주세요</label></div>
				  <select name="option" id="option" >
				    <option value="${allItemDetail.itemDetail.itemPrice}" id="test">${allItemDetail.itemDetail.itemTitle}</option>
				   	<c:forEach var="option2" items="${allItemDetail.itemOptionDetailList }">
				   	<option value="${allItemDetail.itemDetail.itemPrice+option2.extraCharge}" class="addOption">${allItemDetail.itemDetail.itemTitle}+${option2.optionContent}</option>
					</c:forEach>
				  </select>
			</form>
				<input type="submit" value="선택" id="click3" />

			<div id="result">
				
				
			</div>
<!-- 			없다가 선택 버튼 클릭시 생기도록 해야 함 -->
			<div id="price">총 합계 : </div>
			<hr>
			<button>장바구니 담기</button>
			<button>바로구매 하기</button>
		</div>
</div>
<hr>
<div id="itemDetail">
${allItemDetail.itemDetail.itemContent }

<h1>QnA</h1>

</div>
<c:import url="../store/storeBoard.jsp" />

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
			"<div>" + $("#option :selected").html() + "</div>"		
		)
		$("#result").append(
			"<div id='price'>"
			+	"<b>"
			+	$("#option :selected").val()
			+ 	"</b>원"
			+	"<div class='input-group' style='margin-left: auto;'>"
			+	"<input type='button' class='btnCount' value='-'/>"
			+	"<div class='resultNum'>1</div>"
			+	"<input type='button' class='btnCount'  value='+'/>"
			+	"</div>"
			+	"</div>"
			+	"</div>"					
			)
		
	})
	<!-- 가격 + 수량 관련 -->

	
	$("#result").on("click", ".btnCount", function() {
		
			console.log("click됐나요?")
		
		if ($(this).val() == "+") {
			var count1 = $(this).parent().children("div").text();
		
			console.log("뭐죠?", count1)
			console.log("뭐죠?1", $(this).parent().children("div").text())
			count1++
			
			$(this).parent().children("div").text(count1);
		}
		
		if ($(this).val() == "-") {
			let count2 = $(this).parent().children("div").text();
			
			console.log("뭐죠3?", count2)
			
			if (count2 != '1') {
			console.log("뭐죠4?", count2)
				count2--
			}
			
			$(this).parent().children("div").text(count2);
		}
		
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