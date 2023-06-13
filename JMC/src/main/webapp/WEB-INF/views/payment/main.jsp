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
	  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
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
<input type="hidden" value="함석봉"  id="name">
<input type="hidden" value="abcd" id="name2">
아이디 : 나나나
이름 : 함석봉
번호 : 01054906413<br>
주문 목록 : 
1<input type="hidden" value="item1" id="item1"><br>
2<input type="hidden" value="item2" id="item2"><br>
3<input type="hidden" value="10000" id="item3"><br>
4<input type="hidden" value="item4" id="item4"><br>
총 주문액 : 

${sbList } 
  <!-- 결제위젯, 이용약관 영역 -->
  <div id="payment-method"></div>
  <div id="agreement"></div>
  <!-- 결제하기 버튼 -->
  <button id="payment-button">결제하기</button>
  <script> 

  	var name = $("#name").val(); 
  	var name2 = $("#name2").val();
  	var price = $("#item3").val();
  	console.log("네임", name);
  	console.log("네임2", name2);
  	console.log("가격", price);
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
    paymentWidget.renderPaymentMethods("#payment-method", { value: price })

    // ------  이용약관 렌더링 ------
    // 이용약관이 렌더링될 DOM 요소를 지정하는 CSS 선택자를 넣어주세요.
    // https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자
    paymentWidget.renderAgreement('#agreement')
    // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
    // 더 많은 결제 정보 파라미터는 결제위젯 SDK에서 확인하세요.
    // https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
    button.addEventListener("click", function () {
      paymentWidget.requestPayment({
        orderId:  'JMC'+ new Date().getTime(),            // 주문 ID(직접 만들어주세요)
        orderName: "토스 티셔츠 외 2건",                 // 주문명
        // 주문명 추후에 추가해야함
//         successUrl: "http://localhost:8888/payment/success",  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        successUrl: "http://localhost:8888/payment/abc",  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        failUrl: "http://localhost:8888/payment/fail",        // 결제에 실패하면 이동하는 페이지(직접 만들어주세요)
        customerEmail: "skfkqhd@gmail.com",
        customerName: "함석봉"
      })
    })
  </script>

<!-- <div id ="tossstart"> -->
<!-- </div> -->

</body>
</html>