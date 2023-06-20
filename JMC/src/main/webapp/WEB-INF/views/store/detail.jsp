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
/* border : 1px solid black; */
    width: 100%;
    border: 1px solid #444444;
    border-collapse: collapse;
} 
 
th, td {
height: 50px;
width: 100%;
}
</style>
</div>
    <div class="right">
<h1>결제내역 상세 조회</h1>
<hr>
<div style="height: 30px;"></div>
<div class="meetingform">
<div id="result">
<table class="table table table-hover txc-table" style="margin: auto;">
<tr class="table-secondary">
	<th>주문이름</th>
	<th>상품사진</th>
	<th>상품옵션</th>
	<th>갯수</th>
	<th>가격</th>
	<th>구매시간</th>
	<th>주문자 이름</th>
	<th>주문자 주소</th>
	<th>주문 상태</th>
</tr>	 
<c:forEach var="list" items="${buylist}" varStatus="status" >
<tr>
	<th>${list.ITEM_NAME}</th>	 
	<th><img id="material" src="/itemfile/${list.I_STORED_NAME }/" width="60px" height="60px"></th>
		<th><c:if test="${list.ITEM_OPTION ne null }">${list.ITEM_OPTION}</c:if>
	<c:if test="${list.ITEM_OPTION eq null }"> 없음 </c:if></th>	  
	<th>${list.ITEM_COUNT }</th>
	<th class="perPrice">${list.ITEM_TOTAL_PRICE }</th>
	<th><fmt:formatDate value="${list.STATUS_DATE}" pattern="yyyy/MM/dd HH:mm"/></th>
	<th>${list.NAME }</th>
	<th>${list.ADD2 }  &nbsp;&nbsp; ${list.ADD3 }</th>
	<th>
	  	<c:if test="${list.ORDER_STATUS eq 'payed' }">결제완료</c:if>
	  	<c:if test="${list.ORDER_STATUS eq 'cancel' }">결제취소</c:if>
	  	<c:if test="${list.ORDER_STATUS eq 'delivered' }">배송완료</c:if>
	  	<c:if test="${list.ORDER_STATUS eq 'ondelivery' }">배송중</c:if>
	  	<c:if test="${list.ORDER_STATUS eq 'refund' }">반품</c:if>
	</th>
</tr>
</c:forEach> 
</table> 
</div>
</div>
</div>
</div> 
<c:import url="../layout/footer.jsp" />
