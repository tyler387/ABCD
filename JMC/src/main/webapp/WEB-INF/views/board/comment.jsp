<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:choose>
<c:when test="${sessionScope.userId eq null}">
<div id="noncComment">
로그인 후 덧글을 작성할 수 있습니다.<br><br>
</div>
</c:when> 

<c:when test="${sessionScope.userId ne null }">  
<div id="cComment">
<div><input type="text" id="commentWrite" name="cContent" placeholder="덧글을 작성하세요" style="display:inline-block; margin-bottom:5px; padding: 10px 62px;" ></div>
<button id="btnWrite" style="margin-top:5px; margin-left: 260px">등록</button><br>

</c:when>
</c:choose>   



<div id="commentList">

<div id="commentContent" >
<c:forEach var="list" items="${list}" varStatus="status" >

<input type="hidden" value="${list.commentno }">

${list.commentno}.<div id="cContent${list.commentno}"> ${list.cContent }</div>
<c:choose>
 <c:when test="${sessionScope.userno eq list.userno}">
<button class="cDelete" data-commentno="${list.commentno}" data-contentno="${list.commentno}" data-boardno="${list.boardno}">삭제</button>

<!-- 작성하는 것1111 -->

<button class="cContent" data-commentno="${list.commentno}" data-contentno="${list.commentno}" data-boardno="${list.boardno}">수정</button>

<button class="confirm" data-commentno="${list.commentno}" data-contentno="${list.commentno}" >확인</button><br>
</c:when>
</c:choose>   
<!-- 작성하는 것2222 1은1 2는2의 짝꿍 -->
<%-- <button class="cContent" onclick="func(${list.commentno})" >수정</button><br> --%>

</c:forEach>
</div>

</div>
</div>

 
 <style type="text/css">
#cComment{
	position: absolute;
	margin-left: 0px;
	margin-top: 0px;
	
}

#commentContent{

 width:310px;
 height:290px;
 margin: 0px;
 overflow: auto;
}

.cContent{
	text-align: rigth;
	padding: 1px 1px;
	 text-align: center;
	 font-size: 3px;
	 float: right;
}

#noncComment{
	border : 1px solid #ccc;
	width : 300px;
	border-radius: 15px;
	text-align: center;
    margin-top: 10px;
    padding-top: 20px;
}

.confirm{
	text-align: rigth;
	padding: 1px 1px;
	 text-align: center;
	 font-size: 3px;
	 float: right;
	display: none;
}
.cDelete{
	text-align: rigth;
	padding: 1px 1px;
	 text-align: center;
	 font-size: 3px;
	 float: right;
}
</style>

<script type="text/javascript">

//댓글 작성 관련 AJax
$(function(){
	
	//댓글 작성 후 엔터키로 해도 작동 시키기
	$("#commentWrite").keydown(function(e) {
		if(e.keyCode == 13){
			$("#btnWrite").click();
		}
	})

	
	//마우스로 클릭했을 때 작동 시키기
	//"#btnWrite"태그가 클릭되었을 때의 함수!
	$("#btnWrite").click(function(){
		console.log("#ajax commentWrite click")
// 		console.log(${map.BOARDNO})
// 	 var data = {cContent : $('#commentWrite').val()}
	var data = $('#commentWrite').val()
		 console.log("data: ", data)
	var boardno = ${boardno}
		console.log("boardno :", boardno)

	//	date,DTO에 있는 data와
	//	boardno DTO에 있는 boarno이름 맞춰서 쓰고
		//controller에서 받아보기


		      $.ajax({
			         type: "post"
			         , url: "./commentWrite"
			         , data: {data : data, boardno : boardno}
			         , dataType: "html"
			         , success: function(res){
			            console.log("AJAX 성공")
			            //console.log(res)
			            $("#test2").children().remove()
			            $("#test2").append(res)
			            
			            $.ajax({
							type: "get"
							, url: "./coCountLikeCount"
							, data: {boardno:boardno}
							, dataType: "html"
							, success: function(res){
								console.log("AJAX 성공")
								//console.log(res)
								$("#commLike").html(res);		
							}
							, error: function(){
								console.log("AJAX 실패")   
							}

						})	
			         }
			         , error: function(){
			            console.log("AJAX 실패")   
			         }
			      })//END AJAX
			      /* AJAX종료 후 발동 */
			      /* 한 번 클릭시 댓글창 열림 
			      	재 클릭시 댓글창 닫힘*/
// 					if($("#test2").css("display")=="none"){
// 						$("#test2").show()
// 					}else{
// 						$("#test2").hide()
// 					}
				

	})
	
	
	//1. 수정 버튼을 클릭했을 때 
	//	기존의 값 + input창 띄우긴
	//댓글 commentno을 가지고 오기 위한 것!!
	//for each 돌기 전에 미리 예약어로
	//자식에 대해서 이런 이벤트를 걸어달라라고 작성하는 것 11111
	//+추가로 댓글 내용도 input창에 넣음
	$("#commentList").on("click", ".cContent",function() {
		var commentno = $(this).attr("data-commentno");
			console.log(commentno)

		var contentno = $(this).attr("data-contentno");
			console.log(contentno)

		var contentVal = $("#cContent"+contentno).html();
			console.log(contentVal)
		
		$(".confirm").show()
		$(".cContent").hide()
		$("#cContent"+contentno).html("<input type='text' value='" + contentVal + "'>")

		

	})

	// 2. 수정 값을 input창에 쓰고 확인 버튼 클릭시
	// 수정된 값이 들어감
	$("#commentList").on("click", ".confirm",function() {
		var commentno = $(this).attr("data-commentno");
			console.log(commentno)

		var contentno = $(this).attr("data-contentno");
			console.log(contentno)

		var contentVal = $("#cContent"+contentno).html();
			console.log(contentVal)
		
		var data = $("#cContent"+contentno).children().val()
		
		var boardno = $(this).attr("data-boardno");
		console.log(boardno)
			
		console.log("인풋 태그 값", $("#cContent"+contentno).children().val())
		
		$("#cContent"+contentno).html(data)

		//수정한 댓글 내용과 commentno를 가져가기 위한 ajax
				 $.ajax({
			         type: "post"
			         , url: "/board/reviseComment"
			         , data: {commentno : commentno, data:data, boardno:boardno}
			         , dataType: "html"
			         , success: function(res){
			            console.log("AJAX 성공")
			            //console.log(res)
			           // $("#test2").children().remove()
			           // $("#test2").append(res)
			            
			         
			         }
			         , error: function(){
			            console.log("AJAX 실패")   
			         }

		})
		$(".confirm").hide()
		$(".cContent").show()
		
	})
	
	//삭제버튼을 클릭!   하면 글 삭제 시키기
	$("#commentList").on("click", ".cDelete" ,function() {
		var commentno = $(this).attr("data-commentno");
		var boardno = $(this).attr("data-boardno");
		console.log(commentno)
		console.log(boardno)
				 
		
		
		$.ajax({
			  type: "get"
			  , url: "/board/deleteComment"
			  , data: {commentno : commentno, boardno:boardno}
			  , dataType: "html"
			  , success: function(res){
			    console.log("AJAX 성공")
			    //console.log(res)
			    $("#commentContent").html(res);
				
				$.ajax({
					  type: "get"
					  , url: "./coCountLikeCount"
					  , data: {commentno : commentno, boardno:boardno}
					  , dataType: "html"
					  , success: function(res){
					    console.log("AJAX 성공")
					    //console.log(res)
					    $("#commLike").html(res);
					
					   }
					   , error: function(){
					    console.log("AJAX 실패")   
					   }

				})
				
			   }
			   , error: function(){
			    console.log("AJAX 실패")   
			   }

		})		
		
			    
	
	})
	
	//for each 돌기 전에 미리 예약어로
	//자식에 대해서 이런 이벤트를 걸어달라라고 작성하는 것 22222
	//1, 2번 모두 잘 돌아감
// function func(commentno) {
// 	console.log(commentno)
// }
	


})

</script>   