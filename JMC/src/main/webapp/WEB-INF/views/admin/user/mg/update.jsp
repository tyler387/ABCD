<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../main.jsp"></c:import>
<style type="text/css">

.profile{
	display: flex;
	justify-content: center;
	align-items: center;
	
}
.file{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;	
}
.profileUpdatebtn{
	border: 1px solid #371e06;
    background-color: #371e06;
    border-radius: 7px;
    color: #fff;
    width: 180px;
    height: 39px;
    font-size: 20px;
    cursor: pointer;
    margin-top: 40px;


}
</style>

	<div id="Alltitle" style="text-align: center; padding-top: 10px;">
		<h1  style="margin: 0 auto;border-radius: 30px; background-color : #03a9f46e; width: 600px;  text-align: center; padding-bottom: 5px;">
			회원 정보 수정
		</h1>
	</div>
<div class="container text-center">
<!--  <div class="row"> -->
<!--     <div class="col"> -->
<!--       Column -->
<!--     </div> -->
<!--     <div class="col"> -->
<!--       Column -->
<!--     </div> -->
	<div  class="update" style ="width: 600px; margin: 0 auto; padding-top: 1px;">
	<form action="./update" method="post" enctype="multipart/form-data">
	<input type="hidden" class="form-control" value="${paging.curPage}" aria-label="Username" aria-describedby="basic-addon1"  name="curPage">
	<input type="hidden" class="form-control" value="${users.USER_ID}" aria-label="Username" aria-describedby="basic-addon1"  name="userId">
	<input type="hidden" class="form-control" value="${users.USER_PW}" aria-label="Username" aria-describedby="basic-addon1"  name="userPw">
	<input type="hidden" class="form-control" value="${users.ROLE}" aria-label="Username" aria-describedby="basic-addon1"  name="role">
	<input type="hidden" class="form-control" value="${users.PLATFORM_OPTION}" aria-label="Username" aria-describedby="basic-addon1"  name="platFormOption">
	<input type="hidden" class="form-control" value="${users.USERNO}" aria-label="Username" aria-describedby="basic-addon1"  name="userno">
	
	<div class="input-group mb-3" style="margin-top: 20px; pad"> 
		  <span class="input-group-text" id="basic-addon1">이름</span>
	  <input type="text" class="form-control" value="${users.USER_NAME}" aria-label="Username" aria-describedby="basic-addon1"  name="userName">
  	  	  <span class="input-group-text" id="basic-addon1">경고횟수</span>
	  <input type="text" class="form-control" value="${users.WARN_COUNT}" aria-label="warnCount" aria-describedby="basic-addon1"  name="warnCount" aria-describedby="basic-addon1" disabled name="warnCount">
	  	  <span class="input-group-text" id="basic-addon1">유저 번호</span>
	  <input type="text" class="form-control" value="${users.USERNO}" aria-label="Userno" aria-describedby="basic-addon1"  name="userno"  aria-describedby="basic-addon1" disabled name="Userno">
	</div> 
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">닉네임</span>
	  <input type="text" class="form-control" value="${users.USER_NICK}" aria-label="userNick" aria-describedby="basic-addon1" name="userNick">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">이메일</span>
	  <input type="text" class="form-control" value="${users.EMAIL }" aria-label="email" aria-describedby="basic-addon1" name="email">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">폰번호</span>
	  <input type="text" class="form-control" value="${users.PHONE }" aria-label="phone" aria-describedby="basic-addon1" name="phone">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">주소1</span>
	  <input type="text" class="form-control" value="${users.ADDR1 }" aria-label="addr1" aria-describedby="basic-addon1" name="addr1">
  	  <span class="input-group-text" id="basic-addon1">주소2</span>
	  <input type="text" class="form-control" value="${users.ADDR2 }" aria-label="addr2" aria-describedby="basic-addon1" name="addr2">
	</div>
	 
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">주소3</span>
	  <input type="text" class="form-control" value="${users.ADDR3 }" aria-label="addr3" aria-describedby="basic-addon1" name="addr3">
	</div>
	
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">가입날짜</span>
<%-- 	  <input type="text" class="form-control" value="<fmt:formatDate value='${users.JOIN_DATE }' pattern ='yyyy-MM-dd' />" aria-label="joinDate" aria-describedby="basic-addon1" disabled name="joinDate"> --%>
	  <input type="text" class="form-control" value="${users.JOIN_DATE }" aria-label="joinDate" aria-describedby="basic-addon1" disabled name="joinDate">
	  <span class="input-group-text" id="basic-addon1">등급</span>
	  <input type="text" class="form-control" value="${users.GRADE }" aria-label="addr3" aria-describedby="basic-addon1" name="grade">
	</div>
	
	  
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">생일</span>
<%-- 	  <input type="text" class="form-control"  value="<fmt:formatDate value='${users.BIRTH}' pattern ='yyyy-MM-dd' />" aria-label="birth" aria-describedby="basic-addon1" name="birth">  --%>
	  <input type="text" class="form-control"  value="${users.BIRTH}" aria-label="birth" aria-describedby="basic-addon1" name="birth"> 
	</div>
		
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">성별</span>
	  <input type="text" class="form-control" value="${users.GENDER }" aria-label="gender" aria-describedby="basic-addon1" name="gender">
	  <span class="input-group-text" id="basic-addon1">상태</span>
	  	<select name ="status" id="status" class=" form-select" style="width: 70px;">
	  	<c:if test="${users.STATUS eq 'active' }">
			<option value="active" selected>정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
  		<c:if test="${users.STATUS eq 'leave' }">
			<option value="active">정상</option>
			<option value="leave"selected>탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.STATUS eq 'unactive' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive" selected>휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.STATUS eq 'block' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block" selected>정지</option>
			<option value="blacklist">블랙리스트</option>
	  	</c:if>
	  	<c:if test="${users.STATUS eq 'blacklist' }">
			<option value="active">정상</option>
			<option value="leave">탈퇴</option>
			<option value="unactive">휴먼</option>
			<option value="block">정지</option>
			<option value="blacklist" selected>블랙리스트</option>
	  	</c:if>
	</select>
	</div>
	  <span class="input-group-text" id="basic-addon1">프로필 사진</span>
		<div class='profile'>
		<c:if test="${empty users.PROFILE_STORED_NAME}">
			<div>
				<img src="/resources/image/Default-Profile-Picture-PNG-Download-Image.png" id="profileimg" style ="width: 140px; height: 140px;"> 
			</div>	
			
			<div class="filebox">	
		        <input type="file" id="file" name="file">
		    </div>
        </c:if>
        
        <c:if test="${not empty users.PROFILE_STORED_NAME}">
	        <div>
				<img src="<%=request.getContextPath() %>/userProfile/${users.PROFILE_STORED_NAME}" id="profileimg" style ="width: 140px; height: 140px;"> 
			</div>	
			
			<div class="filebox">
		        <input type="file" id="file" name="file">
		    </div>    
        </c:if>
     </div> 
	
<!-- 	<div class="input-group mb-3"> -->
<!-- 	  <span class="input-group-text" id="basic-addon1">프로필사진</span> -->
<%-- 	  <input type="text" class="form-control" value="${users.profileImgUrl }" aria-label="Username" aria-describedby="basic-addon1" name="profileImgUrl"> --%>
<!-- 	</div> -->
	
	 
	<button  class="btn btn-secondary" style ="width: 600px;">수정 완료</button>
	</form>
	<br>
	<a href= "javascript:history.back();"><button  class="btn btn-secondary" style ="width: 600px;">취소</button></a>
	 </div>
 </div>
</body>
</html>
