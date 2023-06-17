<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

/*	페이지네이션 CSS */
.page{
	text-align: center;
	width: 50%;
	margin: 0 auto;
}

.pagination {
	list-style: none;
	display: inline-block;
	padding: 0;
	margin-top: 20px;
}

.pagination li {
	display: inline;
	text-align: center;
}

.pagination a{
	float: left;
	display: block;
	font-size: 14px;
	text-decoration: none;
	padding: 5px 12px;
	color: #96a0ad;
	line-height: 1.5;	
}

.first{
	margin-right: 15px;
}
.last{
	margin-left: 15px;
}

.first:hover, .last:hover, .leftP:hover, .rightP:hover, .leftList:hover, .rightList:hover{
	color: #2e9cdf;
}

.pagnation a:active{
	cursor: default;
	color: #fffff;
}

.pagnation a:active{
	outline: none;
}

.modal .num{
	margin-left: 3px;
	padding: 0;
	width: 30px;
	height:30px;
	line-height: 30px;
	-moz-border-radius: 20%;
	-webkit-border-radius: 20%;
	border-radius: 20%;
}

.modal .num.active, .modal .num:active{
	background-color: #91d1f7;
	cursor:pointer;
}

.arrow-leftList{
	width: 0;
	height: 0;
	border-top: 10px solid transparent;
	border-bottom: 10px solid transparent;
	border-right: 10px solid blue;
}
 
.arrow-leftP{
	width: 0;
	height: 0;
	border-top: 10px solid transparent;
	border-bottom: 10px solid transparent;
	border-right: 10px solid blue;
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
				<div id="pagingContainer">
				<c:import url="../paging.jsp"/>
				</div>
			</div>
		</div>
	</div>
</div>



<c:import url="../../layout/footer.jsp"/>