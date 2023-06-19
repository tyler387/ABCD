<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <style type="text/css">
      
        #temodal-overlay{
            width: 100%;
            height: 100%;
          
            left: 0;
            top: 0;
            display: none;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);

			  position: fixed;
			  top: 50%;
			  left: 50%;
			  transform: translate(-50%, -50%);

        }
       
        #temodal-window {
            background: #FFA500;
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 320px;
            height: 400px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        
        #tetitle {
            padding-left: 10px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        
        #temodal-overlay.tetitle h2 {
            display: inline;
        }
       
        #temodal-overlay.teclose-area {
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #temodal-overlay.tecontent {
            margin-top: 20px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #temodaldivt{
        	margin-bottom: 15px;
        	
        }
       
        #temodalbutton{
        	margin-top: 20px;
   			margin-left: 230px;
   			border: 2px solid white;
			background-color: rgba(0, 0, 0, 0);
			color: white;
			font-size: 25px;
			border-top-left-radius: 5px;
			border-bottom-left-radius: 5px;
			border-top-right-radius: 5px;
			border-bottom-right-radius: 5px;
			cursor: pointer;
        }
    </style>
<style type="text/css">

table {
		width: 1020px;
}
thead {
	
    height: 100px;
}

#status{
	text-align: center;
}
#trWriter{
	text-align: center;
}
#trdate{
	text-align: center;
}

 table {
    width: 1020px;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 3px solid #444444;
  }
td{
	cursor: pointer;
}


</style>


<body>
<div id="qnaBoard" style="padding-left: 450px; padding-bottom: 60px;">
<table>
<thead>
	<tr>
		<th style="width: 15%;">답변상태</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 25%;">작성일</th>
	</tr>
</thead>

<c:forEach var="itemQnAQList" items="${itemQnAQList }">
<tr id="answer">

		<c:choose>
			<c:when test="${itemQnAQList.IQ_STATUS eq 'unprocessed'}">
				<td style="width: 15%;" id="status">답변대기</td>	
			</c:when>
			<c:when test="${itemQnAQList.IQ_STATUS eq 'done'}">
				<td style="width: 15%;" id="status">답변완료</td>
			</c:when>
		</c:choose>	
		<td style="width: 45%;" id="trcontent" data-userno ="${itemQnAQList.USERNO }" data-qnano="${itemQnAQList.ITEM_QNANO }">${itemQnAQList.IQ_TITLE }</td>
		<td style="width: 15%;" id="trWriter">${itemQnAQList.USER_ID }</td>
		<td style="width: 25%;" id="trdate"><fmt:formatDate value="${itemQnAQList.IQ_WRITE_DATE}" pattern="yyyy.MM.dd HH:mm"/></td>

</tr>
</c:forEach>

</table>
<!-- 	 <input type="button" value="문의하기" onclick="showPopup();" /> -->
	<div class= "qnabtn" style="padding-top: 30px; padding-left: 850px;">
		<c:import url="../store/boardWrite2.jsp" />
	</div>

</div>
<body>
<div id="temodal-overlay" class="temodal-overlay">
    <div class="temodal-window">
        <div class="tetitle">
            <h2>답변입니다.</h2>
        </div>
        <div class="teclose-area">X</div>
      
        <div class="tecontent"> 
          <div id="temodaldivt" style="margin-bottom:5px;">${map.IQ_TITLE}</div>
         <div id="modalContentDiv"></div>
          <div id="temodaldivc" style="margin-bottom:5px;">${map.IQ_CONTENT}</div>

          <button class="teclose-area" id="temodalbutton" onclick="confirm">확인</button>
   
        </div>
<!--         </form> -->
    </div>
</div>

<script type="text/javascript">

var userno = null;
var item_qnano = null;


$(document).on("click", "#trcontent", function() {
	console.log("td 버튼 클릭됨")
	userno = $(this).attr("data-userno");
	item_qnano = $(this).attr("data-qnano");
	console.log(userno);
	console.log(item_qnano);
	var te = document.getElementById("temodal-overlay")
	$.ajax({
         type: "GET"
         , url: "/store/answer"
         , data: {userno : userno
        	 	, itemQnano : item_qnano}
         , dataType: "json"
         , success: function(res){
        	 console.log(res.IA_CONTENT)
            console.log("AJAX 성공")
            te.style.display = "flex"
            $("#modalContentDiv").text(res.IA_CONTENT)             
            
         }
         , error: function(){
            console.log("AJAX 실패")   
         }
      })
          //X(클로즈) 버튼에 위 예제와 반대되는 이벤트를 부여합니다.
    const closeBtn = te.querySelector(".teclose-area")
	closeBtn.addEventListener("click", e => {
    te.style.display = "none"
	})
    
    //모달창 바깥 영역을 클릭하면 모달창이 꺼지게 하기
    te.addEventListener("click", e => {
    const evTarget = e.target
	    if(evTarget.classList.contains("modal-overlay")) {
	        te.style.display = "none"
	    }
	})
	
})






</script>
