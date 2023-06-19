<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:import url="../layout/header.jsp" />
<c:import url="../chat/chatbutton.jsp"></c:import>

<style type="text/css">


.factoryinfo{
	
/* 	margin-top: 50px; */
	text-align: center;
}

.coment{

	margin-bottom: 100px;

}

.introducetitle{
	margin-top: 50px;
	margin-bottom: 50px;
}

.introduce{

	margin-bottom: 50px;
}



.meeting{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}


.community{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}

.cocktail{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}

.factory{
	width: 364px;
	height: 200px;
	margin-right: 70px;

}

.cocktail1{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}

.security{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}

.mcomment{
	width: 364px;
	height: 200px;
	margin-right: 70px;
}
.ccomment{
	width: 364px;
	height: 200px;
	margin-right: 70px;

}
.cmcomment{
	width: 364px;
	height: 200px;
	margin-right: 70px;

}

.image{
	margin-bottom: 200px;

}

.meeting{
	display: inline-block;
	
}

.function{
	background-color: #e2e2e2; 
}



.ltitle{
	font-size: 20px;

}

.borderhr{
	
	margin-bottom: 100px;
	size: 50px;

}

</style>





<div class="factoryinfo">

<div class= "title"><h1>About JMC</h1></div>
<div class="coment"><h2>수많은 인연과 추억을 선물합니다.</h2> 
<hr></div>

<div class="introducetitle">
<div class="introduce"><h1>JAMANCHU</h1></div>
<div class="introduce"><h2>Since 2023</h2></div>
<div>저희 JAMANCHU는 단순한 음주만을 위한 모임이 아닌 인연과 추억을 만들기 위한 모임 플랫폼을 제공합니다</div>
또한 애주가부터 이제 위스키에 관심을 갖는 사람들까지 전부 참여할수 있는 서비스를 제공합니다
</div>

<div class="image">


<div class="meeting">
<div class="function">
<img src="../resources/image/모임.jpeg" class="meeting">
<p class="ltitle">모임에 참가하세요!</p>
<p>성인이라면 누구든 위스키 모임을 등록하고 참여할수 있는 기능을 제공합니다!</p>
</div>
</div>

<div class="meeting">
<div class="function">
<img src="../resources/image/칵테일 재료.jpg" class="cocktail">
<p class="ltitle">나만의 칵테일을 만들어보세요!</p>
<p>다양한 칵테일 재료와 용품들을 저렴한 가격으로 판매합니다!</p>
</div>
</div>

<div class="meeting">
<div class="function">
<img src="../resources/image/커뮤니티.jpg" class="community">
<p class="ltitle">다양한 정보들을 공유하세요!</p>
<p>시음기와 모임 후기를 공유할수 있는 커뮤니티 기능을 제공합니다!</p>
</div>
</div>

</div>

<hr class="borderhr">

<div class= "title1"><h1>Our Vision</h1></div>

<div class="comment1">저희 JAMANCHU의 궁극적인 목표는 위스키와 칵테일의 대중화와</div>
<div class="introduce">위스키와 칵테일이라는 즐거운 주제로 인연과 추억을 만들어가는 사람들의 행복의 극대화입니다.</div>


<div class="image">


<div class="meeting">
<div class="function">
<img src="../resources/image/회사목표.jpg" class="factory">
<p class="ltitle">좀더 나은 서비스를 위해 노력합니다</p>
<p>현실에 안주하지 않고 좀 더 좋은 서비스를 목표로 하고 있습니다</p>
</div>
</div>

<div class="meeting">
<div class="function">
<img src="../resources/image/칵테일 연구.jpeg" class="cocktail1">
<p class="ltitle">새로운 칵테일 레시피를 연구합니다</p>
<p>위스키와 칵테일을 즐기는 사람들로서 소비자의 입장으로 더 좋은 레시피를 연구하고 공유합니다</p>
</div>
</div>

<div class="meeting">
<div class="function">
<img src="../resources/image/세큐리티.jpg" class="security">
<p class="ltitle">사용자의 안전을 위해 노력합니다</p>
<p>모임으로 인해 생기는 문제 해결과 악성사용자 배제를 우선시해 사용자의 안전을 가장 우선시합니다</p>
</div>
</div>

</div>


</div>



<c:import url="../layout/footer.jsp" />
