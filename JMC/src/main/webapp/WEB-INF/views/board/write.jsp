<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<form id="uploadFile"  enctype="multipart/form-data">
<select id="category" name="category" style="margin-bottom: 5px; margin-top: 5px;">
  	<option value="none">=== 선택 ===</option>
	<option value ="11">모임후기</option>
	<option value ="12">술자랑 & 구입기</option>
	<option value ="13">위스키 시음기</option>
	<option value ="14">바 정보 & 방문기</option>
	<option value ="15">나만의 칵테일</option>
</select>



<input type="text" size="20" placeholder="입력하세요!" id="boardWrite" name="boardWrite" style="width:300px;height:300px; font-size:12px;">

<!-- 부트스트랩 제거 후 주석한 부분1 -->
<!-- <div class="img-wrap" style="cursor:pointer;">	 -->
<!-- 		<img alt="picUpIcon" src="/resources/image/fileuploadIcon.png" style="width:50px;"> -->
<!-- 	</div> -->
<!-- 	<div class="uploadedPic"> -->
	
<!-- 	</div> -->
	<br>
	<input type="file" id="file" name="file" multiple="multiple" class="form-control rounded-bottom d-none" style="width:300px;height:40px; font-size:12px; margin-top:5px;">
	<br>
	<button type ="button" id="boardContent" style="margin-top:5px; margin-left: 250px">등록</button>
</form>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- JavaScript Bundle with Popper -->

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

$(function() {

	$(".img-wrap").click(function() {
		
		 console.log("img-wrap.click!")
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
	              ,width:100
	              ,height:100
	           })
	           .appendTo($(".uploadedPic"))
	        }   

			reader.readAsDataURL(files[i])
			
		}
	})
	
	
	
	$("#boardContent").click(function(){
		var formData = new FormData($("#uploadFile")[0])
		
// 		formData.append("file", $("#file")[0].files[0])
		
// 		console.log(formData)
		
// 		alert(JSON.stringify(formData ))
 		var cateData = $('#category').val()
		 console.log("boardContent click!!")
		 
		
		$.ajax({
			  type: "post",
			    url: "/board/write",
			    processData: false,
			    contentType: false,
			    enctype : 'multipart/form-data',
// 			    data: {file : formData },
				data: formData,
//			    data: {file : formData, cateData : cateData},
			    success: function(res) {

			        console.log("AJAX 성공");

//        	         $("#back").remove()
//        	          console.log("res는???", res)
// //        	         $("#back").append(res)
// //     	            $("#grid").children().remove()    
// 		        // $("#back").append(res)
       	        
					location.reload();
			    },
			    error: function() {
			        console.log("AJAX 실패");
			    }
		
		})
			   
	
	})
	
	

})


</script>