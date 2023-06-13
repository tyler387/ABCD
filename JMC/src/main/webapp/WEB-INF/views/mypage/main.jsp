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
/* 	margin-right: 70px; */
	margin-top: 30px;
}

.box2{
	display: inline-block;
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  margin-left: 15px;
}

th {
  text-align: left;
}
  
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  
  
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
      			<c:if test="${profile.profileStoredName eq null}">
      				<img src="/resources/image/Default-Profile-Picture-PNG-Download-Image.png" id="profileimg"> 
      			 </c:if>
      			  
      			   <c:if test="${profile.profileStoredName ne null}">
						<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" id="profileimg"> 
      			   </c:if>
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
      		
      		<c:if test="${loginInfo.grade == 1}">
	      		<div class="img">
	      			<div id="userinfo1">
	      				<img src="/resources/image/2b50.png" id="gradeimg">
	      			</div>
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       	</div>
	      		</div>
	      	</c:if>	
	      	
	      	<c:if test="${loginInfo.grade == 2}">
	      		<div class="img">
	      			<div id="userinfo1">
	      				<img src="/resources/image/별2.png" id="gradeimg">
	      			</div>
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       	</div>
	      		</div>
	      	</c:if>
	      	
	      	<c:if test="${loginInfo.grade == 3}">
	      		<div class="img">
	      			<div id="userinfo1">
	      				<img src="/resources/image/별3.png" id="gradeimg">
	      			</div>
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       	</div>
	      		</div>
	      	</c:if>
	      	
	      	<c:if test="${loginInfo.grade == 4}">
	      		<div class="img">
	      			<div id="userinfo1">
	      				<img src="/resources/image/별4.png" id="gradeimg">
	      			</div>
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       	</div>
	      		</div>
	      	</c:if>
	      		
	      		
      			
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

   			<div id="searchFriend">
				<input type="hidden" name="userno" id="userno" value="${userno}">
				<table class="friendTable">
					<tr>
						<th>유저 아이디</th>
						<th>유저 닉네임</th>
						<th>유저 이름</th>
					</tr>
				<c:forEach var="list" items="${list }">
					
					<tr>
						<td>${list.userId }</td>
						<td>${list.userNick }</td>
						<td>${list.userName }</td>
					</tr>
				</c:forEach>
				</table>
	 		</div>
      		
      	</div>
      	
      	
      </div>
   
</div>

</div>

<c:import url="../layout/footer.jsp" />