     <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript">
    
</script>
<style type="text/css">
#proId{
	width : 70px;
	height : 60px;
}
</style>
     
      <div id="tablesize">
        	<table>
  		<thead id="thead">
  		<tr>
  			<th>프로필</th>
  			<th>모임명</th>
  			<th>닉네임</th>
  			<th>자기소개</th>
  			<th>수락/거절</th>
 		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="map" items="${map}">
  			<tr>
				<c:choose>
					<c:when test="${map.PROFILE_STORED_NAME eq null}">
  					<td>
  					<img src="../resources/image/Default-Profile-Picture-PNG-Download-Image.png" id="proId" style="border-radius : 100%;">
  					</td>
					</c:when>
					<c:when test="${map.PROFILE_STORED_NAME ne null }">
					<td>
					<img src="<%=request.getContextPath()%>/userProfile/${map.PROFILE_STORED_NAME}" id="proId" style="border-radius : 100%;">
					</td>
					</c:when>
				</c:choose>
  				<td>${map.MNAME }</td>
  				<td>${map.USER_NICK }</td>
  				<td>${map.APPLICANT_CONTENT }</td>
  				<td>
  				<a href="./agree?userno=${map.USERNO }&agree=yes&meetingno=${map.MEETINGNO}" id="agreeY">수락</a>
  				<a href="./agree?userno=${map.USERNO }&agree=no&meetingno=${map.MEETINGNO}" id="agreeN">거절</a>
  				</td>
  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	</div>
    <div id="paging">
	<c:import url="../layout/meetingpaging.jsp"></c:import>
	</div>