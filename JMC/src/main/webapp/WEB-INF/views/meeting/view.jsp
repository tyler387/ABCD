<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../layout/header.jsp" />
<c:import url="../chat/chatbutton.jsp"></c:import>



<style>


.report{
  height: 30px;
  width: 30px;


}
.applicantnickbox {
  margin: 0 auto;
  height: 300px;
  width: 520px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgba(100, 100, 100, 0.16), 0 2px 17px 0 rgba(200, 200, 200, 0.2);
  overflow: scroll;
  background-color: #E2E2E2;
}

.applicantnickbox2 {
  margin: 0 auto;
  height: 300px;
  width: 520px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgba(100, 100, 100, 0.16), 0 2px 17px 0 rgba(200, 200, 200, 0.2);
  overflow: scroll;
  background-color: #E2E2E2;
}


.reportbtn{
 text-align: right;
 height: 20px;
 margin: 1%;
}

.btn-open-popup{
  text-align: right;
}

.btn-open-popup2{
  height: 50px;
  width: 300px;
  border-radius: 20px; 
  background: orange;
  color: #fff;
  text-align : center;
  position: absolute;
  top: 80%;
  left: 100;
  border: none;

}

.btn_join{
  height: 50px;
  width: 300px;
  border-radius: 20px; 
  background: orange;
  color: #fff;
  text-align : center;
  position: absolute;
  top: 60%;
  left: 100;

}

.btn_report{
  height: 50px;
  width: 300px;
  border-radius: 20px; 
  background: orange;
  color: #fff;
  text-align : center;
  position: absolute;
  top: 60%;
  left: 100;

}



.meetingviewall{
	display: inline block;
	width: 1200px;
	height: 1100px;
	margin: 0 auto;	
	z-index: 1000;
}

.meetinginfo{
	
	width: 600px;
	height: 400px;
	float: right;
}

.meetinginfo2{
	border-radius: 20px;
	box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
	position: relative;
	width: 500px;
	height: 300px;

}

.nicknamebox{
  width: 500px;

}

.nicknameboxleader{
  background-color:white;
  width:500px;
  height:150px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  margin-bottom: 50px;
  
  }

.nicknameboxapp{
  margin-bottom: 50px;
  background-color:white;
  width:500px;
  height:150px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  
  }

.modal {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	display: none;
	background-color: rgba(0, 0, 0, 0.4);
	z-index: 9999;
}

.modal.show {
	display: block;
}

.modal_body {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 400px;
	height: 600px;
	padding: 40px;
	text-align: center;
	background-color: rgb(255, 255, 255);
	border-radius: 10px;
	box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
	transform: translateX(-50%) translateY(-50%);
}

.modal2 {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	display: none;
	background-color: rgba(0, 0, 0, 0.4);
	z-index: 9999;
}

.modal2.show {
	display: block;
}

.modal_body2 {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 400px;
	height: 600px;
	padding: 40px;
	text-align: center;
	background-color: rgb(255, 255, 255);
	border-radius: 10px;
	box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
	transform: translateX(-50%) translateY(-50%);
}
</style>



<div class="modal">
	<div class="modal_body">
		<h1>신고하기</h1>

		<form id="report" action="/meeting/report" method="post">

			<input type="hidden" name="meetingno" id="meetingno"value=${viewmeeting.meetingno }>
			<div><label>게시글 제목<input type="text" readonly="readonly" name="rmTitle" id="rmTitle" value="${viewmeeting.mname }"></label></div>
			<div><label>게시글 내용<input type="text" readonly="readonly" name="rmContent" id="rmContent" value="${viewmeeting.introduce }"></label></div>
			<label>신고사항<textarea cols="50" rows="10" id="rmOption" name="rmOption"> </textarea></label>


			<button class="btn_report" onclick="fn_insert()">신고하기</button>

		</form>

	</div>
</div>

<div class="modal2">
  <div class="modal_body2">
    <h1>모임 신청</h1>
    <form id="join" action="/meeting/join" method="post">
	
		<h3><label>한줄 신청창</label></h3>
		<input type="hidden" name="meetingno" id="meetingno" value=${viewmeeting.meetingno }>
		<textarea cols="50" rows="10" id="applicantContent" name="applicantContent"> </textarea>                                 
		
		<button class="btn_join" onclick="fn_join()">모임 신청</button>
	
	</form>
    
  </div>
</div>


<h4>조회수:${viewmeeting.hit }</h4>

<div class= "reportbtn">
	<button class="btn-open-popup"><img src="../resources/image/report.jpg" alt="신고하기" class="report"></button>
</div>


<hr>

<div class= "meetingviewall">

<div class = "meetinginfo">


<h2>모집 정보</h2>

<div class = "meetinginfo2">
<table>
	<tr>
		<th>&emsp;<img src="https://www.greenlight.co.kr/pc/public/img/i_position1.png">&ensp;모임 위치</th>
		<td>${viewmeeting.loc1}</td>
	</tr>
	
	<tr>	
		<th>&emsp;<img src="https://www.greenlight.co.kr/pc/public/img/i_calendar1.png">&ensp;모임 일시</th>
		<td><fmt:formatDate value="${viewmeeting.meetingDate }" pattern="yyyy년MM월dd일 a h시mm분" type="date"/></td>
	</tr>
	<tr>	
		<th>&emsp;<img src="https://www.greenlight.co.kr/pc/public/img/i_users.png">&ensp;모집 인원</th>
		<td>${viewmeeting.headCount}</td>
	</tr>
	<tr>	
		<th><img src="https://www.greenlight.co.kr/pc/public/img/i_price.png">&ensp;참가비</th>
		<td>${viewmeeting.fee }원</td>
	</tr>
	<tr>	
		<th>&emsp;<img src="https://www.greenlight.co.kr/pc/public/img/i_descript.png">&ensp;모임 소개</th>
		<td>${viewmeeting.introduce }</td>
	</tr>
	<tr>		
		<th>&emsp;<img src="https://www.greenlight.co.kr/pc/public/img/i_tag.png" class="top-2">&ensp;추가 태그</th>
		<td>흡연 여부: 
			<c:if test="${viewpreference.smoke eq 'nomatter'}"> 무관</c:if>
			<c:if test="${viewpreference.smoke eq 'yes'}"> 흡연가능</c:if>
			<c:if test="${viewpreference.smoke eq 'no'}"> 흡연금지</c:if>
			
			동반자 여부:
			<c:if test="${viewpreference.friend eq 'nomatter'}"> 무관</c:if>
			<c:if test="${viewpreference.friend eq 'yes'}"> 동반자가능</c:if>
			<c:if test="${viewpreference.friend eq 'no'}"> 동반자금지</c:if>
	</tr>



</table>
	
	<button class="btn-open-popup2">모임 신청</button>

</div>


</div>



<div class="nicknamebox">

<h2>모집자</h2>
<div class=nicknameboxleader onclick="window.open('/meeting/applicant?userno=${applicantnick1.userno}&meetingno=${viewmeeting.meetingno}' )">
	<table>
		<tr>
			<th>닉네임</th>
		</tr>

		<tr>
			<td>${applicantnick1.userNick}</td>

		</tr>

	</table>

</div>


<h2 style ="display : inline">모집 인원 현황</h2>
총원 ${appcount}명 / 확정 인원 ${appcountcheck}명<br><br>

확정 인원 총${appcountcheck}명

<br><br>

<div class="applicantnickbox">

<c:forEach var="applicantnickagree" items="${applicantnickagree}">
	
	<div class="nicknameboxapp" onclick="window.open('/meeting/applicant?userno=${applicantnickagree.userno}&meetingno=${viewmeeting.meetingno}' )">
	
	
	<table>
		<tr>
			<th>닉네임</th>
		</tr>

		<tr>
			<td>${applicantnickagree.userNick}</td>

		</tr>

	</table>
	</div>
</c:forEach>
</div> <br><br>

신청 인원 총${appcountnocheck}명

<br><br>

<div class="applicantnickbox2">

<c:forEach var="applicantnicknocheck" items="${applicantnicknocheck }">
	

	
	<div class="nicknameboxapp" onclick="window.open('/meeting/applicant?userno=${applicantnicknocheck.userno}&meetingno=${viewmeeting.meetingno}' )">
	
	
	<table>
		<tr>
			<th>닉네임</th>
		</tr>

		<tr>
			<td>${applicantnicknocheck.userNick}</td>

		</tr>

	</table>
	</div>
</c:forEach>
</div>

 
</div>
</div>
<script>
      const body = document.querySelector('body');
      const modal = document.querySelector('.modal');
      const btnOpenPopup = document.querySelector('.btn-open-popup');
		
      btnOpenPopup.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
          body.style.overflow = 'hidden';
        }
      });

      modal.addEventListener('click', (event) => {
        if (event.target === modal) {
          modal.classList.toggle('show');

          if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
          }
        }
      });
      
      const bodyElement = document.querySelector('body');
      const modal2 = document.querySelector('.modal2');
      const btnOpenPopup2 = document.querySelector('.btn-open-popup2');

      btnOpenPopup2.addEventListener('click', () => {
        modal2.classList.toggle('show');

        if (modal2.classList.contains('show')) {
          bodyElement.style.overflow = 'hidden';
        }
      });

      modal2.addEventListener('click', (event) => {
        if (event.target === modal2) {
          modal2.classList.toggle('show');

          if (!modal2.classList.contains('show')) {
            bodyElement.style.overflow = 'auto';
          }
        }
      });
      
      function fn_insert(){
  		alert("신고가 완료되었습니다");	
  	}
      
</script>





<c:import url="../layout/footer.jsp" />
