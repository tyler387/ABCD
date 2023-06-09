<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/header.jsp" />
<c:import url="../chat/chatbutton.jsp"></c:import>
<style type="text/css">


.page{
	width: 200px;
 	margin: 0 auto;
}

#content{
	padding-top: 50px;
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
		<li class = "cate" value='11'>모임후기</li>
		<li class = "cate" value='12'>술자랑 & 구입기</li>
		<li class = "cate" value='13'>위스키 시음기</li>
		<li class = "cate" value='14'>바 정보 & 방문기</li>
		<li class = "cate" value='15'>나만의 칵테일</li>
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


<!-- 부트스트랩 3 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


<script type="text/javascript">

$(function(){

$.ajax({
	type: "get"
	, url: "/board/cateFilepage"
	,dataType : "json"
	, data : {}
	,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	,success: function(res){
		console.log("AJAX 성공")
// 			$("html").children().remove()
// 	        $("html").append(res)

// 		console.log(res);
// 		console.log(res.length);
// 		console.log(res[0]);
// 		console.log(res[0].STORED_NAME);
// 		console.log(res[0].BOARDNO);
		
		
		var putHtml = "" 
		for(var i = 0; i <res.length; i ++){
		putHtml += "<a data-boardno='"+res[i].BOARDNO+"'><img src='/boardFileUpload/"+res[i].STORED_NAME+"/' class='boardPic'></a>";
// 		putHtml += "<a data-boardno='"+res[i].BOARDNO+"'><img src='/upload/"+res[i].STORED_NAME+".jsp/'></a>";
// 		putHtml += "<a data-boardno='"+res[i].BOARDNO+"' id='a"+i+"'><img alt='사진' src=''></a>";
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

				
				$("#article > img").attr("src", "/boardFileUpload/"+res1.STORED_NAME)
				$("#article > #content22").html(res1.CONTENT)
				
				
				console.log("댓글 수 잘 찍히냐?", res1.COCOUNT)
				console.log("좋아요 수 잘 찍히냐?", res1.LIKECOUNT)
				
				
				$("#article[id='cocountSpan']").html(res1.COCOUNT)
				$("#article[id='like']").html(res1.LIKECOUNT)
				
				$.ajax({
		         type: "get"
		         , data: {boardno : res[0].BOARDNO}
		         , dataType: "json"
		         , success: function(res){
		            console.log("AJAX 성공")
		            console.log("res!!", res)
		    		if(res.chkReco == 0){
		    			$("#likeCount").html(res.allCount)
		    			$("#heartw").attr("style","display: inline")
		    			$("#heartr").attr("style","display: none")
		    			
		    			
		    		}else{
		    			$("#likeCount").html(res.allCount)
		    			$("#heartw").attr("style","display: none")
		    			$("#heartr").attr("style","display: inline")
		    			
		    		}
		          
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
	}	
	 , error: function(){
            console.log("AJAX 실패")   
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
	} )
	

	$(".cate").click(function(){
		console.log(".cate ajax click")
		boardOptionno = $(this).val()
		console.log(boardOptionno)
		
		$.ajax({
	type: "get"	
	, url: "/board/cateFilepage"
	,dataType : "json"
	, data : {boardOptionno:boardOptionno}
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
				console.log("댓글 수 잘 찍히냐?", res1.COCOUNT)
				
				console.log("좋아요 수 잘 찍히냐?", res1.LIKECOUNT)

 				$("#cocountSpan").html(res1.COCOUNT)
 				$("#likeCount").html(res1.LIKECOUNT)
 				//23/06/08 19:30 주석 후 위에 내용 작성
// 			    $("#article[id='cocountSpan']").html(res1.COCOUNT)
// 				$("#article[id='like']").html(res1.LIKECOUNT)
				
			
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

})




/* --------------------------------- */

		
</script>

<c:import url="../layout/footer.jsp" />