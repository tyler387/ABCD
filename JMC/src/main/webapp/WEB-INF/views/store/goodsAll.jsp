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
	height: 50px;
 	position: relative;
	left : 900px;

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
</style>

<body>
<div id="goods">
칵테일 용품
<span class="search"><!-- 검색어 관련 -->
 	<input type="text" id="searchWrite" name="searchWrite" placeholder="검색어를 입력하세요">
<!--  	<img id="btn_Search" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"> -->
</span>
</div>
<hr>
<div id="btn_group">
<button id="goodswhole">전체보기</button>
<button id="goodsglass">글라스</button>
<button id="goodsshaker">쉐이커</button>
<button id="goodsoffset">지거</button>
</div>

<div class="container">
	<div class="item"><img id="material" src="/resources/image/뉴욕 롱 드링크.jpg" width="250px" height="250px" >
		<div>글라스</div>
		<div>제품명</div>
		<div>4,900원</div>
	</div>
	
	
	<div class="item"><img id="material" src="/resources/image/렉싱톤 락 글라스.jpg" width="250px" height="250px" >
		<div>글라스</div>
		<div>제품명</div>
		<div>4,900원</div>
	</div>
	<div class="item"><img id="material" src="/resources/image/뮌헨 맥주 글라스.jpg" width="250px" height="250px" >C</div>
	<div class="item"><img id="material" src="/resources/image/브랜디잔.jpg" width="250px" height="250px" >D</div>
	<div class="item"><img id="material" src="/resources/image/오션 임페리얼 글라스.jpg" width="250px" height="250px" >E</div>
	<div class="item"><img id="material" src="/resources/image/지거음.jpg" width="250px" height="250px" >
		<div>글라스</div>
		<div>제품명</div>
		<div>4,900원</div>	
	</div>
	<div class="item"><img id="material" src="/resources/image/포코 그란데 고블렛.jpg" width="250px" height="250px" >
		<div>글라스</div>
		<div>제품명</div>
		<div>4,900원</div>
	</div>
	<div class="item"><img id="material" src="/resources/image/포크 바스푼.jpg" width="250px" height="250px" >H</div>
</div>



<c:import url="../layout/footer.jsp" />