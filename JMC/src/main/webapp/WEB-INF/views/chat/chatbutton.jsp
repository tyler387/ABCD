<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#chatbutton").click(function(){
		
		$(".close").show()
		$(this).css("display","none")
	})
	$("#closeButton").click(function(){
		$(".close").css("display","none")
		$("#chatbutton").show()
	})
	$("#backButton").click(function(){
		$('#iframeChat').get(0).contentWindow.back()   		
	})
})

function backbuttonhide(){
	$("#backButton").hide()
}
function backbuttonshow(){
	$("#backButton").show()
}


</script>
<style type="text/css">
#buttonjsp{
	position:fixed;
	bottom : 10%;
	left : 90%;
	z-index : 9990;
}
.close{
	position : relative;
	display : none;
	right : 310px;
	width : 370px;
	height : 600px;
	background-color: white;
	border-radius: 30px;
    box-shadow: 0px 0px 5px 3px #8D7B68;
	
	animation: 0.25s ease-out 0s 1 normal none running test;
	
}
@keyframes test{
	0% {
    opacity: 0;
    transform: scale(0.7);
}

100% {
    opacity: 1;
    transform: scale(1);
}

}

#iframeChat{
	width: 100%;
	height: 90%;
	border : none;
}
#closeChat{
	margin-left : 263px;
}


#buttonjsp{
	width : 0px;
}
#closeButton{
	width : 30px;
	height : 30px;
	cursor: pointer;
}
#headerButton{
	display : flex;
	align-items: center;
	padding-right : 15px;
	padding-left: 15px;
	height : 10%;
}
#backChat{
	display : flex;
	width: 100%;
}
#backButton{
	width:40px;
	height: 45px;
	cursor: pointer;
}
#chatbutton{
 border: 3px solid white;
    border-radius: 50px;
    background-color: white;
    width: 80px;
    height:80px;
    cursor: pointer;
    box-shadow: 0px 0px 5px 3px #8D7B68;
}
</style>
</head>
<body>
<div id="buttonjsp">
<div id="imgbutton">
<img  src="../resources/image/chaticon4.png" id="chatbutton">
</div>
<!-- <button id="chatbutton">채팅방</button> -->
<div class="close">
<div id="headerButton">
<div id="backChat">
<img src="../resources/image/back.png" id="backButton">
</div>
<div id="hideChat">
<img src="../resources/image/close.png" id="closeButton">
</div>
</div>
<iframe src="../chat/chatroomlist" id="iframeChat">
</iframe>
</div>
</div>
</body>
</html>