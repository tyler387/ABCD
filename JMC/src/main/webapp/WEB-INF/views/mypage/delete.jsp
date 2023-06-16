<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

  </div>
  
      <div class="right">
      <h1>회원탈퇴를 하면 서비스를 더이상 이용하실 수 없습니다.</h1>
      <h3>탈퇴를 진행하시겠습니까?</h3>
      <form action="/mypage/delete" method="post">
        <div class="userleave">
        	<div><input type="hidden" id="userno" name="userno" value="${user.userno}"></div>
			<div class="box1">
			
				<div class="labelbox"><label for="userId">아이디</label></div>
				
				<div class="box2">
					<input type="text" name="userId" id="userId">
				</div>	
				
				<div class="msgbox">
					<span id="id_msg" style="font-size: 17px;"></span>	
				</div>	
			</div>
			 
			
			<div class="box1">
			
				<div class="labelbox"><label for="userPw">현재 패스워드</label></div>	
				
				<div class="box2">
					<input type="password" name="userPw" id="userPw">
				</div>
				<div class="msgbox">
					<span id="pw_msg" style="font-size: 17px;"></span>	
				</div>	
				
			</div>
			
			
			<div class="box1">
			
				<div class="labelbox"><label for="userPw_chk">패스워드 확인</label></div>
				
				<div class="box2">
					<input type="password" name="userPw_chk" id="userPw_chk">
				</div>
				
				<div class="msgbox">
					<span id="pwchk_msg" style="font-size: 17px;"></span>	
				</div>	
				
			</div>
			        	
        	
        	
        	 <a href="/login/main"><button>회원탈퇴</button></a> 
        	
        	</div>
        	</form>
        	
        </div>
      </div>
  
  
  
  
    </div>

<c:import url="../layout/footer.jsp" />