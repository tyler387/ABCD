<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css"> 

.img{
	display: flex;
	align-items: center;
	margin-left: 40px;
	margin-top: 18px;
}
.info{
	padding: 6px;
	font-size: 15px;
	font-weight: bold;
	padding-top: 28px;
}
#userinfo1{
	display: inline-block;
}

#userinfo2{
	display: inline-block;
	margin-left: 20px;
}

.box1{
	display: inline-block;
	margin-left: 30px;
	margin-right: 70px;
	margin-top: 30px;
}

.box2{
	display: inline-block;
}

</style>


</div>
    <div class="right">
      
      <div  class="box1">
      	<div class="info">
      	 
      		<label for="my" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">내정보</label>
      		<div style="width:75px; margin-left: 18px;" ><hr></div>
      		<div class="img">
      			<div id="userinfo1">
      				<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" id="profileimg">
      			</div>
      			<div id="userinfo2">
		       		<div class="info">아이디 : ${userId }</div>
		       		<div class="info">닉네임 : ${loginInfo.userNick }</div>
		       		<div class="info">이메일 : ${loginInfo.email }</div>
		       	</div>
      		</div>
      	</div>
      	
      	<div class="info">
	      	<label for="myMeetiong" style="font-size: 20px; padding-top: 50px; margin-left: 20px; ">진행중인 모임</label>
	      	<div style="width:140px; margin-left: 18px;" ><hr></div>
	      		
	      	<div class="meeting">
	      	
	      	</div>
      	</div>
      	
      	<div class="info">
	      	<label for="myBuyList" style="font-size: 20px; padding-top: 50px; margin-left: 20px; ">결제</label>
	      	<div style="width:65px; margin-left: 18px;" ><hr></div>
      		
      		<div class="buylist">
      		
      	
      		</div>
      	</div>
      </div>
     
      <div class="box2">
      	<div class="info">
      	
      		<label for="myGrade" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">내등급</label>
      		<div style="width:75px; margin-left: 18px;" ><hr></div>
      		
      		<div class="grade">
      		
	      		<div class="img">
	      			<div id="userinfo1">
	      				<img src="/userProfile/${fileInfo.profileStoredName}" id="gradeimg">
	      			</div>
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       		
			       	</div>
	      		</div>
      			
      		</div>
      	</div>
      	
      	
      	<div class="info">
      	
      		<label for="my" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">종료된 모임</label>
      		<div style="width:140px; margin-left: 18px;" ><hr></div>
      		
      		<div class="grade">
      			
      		</div>
      	</div>
      	
      	<div class="info">
      	
      		<label for="my" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">친구 목록</label>
      		<div style="width:85px; margin-left: 18px;" ><hr></div>
      		
      		<div class="grade">
      			
      		</div>
      	</div>
      	
      	
      </div>
   
</div>

</div>

<c:import url="../layout/footer.jsp" />