<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

  </div>
      <div class="right">
        <form action="" method="post" enctype="multipart/form-data">
        
        <div class='profile'>
		  	<div>
		  		<img src="#">
		  	</div>
	  	</div>
        
        <input type="file" id="profile" name="profile">
        
        <div>
	        <a href="#"><button>업로드</button></a>
    	    <a href="#"><button>취소</button></a>
        </div>
        </form>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />