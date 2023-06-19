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
	margin-top: 60px;
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
	border: 1px solid orange;
    background-color: orange;
    border-radius: 7px;
    color: #fff;
    width: 180px;
    height: 39px;
    font-size: 20px;
    cursor: pointer;
    margin-top: 40px;
    font-family: '양진체';


}
.btnbox{
	padding-left: 10px;
}

.imgbox{
	padding-bottom: 50px;
}
.img{
	width:150px;
	height: 150px;
	border-radius: 70%;
	margin-top: 30px;

}
.profileupload{
	display: flex;
	flex-direction: column;
	align-items: center;
}

.filebox{
	width: 360px;
	display: flex;
}

.filebox .upload-name {
    display: inline-block;
    height: 40px;
    padding: 0 10px;
    vertical-align: middle;
    border: 1px solid orange;
    width: 80%;
    color: #371e06;
    font-family: '양진체';
}

.filebox label {
    display: flex;
    flex-direction:row;
    padding: 10px 20px;
    color: #fff;
    vertical-align: middle;
    background-color:  orange;
    cursor: pointer;
    height: 20px;
    width:20%;
    margin-left: 10px;
 

}

.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}
.profileUpdatebtn:hover{
	background-color: #ffcca8;
}
.msgbox{
	padding-top: 10px;
}

</style>

</div>
    <div class="right">
    <div  style="font-size: 20px; padding-top: 38px; margin-left: 20px; ">프로필사진  수정</div>
       <div style="width:180px; margin-left: 18px;"><hr></div>
    <div class="profileForm">
     <form action="/mypage/profile" method="post" enctype="multipart/form-data" class="profileForm">
      	<input type="hidden" name="userno" id="userno" value="${userno}">  
	  
		<div class="profileupload">
				<div class="imgbox">
					<c:if test="${empty profile}">
						<div>
							<img src="/resources/image/Default-Profile-Picture-PNG-Download-Image.png" class="img"> 
						</div>	
			        </c:if>
						
			        
			        <c:if test="${not empty profile}">
				        <div>
							<img src="<%=request.getContextPath() %>/userProfile/${profile.profileStoredName}" class="img"> 
						</div>	
			        </c:if>
				</div>	
				
				<div class="filebox">
				    <input class="upload-name" value="첨부파일" placeholder="첨부파일" disabled="disabled">
				    <label for="file">파일찾기</label> 
				    <input type="file" id="file" name="file">
				</div>
	     </div>  
	    
	    <div class="profilebtn">
	    	<div class="btnbox">
	    		<button id="profileInput" class="profileUpdatebtn">프로필 수정</button>
	    	</div>
	   
	    	<div class="btnbox">
	    		<a href="/mypage/main"><input type="button" class="profileUpdatebtn" value="취소"></a>
	    	</div>
	    </div>
	    	<div class="msgbox">
				<span id="msg" style="font-size: 17px;"></span>	
			</div>	
      </form>
	</div>	    
  </div>
  </div>  
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

$("#file").on('change',function(){
	  var fileName = $("#file").val();
	  $(".upload-name").val(fileName);
	});
	
$("#profileInput").click(function() {
	var file = $("#file").val();
	if(file==""){
		$("#msg").html("파일을 첨부해주세요");
		$("#msg").css("color","red");
		return false;
	}else{
		$("#msg").html("");
		$("#msg").css("color","red");
	}
})

</script>    
    
<c:import url="../layout/footer.jsp" />