<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">

	var socket
	var userid = "${sessionScope.userId}"
$(function(){
	var roomid = "${roomid}"
	console.log(roomid)
	
	console.log("${sessionScope.userId}")
	socket = new WebSocket("ws://localhost:8888/websocket/"+roomid)
	socket.onmessage = function(event) {
		console.log(event.data)
		  $("#chat").append(event.data+"<br>")
		};
})

	function test(){
	 
	var sendtest = $("#chatmessage").val()
	console.log(sendtest)
	if(sendtest==""){
		alert("채팅내용을 입력하세요")
		return false;
	}else{
	socket.send(userid +": " + sendtest)
	}
}

</script>
</head>
<body>
<div id="chat"></div>
<div>
<input type="text" id="chatmessage" name="chatmessage">
<button id="send" onclick="test()">전송</button>
</div>
</body>
</html>