<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../layout/header.jsp" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>





<style type="text/css">



.meetingsearch {
  position: relative;	
  width: 300px;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

.filtercheck {
  height: 50px;
  width: 300px;
  border-radius: 20px; 
  background: orange;
  color: #fff;
  position: relative;
  text-align : center;
  top: 40%;
  left: 100;
  border: none;
  font-size: 20px;

}

.filtercheck:hover { 
	background-color: #ffcca8;

}



.join {

	margin-bottom: 25px;
}

.meetingbar {
	position: absolute;
	width: 800px;
	left: 65%;
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


 

.fc-highlight{
	border: solid red;

}

.meetingall{ 
 margin: 0 auto;
 display: flex; 
 flex-direction: row;
 align-items: flex-start;
 width: 1300px;
 height: 1000px;
 

}

.meetinglist{
  margin: 0 auto;
  overflow: scroll; 
  width: 400px;
  height: 850px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  background-color: #E2E2E2;

}

.meetingbox{
  background-color: white;
  width:380px;
  height:150px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  margin-bottom: 20px;
  font-size: 20px;
  text-align: center;
  }

.meetingbox:hover{
  background-color: beige;

}

.meetingcal{
  
  margin-right: 30px;
  height: 800px;
  width: 1000px;	
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  z-index: 1000;
}

.selectbtn{
  height: 100px;
  text-align: center;
}

.selectbtncal{
  font-family: '양진체';
  height: 50px;
  width: 300px;
  border-radius: 20px; 
  background: orange;
  color: #fff;
  border: none;
  font-size: 20px;
	
}

.selectbtncal:hover{
	background-color: #ffcca8;


}

.selectbtnmap:hover{
	background-color: #e2e2e2;
}

.selectbtnmap{
  font-family: '양진체';
  height: 50px;
  width: 300px;
  border-radius: 20px;
  background: gray;	
  color: #fff;
  border: none;
  font-size: 20px;
  cursor:pointer;
}

.fc-event-title-container{
	background-color: #967E76;
	border-color: #967E76;
}




</style>

<div id="modal" class="modal">
	<div class="modal_body">
		<h1>필터</h1>
		
		<div class="cost">
		요금
		<input type="radio" id="feeAll" name="fee" value="999999999999999999" checked>상관없음
		<input type="radio" id="fee100000" name="fee" value="100000" >10만원 미만
		<input type="radio" id="fee50000" name="fee" value="50000" >5만원 미만
		<input type="radio" id="fee30000" name="fee" value="30000" >3만원 미만
		</div>
		
		<div class="count">
		인원
		<input type="radio" id="countAll" name="headCount" value="999999999999999999" checked>상관없음
		<input type="radio" id="count10" name="headCount" value="10" >10명 미만
		<input type="radio" id="count7" name="headCount" value="7" >7명 미만
		<input type="radio" id="count5" name="headCount" value="5" >5명 미만
		</div>
		
		
		<button class="filtercheck" id="filterinput">확인</button>
		
	</div>
</div>


<div class="join">
<br><br>
<div class="selectbtn">
<button class="selectbtncal">캘린더</button>
<button class="selectbtnmap" onclick="location.href='/meeting/meetingmap'">지도</button><br>
</div>


<div class="meetingbar">
<a data-toggle="modal" data-target="#joinFilterModal" class="filter">
<img src="https://www.greenlight.co.kr/pc/public/img/i_filter.png" class="img2"> 필터</a>

<input type="text" class="meetingsearch" name="meetingsearch" id="meetingsearch" placeholder="검색어 입력"> 	

</div>

</div>


<div class= "meetingall">
<div class="meetingcal">

<div id='calendar'></div>

</div>

<div>
<h4>전체 : ${meetingcount}개 | 모집 중 ${meetingcountnow }개 </h4><br>
<div class="meetinglist1" style="flex: 1; width: 350px;">
<c:import url="/WEB-INF/views/meeting/meetinglist.jsp"/>
</div>
</div>
</div>





<script type="text/javascript">




const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const filter = document.querySelector('.filter');

filter.addEventListener('click', () => {
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


$(document).ready(function() {
	$("#filterinput").click(function() {
		console.log("#filter click")
		$.ajax({
			type: "get"
			, url: "/meeting/meetingfilter"
			, dateType: "html"
			, data: {fee : $('input[name="fee"]:checked').val() , headcount : $('input:radio[name="headCount"]:checked').val() }
			, success: function(filter) {
				console.log("통신성공");
				$(".meetinglist1").children().remove();
				$(".meetinglist1").append(filter);
			
				$(".modal").click()
			
			}, error: function(e){
				console.log(e)
			}
			
			})
			
		})
})







$(document).ready(function() {
	$("#meetingsearch").keypress(function(e) {
		if(e.keyCode && e.keyCode == 13){
			$("#meetingsearch").trigger("click");
		}
		console.log("#search click")
		$.ajax({
			type: "get"
			, url: "/meeting/meetingsearch"
			, dataType: "html"
			, data: {search : $("#meetingsearch").val()}
			, success: function(search) {
				console.log("통신성공");
				$(".meetinglist1").children().remove();
        		$(".meetinglist1").append(search)
			},error: function(e){
				console.log(e)
			}
			
			
		})
	})
	
	
})





document.addEventListener('DOMContentLoaded', function() {
// 	var size = ${meetinglist}.size();
// 	for( var i=0, result = []; i<size; i++){
// 		result.push({"title" :"${meetinglist}", "start":"2023-06-01"});
// 	}
	var today = new Date().toISOString().split("T")[0];


	var title = 0;
	var start = 0;
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
		headerToolbar : { // 헤더에 표시할 툴 바
			start : 'prev',
			center : 'title',
			end : 'next'
		},
		titleFormat : function(date) {
			return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
		},
		selectable : true, // 달력 일자 드래그 설정가능
		droppable : true,
		editable : true,
		nowIndicator: true, // 현재 시간 마크
		locale: 'ko', // 한국어 설정
		
		
		dateClick: function(info) {      //날짜 클릭하면 해당 일 출력
	         var string = info.date
	         year = string.getFullYear()
	         month = string.getMonth()+1
	         day = string.getDate()
	        
	         
	         //여기에 해당 일자 목록 불러오는 에이젝스..? 혹은 메소드 추가해야 함
	      
	        $.ajax({
	        	type: "get",
	        	url: "/meeting/meetinglist",
	        	datatype: "json",
	        	data : {data : year , data1 : month , data2 : day},
	        	success: function(data){
	        		console.log("통신성공");
	        		$(".meetinglist1").children().remove();
	        		$(".meetinglist1").append(data)
	        		
	        		
	        	}
	        })		 
	        
	      },//dateclick 
	
	      
	   events : [
		   
// 			title: '${meetinglist}',
// 			start: '2023-06-01'
		   
			   <c:forEach var="meet1" items="${meetinglist}"  >
			   {
			 
			   title : '"${meet1.mname}"' , start : '<fmt:formatDate value="${meet1.meetingDate }" pattern="yyyy-MM-dd" />'  
			   	
			   	
			   },
			   </c:forEach>
		   
		  
	   ],
	   validRange: {
		 start: today
	   
	   }
	}); //캘린더 설정
	calendar.render();
	
}); // 이벤트리스너  

</script>







<c:import url="../layout/footer.jsp" />