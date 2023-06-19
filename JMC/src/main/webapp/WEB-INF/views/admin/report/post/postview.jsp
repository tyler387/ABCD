<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div style ="width: 600px; margin: 0 auto; padding-top : 80px; ">

<c:forEach var="report" items="${reportView }">
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">제목 : ${report.TITLE }</label>
	  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  disabled readonly style="resize: none; height: 62px;">신고자 : ${report.USER_ID}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 신고자 아이디 : ${report.USER_NAME}&#010;작성일 : <fmt:formatDate value='${report.WRITE_DATE }' pattern ='yyyy-MM-dd' />  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;글번호 : ${report.REPORTNO }</textarea>
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">신고 게시글 및 유저 정보 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  신고 분류 : ${report.REPORT_OPTION }</label>
	  <div>신고글 주소 : <a href="asdsaadasdasdadsdsaadssaddsasad?boarno=${report.REPORTNO }">바로기기</a></div>
	  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  disabled readonly style="resize: none; height: 62px;">이름 : ${report.R_USER_NAME }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  아이디 : ${report.R_USER_ID }  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 유저 번호 : ${report.R_USERNO }
	  </textarea>
	</div>   
	<div class="mb-3">   
	  <label for="exampleFormControlTextarea1" class="form-label" >신고 내용</label>
	  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  disabled readonly style="resize: none;">${report.CONTENT}</textarea>
	</div> 
	</div>
	<div class="d-flex justify-content-between" style ="width: 400px; margin: 0 auto;">
		<div class="border">
			<a href="<%=request.getContextPath() %>/admin/report/post/boarddelete?boardno=${report.BOARDNO}"><button id="delete_btn"  class="btn btn-secondary">게시글 삭제</button></a>
		</div>
		<div class="border">
			<a href="<%=request.getContextPath() %>/admin/report/post/state?ruserno=${report.R_USERNO }&type=approval&reportno=${report.REPORTNO }"><button id="approval_btn"  class="btn btn-secondary">승인</button></a>
		</div>
		<div class="border">
			<a href="<%=request.getContextPath() %>/admin/report/post/state?reportno=${report.REPORTNO }&type=cancel"><button id="cancel_btn"  class="btn btn-secondary">반려</button></a>
		</div>
		<div class="border">
			<a href= "javascript:history.back();"><button  class="btn btn-secondary">취소</button></a>
		</div>
	</div>
</c:forEach>
 </div>


</body>
