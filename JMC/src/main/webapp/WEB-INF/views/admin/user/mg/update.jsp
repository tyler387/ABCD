<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../main.jsp"></c:import>

<H1>유저 수정 페이지</H1>
<hr>
<div class="container text-center">
<!--  <div class="row"> -->
<!--     <div class="col"> -->
<!--       Column -->
<!--     </div> -->
<!--     <div class="col"> -->
<!--       Column -->
<!--     </div> -->
	<div  class="update" style ="width: 600px; margin: 0 auto;">
	<form action="./update" method="post">
	<input type="hidden" class="form-control" value="${paging.curPage}" aria-label="Username" aria-describedby="basic-addon1"  name="curPage">
	<input type="hidden" class="form-control" value="${users.userId}" aria-label="Username" aria-describedby="basic-addon1"  name="userId">
	<input type="hidden" class="form-control" value="${users.userPw}" aria-label="Username" aria-describedby="basic-addon1"  name="userPw">
	<input type="hidden" class="form-control" value="${users.role}" aria-label="Username" aria-describedby="basic-addon1"  name="role">
	<input type="hidden" class="form-control" value="${users.platFormOption}" aria-label="Username" aria-describedby="basic-addon1"  name="platFormOption">
	
	<div class="input-group mb-3" style="margin-top: 20px;">
		  <span class="input-group-text" id="basic-addon1">이름</span>
	  <input type="text" class="form-control" value="${users.userName}" aria-label="Username" aria-describedby="basic-addon1"  name="userName">
	  	  <span class="input-group-text" id="basic-addon1"></span>
	  <input type="hidden" class="form-control" value="${users.userno}" aria-label="Username" aria-describedby="basic-addon1"  name="userno">
  	  	  <span class="input-group-text" id="basic-addon1">경고횟수</span>
	  <input type="text" class="form-control" value="${users.warnCount}" aria-label="Username" aria-describedby="basic-addon1"  name="warnCount">
	</div> 
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">닉네임</span>
	  <input type="text" class="form-control" value="${users.userNick}" aria-label="Username" aria-describedby="basic-addon1" name="userNick">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">이메일</span>
	  <input type="text" class="form-control" value="${users.email }" aria-label="Username" aria-describedby="basic-addon1" name="email">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">폰번호</span>
	  <input type="text" class="form-control" value="${users.phone }" aria-label="Username" aria-describedby="basic-addon1" name="phone">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">주소1</span>
	  <input type="text" class="form-control" value="${users.addr1 }" aria-label="Username" aria-describedby="basic-addon1" name="addr1">
  	  <span class="input-group-text" id="basic-addon1">주소2</span>
	  <input type="text" class="form-control" value="${users.addr2 }" aria-label="Username" aria-describedby="basic-addon1" name="addr2">
	</div>
	 
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">주소3</span>
	  <input type="text" class="form-control" value="${users.addr3 }" aria-label="Username" aria-describedby="basic-addon1" name="addr3">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">가입날짜</span>
	  <input type="text" class="form-control" value="<fmt:formatDate value='${users.joinDate }' pattern ='yyyy-MM-dd' />" aria-label="Username" aria-describedby="basic-addon1" disabled name="joinDate">
	</div>
	
	  
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">생일</span>
	  <input type="text" class="form-control"  value="<fmt:formatDate value='${users.birth}' pattern ='yyyy-MM-dd' />" aria-label="Username" aria-describedby="basic-addon1" name="birth"> 
	</div>
		
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">성별</span>
	  <input type="text" class="form-control" value="${users.gender }" aria-label="Username" aria-describedby="basic-addon1" name="gender">
	  <span class="input-group-text" id="basic-addon1">상태</span>
	  	<select name ="status" id="status" class=" form-select" style="width: 70px;">
	  	<c:if test="${users.status eq 'active' }">
			<option value="active" selected>정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
  		<c:if test="${users.status eq 'leave' }">
			<option value="active">정상</option>
			<option value="leave"selected>탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.status eq 'unactive' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive" selected>휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.status eq 'block' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block" selected>정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.status eq 'blacklist' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist" selected>블랙리스트</option>
	  	</c:if>
	</select>
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">프로필사진</span>
	  <input type="text" class="form-control" value="${users.profileImgUrl }" aria-label="Username" aria-describedby="basic-addon1" name="profileImgUrl">
	</div>
	
	 
	<button  class="btn btn-secondary" style ="width: 600px;">수정 완료</button>
	</form>
	<br>
	<a href= "javascript:history.back();"><button  class="btn btn-secondary" style ="width: 600px;">취소</button></a>
	 </div>
 </div>
</body>
</html>
