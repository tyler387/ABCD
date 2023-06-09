<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<c:import url="../layout/header.jsp" />




<style>




.btn-open-popup{
  text-align: right;
  position
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

}

.btn-join{
	text-align : center;
	position: absolute;
	top: 80%;
	left: 210;
}
.meetinginfo{
	position: relative;
	top: 3%;
	left: 70%;
}

.meetinginfo2{
	border-radius: 20px;
	border : 1px solid black;
	width: 500px;
	height: 300px;

}



.nicknameboxleader{
  background-color:#99ccff;
  width:250px;
  height:100px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  
  }

.nicknamebox{
  background-color:#99ccff;
  width:250px;
  height:100px;
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

			<input type="hidden" name="meetingno" id="meetingno"
				value=${viewmeeting.meetingno }> <label>게시글 제목<input
				type="text" readonly="readonly" name="rmTitle" id="rmTitle"
				value="${viewmeeting.mname }"></label><br> <label>게시글
				내용<input type="text" readonly="readonly" name="rmContent"
				id="rmContent" value="${viewmeeting.introduce }">
			</label><br> <label>신고사항<input type="text" name="rmOption"
				id="rmOption"></label>


			<button onclick="fn_insert()">신고하기</button>

		</form>

	</div>
</div>

<div class="modal2">
  <div class="modal_body2">
    <h1>모임 신청</h1>
    <form id="join" action="/meeting/join" method="post">
	
		<label>한줄 신청창</label>
		<input type="hidden" name="meetingno" id="meetingno" value=${viewmeeting.meetingno }>
		<input type="text" id="applicantContent" name="applicantContent">
	
	
		<button onclick="fn_join()">모임 신청</button>
	
	</form>
    
  </div>
</div>


<br><br>

<div>
	<button class="btn-open-popup">신고하기</button>
</div>



      
     


<!-- <script type="text/javascript"> -->

<!-- // 	function reportpopup() { -->
<%-- // 		var popUrl = "/meeting/report?mname=${viewmeeting.mname}&introduce=${viewmeeting.introduce}&meetingno=${viewmeeting.meetingno}" --%>
<!-- // 		var popOption = "top=10, left=10, width=300, height=100, status=no, menubar=no, toolbar=no, resizable=no"; -->
<!-- // 		window.open(popUrl,popOption); -->
<!-- // 	} -->

<!-- // 	function applicantpopup() { -->
<%-- // 		var popUrl1 = "/meeting/applicant?userno=${applicantview.userno}"; --%>
<!-- // 		var popOption1 = "top=10, left=10, width=300, height=100, status=no, menubar=no, toolbar=no, resizable=no"; -->
<!-- // 		window.open(popUrl1,popOption1); -->

<!-- // 	} -->

<!-- </script> -->


<!-- <a onclick="reportpopup();"><button>신고하기</button></a> -->

<hr>
<div class = "meetinginfo">


<h2>모집 정보</h2>

<div class = "meetinginfo2">
<table>
	<tr>
		<th>모임 위치</th>
		<td>${viewmeeting.loc1}</td>
	</tr>
	
	<tr>	
		<th>모임 일시</th>
		<td>${viewmeeting.meetingDate }</td>
	</tr>
	<tr>	
		<th>모집 인원</th>
		<td>${viewmeeting.headCount}</td>
	</tr>
	<tr>	
		<th>참가비</th>
		<td>${viewmeeting.fee }원</td>
	</tr>
	<tr>	
		<th>모임 소개</th>
		<td>${viewmeeting.introduce }</td>
	</tr>
	<tr>		
		<th>추가 태그</th>
	</tr>



</table>
	
	<button class="btn-open-popup2">모임 신청</button>

</div>


</div>


<%-- <a onclick="window.open('/meeting/join?meetingno=${viewmeeting.meetingno}')"> --%>
<!-- <button>모임 신청</button></a> -->


<h1>모집자</h1>
<div class=nicknameboxleader>
	<a onclick="window.open('/meeting/applicant?userno=${applicantnick1.userno}&meetingno=${viewmeeting.meetingno}' )">
	<table>
		<tr>
			<th>모집자 닉네임</th>
		</tr>

		<tr>
			<td>${applicantnick1.userNick}</td>

		</tr>

	</table>

</a>
</div>

<h1>참가자</h1>
<c:forEach var="applicantnick" items="${applicantnick }">
	
	<!-- <table onclick="applicantpopup();"> -->

	
	<div class=nicknamebox >
	<a onclick="window.open('/meeting/applicant?userno=${applicantnick.userno}&meetingno=${viewmeeting.meetingno}' )">
	
	
	<table>
		<tr>
			<th>참가자 닉네임</th>
		</tr>

		<tr>
			<td>${applicantnick.userNick}</td>

		</tr>

	</table>
	</a>
	</div>
</c:forEach>

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
