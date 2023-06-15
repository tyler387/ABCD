<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<c:import url="../layout/header.jsp"/>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
	  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	  	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
// $(function() {
// 	$("#toss").click(function() {
			
// 		$.ajax({
// 			type: "get"
// 			, url: "./tossstart"
// 			, data:  {}
// 			, dataType: "html" 
// 			, success: function( res ) {
// 				console.log("AJAX 성공")
// 				$("#tossstart").html(res)
// 				filter = $("#filter").val();
// 			}
// 			, error: function() {
// 				console.log("AJAX 실패")
// 			}
// 		})
// 	})
// }) 
</script>
</head>
<body>
<table class="table table table-hover" style="width: 1200px; margin: 0 auto;">
<tr class="table-secondary">
	<th>상품번호</th>
	<th>상품이름</th>
	<th>갯수</th>
	<th>가격</th>
</tr>	
<c:forEach var="list" items="${sbList}" varStatus="status" >
<tr>
	<th class="cart_info_td">${status.count}</th> 
	<th>${list.ITEM_TITLE}</th>	
	<th>${list.SB_ITEM_COUNT}</th>
	<th class="perPrice">${list.ITEM_PRICE * list.SB_ITEM_COUNT}</th>
</tr>
</c:forEach>
<tr>
	<th></th>
	<th></th>
	<th></th>
	<th>총 금액 :<span id="totalPrice">0</span></th>
</tr>
</table>

<input type="hidden" id="basketno" name="basketno" value="${basketno }">

<div style ="width: 600px; margin: 0 auto; padding-top : 80px; ">
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">이름</span>
	  <input type="text" class="form-control" value="" aria-label="userNick" aria-describedby="basic-addon1" id="name" name="name" onchange='printName()'>
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">핸드폰 번호</span>
	  <input type="text" class="form-control" value="" aria-label="phone" aria-describedby="basic-addon1" id="phone" name="phone" onchange='printPhone()'>
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">우편번호</span>
	<input type="text" class="form-control" value="" aria-label="userNick" aria-describedby="basic-addon1" name="loc" id="sample6_postcode"  placeholder="우편번호" onchange='printLoc()'>
	  <span class="input-group-text" id="basic-addon1">참고항목</span>
	<input type="text" class="form-control" value="" aria-label="phone" aria-describedby="basic-addon1" name="loc3" id="sample6_extraAddress" placeholder="참고항목" onchange='printLoc3()'><br><br>
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">도로명주소</span>
	<input type="text" class="form-control" value="" aria-label="userNick" aria-describedby="basic-addon1" name="loc1" id="sample6_address" placeholder="도로명주소" onchange='printLoc1()' style="width: 170px;"><br>
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">상세주소</span>
	<input type="text" class="form-control" value="" aria-label="phone" aria-describedby="basic-addon1"  name="loc2" id="sample6_detailAddress" placeholder="상세주소" onchange='printLoc2()'>
	</div>
	
</div>
  <!-- 결제위젯, 이용약관 영역 -->
  <div id="payment-method" style="width: 800px; margin: auto;"></div>
  <div id="agreement" style="width: 800px; margin: auto;"></div>
  <!-- 결제하기 버튼 -->
  <div id="agreement" style="width: 100px; margin: auto;"><button id="payment-button" style="width: 100px; margin: auto;">결제하기</button></div>
  
  
  <script type="text/javascript"> 
  	var name = null; 
  	var phone = null;
  	var loc = null;
  	var loc1 = null;
  	var loc2 = null;
  	var loc3 = null;
  	var price = 0;
    
  	$(function() {
  		<c:forEach var='i' items='${sbList}'>
  		price += ${i.ITEM_PRICE * i.SB_ITEM_COUNT}
  		</c:forEach>
  	  	console.log("가격", price);
  		$("#totalPrice").html(price)
   		 paymentWidget.renderPaymentMethods("#payment-method", price)
  	})
  	
  	
  	function sample6_execDaumPostcode() {
  	    new daum.Postcode({
  	        oncomplete: function(data) {
  	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

  	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
  	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
  	            var addr = ''; // 주소 변수
  	            var extraAddr = ''; // 참고항목 변수

  	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
  	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
  	                addr = data.roadAddress;
  	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
  	                addr = data.jibunAddress;
  	            }

  	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
  	            if(data.userSelectedType === 'R'){
  	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
  	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
  	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
  	                    extraAddr += data.bname;
  	                }
  	                // 건물명이 있고, 공동주택일 경우 추가한다.
  	                if(data.buildingName !== '' && data.apartment === 'Y'){
  	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
  	                }
  	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
  	                if(extraAddr !== ''){
  	                    extraAddr = ' (' + extraAddr + ')';
  	                }
  	                // 조합된 참고항목을 해당 필드에 넣는다.
  	                document.getElementById("sample6_extraAddress").value = extraAddr;
  	              loc3 = document.getElementById('sample6_extraAddress').value;
  	            
  	            } else {
  	                document.getElementById("sample6_extraAddress").value = '';
  	            }

  	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
  	            document.getElementById('sample6_postcode').value = data.zonecode;
  	          	loc = document.getElementById('sample6_postcode').value;
  	            document.getElementById("sample6_address").value = addr;
  	          loc1 = document.getElementById('sample6_address').value;
  	            // 커서를 상세주소 필드로 이동한다.
  	            document.getElementById("sample6_detailAddress").focus();
  	        }
  	    }).open();
  	}
  	
  	
  	function printName()  {
  	  name = document.getElementById('name').value;
//   	document.getElementById('name').value = name;
  	console.log("네임", name);
  	}
  	 
  	function printPhone()  {
  		phone = document.getElementById('phone').value;
    	console.log("폰번호", phone);
    	}
//   	function printLoc()  {
//   		sample6_postcode = document.getElementById('sample6_postcode').value;
//     	console.log("우편번호", sample6_postcode);
//    	}
//   	function printLoc3()  {
//   		sample6_extraAddress = document.getElementById('sample6_extraAddress').value;
//   	console.log("참고항목", sample6_extraAddress);
//  	}  	
//   	function printLoc1() {
//   		sample6_address = document.getElementById('sample6_address').value;
//   	console.log("도로명주소", sample6_address);
//  	}
  	function printLoc2()  {
  		loc2 = document.getElementById('sample6_detailAddress').value;
  	console.log("상세주소", sample6_detailAddress);
 	}
  	
	const clientKey = 'test_ck_4vZnjEJeQVxpqRELbWqVPmOoBN0k'
    const customerKey = "rNodXBSE7vXPAX54LsEgx" // 내 상점의 고객을 식별하는 고유한 키
    // 커스텀키는 유저 번호가 들어가야함
    const button = document.getElementById("payment-button")

    // ------  결제위젯 초기화 ------ 
    // 비회원 결제에는 customerKey 대신 ANONYMOUS를 사용하세요.
    const paymentWidget = PaymentWidget(clientKey, customerKey) // 회원 결제
    // const paymentWidget = PaymentWidget(clientKey, PaymentWidget.ANONYMOUS) // 비회원 결제

    // ------  결제위젯 렌더링 ------ 
    // 결제위젯이 렌더링될 DOM 요소를 지정하는 CSS 선택자 및 결제 금액을 넣어주세요. 
    // https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션
//     paymentWidget.renderPaymentMethods("#payment-method", price)

    // ------  이용약관 렌더링 ------
    // 이용약관이 렌더링될 DOM 요소를 지정하는 CSS 선택자를 넣어주세요.
    // https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자
    paymentWidget.renderAgreement('#agreement')
    // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
    // 더 많은 결제 정보 파라미터는 결제위젯 SDK에서 확인하세요.
    // https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
    button.addEventListener("click", function () {
      paymentWidget.requestPayment({
        orderId:  'JMC'+ new Date().getTime(),           // 주문 ID(직접 만들어주세요)
        orderName: "토스 티셔츠 외 2건",                 // 주문명
        // 주문명 추후에 추가해야함
//         successUrl: "http://localhost:8888/payment/success",  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        successUrl: "http://localhost:8888/payment/paysuccess?name="+name
        			+"&phone="+phone
        			+"&loc="+loc
        			+"&loc1="+loc1
        			+"&loc2="+loc2
        			+"&loc3="+loc3
        			<c:forEach var='bn' items='${basketno}'>
						+"&basketno=${bn}"
					</c:forEach>
        			<c:forEach var='sl' items='${sbList}'>
						+"&itemTitle=${sl.ITEM_TITLE}"
					</c:forEach>
        			,  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        failUrl: "http://localhost:8888/payment/fail",        // 결제에 실패하면 이동하는 페이지(직접 만들어주세요)
        customerEmail: "skfkqhd@gmail.com",
        customerName: "함석봉"
      })
    })

  </script>
  

<c:import url="../layout/footer.jsp" />
<!-- <div id ="tossstart"> -->
<!-- </div> -->
