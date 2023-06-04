<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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
</head>
<body>
<H1>신고 게시글 상세조회</H1>
<hr>
게시글 제목 및 게시글 내용<br>

<c:forEach var="report" items="${reportView }">
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
<br><Br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/mg/list"><button>유저수정 페이지</button></a>

</body>
</html>