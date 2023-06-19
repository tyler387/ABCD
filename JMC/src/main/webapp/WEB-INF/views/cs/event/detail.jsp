<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../header.jsp"/>

<style type="text/css">

table{
	border-collapse: collapse;
	width: 1000px;
	margin: 0 auto;
}

tr, th, td{
	border-bottom: 1px solid gray;
	text-align: center;
}

#eventDetailTable{
	padding-bottom: 100px;
}

div.main {
    padding-bottom: 90px;
      margin: 0 auto;
    width: 1800px;
    height: 750px;
}

div.left {   
   padding: 30px;
   float:left;
   width: 15%;
    display: inline-block;
   box-sizing: border-box;
   border: 1px solid #000;
   background-color: #efeeee;
   height: 800px;
}
 
div.right {
float:right;
    width: 80%;
        display: inline-block;
    box-sizing: border-box;    
     border-top-style: solid;
   border-bottom-style: solid;
      border-right-style: solid;
      border-left-style: solid;
     border-width: 1px;
     height: 800px;
}
div.title{
    font-size: 50px;
/*     float:left; */
   height: 120px;
}
</style>

<div class="main">
	<div class="left">
		<div class="title">
			<a href="<%=request.getContextPath()%>/cs/notice/list">공지사항</a>
		</div>
		<div class="title">
			<a href="<%=request.getContextPath()%>/cs/event/list">이벤트</a>
		</div>
		<div class="title">
			<a href="<%=request.getContextPath()%>/cs/qna/list">Q / A</a>
		</div>
		<!-- <span>공지사항</span> -->
		<!-- <span>이벤트</span> -->
		<!-- <span>Q / A</span> -->
	</div>
	<div class="right">		
		<div id="eventDetailContent">
			<div id="eventDetailTable">
				<table>
					<tr>
						<th>번호</th>
						<td>${eDetail.ADMIN_BOARDNO}</td>
						<th>작성자</th>
						<td>${eDetail.USER_NICK}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">${eDetail.TITLE}</td>
					</tr>
					<tr>
						<td colspan="4">${eDetail.CONTENT}</td>
					</tr>
				</table>
			</div>
		</div>
		<button onclick="history.go(-1)">이벤트 목록</button>
	</div>
</div>
<c:import url="../../layout/footer.jsp"/>