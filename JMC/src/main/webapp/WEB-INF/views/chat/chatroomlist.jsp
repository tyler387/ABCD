<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function(){
	
	parent.backbuttonhide()
})
function back(){
	return;
}

</script>
<style type="text/css">
#listAll{
	width: 100%;
	height: 80px;
	border : 1px solid orange;
	text-align: center;
	margin-top: 15px;
	border-radius: 10px;
	
}
#listAll:hover{
border: 3px solid orange;
    border-radius: 10px;
}
}
html{
	width : 100%;
	height : 100%;
}
body{
	width : 95%;
	height : 90%;
}
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover {  color: black; text-decoration: none;}
 a{
     display: flex;
    /* padding: 30px; */
    overflow: hidden;
    justify-content: center;
    align-items: center;
    height: 100%;
}
 
</style>
</head>

<body>


	


<div class="chatList">
<c:choose>
<c:when test="${sessionScope.userId eq null}">
<a>로그인 후 이용 가능!!</a><br>
</c:when>
<c:when test="${sessionScope.userId ne null }">
<c:forEach var="list" items="${list }">
<div id="listAll">
<a href="./chatroom?chatno=${list.chatno }" id="chatRoom">${list.chatname }</a>
</div>
</c:forEach>
</c:when>
</c:choose>
</div>
</body>
</html>