<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
div.admin {
   	margin: 0 auto;
    width: 1800px;
    height: 750px;
        
}

div.left {   
	width: 15%;
	float: left;
	box-sizing: border-box;
	border: 1px solid #000;
	background-color: #efeeee;
	height: 800px;
}
 
div.right {
    width: 85%;
    float: right;
    box-sizing: border-box;    
  	border-top-style: solid;
	border-bottom-style: solid;
   	border-right-style: solid;
  	border-width: 1px;
  	height: 800px;
}

h2{
   padding-left : 50px;
}

p{
   padding-left : 50px;
}

a {
   text-decoration: none !important;
	color: black;
}

a:visited {
	color : black;
}
 
.right{
	overflow-y:scroll;
}  
</style>
<style type="text/css">
 *{
 font-family: 'Noto Sans KR', sans-serif;
 }
.innerTitle {
	margin: 0 auto;
	border-radius: 30px; 
	background-color : #03a9f46e; 
	width: 600px;  
	text-align: center; 
	padding-bottom: 5px;
}
</style>
</head> 
<body>
<h1><a href="/admin/main"  style = "padding-top : 20px; padding-left : 30px; width: 400px;" >관리자 메인 페이지</a></h1>
<br>
<div class="admin">
	<div class="left">
	
	
	<h2 style = "padding-top : 50px;">회원관리</h2>
	<p><a href="/admin/user/mg/list">회원 정보 수정</a><br></p>
	<p><a href="/admin/user/black/list">블랙리스트 관리</a><br><br></p>
	<h2>신고관리</h2>
	<p><a href="/admin/report/post/list">신고글 확인</a><br></p>
	<p><a href="/admin/report/meeting/list">모임 신고 확인</a><br></p>
	<p><a href="/admin/report/user/list">신고 계정 확인</a><br><br></p>
	<h2>판매관리</h2>
	<p><a href="/admin/item/itemview/write">상품 등록</a><br></p>
	<p><a href="/admin/item/itemview/list">상품 삭제/수정</a><br></p>
	<p><a href="/admin/board/itemqna/list">상품 문의</a><br><br></p>
	<h2>고객센터관리</h2>
	<p><a href="/admin/main/boardCategory?boardOption=notice">공지사항 관리</a><br></p>
	<p><a href="/admin/main/boardCategory?boardOption=event">이벤트 관리</a><br></p>
	<p><a href="/admin/board/qna/list">Q & A 관리</a><br><br></p>
	
	</div>
<div class="right">


<!-- include libraries(jQuery, bootstrap) -->
<!-- CSS only -->
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

$(function() {
	
	
	<%-- 
	
	웹 에디터에 엄청 큰 사진을 올리게 되면 서버(tomcat)이 받아들이지 못해 POST 요청모두를 못받는 
	경우가 생길수 있는데 이 경우엔 서버의 요청에 대한 사이즈를 무제한으로 설정하면 해결할수 있다 
	이 경우는 mutipart가 아니라 data-64로 처리하는 동안 발생하는 문제점이다
	확인해보니 아무런 톰캣 설정을 하지 않으면 POST타입으로 데이터를 전송할때 POST BODY의 사이즈가 2mb로
	제한되어 있다는 부분이 문제점이 되는 것임...!
	
	server 프로젝트에서 server.xml파일에서 
	<Connector connectionTimeout="20000" port="8888" protocol="HTTP/1.1" redirectPort="8443"/>
	에서 
	<Connector connectionTimeout="20000" port="8888" protocol="HTTP/1.1" redirectPort="8443" maxPostSize="5242880"/>
	과 같이 사이즈를 지정해주거나 
	<Connector connectionTimeout="20000" port="8888" protocol="HTTP/1.1" redirectPort="8443" maxPostSize="-1"/>
	으로 지정하면 문제가 해결된다
	 
	 ** -1로 설정하면 최대 설정값인 2GB로 설정이된다
	 
	
	 --%>
	
	//div#content에 에디터 적용하기
	$("#summernote").summernote({
				height: 400,
				width: 800,
				//resize: none;
				disableResizeEditor: true,
				//fileSave
				callbacks: {
					onImageUpload: function(files, editor, welEditable) {
						console.log("사용이 되나요1?");
						for(var i = files.length -1 ; i >= 0; i--){
							sendFile(files[i], this)
						}
					}
				}
			});
	
	function sendFile(file, el) {
		console.log("el {}", el);
		data = new FormData();
		data.append("file", file);	//** 파일전달파라미터의 name
		
		$.ajax({
			data: data
			,type: "POST"
			,url: "./writeFileupload"
			,cache: false
			,contentType: false
			,processData: false
			,success: function(res) {
				var image = $('<img>').prop('src', res.url)
				$(el).summernote('insertNode', image[0])
				console.log($(el))
				console.log(res)
				console.log(res.url)
			}
			,error: function() {
				console.log("error입니다스!")
			}
		})
	}
	
	$("#btnCancel").click(function() {
		
		history.go(-1)
	})
	
// 	$(".img-wrap").click(function() {
// 		$("#file").click()
// 	})
	
// 	$("#file").change(function() {
		
// 		var files = this.files;
		
// 		for(var i = 0; i<files.length; i++){
			
// 			if(!files[i].type.includes("image")){
// 				alert((i+1)+ "번째 파일("+files[i]+")은 이미지가 아닙니다")
// 				continue
// 			}
			
// 			$(".uploadedPic").html('')
			
// 			var reader = new FileReader()
			
// 	        reader.onload = function(){
// 	           $("<img>")
// 	           .attr({
// 	              src:this.result
// 	              ,width:200
// 	              ,height:200
// 	           })
// 	           .appendTo($(".uploadedPic"))
// 	        }   

// 			reader.readAsDataURL(files[i])
			
// 		}
// 	})
})

</script>
<style type="text/css">
#summernoteDiv{
	display: inline-block;
	position: relative;
}
#files{
	display: inline-block;
}


</style>


<div id="Alltitle" style="text-align: center; padding-top: 10px;">




</div>

<div  class="wirte" style ="width: 800px; margin: 0 auto;">
<form action="./write" method="post" enctype="multipart/form-data">
	<input type="hidden" id="curPage" name="curPage" value="">
<div class="input-group mb-3">
	<label for="title" class="input-group-text">제목</label>
	<input type="text" id="title" name="title" class="form-control">
</div>
<div class="input-group mb-3 rounded-3">
	<br>
	<label for="summernote" class="input-group-text rounded-top" style="width: 800px;" >내용</label>
	<div id="summernoteDiv">
	<textarea id="summernote" name="content" class="form-control" ></textarea>
	</div>
<!-- 	<div class="img-wrap" style="cursor:pointer;">	 -->
<!-- 		<img alt="picUpIcon" src="/resources/image/fileuploadIcon.png" style="width:50px;"> -->
<!-- 	</div> -->
<!-- 	<div class="uploadedPic"> -->
	
<!-- 	</div> -->
	<br>
	<input type="file" id="file" name="file" multiple="multiple" class="form-control rounded-bottom">
	<br>
</div>
<div id="btnGroup">
	<button class="btn btn-secondary">전송</button>
	<button id="btnCancel" type="button" class="btn btn-secondary">작성취소</button>
</div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>