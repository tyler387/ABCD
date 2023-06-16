<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../layout/header.jsp"/>
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

#noticeTable{
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
      <div class="title"><a href="<%=request.getContextPath()%>/cs/notice/list">공지사항</a></div>
      <div class="title"><a href="<%=request.getContextPath()%>/cs/event/list">이벤트</a></div>
      <div class="title"><a href="<%=request.getContextPath()%>/cs/qna/list">Q / A</a></div>
   <!-- <span>공지사항</span> -->
   <!-- <span>이벤트</span> -->
   <!-- <span>Q / A</span> -->
   </div>
	<div class="right">
		<div id="noiceContent">
			<div id="noticeTable">
				<table>
					<thead>
						<tr>
							<th style="width: 10%">번호</th>
							<th style="width: 50%">공지사항 제목</th>
							<th style="width: 20%">작성자</th>
							<th style="width: 20%">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="nl" items="${nList}">
							<tr>
								<td>${nl.ADMIN_BOARDNO}</td>
								<td><a
									href="./detail?adminBoardno=${nl.ADMIN_BOARDNO}&curPage=${paging.curPage}">${nl.TITLE}</a></td>
								<td>${nl.USER_NICK}</td>
								<td><fmt:formatDate value="${nl.WRITE_DATE}"
										pattern="yyyy.MM.dd HH:mm" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<c:import url="../../layout/footer.jsp"/>