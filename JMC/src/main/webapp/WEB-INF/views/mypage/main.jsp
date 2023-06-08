<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css"> 
.img{
	
}

</style>


  </div>
      <div class="right">
        
        <div  class="box1">
        	<div class="info">
        	
        		<label for="my">내정보</label>
        		<div style="width:50px;"><hr></div>
        		
        		<div class="img"><img src="/userProfile/${profileStoredName}"></div>
        		
        		<div>
	        		<div>아이디 : ${userId }</div>
	        		<div>닉네임 : ${loginInfo.userNick }</div>
	        		<div>이메일 : ${loginInfo.email }</div>
        		</div>
        	</div>
        	
        	<div class="meeting">
        	
        	</div>
        	
        	<div class="delivery">
        	
        	</div>
        </div>
       
        <div class="box2">
        	<div></div>
        	<div></div>
        	<div></div>
        </div>
     
		</div>
	
  </div>

<c:import url="../layout/footer.jsp" />