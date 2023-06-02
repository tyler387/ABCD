<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>






<input type="text" placeholder="입력하세요!" style="width:300px;height:300px; font-size:12px;">

<div class="img-wrap" style="cursor:pointer;">	
		<img alt="picUpIcon" src="/resources/image/fileuploadIcon.png" style="width:50px;">
	</div>
	<div class="uploadedPic">
	
	</div>
	<br>
	<input type="file" id="file" name="file" multiple="multiple" class="form-control rounded-bottom d-none">
	<br>
	
<button>확인</button>



<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

$(function() {
	
	$(".img-wrap").click(function() {
		$("#file").click()
	})
	
	$("#file").change(function() {
		
		var files = this.files;
		
		for(var i = 0; i<files.length; i++){
			
			if(!files[i].type.includes("image")){
				alert((i+1)+ "번째 파일("+files[i]+")은 이미지가 아닙니다")
				continue
			}
			
			$(".uploadedPic").html('')
			
			var reader = new FileReader()
			
	        reader.onload = function(){
	           $("<img>")
	           .attr({
	              src:this.result
	              ,width:200
	              ,height:200
	           })
	           .appendTo($(".uploadedPic"))
	        }   

			reader.readAsDataURL(files[i])
			
		}
	})
})

</script>