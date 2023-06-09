<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../../main.jsp"/>

<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet"> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

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

<script type="text/javascript">
$(function() {
	
	
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
	

})

</script>


<div id="Alltitle" style="text-align: center; padding-top: 10px;">
<c:choose>
<c:when test="${not empty boardOption  and boardOption eq 'notice'}">
<h1 class="innerTitle">공지사항 글수정</h1>
<hr>
</c:when>
<c:when test="${not empty boardOption and boardOption eq 'event'}">
<h1 class="innerTitle">이벤트 글수정</h1>
<hr>
</c:when>
</c:choose>
</div>

<div class="update" style ="width: 800px; margin: 0 auto;">
<form action="./update" method="post" enctype="multipart/form-data">
	
	<input type="hidden" id="adminBoardno" name="adminBoardno" value="${detail.adminBoardno}">
	<input type="hidden" id="curPage" name="curPage" value="${curPage}">
<div class="input-group mb-3">
	<label for="title" class="input-group-text">제목</label>
	<input type="text" id="title" name="title" value="${detail.title}" class="form-control">
</div>
	<br>
<div class="input-group mb-3 rounded-3">
	<label for="summernote" class="input-group-text rounded-top" style="width: 800px;" >내용</label>
	<div id="summernoteDiv">
	<textarea id="summernote" name="content" class="form-control" >${detail.content}</textarea>
	</div>
	<br>
	<input type="file" id="file" name="file" multiple="multiple" class="form-control rounded-bottom">
</div>
<div id="btnGroup">
	<button class="btn btn-secondary">수정</button>
	<button type="button" onclick="history.go(-1)" class="btn btn-secondary">취소</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>