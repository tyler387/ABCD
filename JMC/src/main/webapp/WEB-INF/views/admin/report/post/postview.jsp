
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<script type="text/javascript">
$(function() {
$("#approval_btn").click(function(){
		console.log("ㄴ버튼 눌림");
    if(confirm("정말 승인하겠습니까 ?") == true){
        alert("승인되었습니다");
    }
    else{
        return ;
    }
	});
$("#cancel_btn").click(function(){
		console.log("ㄴ버튼 눌림");
    if(confirm("정말 반려하겠습니까 ?") == true){
        alert("반려되었습니다");
    }
    else{
        return ;
    }
	});
$("#delete_btn").click(function(){
		console.log("ㄴ버튼 눌림");
    if(confirm("게시글 삭제하겠습니까 ?") == true){
        alert("삭제되었습니다");
    }
    else{
        return ;
    }
	});
});
</script>

<c:import url="../../main.jsp"></c:import>


<body>
<div id="Alltitle" style="text-align: center; padding-top: 10px;">
	<h1  style="margin: 0 auto;border-radius: 30px; background-color : #03a9f46e; width: 600px;  text-align: center; padding-bottom: 5px;">
		신고 게시글 상세조회
	</h1>
</div>
<hr>

<div  class="update" style ="width: 600px; margin: 0 auto;">

<c:forEach var="report" items="${reportView }">

<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">제목 : ${report.TITLE }</label>
  <input type="text" class="form-control" id="exampleFormControlInput1" 
  value="신고자 : ${report.USER_ID} 신고자 아이디 : ${report.USER_NAME}
   작성일 : <fmt:formatDate value='${report.WRITE_DATE }' pattern ='yyyy-MM-dd' /> 글번호 : ${report.REPORTNO }" disabled readonly>
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Email address</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
</div> 
<div class="mb-3"> 
  <label for="exampleFormControlTextarea1" class="form-label">신고 게시글 및 유저 정보 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  신고 분류 : ${report.REPORT_OPTION }</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div> 
${reprot.REPORTNO }${reprot.REPORTNO }${empty reprot.REPORTNO }
	신고자 : ${report.USER_ID } <br>
	신고자 아이디 : ${report.USER_NAME } <br>
	작성일 : ${report.WRITE_DATE } <br>
	신고글 제목 : ${report.TITLE } <br>
	피신고자 이름 : ${report.R_USER_ID }<br> 
	게시글 : <a href="asdsaadasdasdadsdsaadssaddsasad?boarno=${reprot.BOARDNO}"><button>바로가기</button></a><br>
	피신고자 아이디 : ${report.R_USER_NAME }<br> 
	신고분류 : ${report.REPORT_OPTION }<br>
	내용 : ${report.CONTENT} <br>

<br><Br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/boarddelete?boardno=${report.BOARDNO}"><button id="delete_btn">게시글 삭제</button></a>
<a href="<%=request.getContextPath() %>/admin/report/post/state?userno=${report.USERNO}&type=approval&reportno=${report.REPORTNO}"><button id="approval_btn">승인</button></a>
<a href="<%=request.getContextPath() %>/admin/report/post/state?reportno=${report.REPORTNO}&type=cancel"><button id="cancel_btn">반려</button></a>
<button>취소</button>	
</c:forEach>

 </div>
</body>



</body>
