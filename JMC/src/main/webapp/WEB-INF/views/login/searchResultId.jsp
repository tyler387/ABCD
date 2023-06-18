<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />


<style type="text/css">

.container{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.searchbox{
	display:flex;
 	justify-content:center; 
	align-items: center;
	flex-direction:column;
	width:  680px;
	height:  400px;	
	margin-bottom: 350px;
	border: 1px solid #371e06;
	border-radius: 10px 10px 10px 10px;
	box-shadow: 5px 5px 15px;
	margin-top: 200px;	
}

.searchresult{
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
}

.searchresult p{
	font-size: 24px;
}
#resultForm{
	padding-top: 45px;
}

.Idresultbtn{
	font-family: '양진체';
	display :inline-block;
	background-color: #371e06;
	color: #fff;
	height: 50px;
	width: 200px;
	background: orange;
	border-radius: 20px;
	border: none;
	font-size: 20px;
	margin-right: 20px;
	margin-top: 90px;
	cursor: pointer;
}

.Idresultbtn:hover{
	background-color: #ffcca8;
}

</style>


<div class="container">
	<div class="searchbox">	
		<div><h1 style="font-size: 35px;">아이디 찾기</h1></div>
		<form action="/login/searchResultId" method="post" id="resultForm">
			<div class="searchresult">
			<c:choose>
				<c:when test="${result.userId eq null }">
				 	<p>조회된 아이디가 없습니다</p>
				</c:when>
				
				<c:otherwise>
					<p>아이디는 ${result.userId } 입니다.</p>
				</c:otherwise>
			</c:choose>
			</div>
		</form>
		
	<div>
		<a href="./login"><input class="Idresultbtn" type="button" value="로그인"></a>
		<a href="./searchPw"><input class="Idresultbtn" type="button" value="비밀번호 찾기"></a>
	</div>
	</div>
</div>
<c:import url="../layout/footer.jsp" />