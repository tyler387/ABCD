<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../layout/mypageAside.jsp" />
<style type="text/css">


</style>


  </div>
      <div class="right">
      <c:forEach var="map" items="${map}">
		<div id="applicantAll">
		<div id="meetingName">
		${map.MNAME }
		</div>
		<div id="applicantUserNick">
		${map.USER_NICK }
		</div>
		<div id="applicantContent">
		${map.APPLICANT_CONTENT }
		</div>
		<div id="agreeY">
		<a href="./agree?userno=${map.USERNO }&agree=yes&meetingno=${map.MEETINGNO}">수락</a>
		</div>
		<div id="agreeN">
		<a href="./agree?userno=${map.USERNO }&agree=no&meetingno=${map.MEETINGNO}">거절</a>
		</div>
		</div>
	</c:forEach>	
      </div>
    </div>

<c:import url="../layout/footer.jsp" />