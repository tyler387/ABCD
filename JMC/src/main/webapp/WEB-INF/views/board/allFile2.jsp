<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<div id="right">
<div class="search">
  <input type="text" placeholder="검색어를 입력하세요">
  <img id="search2" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
</div>
<div id="write" class="write">
자유롭게 글을 작성하세요 <span>&#128196;</span><br><br>
</div>
<div id="write2">
<c:import url="./write.jsp" />
</div>



<div id="article">
	<img src='/upload/${map.STORED_NAME}'  class="boardDetailPic">
	<div  id ="content22" style="overflow-y:auto; width:300px; height:168px; word-break: break-all;">
	${map.CONTENT }
	</div>
	<div id="commLike">
	<c:import url="./coCountLikeCount.jsp"/>
	</div>
	
<div id="test2">
</div>
</div>

</div>






<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">

input {
  border: 1px solid #bbb;
  border-radius: 15px;
  padding: 10px 65px;
  font-size: 14px;
  position: relative;
  left: 0px;
  
}
.search{
	height: 45px;
}

#search2 {
  position : relative;
  width: 30px;
  bottom: 37px;
  left: 250px

}

#article{
	width: 300px;
	
	
}
#right{
	float : right;
	width : 606px;
	height : 606px;
	margin-right : 50px;

}

#write{

	border : 1px solid #ccc;
	width : 300px;
	border-radius: 15px;
	text-align: center;
    margin-top: 10px;
    padding-top: 20px;
 
	
}

.button{ 
 	padding-top: 10px;
 	cursor: pointer;
 }
 
#heartr{
	display: none;
}

</style>

<script type="text/javascript">
$(function(){
	
	$("#test2").css("display","none")
	

	
	//.button 가 클릭 됐을 때 console로 찍어보기
	$(".button").click(function(){
	
		    console.log("#ajax cContent click")
		    var boardno = "${map.BOARDNO}"	//담아갈 값
		    								//댓글리스트와 //글쓰기 창을
		    								//여기에 넣으면 됨!boardno는 덧글 때문에 보내야 함
		    console.log(boardno)			//클릭 했을 때의 boardno 값
		    
			console.log($("#test2").css("display"))	//클릭 했을 때의 css("display")상태, none or block

		     $.ajax({
		         type: "get"
		         , url: "/board/commentList"
		         , data: {boardno : boardno}
		         , dataType: "html"
		         , success: function(res){
		            console.log("AJAX 성공")
		          	 console.log(res)
		            $("#test2").children().remove()
		            $("#test2").append(res)
		          //#test2는 클릭을 해야지만 나오는 녀석
		          //클릭 후 값은 res로 append한다
		          //글쓰기를 하려면 글쓰기 JSP만들고
		          //걔를 res로 받아야 한다.
		         }
		         , error: function(){
		            console.log("AJAX 실패")   
		         }
		      })//END AJAX
		      /* AJAX종료 후 발동 */
				if($("#test2").css("display")=="none"){
					$("#test2").show()
					
				}else{
					$("#test2").hide()
				}
	})
	
	
	//글쓰기 버튼을 눌렀을 때, 글 쓰기 페이지 띄우는 AJAX
	$("#write2").css("display","none")
	$("#write").click(function(){
		
		$("#write2").show()
		$("#write").hide()
		console.log("글 쓰기 버튼 자알 눌림")
		var boardOptionno =  ${map.BOARD_OPTIONNO}
		console.log("옵션 번호 가지고 와?", boardOptionno)
		
		 $.ajax({
		         type: "get"
		         , url: "/board/write"
		         , data: {boardOptionno : boardOptionno}
		         , dataType: "html"
		         , success: function(res){
		            console.log("AJAX 성공")
		         }
		         , error: function(){
		            console.log("AJAX 실패")   
		         }
	})
})
	
	//좋아요 누르면 하트색깔 바꾸고, 좋아요 카운트 수 올리기
	$(".like").click(function(){
		
		console.log("#ajax like click")
		var boardno = "${map.BOARDNO}"
		console.log(boardno)
		
		$("#heartw").hide()
		$("#heartr").show()
		
		  $.ajax({
		         type: "get"
		         , url: "/board/boardReco"
		         , data: {boardno : boardno}
		         , dataType: "html"
		         , success: function(res){
		            console.log("AJAX 성공")
		          //  console.log(res)
		           // $("#test2").children().remove()
		           // $("#test2").append(res)
		          
		         }
		         , error: function(){
		            console.log("AJAX 실패")   
		         }
		      })//END AJAX
		      /* AJAX종료 후 발동 */
// 				if($("#test2").css("display")=="none"){
// 					$("#test2").show()
					
// 				}else{
// 					$("#test2").hide()
// 				}
	})
		

})
</script>
