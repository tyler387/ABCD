<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="./main.jsp"/>

<style type="text/css">
#allInfo{
	width: 1500px;
	margin: 0 auto;
}

.topcontainer{ 
 	border: 1px solid black; 
 	height: 310px; 
} 

#iine1st{
	margin:0 auto;
	width: 1250px;
}

#line3nd{
	margin:0 auto;
	width: 1200px;
}

#joinUser, #writeBoard {
	vertical-align: text-bottom;
	margin: 0 auto;
}

#joinUser > div , #writeBoard > div {
	border: 1px solid black;
}

#joinUser{
	width: 1200px;
}

#writeBoard{
	width: 1200px;
}
#writeReport{
	width: 1210px;
    margin: 0 auto;
}

.reports{
	border: 1px solid black;
	width: 1200px;
	height: 310px;
	margin-bottom: 10px;
}

table {
	width: 900px;
	margin: 0 auto;
}

td, th{
	text-align: center;
	width
}


#todayBoards > table {
	width: 700px;
}

</style>
<div id="allInfo">
	<div id="iine1st">
		<div id="joinUser">
		<h4>오늘 가입한 유저</h4>
			<div class="topcontainer">
				<div id="cntUsers">
					가입한 유저 수:<span>${allInfoMap.todayJoinUsersCnt}</span>
				</div>
				<div id="todayJoinUser">
					<c:if test="${allInfoMap.todayJoinUsersCnt ne 0}">
					<table>
						<tr>
							<th >가입자 번호</th>
							<th>가입자 아이디</th>
							<th>가입자 이름</th>
							<th>가입자 성별</th>
							<th>가입 시간</th>
						</tr>
						<c:forEach var="userList" items="${allInfoMap.todayJoinUsers}"
							varStatus="data">
							<tr>
							<td>${userList.USERNO}</td>
							<td>${userList.USER_ID}</td>
							<td>${userList.USER_NAME}</td>
							<td>${userList.GENDER}</td>
							<fmt:parseDate value="${userList.JOIN_DATE}" pattern="yyyy-MM-dd HH:mm" var="logDate"/>
							<td><fmt:formatDate value="${logDate}" pattern="yyyy-MM-dd HH:mm"/></td>
							</tr>
						</c:forEach>
					</table>
					</c:if>
					<c:if test="${allInfoMap.todayJoinUsersCnt eq 0}">
						<h2 style="text-align: center;">오늘 가입한 사용자가 없습니다</h2>
					</c:if>
				</div>
			</div>
		</div>
		
		<div id="writeBoard">
		<h4>오늘 작성된 게시글</h4>
			<div class="topcontainer">
				<div id="cntBoards">
					생성된 게시글 수:<span>${allInfoMap.todayWriteBoardsCnt}</span>
				</div>
			
				<div id="todayBoards">
					<c:if test="${allInfoMap.todayWriteBoardsCnt ne 0}">
					<table>
						<tr>
							<th style="width: 10%;">글번호</th>
							<th style="width: 20%;">작성된 게시판</th>
							<th style="width: 20%;">작성자</th>
							<th style="width: 20%;">이름</th>
							<th style="width: 30%;">작성시간</th>
						</tr>
						<c:forEach var="boardList" items="${allInfoMap.todayWriteBoards}"
							varStatus="data">
							<tr>
							<td>${boardList.BOARDNO}</td>
							<td>${boardList.BOARD_TITLE}</td>
							<td>${boardList.USER_ID}</td>
							<td>${boardList.USER_NAME}</td>
							<td>${boardList.WRITE_DATE}</td>
							</tr>
						</c:forEach>
					</table>
					</c:if>
					<c:if test="${allInfoMap.todayWriteBoardsCnt eq 0}">
						<h2 style="text-align: center;">오늘 생성된 게시글이 없습니다</h2>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div id="writeReport">
	<h4>오늘 작성된 신고글</h4>
		<div class="reports">
			<div id="cntBoardReports">
				생성된 신고(게시글) 수:<span>${allInfoMap.todayWriteReportBoardsCnt}</span>
			</div>
			<div id="todayBoardReports">
				<c:if test="${allInfoMap.todayWriteReportBoardsCnt ne 0}">
				<table>
					<tr>
						<th>신고번호</th>
						<th>신고제목</th>
						<th>신고자ID</th>
						<th>신고자</th>
						<th>신고된 게시글번호</th>
						<th>피신고자ID</th>
						<th>피신고자</th>
						<th>신고시간</th>
						<th>처리상태</th>				
					</tr>
					<c:forEach var="BRList" items="${allInfoMap.todayWriteReportBoards}"
						varStatus="data">
						<tr>
						<td>${BRList.REPORTNO}</td>
						<td>${BRList.TITLE}</td>
						<td>${BRList.USER_ID}</td>
						<td>${BRList.USER_NAME}</td>
						<td>${BRList.BOARDNO}</td>
						<td>${BRList.USER_ID}</td>
						<td>${BRList.USER_NAME}</td>
						<td>${BRList.WRITE_DATE}</td>
						<td>${BRList.STATUS}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<c:if test="${allInfoMap.todayWriteReportBoardsCnt eq 0}">
					<h2 style="text-align: center;">오늘 신고된 게시글이 없습니다</h2>
				</c:if>
			</div>
		</div>
		<div class="reports">
			<div id="cntUserReports">
				생성된 신고(계정) 수:<span>${allInfoMap.todayWriteReportUsersCnt}</span>
			</div>
			<div id="todayUserReports">
				<c:if test="${allInfoMap.todayWriteReportUsersCnt ne 0}">
				<table>
					<tr>
						<th>신고번호</th>
						<th>신고제목</th>
						<th>신고자ID</th>
						<th>신고자</th>
						<th>피신고자ID</th>
						<th>피신고자</th>
						<th>신고시간</th>
						<th>처리상태</th>
					</tr>
					<c:forEach var="URList" items="${allInfoMap.todayWriteReportUsers}"
						varStatus="data">
						<tr>
						<td>${URList.REPORTNO}</td>
						<td>${URList.TITLE}</td>
						<td>${URList.USER_ID}</td>
						<td>${URList.USER_NAME}</td>
						<td>${URList.R_USER_ID}</td>
						<td>${URList.R_USER_NAME}</td>
						<td>${URList.WRITE_DATE}</td>
						<td>${URList.STATUS}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<c:if test="${allInfoMap.todayWriteReportUsersCnt eq 0}">
					<h2 style="text-align: center;">오늘 신고된 사용자가 없습니다</h2>
				</c:if>
			</div>
		</div>
		<div class="reports">
			<div id="cntMeetingReports">
				생성된 신고(모임) 수:<span>${allInfoMap.todayWriteReportMeetingsCnt}</span>
			</div>
			<div id="todayMeetingReports">
				<c:if test="${allInfoMap.todayWriteReportMeetingsCnt ne 0}">
				<table>
					<tr>
						<th>신고번호</th>
						<th>신고제목</th>
						<th>신고자ID</th>
						<th>신고자</th>
						<th>신고된 모임이름</th>
						<th>피신고자ID</th>
						<th>피신고자</th>
						<th>신고시간</th>
						<th>처리상태</th>
					</tr>
					<c:forEach var="MRList" items="${allInfoMap.todayWriteReportMeetings}"
						varStatus="data">
						<tr>
						<td>${MRList.REPORTNO}</td>
						<td>${MRList.TITLE}</td>
						<td>${MRList.USER_ID}</td>
						<td>${MRList.USER_NAME}</td>
						<td>${MRList.MNAME}</td>
						<td>${MRList.R_USER_ID}</td>
						<td>${MRList.R_USER_NAME}</td>
						<td>${MRList.WRITE_DATE}</td>
						<td>${MRList.STATUS}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<c:if test="${allInfoMap.todayWriteReportMeetingsCnt eq 0}">
					<h2 style="text-align: center;">오늘 신고된 모임이 없습니다</h2>
				</c:if>
			</div>
		</div>
	</div>
	
	<div id="line3nd">
		<div id="makeMeeting">
		<h4>오늘 생성된 모임</h4>
			<div class="topcontainer">
				<div id="cntMeeting">
					생성된 모임 수:<span>${allInfoMap.todayWriteMeetingsCnt}</span>
				</div>
				<div id="todayMakeMeetings">
					<c:if test="${allInfoMap.todayWriteMeetingsCnt ne 0}">
					<table>
						<tr>
							<th>모임번호</th>
							<th>모임제목</th>
							<th>호스트ID</th>
							<th>호스트이름</th>
							<th>모임등록시간</th>
						</tr>
						<c:forEach var="meetingList" items="${allInfoMap.todayWriteMeetings}"
							varStatus="data">
							<tr>
							<td>${meetingList.MEETINGNO}</td>
							<td>${meetingList.MNAME}</td>
							<td>${meetingList.USER_ID}</td>
							<td>${meetingList.USER_NAME}</td>
							<td>${meetingList.MAKE_DATE}</td>
							</tr>
						</c:forEach>
					</table>
					</c:if>
					<c:if test="${allInfoMap.todayWriteMeetingsCnt eq 0}">
						<h2 style="text-align: center;">오늘 생성된 모임이 없습니다</h2>
					</c:if>
				</div>
			</div>
		</div>
	</div>

<%-- 추가로 보여줄만한 것이 필요함... --%>
</div>


</div>
</div>
</body>
</html>