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
	if(userid==null){
		alert("로그인 후 이용 가능")
		location.href="/login/login"
	}
	
	connect();
})

	function test(){
	 
	var sendtest = $("#chatmessage").val()
	console.log(sendtest)
	socket.send(sendtest)

}
	function connect(){
		var roomid = "${roomid}"
			socket = new WebSocket("ws://localhost:8888/websocket/"+roomid)
			socket.onmessage = function(event) {
		  $("#chat").append(event.data+"<br>")
			};
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