<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>유저 수정 페이지</H1>
<hr>
<form action="./update" method="Post">
이름 : <input type="text" name="userName" placeholder="${users.userName }"><br>
닉네임 : <input type="text" name="userNick" placeholder="${users.userNick }"><br>
성별 : <input type="text" name="gender" placeholder="${users.gender }"><br><br>
<button>수정 완료</button>
</form>
<button>실패</button>

<br><br><br>
<a href="<%=request.getContextPath() %>/admin/report/post/list"><button>신고 게시글 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/report/user/list"><button>신고 계정 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/black/list"><button>블랙리스트 페이지</button></a>
<a href="<%=request.getContextPath() %>/admin/user/mg/list"><button>유저수정 페이지</button></a>
</body>
</html>