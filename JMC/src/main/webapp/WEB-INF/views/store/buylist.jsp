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
	width: 100px;
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
<h1>결제내역</h1>
<hr>
<div style="height: 30px;"></div>
<div class="meetingform">
<div id="result">
<table class="table table table-hover txc-table" style="margin: auto;">
<tr class="table-secondary">
	<th>주문번호</th>
	<th>주문이름</th>
	<th>총 가격</th>
	<th></th>
</tr>	
<c:forEach var="list" items="${buylist}" varStatus="status" >
<tr>
	<th class="cart_info_td">${list.BUYNO}</th> 
	<th>${list.ITEM_NAME}</th>	 
	<th class="perPrice">${list.TOTAL_PRICE }</th> 
	<th><a href="/store/detail?buyno=${list.BUYNO}"><button type="button" class="btn btn-secondary bsketbtn" data-basketno="${list.BUYNO}">주문 상세보기</button></a></th>
</tr>
</c:forEach> 
</table> 
</div>
</div>
</div>
</div>
<c:import url="../layout/footer.jsp" />
