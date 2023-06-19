<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<c:import url="../layout/header.jsp" />
<style type="text/css">


.page{
	width: 200px;
 	margin: 0 auto;
}

#content{
	padding-top: 70px;
}

.boardPic{
width: 245px;
height: 245px;
}

.boardDetailPic{
width: 300px;
height: 300px;
}



</style>



<div id="content">
<nav id="nav">
	<ul>
		<li id="whole" class = "cate">전체</li>
		<li class ="cate" id="meeting" value='11'>모임후기</li>
		<li class ="cate" id="buy" value='12'>술자랑 & 구입기</li>
		<li class ="cate" id="drink" value='13'>위스키 시음기</li>
		<li class ="cate" id="visit" value='14'>바 정보 & 방문기</li>
		<li class ="cate" id="mycocktail" value='15'>나만의 칵테일</li>
	</ul>
</nav>

<div id="back">
<div id="wrap1">
<div id ="grid">
<div id="merchantList">

</div>
<div id="merchant">
<c:import url="/WEB-INF/views/board/allFile2.jsp" />
</div>

</div >

<div id="pagingDiv">
<c:import url="./paging.jsp" />
</div>
</div>

</div>
</div>

<style type="text/css">
#content{
	width: 1600px;
	margin: 0 auto;
	padding-bottom: 100px;
}

/* img{ */
/* width:300px;  */
/* height:300px; */
/* } */

#nav{
	background : black;
	text-align : center;


}
#nav ul {margin:0; padding:0; list-style:none; color:white}
#nav ul li { background: black; padding:20px; display:inline-block;  }

#grid { 
  display : grid ; 
  grid-template-columns: 3fr 1fr;
  grid-gap : 3px;


/*   /* float:left; */ */
} 

#merchant{
	width:400px;
	margin: 0 auto;

}

#merchantList{

	display: grid;
    grid-template-columns: repeat(3, 250px);
    grid-template-rows: repeat(3, 250px);
    cursor : pointer;
  
}

#back{
width: 1200px;
margin-top : 50px;
height: 880px;
	
}


#search{
position: relative;
width: 150px;
text-align: center;
}

input {
  border: 1px solid #bbb;
  border-radius: 15px;
  padding: 10px 65px;
  font-size: 14px;
  position: relative;
  left: 0px;
  
}


#article{
	width: 300px;
	
	
}
#right{
/* 	float : right; */
	width : 300px;
	height : 300px;
}



.button{ 
 	padding-top: 10px; 
 }

#confirm{
/* 	display : none; */
}

#wrap1{
	width: 609px;
	margin: 0 auto;
}
.cate{
	cursor : pointer;
}


</style>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>


<script type="text/javascript">

$(function(){

	//시작과 함께 로드되는 AJAX파트 - 사실은 카테고리값에 따른 전체 조회
	categoryEvent(0,1)
	
	
	var curPage;
	var totalPage;
	
	$("#pagingDiv").on("click", ".number", function() {
		
		curPage = $(this).html()
		categoryEvent(boardOptionno, curPage);
	})
	
	$("#pagingDiv").on("click", ".first", function () {
		if(!$(".first").hasClass("disabled")){
				categoryEvent(boardOptionno, 1);
		}
	})

	$("#pagingDiv").on("click", ".beforelist", function () {
		if(!$(".beforelist").hasClass("disabled")){
			curPage = parseInt(curPage) - 10
			categoryEvent(boardOptionno, curPage);
		}
	})
	
	$("#pagingDiv").on("click", ".before", function () {
		if(!$(".before").hasClass("disabled")){
			console.log("curPage-before",curPage)
			curPage = parseInt(curPage) - 1;
			console.log("curPage-before--",curPage)
			console.log("boardOptionno--",boardOptionno)
			categoryEvent(boardOptionno, curPage)
		}
	})
	
	$("#pagingDiv").on("click", ".next", function () {
		if (!$(".next").hasClass("disabled")) {
			console.log("curPage-after",curPage)
			console.log("curPage-after is NaN",isNaN(curPage))
			
			if(isNaN(curPage)){
				curPage = 1;
			}
			
			curPage = parseInt(curPage) + 1;
			categoryEvent(boardOptionno, curPage);
		}
	})
	
	$("#pagingDiv").on("click", ".nextlist", function () {
		if(!$(".nextlist").hasClass("disabled")){
			
			if(isNaN(curPage)){
				curPage = 1;
			}

			curPage = parseInt(curPage) + 10
			categoryEvent(boardOptionno, curPage);
		}
	})

	$("#pagingDiv").on("click", ".end", function () {
		if (!$(".end").hasClass("disabled")) {
			console.log("totalPage",$("#totalPage").val())
			
			categoryEvent(boardOptionno, $("#totalPage").val());
			
			//현재 페이지 값을 전체 페이지 값으로 유지
			//	전체 페이지가 AJAX를 통해 발생된것이 아니기에..
			curPage = $("#totalPage").val()
		}
	})
	
	//<a>태그가 클릭되었을 때의 함수!
	$("#merchantList").on("click","a",function(){
		 console.log("#ajax click")
		  var boardno = $(this).attr("data-boardno")
		  	console.log("boardno :", boardno)
		     
		  
		  $.ajax({
		         type: "get"
		         , url: "/board/abacabc"
		         , data: {boardno : boardno}
		         , dataType: "html"
		         , success: function(res){
		            console.log("AJAX 성공")
		            
		            $("#merchant").children().remove()    
		            $("#merchant").append(res)
		            
		         }
		         , error: function(){
		            console.log("AJAX 실패")   
		         }
		  })
	
	})


	$(".cate").click(function(){
		
		console.log(".cate ajax click")
		boardOptionno = $(this).val()
		console.log(boardOptionno)
		
		categoryEvent(boardOptionno, 0);
	
	})
	
})
 
//카테고리를 누를때 전체 게시글과 첫 게시글이 변경된다 
function categoryEvent(boardOptionno, curPage) {
		
	if(boardOptionno === undefined){
		console.log("isUndefined: ".boardOptionno === undefined)
		boardOptionno = 0;
		console.log("boardOptionno: ",boardOptionno)
	}
	
		$.ajax({
			type: "get"	
			, url: "/board/cateFilepage"
			,dataType : "json"
			, data : {boardOptionno:boardOptionno, curPage:curPage}
			,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			,success: function(res){
				console.log("AJAX 성공")
		// 			$("html").children().remove()
		//	        $("html").append(res)
				console.log("11111result set :", res)
		// 		console.log(res);
		// 		console.log(res.length);
		// 		console.log(res[0]);
		// 		console.log(res[0].STORED_NAME);
		// 		console.log(res[0].BOARDNO);
				
				
				var putHtml = "" 
				for(var i = 0; i <res.list.length; i ++){
				putHtml += "<a data-boardno='"+res.list[i].BOARDNO+"'><img src='/boardFileUpload/"+res.list[i].STORED_NAME+"/' class='boardPic' style='box-shadow: 0px 1px 2px;  border-radius: 10px; border: 3px;'></a>";
				}
				
				$("#merchantList").html(putHtml);
				
				$.ajax({
					type: "get"
					, url: "/board/firstPage"
					,dataType : "json"
					, data : {boardno: res.list[0].BOARDNO}
					,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
					,success: function(res1){
						console.log("AJAX 성공")
						console.log("AJAX 성공:", res)
						console.log("값 잘 가지고 옴????", res.list[0].BOARDNO);
						$("#article > img").attr("src", "/boardFileUpload/"+res1.STORED_NAME)
						//★여기서 추가로 글 값들까지 가지고 오게 해야 함.........
						$("#article > #content22").html(res1.CONTENT)
						console.log("댓글 수 잘 찍히냐?", res1.COCOUNT)
						
						console.log("좋아요 수 잘 찍히냐?", res1.LIKECOUNT)
						
						//res에 담겨있는 페이징 객체 확인
						console.log("페이징:", res.paging)
		
		 				$("#cocountSpan").html(res1.COCOUNT)
		 				$("#likeCount").html(res1.LIKECOUNT)
		 				
		 				//23/06/08 19:30 주석 후 위에 내용 작성
		// 			    $("#article[id='cocountSpan']").html(res1.COCOUNT)
		// 				$("#article[id='like']").html(res1.LIKECOUNT)
						
						totalCount : res.paging.totalCount;
		
						$.ajax({
							type: "get"
							, url: "/board/getPaging"
							,dataType : "html"
							, data : {
								
								//페이징 객체를 뜯어 보내자 
								curPage : res.paging.curPage,
								totalCount : res.paging.totalCount,
								totalPage : res.paging.totalPage,
								listCount : res.paging.listCount,
								pageCount : res.paging.pageCount,
								startPage : res.paging.startPage,
								endPage : res.paging.endPage,
								startno : res.paging.startno,
								endno : res.paging.endno
								
								}
							,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
							,success: function(pagingRes){
								
								$("#pagingDiv").html(pagingRes);
							}
							, error: function(){
						            console.log("AJAX 실패1")   
						    }
						})
					}
					, error: function(){
			            console.log("AJAX 실패2")   
				    }
				})
				
		}
		 , error: function(){
			 console.log("AJAX 실패3")   
    	}
	})
} 
/* --------------------------------- */

		
</script>

<c:import url="../layout/footer.jsp" />