<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<script type="text/javascript">


</script>
<style type="text/css">
.right{
	padding : 0!important;
}
th{
	width : 15%;
}
td{
	text-align: center;
}
#view{	
	display : inline-block;
	width : 70px;
	padding : 10px;
}
tbody{
	height: 100%;
}
tr{
	height : 100px;	
	border-bottom : 1px solid black;
}
#view{
	background-color: #371e06;
	color : white;
}


.pagination li{
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;


}
.pagination{
	padding: 0;
}
#paging{
	width: 100%;
	height : 100px;
	display: flex;
	justify-content: center;
}
table{
	width:90%;
	border-collapse: collapse;
    height: 0;
}
#apaging{

	padding: 5px 10px 5px 10px;
	font-size : 20px;
	margin-right : 5px;
}
#tablesize{
    height: 700px;
    display: flex;
    justify-content: center;
}
</style>


  </div>
      <div class="right">
      
      <div id="tablesize">
        	<table>
  		<thead id="thead">
  		<tr>
  			<th>모임명</th>
  			<th>모임날짜</th>
  			<th>현재인원</th>
  			<th>상세보기</th>
 		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="map" items="${map}">
  			<tr>
  				<td>${map.MNAME }</td>
  				<td>
  				<fmt:formatDate value="${map.MEETING_DATE }" pattern="MM월dd일 a hh:mm"/>
  				</td>
  				<td>${map.CNT } / ${map.HEAD_COUNT }</td>
  				<td><a href="../meeting/view?meetingno=${map.MEETINGNO }" id="view">바로가기</a>
  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	</div>
    <div id="paging">
		<div class="page">
<ul class="pagination">

<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
	<c:if test="${paging.curPage eq i }">
	<li><a href="./mymeeting?curPage=${i}" id="apaging" style="font-weight: 700;">${i}</a></li>
	</c:if>	
	<c:if test="${paging.curPage ne i }">
	<li><a href="./mymeeting?curPage=${i}" id="apaging">${i}</a></li>
	</c:if>	
</c:forEach>

</ul>
</div>
	</div>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />