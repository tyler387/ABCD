<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css"> 


.imgprofile{
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
  border: 1px #371e06 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 50vh;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
  margin-left: 15px;
}

th {
  text-align: left;
 background: #371e06;
 color : #fff;
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
    border-bottom: 1px solid #371e06;
  }
  
  td {
    border-bottom: 1px solid #371e06;
  }
  
  
  }

</style>


</div>
    <div class="right">
      
      <div  class="box1">
      	<div class="info">
      	 
      		<label for="my" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">내정보</label>
      		<div style="width:75px; margin-left: 18px;" ><hr></div>
      		<div class="imgprofile">
      		
      			<div id="userinfo1">
      			<c:if test="${empty profile}">
      				<img src="/resources/image/Default-Profile-Picture-PNG-Download-Image.png" class="img"> 
      			 </c:if>
      			  
      			   <c:if test="${not empty profile}">
						<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" class="img"> 
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
	      		
	      	<div id="searchFriend">
				<input type="hidden" name="userno" id="userno" value="${userno}">
				<table class="friendTable">
					<tr>
						<th>모임명 </th>
						<th>모임 날짜</th>
						<th>현재 인원</th>
					</tr>
				<c:forEach var="map" items="${map}">
		  			<tr>
		  				<td>${map.MNAME }</td>
		  				<td>
		  				<fmt:formatDate value="${map.MEETING_DATE }" pattern="MM월dd일 a hh:mm"/>
		  				</td>
		  				<td>${map.CNT } / ${map.HEAD_COUNT }</td>
		  			</tr>
		  		</c:forEach>
				</table>
	 		</div>
      	</div>
      	</div>
      	
<!--       	<div class="info"> -->
<!-- 	      	<label for="myBuyList" style="font-size: 20px; padding-top: 50px; margin-left: 20px; ">결제</label> -->
<!-- 	      	<div style="width:65px; margin-left: 18px;" ><hr></div> -->
      		
<!--       		<div id="searchFriend"> -->
<%-- 				<input type="hidden" name="userno" id="userno" value="${userno}"> --%>
<!-- 				<table class="friendTable"> -->
<!-- 					<tr> -->
<!-- 						<th>유저 아이디</th> -->
<!-- 						<th>유저 닉네임</th> -->
<!-- 						<th>유저 이름</th> -->
<!-- 					</tr> -->
<%-- 				<c:forEach var="list" items="${list }"> --%>
					
<!-- 					<tr> -->
<%-- 						<td>${list.USER_ID}</td> --%>
<%-- 						<td>${list.USER_NICK }</td> --%>
<%-- 						<td>${list.USER_NAME }</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 				</table> -->
<!-- 	 		</div> -->
<!--       	</div> -->
     
     
      <div class="box2">
      	<div class="info">
      	
      		<label for="myGrade" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">내등급</label>
      		<div style="width:75px; margin-left: 18px;" ><hr></div>
      		
      		<div class="grade">
      		
      		<c:if test="${loginInfo.grade == '술찐'}">
	      		<div class="imgprofile">
	      			<div id="userinfo1">
	      				<img src="/resources/image/free-icon-whiskey-sour-7743462.png" class="img">
	      			</div>
	      			
	      			<div id="userinfo2">
			       		<div class="info">등급 : ${loginInfo.grade}</div>
			       	</div>
	      		</div>
	      	</c:if>	
      		</div>
      	</div>
      	
<!--       		<div class="info">  -->
      	
<!--       		<label for="my" style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">종료된 모임</label> -->
<!--       		<div style="width:140px; margin-left: 18px;" ><hr></div> -->
      		
<!--       		<div id="searchFriend"> -->
<%-- 				<input type="hidden" name="userno" id="userno" value="${userno}"> --%>
<!-- 				<table class="friendTable"> -->
<!-- 					<tr> -->
<!-- 						<th></th> -->
<!-- 						<th></th> -->
<!-- 						<th></th> -->
<!-- 					</tr> -->
<%-- 				<c:forEach var="list" items="${list }"> --%>
					
<!-- 					<tr> -->
<%-- 						<td>${list.USER_ID}</td> --%>
<%-- 						<td>${list.USER_NICK }</td> --%>
<%-- 						<td>${list.USER_NAME }</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 				</table> -->
<!-- 	 		</div> -->
<!--       	</div>  -->
      	
      	
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
						<td>${list.USER_ID}</td>
						<td>${list.USER_NICK }</td>
						<td>${list.USER_NAME }</td>
					</tr>
				</c:forEach>
				</table>
	 		</div>
      		
      	</div>
      	
      
      	
      	
      </div>
   


</div>
 </div>
<c:import url="../layout/footer.jsp" />