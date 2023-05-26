<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>신고 게시글 상세조회</H1>
<hr>
게시글 제목 및 게시글 내용<br>

<c:forEach var="report" items="${userView }">
	신고자 : ${report.USER_ID } <br>
	신고자 아이디 : ${report.USER_NAME } <br>
	작성일 : ${report.WRITE_DATE } <br>
	신고글 제목 : ${report.TITLE } <br>
	피신고자 이름 : ${report.R_USER_ID }<br> 
	게시글 URL : <a href="asdsaadasdasdadsdsaadssaddsasad?boarno=${reprot.BOARDNO}">ㅁㄴㄴㅁㅇ</a><br>
	피신고자 아이디 : ${report.R_USER_NAME }<br> 
	신고분류 : ${report.REPORT_OPTION }<br>
	내용 : ${report.CONTENT} <br>
</c:forEach>
<br><Br><br>
<button>게시글 삭제</button>
<button>승인</button>
<button>반려</button>
<button>취소</button>

<a href="/jaManChw/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="/jaManChw/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="/jaManChw/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="/jaManChw/admin/user/mg/list"><button>유저수정 페이지</button></a>

</body>
</html>