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

form{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: flex-start;
	margin-top: 89px;	
	padding-bottom:50px;

}
</style>


<div class="container">
<form action="/login/searchResultId" method="post">
	<div>
		<h1 style="font-size: 35px;">아이디 찾기</h1>
	</div>
	
	<c:choose>
		<c:when test="${result.userId eq null }">
		 <p>조회된 아이디가 없습니다</p>
		</c:when>
		<c:otherwise>
		<p>아이디는 ${result.userId } 입니다.</p>
		</c:otherwise>
	
	</c:choose>
</form>
<div>
	<a href="./login"><button>로그인</button></a>
	<a href="./searchPw"><button>비밀번호 찾기</button></a>
</div>
</div>
<c:import url="../layout/footer.jsp" />