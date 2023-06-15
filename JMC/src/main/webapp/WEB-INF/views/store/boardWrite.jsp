<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">

</style>

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
      
</script>   

</head>
<body>

<!-- 모달창 으로 띄웠을 때의 바디인 가봄 -->
<div class= "reportbtn">
	<button class="btn-open-popup">글쓰기</button>
</div>


<div class="modal">
	<div class="modal_body">
		<h1>신고하기</h1>

		<form id="report" action="/meeting/report" method="post">

			<input type="hidden" name="meetingno" id="meetingno"> 
			<label>게시글 제목<input type="text" readonly="readonly" name="rmTitle" id="rmTitle" ></label><br> 
			<label>게시글 내용<input type="text" readonly="readonly" name="rmContent" id="rmContent"> </label><br> 
			<label>신고사항<input type="text" name="rmOption" id="rmOption"></label>

			<button onclick="fn_insert()">신고하기</button>
			<!-- 이거는 모달창 띄운 상태에서 확인 버튼 같음 -->
		</form>

	</div>
</div>




</body>
</html>