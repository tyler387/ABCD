<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div id="right">
<div class="search"><!-- 검색어 관련 -->
  <input type="text" id="searchWrite" name="searchWrite" placeholder="검색어를 입력하세요" style="padding: 10px 62px">
 <img id="btn_Search" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
</div>

<!-- 회원이라면 글 쓰기 가능, 비회원이라면 글 쓰기 막기 -->
<c:choose>
<c:when test="${sessionScope.userId eq null}">
<div id="nonwrite">
로그인 후 글을 작성할 수 있습니다.<span>&#128196;</span><br><br>
</div>
</c:when>




<c:when test="${sessionScope.userId ne null }">
<div id="write" class="write">
자유롭게 글을 작성하세요 <span>&#128196;</span><br><br>
</div>
<div id="write2">
<c:import url="./write.jsp" />
</div>
</c:when>
</c:choose>



<div id="article">
	<img src='/boardFileUpload/${map.STORED_NAME}'  class="boardDetailPic">
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

#btn_Search {
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
#nonwrite{
	border : 1px solid #ccc;
	width : 300px;
	border-radius: 15px;
	text-align: center;
    margin-top: 10px;
    padding-top: 20px;
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
var like = "${map.LIKECOUNT}"
var boardOptionno
$(function(){
	//★★★★★★★★★★★★★★★★★★★
	//좋아요를 누른 리스트에 해당 유저번호가 없으면 흰색
	//좋아요를 누른 리스트에 해당 유저번호가 있으면 레드
// 	if(like== 0){
// 		$("#heartw").show()
// 		$("#heartr").hide()
		
		
// 	}else{

// 		$("#heartw").hide()
// 		$("#heartr").show()
		
// 	}
	//★★★★★★★★★★★★★★★★★★★

	$("#test2").css("display","none")
	console.log($("#test2").css("display"))

	
	//댓글 버튼을 클릭 했을 때 댓글창 열어 주기
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
		          	// console.log(res)
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
	console.log($("#write2").css("display"))
	
	$("#write").click(function(){
		
		if($("#write2").css("display")=="none"){
		$("#write2").css("display", "block")
		}else{
		$("#write2").css("display","none")
		}

		//$("#write").hide()
		
		//클릭 했을 때의 css("display")상태, none or block
		console.log($("#write2").css("display"))	
		console.log("글 쓰기 버튼 자알 눌림")
		var boardOptionno =  ${map.BOARD_OPTIONNO}
		console.log("옵션 번호 가지고 와?", boardOptionno)
		
		 


	})
	
	//좋아요 누르면 하트색깔 바꾸고, 좋아요 카운트 수 올리기
	$(".like").click(function(){

		console.log("#ajax like click")
		var boardno = "${map.BOARDNO}"
		console.log(boardno)	


		"${sessionScope.userId}"
		
		  $.ajax({
		         type: "get"
		         , url: "/board/boardReco"
		         , data: {boardno : boardno}
		         , dataType: "json"
		         , success: function(res){
		            console.log("AJAX 성공")
		            console.log("res!!", res)
		    		if(res.chkReco==0){
		    			$("#likeCount").html(res.allCount)
		    			$("#heartw").show()
		    			$("#heartr").hide()
		    		
		    			
		    		}else{
		    			$("#likeCount").html(res.allCount)
		    			$("#heartw").hide()
		    			$("#heartr").show()
		    		}
		            
		          
		         }
		         , error: function(){
		            console.log("AJAX 실패")
		    		if(${empty loginAccess or loginAccess}){
		    			alert("로그인하지 않아 접근이 불가능합니다!")
		    		}else if(${empty statusAccess or statusAccess}){
		    			alert("해당 아이디는 접근할수 없는 상태입니다, 관리자에게 문의 바랍니다")
		    		}
		            
		            //해당 요청요청마다 응답을 주고서 삭제할 경우에는 세션보다는 
		            //Request영역이 적절...!
<%-- 		            <% --%>
// 		            session.removeAttribute("loginAccess");
// 		            session.removeAttribute("adminAccess");
// 		            session.removeAttribute("statusAccess");
<%-- 		            %> --%>
	            	
	            	
		         }
		      })//END AJAX
		      /* AJAX종료 후 발동 */
// 				if($("#test2").css("display")=="none"){
// 					$("#test2").show()
					
// 				}else{
// 					$("#test2").hide()
// 				}
	})

	
	

	//====================================================================================================================
// 	//검색어에 따른 결과 받기 위한 ajax

	//엔터로 해도 작동 시키기
	$("#searchWrite").keydown(function(e) {
		if(e.keyCode == 13){
			$("#btn_Search").click();
		}
	})
	
	//마우스로 클릭시 작동 시키기
	 $("#btn_Search").click(function() {
		 console.log("돋보기 버튼 클릭 됨")
		 var searchData = $('#searchWrite').val()
		
		 if(searchData == ""){
			 return;
		 }
		 console.log(boardOptionno)
		
		 if(boardOptionno == undefined){
			 boardOptionno=0
		 }
		console.log("검색 값 :", searchData)
		console.log(boardOptionno)
		 
		 $.ajax({
		         type: "get"
		         , url: "/board/search"
			     , dataType: "json"
		         , data: {searchData : searchData, boardOptionno: boardOptionno}
				 ,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		         , success: function(res){
		            console.log("AJAX 성공")
		            console.log("res!!!!! :", res)
		    		var putHtml = "" 
		    			for(var i = 0; i <res.length; i ++){

		    			putHtml += "<a data-boardno='"+res[i].BOARDNO+"'><img src='/boardFileUpload/"+res[i].STORED_NAME+"/' class='boardPic'></a>";
		    			}
		            
		            $("#merchantList").html(putHtml);
		    		$.ajax({
		    			type: "get"
		    			, url: "/board/firstPage"
		    			,dataType : "json"
		    			, data : {boardno: res[0].BOARDNO}
		    			,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		    			,success: function(res1){
		    				console.log("AJAX 성공")
		    				console.log("값 잘 가지고 옴????", res[0].BOARDNO);
		    				$("#article > img").attr("src", "/boardFileUpload/"+res1.STORED_NAME)
		    				//★여기서 추가로 글 값들까지 가지고 오게 해야 함.........
		    				$("#article > #content22").html(res1.CONTENT)
		    				$("#article[id='cocountSpan']").html(res1.COCOUNT)
		    				$("#article[id='like']").html(res1.LIKECOUNT)
		    				
		    			
		    			}
		    			
		    			 , error: function(){
		    		            console.log("AJAX 실패")   
		    		    }
		    		})
		    			           
		            
		            
		         }//SUCCESS종료
		         , error: function(){
		            console.log("AJAX 실패")   
		         }//ERROR종료
		      })//AJAX 종료 		 



	 })//function 종료

})
</script>

