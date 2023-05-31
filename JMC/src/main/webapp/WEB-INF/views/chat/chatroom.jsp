<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript">

	var socket
	var stomp
	var roomid
	var userid = "${sessionScope.userId}"
	var userno = "${sessionScope.userno}"
	var close = true
$(function(){
	
	$('#chat').scrollTop($('#chat')[0].scrollHeight)
	
	if(userid==""){
		alert("로그인 후 이용 가능")
		location.href="/chat/chatroomlist"
	}
	
	connect()
	
	
	$("#chatmessage").keypress(function(e){
		if(e.keyCode==13){
			
		   if (!e.shiftKey) {
		   e.preventDefault()
	       sendmessage();
			    } 			

		}
	})
	
	
	})

	function sendmessage(){
	var sendmessage = $("#chatmessage").val()
	if(sendmessage==""){
		alert("내용을 입력하세요!")
		return false;
	}
	if(!close){
		alert("다시 입장해주세요!")
		location.href="/chat/chatroomlist"
		return false;	
	}
	sendmessage = sendmessage.replaceAll("<","&lt").replaceAll(">","&gt").replaceAll("\n","<br>")
	stomp.send('/pub/chat/test/'+roomid,{},JSON.stringify({chatno : roomid, message:sendmessage,sendId : userid}),function(e){
	})
	$("#chatmessage").val("")
	

}
	
	function connect(){
		roomid = "${roomid}"
		socket = new SockJS("http://localhost:8888/chat")
		stomp = Stomp.over(socket)
		
		
		stomp.connect({},function(){
			
		stomp.send('/pub/chat/join/'+ roomid,{},JSON.stringify({chatno : roomid}),function(test){
		
		})	
		stomp.subscribe('/sub/chat/join/'+roomid,function(t){
				var content = JSON.parse(t.body)
				for(var i in content){
					if(content[i].sendId==userid){
						$("#chat").append(
								"<div style='text-align: right;'>" + content[i].sendId +"<br>"
								+"<a>"+content[i].message+"</a>"
								+"</div>"		
						)
						
					}else{
						$("#chat").append(
								"<div style='text-align: left;'>" + content[i].sendId +"<br>"
								+"<a>"+content[i].message+"</a>"
								+"</div>"		
						)
					
					}
				}	
				$('#chat').scrollTop($('#chat')[0].scrollHeight)
		})
		
		stomp.subscribe('/sub/chat/test/'+roomid,function(test){
			var content = JSON.parse(test.body);
			var sendid = content.sendId
			var message = content.message
			if(sendid==userid){
				$("#chat").append(
						"<div style='text-align: right;'>" + sendid +"<br>"
						+"<a>"+message+"</a>"
						+"</div>"		
				)
			}else{
				$("#chat").append(
						"<div style='text-align: left;'>" + sendid +"<br>"
						+"<a>"+message+"</a>"
						+"</div>"		
				)
			
			}
			$('#chat').scrollTop($('#chat')[0].scrollHeight)
			})
		})
		
		
		
	}
	


</script>
<style type="text/css">
#chat{
	width : 300px;
	height : 300px;
	overflow: auto;
	border: 1px solid black;
}
#chatAll{
	width: 500px;
	height: 500px;
	

}
#inputMessage{
	width: 296px;
	height: 200px;
}
#send{
	text-align: right;
}
</style>
</head>
<body>
<div id="chatAll">
<div id="chat"></div>
<div id="inputMessage">
<textarea style="width: 296px; height: 80px;resize: none;" name="chatmessage" id="chatmessage"></textarea><br>
<div class="sendbutton">
<button id="send" onclick="sendmessage()">전송</button>
</div>
</div>
</div>
</body>
</html>