<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">
<head>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <script>
    const userCode = "imp65870667";
    IMP.init(userCode);
          
        var today = new Date();   
        var hours = today.getHours(); // 시
        var minutes = today.getMinutes();  // 분
        var seconds = today.getSeconds();  // 초
        var milliseconds = today.getMilliseconds();
        var makeMerchantUid = hours +  minutes + seconds + milliseconds;
         

        function requestPay() {
            IMP.request_pay({
                pg: "uplus",
                pay_method: "card",
                merchant_uid: '자만추_' + new Date().getTime(),
                name: "dddd",
                amount: 100,  // 추후 장바구니 값 구현해야함 
                buyer_tel: "01054906413",
                m_redirect_url: 'http://localhost:8888/payment/end'
//                 m_redirect_url: "http://localhost:8888/payment/end" // 안되는 이유 모르겠음 
            }, function (rsp) { // callback
                if (rsp.success) { 
                    console.log(rsp);
            		$.ajax({
        			type: "post"
        			, url: "./end"
        			, data:  {}
        			, dataType: "html" 
        			, success: function( res ) {
        				console.log("AJAX 성공")
        				$("#result").html(res)
        			}
        			, error: function() {
        				console.log("AJAX 실패")
        			}
        		})
                } else {
                    console.log(rsp);
                }
            });
        }
    </script>
    <meta charset="UTF-8">
    <title>Sample Payment</title>
</head>
<body>
    <button onclick="requestPay()">결제하기</button> <!-- 결제하기 버튼 생성 -->
<div id = "result">

</div>
</body>
</html>




