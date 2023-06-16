<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <!-- 결제위젯 SDK 추가 -->
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
</head>
<body>
  <!-- 결제위젯, 이용약관 영역 -->
  <div id="payment-method"></div>
  <div id="agreement"></div>
  <!-- 결제하기 버튼 -->
  <button id="payment-button">결제하기</button>
  <script>
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
    paymentWidget.renderPaymentMethods("#payment-method", { value: 101 })
	paymentWidget.renderPaymentMethods("")
    
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
//         successUrl: "http://localhost:8888/payment/abc?val="+'abc'"&bbb="+'bbb',  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        successUrl: "http://localhost:8888/payment/abc?val="+'abc'+"&bbb="+'bbb',  // 결제에 성공하면 이동하는 페이지(직접 만들어주세요)
        failUrl: "http://localhost:8888/payment/fail",        // 결제에 실패하면 이동하는 페이지(직접 만들어주세요)
        customerEmail: "skfkqhd@gmail.com",
        customerName: "함석봉",
      })
    })
  </script>
  
  <input type="hidden" value="abcd">
</body>
