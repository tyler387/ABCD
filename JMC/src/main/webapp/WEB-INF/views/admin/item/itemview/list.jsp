<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../../main.jsp"/>

<style>
table {
    margin-left:auto; 
    margin-right:auto;
}

table, td, th {
    border-collapse : collapse;
    text-align: center; 
}

div.admin1 {
        height: 650x;
      	padding-left: 60px;
    width: 98%;
        
}

.innerTitle {
	margin: 0 auto;
	border-radius: 30px; 
	background-color : #03a9f46e; 
	width: 600px;  
	text-align: center; 
	padding-bottom: 5px;
}

</style>

<div id="Alltitle" style="text-align: center; padding-top: 10px;">

<h1 class="innerTitle">판매 물품 정보 수정/삭제</h1>

</div>
<form action="./filter" method="get">
<div class="input-group mb-12 ms-auto  justify-content-end"
	style="padding-right: 50px; padding-top: 15px; margin-bottom: 15px; width: 750px;">
	<label for="content" class="input-group-text">상태</label>&nbsp;
	<select name ="status" id="status" class="form-select" style="width:115px;">
		<option value="" selected>미선택</option>
		<option value="sale">판매중</option>
		<option value="sold_out">매진</option>
		<option value="stop_selling">판매중지</option>
	</select>
	&nbsp;&nbsp;
	<select class=" form-select " name="filter" id="filter"
		style="width: 100px;">
		<option value="item_type" selected>판매유형</option>
		<option value="item_title">제품명</option>
	</select> <label for="content" class="input-group-text">검색 </label> 
	<input type="text" name="content" id="content">
	<button id="searchBtn" class="btn btn-secondary">검색하기</button>
</div>
</form>
<%-- mt : ${boardOption} --%> 

<div id="list" class="admin1">
<table class="table table table-hover">
<tr class="table-secondary">
	<th>번호</th>
	<th>판매유형</th>
	<th>제품명</th>
	<th>가격</th>
	<th>판매상태</th>
	<th>작성일</th>
	<th>관리</th>
</tr>
<c:forEach var="il" items="${itemList}">
<tr>
	<td>${il.ITEMNO}</td>
	<td>${il.ITEM_TYPE}</td>
	<td>${il.ITEM_TITLE}</td>
	<td>${il.ITEM_PRICE}</td>
	<c:choose>
		<c:when test="${il.ITEM_STATUS eq 'sale'}">
		<td>판매중</td>
		</c:when>
		<c:when test="${il.ITEM_STATUS eq 'sold_out'}">
		<td>매진</td>
		</c:when>
		<c:when test="${il.ITEM_STATUS eq 'stop_selling'}">
		<td>판매중지</td>
		</c:when>
	</c:choose>
	<td>${il.WRITE_DATE}</td>
	<td> 
		<button onclick="location.href='./update?itemno=${il.ITEMNO}&curPage=${paging.curPage}'" class="btn btn-secondary">수정</button>
		<button onclick="location.href='./delete?itemno=${il.ITEMNO}&curPage=${paging.curPage}'" class="btn btn-secondary">삭제</button>
<%-- 		<button class="btnDelete" data-boardno="${bl.ADMIN_BOARDNO}">삭제</button> --%>
	</td>
</tr>	
</c:forEach>

</table>

<c:import url="../../paging.jsp"/>

</div>

</div>
</div>
</body>
</html>