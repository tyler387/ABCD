<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

<style type="text/css">
.profileForm{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;	

}
.profilebtn{
	display: flex;
	justify-content: center;
	align-items: center;	
	
}
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
.btnbox{
	padding-left: 10px;
}
.filebox{
	
}

</style>

</div>
    <div class="right">
     <form action="/mypage/profile" method="post" enctype="multipart/form-data" id="profileForm">
      <input type="hidden" name="userno" id="userno" value="${userno}">  
  
	<div class='profile'>
		<c:if test="${profile.profileStoredName eq null}">
			<div>
				<img src="<%=request.getContextPath() %>/userProfile/pexels-tobias-bjørkli-1693095.jpgf6f88b97" id="profileimg"> 
			</div>	
			
			<div class="filebox">	
		        <input type="file" id="file" name="file">
		    </div>
        </c:if>
        
        <c:if test="${profile.profileStoredName ne null}">
	        <div>
				<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" id="profileimg"> 
			</div>	
			
			<div class="filebox">
		        <input type="file" id="file" name="file">
		    </div>    
        </c:if>
     </div>  
    
    <div class="profilebtn">
    	<div class="btnbox">
    		<button id="profileInput" class="profileUpdatebtn">프로필 수정</button>
    	</div>
    	<div class="btnbox">
    		<a href="/mypage/main"><button class="profileUpdatebtn" >취소</button></a>
    	</div>
    </div>
      </form>
    </div>
  </div>
    
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">



</script>    
    
<c:import url="../layout/footer.jsp" />