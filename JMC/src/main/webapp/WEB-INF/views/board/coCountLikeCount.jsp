<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<style type="text/css">
#heartw {
	vertical-align: bottom;
}
#heartr {
	vertical-align: bottom;
}

</style>




<span class="button" id="test3">
댓글 <span id="cocountSpan" style="font-size:1em">${map.COCOUNT }</span>▽ 
<span style="font-size:1em">댓글 쓰기</span>
</span>

<span class="like">
<img id="heartw" src="/resources/image/heartw.png" alt='이미지' width="25px" height="25px">
<img id="heartr" src="/resources/image/heartr.png" alt='이미지' width="25px" height="25px" />
<span style="font-size:1em" id="likeCount">${map.LIKECOUNT }</span>
</span>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function(){

var chkReco = "${chkReco}"
if(chkReco==0){
	$("#heartw").attr("style","display: inline")
	$("#heartr").attr("style","display: none")
}else{
	$("#heartw").attr("style","display: none")
	$("#heartr").attr("style","display: inline")
}
})


</script>