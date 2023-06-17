<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../header.jsp"/>

<style type="text/css">

#titleContainers{
	height: 60px;
	margin: 0 auto;
	width: 1200px;
	text-align: center;
}
strong{
	padding-top: 30px;
	margin: 0 auto;
	font-size: 30px;
}

table{
	border-collapse: collapse;
	width: 1000px;
	margin: 0 auto;
}

tr, th, td{
	border-bottom: 1px solid gray;
	text-align: center;
}

#qnATable{
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

button{
	marg
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
			<a href="<%=request.getContextPath()%>/cs/qna/list">Q & A</a>
		</div>
		<!-- <span>공지사항</span> -->
		<!-- <span>이벤트</span> -->
		<!-- <span>Q / A</span> -->
	</div>
	<div class="right">
		<div id="titleContainers">
			<strong>Q&A 문의수정 페이지</strong>
			<hr>
		</div>	
		<div id="qnAWriteFormDiv">
			<form action="./revise" method="post">
				<input type="hidden" id="questionno" name="questionno" value="${qnADetail.QUESTIONNO}">
				<input type="hidden" id="curPage" name="curPage" value="${curPage}">
				<table>
					<tr>
						<th style="font-size: 30px; text-align: center" colspan="2">문의하기</th>
					</tr>
					<tr>
						<th><label for="isPublic">공개여부</label> </th>
						<th>
							<c:if test="${not empty qnADetail and qnADetail.IS_PUBLIC eq'public'}">
							<select id="isPublic" name="isPublic">
								<option value="public" selected="selected" style="width:500px; height:30px;">공개</option>
								<option value="private">비공개</option>
							</select>
							</c:if>
							<c:if test="${not empty qnADetail and qnADetail.IS_PUBLIC eq'private'}">
							<select id="isPublic" name="isPublic">
								<option value="public" style="width:500px; height:30px;">공개</option>
								<option value="private" selected="selected">비공개</option>
							</select>
							</c:if>
						</th>
					</tr>
					<tr>
						<th><label for="qTitle">문의제목</label></th>
						<th><input type="text" id="qTitle" name="qTitle" value="${qnADetail.Q_TITLE}" style="width:500px; height:30px;"></th>
					</tr>
					<tr>
						<th><label for="qContent">문의내용</label></th>
						<th><textarea id="qContent" name="qContent" style="width:500px; height:500px;resize: none">${qnADetail.Q_CONTENT}</textarea></th>
					</tr>
				</table>
				<div>
					<button>문의수정</button>
					<button type="button" onclick="location.href='./list?curPage=${curPage}'">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>

<c:import url="../../layout/footer.jsp"/>