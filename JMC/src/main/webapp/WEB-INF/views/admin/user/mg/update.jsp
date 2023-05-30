<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:import url="../../main.jsp"></c:import>

<body>
<H1>유저 수정 페이지</H1>
<hr>

<div  class="update" style ="width: 600px; margin: 0 auto;">
<form action="./update" method="Post">
<div class="input-group mb-3" style="margin-top: 70px;">
  <span class="input-group-text" id="basic-addon1">이름</span>
  <input type="text" class="form-control" placeholder="${users.userName }" aria-label="Username" aria-describedby="basic-addon1"  name="userName">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">닉네임</span>
  <input type="text" class="form-control" placeholder="${users.userNick }" aria-label="Username" aria-describedby="basic-addon1" name="userNick">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">이메일</span>
  <input type="text" class="form-control" placeholder="${users.email }" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">폰번호</span>
  <input type="text" class="form-control" placeholder="${users.phone }" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">주소1</span>
  <input type="text" class="form-control" placeholder="${users.addr1 }" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">주소2</span>
  <input type="text" class="form-control" placeholder="${users.addr2 }" aria-label="Username" aria-describedby="basic-addon1">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">주소3</span>
  <input type="text" class="form-control" placeholder="${users.addr3 }" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">가입날짜</span>
  <input type="text" class="form-control" placeholder="${users.joinDate }" aria-label="Username" aria-describedby="basic-addon1">
</div>


<button  class="btn btn-secondary" style ="width: 600px;">수정 완료</button>
</form>
<br>
<button  class="btn btn-secondary" style ="width: 600px;">실패</button>
 </div>
</body>
