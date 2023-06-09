<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../layout/header.jsp" />
<c:import url="../chat/chatbutton.jsp"></c:import>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a27b174f52c385cc5f77f0b961a3735b&libraries=services,clusterer,drawing"></script>


<style type="text/css">


.meetingbar {

	width: 1550px;
	text-align: right;

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
 flext-direction: column;
 align-items: flex-start;
 width: 1300px;
 height: 1000px;
 

}

.meetinglist{
  margin: 0 auto;
  overflow: scroll; 
  width: 310px;
  height: 850px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
}

.skyblue{
  background-color:#99ccff;
  width:300px;
  height:150px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
  
  }

.meetingmap{
  height: 800px;
  width: 1000px;	
  margin-right: 30px;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgb(100 100 100 / 16%), 0 2px 17px 0 rgb(200 200 200 / 20%);
}

.selectbtn{
  height: 100px;
  text-align: center;
}

.selectbtncal{
  height: 50px;
  width: 300px;
  border-radius: 20px;
  background: orange;
  color: #fff;
	
}
.selectbtnmap{
  height: 50px;
  width: 300px;
  border-radius: 20px;
  background: gray;	
  color: #fff;
}

.fc-event-title-container{
	background-color: skyblue;
}


</style>	
	
	<div id="modal" class="modal">
	<div class="modal_body">
		<h1>필터</h1>
		
		요금
		<input type="radio" id="feeAll" name="fee" value="999999999999999999" checked>상관없음
		<input type="radio" id="fee100000" name="fee" value="100000" >10만원 미만
		<input type="radio" id="fee50000" name="fee" value="50000" >5만원 미만
		<input type="radio" id="fee30000" name="fee" value="30000" >3만원 미만
		<br>
		인원
		<input type="radio" id="countAll" name="headCount" value="999999999999999999" checked>상관없음
		<input type="radio" id="count10" name="headCount" value="10" >10명 미만
		<input type="radio" id="count7" name="headCount" value="7" >7명 미만
		<input type="radio" id="count5" name="headCount" value="5" >5명 미만
		
		<br>
		<br>
		<br>
		<button id="filterinput">확인</button>
		
	</div>
</div>
	
	
	<div class="selectbtn">
		<button class="selectbtncal" onclick="location.href='/meeting/meetingcal'">캘린더</button>
		<button class="selectbtnmap">지도</button><br>
	</div>

<div class="meetingbar">
<button class="filter">필터</button>
<input type="text" name="meetingsearch" id="meetingsearch"> <button id="search">검색</button>		
</div><br>
	
	<div class= "meetingall">
		<div class= "meetingmap" id="map" style="width:1000px;height:800px;"></div>
	





	

	
	<div>	
	<h4>전체 : ${meetingcount}개 / 현재: ${meetingcountnow }개 모집 중</h4><br>
	<div class="meetinglist1">
		<c:import url="/WEB-INF/views/meeting/meetinglist.jsp"/>
	</div>
</div>

<script>

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
	$("#search").click(function() {
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


		var map = new kakao.maps.Map(document.getElementById('map'), { //지도를 표시할 div 
			center: new kakao.maps.LatLng(37.497, 127.0254), //지도의 중심좌표
			level: 12
		});
		

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		var listData = [
		
			<c:forEach var="meet1" items="${meetinglist}" >
			   {
				   groupAddress: '"${meet1.loc1}"'  
			   },
			   </c:forEach>
		];
		
		
		var clusterer = new kakao.maps.MarkerClusterer({
			map: map,
			averageCenter: true, 
			minLevel: 10
		})
		
		
		for(let i=0; i< listData.length ; i++) {
			
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(listData[i].groupAddress, function(result, status) {
			console.log("i3" + i)
			var coords;

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
				console.log("!!!!!!!!!!!!!"+result[0].road_address)
				var json = JSON.stringify(result[0].road_address.address_name)
				var json1 = JSON.stringify(result[0].address.address_name)
				console.log("!@!@!@!@"+json)
		        coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		       
		        // 결과값으로 받은 위치를 마커로 표시합니다
		         var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
				
		        
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
// 		        var infowindow = new kakao.maps.InfoWindow({
// 		            content: '<div style="width:150px;text-align:center;padding:6px 0;">모임 위치</div>'
// 		        });
// 		        infowindow.open(map, marker);

		        
		    } // if문 종료 
		   
				clusterer.addMarker(marker);
	       
	        	
		    
		    
			kakao.maps.event.addListener(marker, 'click', function() {
				console.log("!@!@!@!@"+json)
			        $.ajax({
			              type: "get"
			            , url: "/meeting/meetingmapajax"
			            , data: { mapData : json , mapData1 : json1 }
			        	, dataType: "html"
			        	, success: function (mapData){
			                console.log("성공!")
			                $(".meetinglist1").children().remove();
							$(".meetinglist1").append(mapData);
							},
							error: function (){
			                console.log("오류")
			            }
			        })
			    });
	

			}) //주소로 좌표 검색 종료     
		
		
		
		
	
		
	};
	
	
	
	</script>






<c:import url="../layout/footer.jsp" />