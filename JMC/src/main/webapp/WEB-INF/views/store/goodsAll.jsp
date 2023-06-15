<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">



#btn_group button {
	border: 1px solid skyblue;
	background-color: rgba(0, 0, 0, 0);
	color: skyblue;
	padding: 5px;
	font-size: 25px;
}

#btn_group button:hover {
	color: white;
	background-color: skyblue;
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
  margin-bottom: 50px
  

} 

.item{
text-align: center;
}

#btn_Search{
    position: relative;
    left: 952px;
    top: 8px;
}
</style>

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
<button id="goodswhole">전체보기</button>
<c:if test="${list.get(0).ITEM_TYPE eq '칵테일 재료' 
				or list.get(0).ITEM_TYPE eq '칵테일 도구' 
				or list.get(0).ITEM_TYPE eq '칵테일 잔'}">
<button id="goodsglass">글라스</button>
<button id="goodsshaker">쉐이커</button>
<button id="goodsoffset">지거</button>
</c:if>



<c:if test="${list.get(0) eq '위스키 물품' 
				or list.get(0) eq '와인 물품'}">
</c:if>
</div>


<div class="container">
<c:forEach var="list" items="${list}">
	<div class="item">
	<img id="material" src='/itemfile/${list.I_STORED_NAME}/' width="250px" height="250px" >
	      <div>${list.ITEM_TYPE }</div>
	      <div>${list.ITEM_TITLE }</div>
	      <div>${list.ITEM_PRICE }</div>
	</div>
</c:forEach>
</div>


<c:import url="../layout/footer.jsp" />