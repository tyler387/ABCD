<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

$(function() {
	
	
	//div#content에 에디터 적용하기
	$("#summernote").summernote({
				height: 600,
				width: 600,
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
})

</script>
<style type="text/css">
#summernoteDiv{
	display: inline-block;
}
#files{
	display: inline-block;
}
</style>
</head>
<body>

<c:choose>
<c:when test="${not empty boardOption  and boardOption eq 'notice'}">
<h1>공지사항 글쓰기</h1>
<hr>
</c:when>
<c:when test="${not empty boardOption and boardOption eq 'event'}">
<h1>이벤트 글쓰기</h1>
<hr>
</c:when>
</c:choose>

<div>
<form action="./write" method="post" enctype="multipart/form-data">

	<input type="hidden" id="curPage" name="curPage" value="${curPage}">
	
	<label>제목</label>
	<input type="text" id="title" name="title">
	<br>

	<label>내용</label>
	<div id="summernoteDiv">
	<textarea id="summernote" name="content" ></textarea>
	</div>
	<br>
	<label>첨부파일</label>
	<input type="file" id="file" name="file" multiple="multiple">
	<br>
	<button>전송</button>
	<button id="btnCancel" type="button">작성취소</button>
</form>
</div>

</body>
</html>