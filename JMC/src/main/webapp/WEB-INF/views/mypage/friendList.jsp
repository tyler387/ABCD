<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />

  </div>
      <div class="right">
        <div><h1>친구 목록</h1></div>
        <div style="width:150px;"><hr></div>
        <div>총 친구 수</div>
        
        <form name="friendFind" autocomplete="off">
         <div>
        	<select name="type">
        		<option value="userId">아이디</option>
        		<option value="userNick">닉네임</option>
        	</select>
        </div>
        <div>
        	<input type="text" name="keyword" value="">
        </div>
        
        <div>
        	<button>검색</button>
        </div>
        
        </form>
      </div>
    </div>

<c:import url="../layout/footer.jsp" />