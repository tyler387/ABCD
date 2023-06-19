<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

<h1 class="innerTitle">상품 문의</h1>

</div>
<form action="./filter" method="get">
<div class="input-group mb-12 ms-auto  justify-content-end"
	style="padding-right: 50px; padding-top: 15px; margin-bottom: 15px; width: 750px;">
	<label for="content" class="input-group-text">상태</label>&nbsp;
	<select name ="status" id="status" class="form-select" style="width:115px;">
		<option value="" selected>미선택</option>
		<option value="unprocessed">미처리</option>
		<option value="done">처리완료</option>
	</select>
	&nbsp;&nbsp;
	<select class=" form-select " name="filter" id="filter"
		style="width: 100px;">
		<option value="iqq.itemno" selected>상품번호</option>
		<option value="item_title">상품명</option>
		<option value="user_id">문의자 아이디</option>
		<option value="user_name">문의자 이름</option>
		<option value="iq_title">문의 제목</option>
	</select> <label for="content" class="input-group-text">검색</label> 
	<input type="text" name="content" id="content">
	<button id="searchBtn" class="btn btn-secondary">검색하기</button>
</div>
</form>
<%-- mt : ${boardOption} --%> 

<div id="list" class="admin1">
<table class="table table table-hover">
<tr class="table-secondary">
	<th>문의번호</th>
	<th>상품번호</th>
	<th>상품명</th>
	<th>상품사진</th>
	<th>문의자 아이디</th>
	<th>문의자 이름</th>
	<th>문의 제목</th>
	<th>문의 분류</th>
	<th>처리상태</th>
	<th>작성일</th>
	<th>관리</th>
</tr>
<c:forEach var="iql" items="${itemQnAQList}">
<tr>
<%-- 상품 문의시 해당 상품의 정보가 리스트로 보이게끔 하면 좋을것 같음
	 판매 페이지 생성하고 결제 진행 후에 변경해줘야 할점으로 보임
 --%>
	<td>${iql.ITEM_QNANO}</td>
	<td>${iql.ITEMNO}</td>
	<td>${iql.ITEM_TITLE}</td>
	<td><img alt="" src="/itemfile/${iql.I_STORED_NAME}" style="width: 50px; height:50px;"></td>
	<td>${iql.USER_ID}</td>
	<td>${iql.USER_NAME}</td>
	<td>${iql.IQ_TITLE}</td>
	<td>${iql.IQ_OPTION}</td>
	<c:choose>
		<c:when test="${iql.IQ_STATUS eq 'unprocessed'}">
		<td>미처리</td>
		</c:when>
		<c:when test="${iql.IQ_STATUS eq 'done'}">
		<td>처리완료</td>
		</c:when>
	</c:choose>
	<td>${iql.WRITE_DATE}</td>
	<c:choose>
	<c:when test="${not empty iql.IQ_STATUS and iql.IQ_STATUS eq 'done'}">
	<td> 
		<button onclick="location.href='./update?mgrItemno=${iql.MGR_ITEMNO}&itemQnano=${iql.ITEM_QNANO}&curPage=${paging.curPage}'" class="btn btn-secondary">수정</button>
		<button onclick="location.href='./delete?mgrItemno=${iql.MGR_ITEMNO}&itemQnano=${iql.ITEM_QNANO}&curPage=${paging.curPage}'" class="btnDelete btn btn-secondary" >삭제</button>
	</td>
	</c:when>
	<c:when test="${not empty iql.IQ_STATUS and iql.IQ_STATUS eq 'unprocessed'}">
	<td> 
		<button onclick="location.href='./write?itemQnano=${iql.ITEM_QNANO}&curPage=${paging.curPage}'" class="btn btn-secondary">등록</button>
	</td>
	</c:when>
	</c:choose>
</tr>	
</c:forEach>

</table>

<c:import url="../../paging.jsp"/>

</div>

</div>
</div>
</body>
</html>