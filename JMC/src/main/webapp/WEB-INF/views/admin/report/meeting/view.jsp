

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		모임 신고 상세조회
	</h1>
</div>
<hr>

<div  class="update" style ="width: 600px; margin: 0 auto;">

<c:forEach var="report" items="${meetingView }">
	신고자 : ${report.USER_ID } <br>
	신고자 아이디 : ${report.USER_NAME } <br>
	작성일 : ${report.WRITE_DATE } <br>
	신고글 제목 : ${report.TITLE } <br>
	피신고자 이름 : ${report.R_USER_ID }<br> 
	피신고자 아이디 : ${report.R_USER_NAME }<br> 
	신고분류 : ${report.REPORT_OPTION }<br>
	내용 : ${report.CONTENT} <br>
	
<br><Br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/state?userno=${report.USERNO}&type=approval&reportno=${report.REPORTNO}"><button id="approval_btn">승인</button></a>
<a href="<%=request.getContextPath() %>/admin/report/post/state?reportno=${report.REPORTNO}&type=cancel"><button id="cancel_btn">반려</button></a>
<button>취소</button>	
</c:forEach>

 </div>
</body>



</body>
















</body>
