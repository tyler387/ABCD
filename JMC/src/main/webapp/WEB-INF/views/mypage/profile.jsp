<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

  </div>
      <div class="right">
        <form action="/mypage/profile" method="post" enctype="multipart/form-data">
        
      
		<div class='profile'><img src="/userProfile/${profileStoredName}"></div>
	 
        
        <input type="file" id="file" name="file">
       <input type="hidden" name="userno" id="userno" value="${userno}">  
	    <button>프로필 수정</button>
<!--     	    <a href="/mypage/main"><button type="button">취소</button></a> -->
        </form>
      </div>
    </div>
<c:import url="../layout/footer.jsp" />