<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

  </div>
      <div class="right">
        <div class='profile'>
		  	<div>
		  		<img src="/userProfile/${profileStoredName}">
		  	</div>
	  	</div>
	  	
	  		<div>
	  			<a href="/mypage/profile"><button>프로필 수정</button></a>
	  		</div>
	  		
	  		<div>
	  			<a href="/mypage/remove"><button>프로필 삭제</button></a>
	  		</div>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />