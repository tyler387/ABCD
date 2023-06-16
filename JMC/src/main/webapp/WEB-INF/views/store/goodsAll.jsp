<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<c:import url="../layout/header.jsp" />

<style type="text/css">



#btn_group button {
	border: 1px solid #FFA500;
	background-color: rgba(0, 0, 0, 0);
	color: #FFA500;
	padding: 5px;
	font-size: 25px;
}

#btn_group button:hover {
	color: white;
	background-color: #FFA500;
}

#goodswhole {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-right: 20px;
}

#goodsglass {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;

}

#goodsshaker {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

#goodsoffset {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}
#goods{
	font-size: 30px;
}

#searchWrite{
	width: 250px;
	height: 30px;
 	position: relative;
	left : 1000px;

}

.container { 
  display : grid ; 
  grid-template-columns: repeat(4, 400px);
  grid-template-rows: repeat(2,400px);
  place-items: center;
  margin-bottom: 50px;
  margin-left: 150px;

} 

.item{
text-align: center;
cursor: pointer;
}

#btn_Search{
    position: relative;
    left: 952px;
    top: 8px;
}
</style>

<script type="text/javascript">
$(function(){
	
	
	//엔터로 해도 작동 시키기
	$("#searchWrite").keydown(function(e) {
		if(e.keyCode == 13){
			$("#btn_Search").click();
		}
	})//엔터키 function종료
	
	//마우스로 클릭시 작동 시키기
	$("#btn_Search").click(function() {
			 console.log("돋보기 버튼 클릭 됨")
			 var searchData = $('#searchWrite').val()
			 console.log("검색 값 :", searchData)
			// location.href="/store/itemSearch?type=" + searchData
			 var searchUrl ="/store/goodsAll?type=goods&searchData=" + encodeURIComponent(searchData);
			 window.location.href = searchUrl; 
	})// $("#btn_Search").click(function()종료

	$(".item").click(function(){
		console.log("상품 클릭 됨")
		var itemno = $(this).attr("data-itemno");
		console.log("아이템 번호", itemno)
		var detailUrl = "/store/itemDetail?itemno=" +encodeURIComponent(itemno);
		window.location.href = detailUrl; 
	})			 
				 
				 
})//function종료
</script>

<body>
<div id="goods">
칵테일 용품
<span class="search"><!-- 검색어 관련 -->
 	<input type="text" id="searchWrite" name="searchWrite" placeholder="검색어를 입력하세요">
 	<img id="btn_Search" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" width="25px" height="25px">
</span>
</div>
<hr>
<div id="btn_group">
<a href="/store/goodsAll?type=goods"><button id="goodswhole">전체보기</button></a>
<c:if test="${list.get(0).ITEM_TYPE eq '칵테일 재료' 
				or list.get(0).ITEM_TYPE eq '칵테일 도구' 
				or list.get(0).ITEM_TYPE eq '칵테일 잔'}">
<a href="/store/goodsAll?type=goodsglass"><button id="goodsglass">칵테일 재료</button></a>
<a href="/store/goodsAll?type=goodsshaker"><button id="goodsshaker">칵테일 도구</button></a>
<a href="/store/goodsAll?type=goodsoffset"><button id="goodsoffset">칵테일 잔</button></a>
</c:if>



<c:if test="${list.get(0) eq '위스키 물품' 
				or list.get(0) eq '와인 물품'}">
</c:if>
</div>


<div class="container">
<c:forEach var="list" items="${list}" varStatus="data">
	<div class="item" data-itemno="${list.ITEMNO}">
	<img class="material" src='/itemfile/${list.I_STORED_NAME}/' width="250px" height="250px" >
	      <div>${list.ITEM_TYPE }</div>
	      <div>${list.ITEM_TITLE }</div>
	      <div>${list.ITEM_PRICE }원</div>
	</div>
</c:forEach>
</div>
<c:import url="paging.jsp" />

<c:import url="../layout/footer.jsp" />






