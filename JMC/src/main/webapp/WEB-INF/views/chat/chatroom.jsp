<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script src="../resources/js/stomp.min.js"></script>
<script type="text/javascript">

	var socket
	var stomp
	var chatno
	var userid = "${sessionScope.userId}"
	var userno = "${sessionScope.userno}"
	var messageno
	var runAjax	= true
$(function(){

	parent.backbuttonshow()
	
	$("#chatmessage").focus()
	if("${chatMessages[0]}"==""){
		messageno = 0
	}else{
		messageno = "${chatMessages[0].getMessageno()}"
	}
		
	
	if(userid==""){
		alert("로그인 후 이용 가능")
		location.href="/chat/chatroomlist"
	}
	
	connect()
	socket.onclose = close
	$("#chatmessage").keypress(function(e){
		if(e.keyCode==13){
			
		   if (!e.shiftKey) {
		   e.preventDefault()
	       sendmessage();
			    } 			

		}

	})
	
	
	if(runAjax){
	$("#chat").scroll(function(){
		var scroll = $('#chat')[0].scrollHeight
		if(runAjax){
		if($("#chat").scrollTop()==0){
				$.ajax({
					type: "get"
					, url: "/chat/load"
					, data: {
						chatno:chatno,
						messageno:messageno
					}
					, dataType: "json"
					, success: function(res){
						if(res==""){
							runAjax = false
							return;
						}
						
						for(var i in res){
							var sendTime = new Date(res[i].sendTime)
							if(res[i].sendId==userid){
								$("#chat").prepend(
									"<div class='myMsg'>" 
									+"<span class='myName'>"+ res[i].sendId +"</span>"
									+"<span style='font-size:10px; margin-right:15px'>"+dateformat(sendTime)+"</span>"
									+"<span class='myMessage'>"+res[i].message+"</span>"
									+"</div>"		
								
								)
								
								
							}else{
								
								$("#chat").prepend(
								"<div class='yourMsg'>"
								+"<span class='yourName'>" +res[i].sendId +"</span>"
								+"<span class='yourMessage'>"+res[i].message+"</span>"
								+"<span style='font-size:10px; margin-left:15px'>"+dateformat(sendTime)+"</span>"
								+"</div>"		
								)
							}
						}
						
						
						messageno = res[res.length-1].messageno	
						var scrollafter = $('#chat')[0].scrollHeight
						$("#chat").scrollTop(scrollafter - scroll)
						
						
					}
					, error: function(){
						console.log("AJAX 실패")	
					}
				})
		}
		
	}
	})
	}
	
	})

	function sendmessage(){
	var sendmessage = $("#chatmessage").val()
	if(sendmessage==""){
		alert("내용을 입력하세요!")
		return false;
	}
	sendmessage = sendmessage.replaceAll("<","&lt").replaceAll(">","&gt").replaceAll("\n","<br>")
	stomp.send('/pub/chat/test/'+chatno,{},JSON.stringify({chatno : chatno, message:sendmessage,sendId : userid}),function(e){
	})
	$("#chatmessage").val("")
	$("#chatmessage").focus();

}
	
	function connect(){
		chatno = "${chatno}"
		socket = new SockJS("http://192.168.10.30:8888/chat")
		stomp = Stomp.over(socket)
		
		
		
		stomp.connect({},function(e){
			stomp.send('/pub/chat/join/'+ chatno+"/"+userid,{},JSON.stringify({chatno : chatno, sendId : userid}),function(test){
				
			})	
		
		stomp.subscribe('/sub/chat/test/'+chatno,function(test){
			var content = JSON.parse(test.body);
			var sendid = content.sendId
			var message = content.message
			if(content.message==null){
				$("#chat").append(
					"<div style='text-align:center;'>"+sendid+"입장</div>"		
				)
				$('#chat').scrollTop($('#chat')[0].scrollHeight)
				return;
				
			}
			
			
			var sendTime = new Date(content.sendTime)
			
			if(sendid==userid){
				$("#chat").append(
						"<div class='myMsg'>" 
						+"<span class='myName'>"+ sendid +"</span>"
						+"<span style='font-size:10px; margin-right:15px'>"+dateformat(sendTime)+"</span>"
						+"<span class='myMessage'>"+message+"</span>"
						+"</div>"		
				)
				$('#chat').scrollTop($('#chat')[0].scrollHeight)
			}else{
				$("#chat").append(
						"<div class='yourMsg'>"
						+"<span class='yourName'>" +sendid +"</span>"
						+"<span class='yourMessage'>"+message+"</span>"
						+"<span style='font-size:10px; margin-left:15px'>"+dateformat(sendTime)+"</span>"
						+"</div>"		
				)
				$('#chat').scrollTop($('#chat')[0].scrollHeight)
			}
			
			})
		})
		
		
		
	}
	
function close(){
	stomp.send('/pub/chat/out/'+ chatno,{},JSON.stringify({chatno : chatno, sendId : userid}),function(test){
		
	})	
	alert("[세션끊김!] 다시 입장해주세요!")
	location.href = "/chat/chatroomlist"
}


function dateformat(sendTime){
	
	// 오전/오후 HH:MM
	
	var time =  sendTime.getHours()>=12 ? "오후":"오전"
	var hour = sendTime.getHours()>12 ? sendTime.getHours()-12 : sendTime.getHours()
	var minute = sendTime.getMinutes();
	if(minute.toString().length==1) minute= "0"+minute
	return time+" "+ hour + ":" + minute
	
}

function back(){
	window.history.go(-1)
}
</script>
<style type="text/css">


@font-face {
    font-family: '양진체';
    src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); 
    font-weight: normal;
    font-style: normal;
}


html{
	width : 100%;
	height : 91%;
}
body{
	font-family: '양진체';
	width : 95%;
	height : 90%;
}
#chatName{
	width:100%;
	height:10%;
	background-color : #8D7B68;
	color : white;
	display : flex;
	justify-content: center;
	align-items: center;
	overflow: hidden;
}
#chat{
	width: 100%;
    height: 65%;
    overflow: auto;
    border: 1px solid #8D7B68;
    border-radius: 0 0 30px 30px;
    border-top: 0;
    padding-top: 10px;
}
#chatAll{
	width: 100%;
	height: 83%;

}
#inputMessage{
	width: 100%;
	height: 120px;
}
.sendbutton{
	text-align: right;
}
.myMsg{
	text-align: right;

}
.yourMsg{
	text-align: left;
	
}
.yourMessage{
	display: inline-block;
	background-color : #f1f0f0;
	border-radius: 15px;
	padding: 7px 15px;
	margin-bottom:10px;
	margin-top: 5px;
    font-size: 15px;
    font-weight: 400;
}
.myMessage{
	display: inline-block;
	border-radius: 15px;
	padding: 7px 15px;
	margin-bottom:10px;
	margin-top: 5px;
	background-color : #8D7B68;
	color : #fff;	
    font-size: 15px;
    font-weight: 400;
}
.yourName{
	font-size: 15px;
	display: block;
}
.myName{
	font-size: 15px;
	display: block;
}
#chatName{
	border : 1px solid #8D7B68;
	border-bottom: 1px solid black;
    border-radius: 30px 30px 0 0;
}
#chatmessage{
    margin-top: 20px;
    width: 99%;
    height: 55px;
    resize: none;
    border-radius: 30px;
    padding-top: 30px;
    padding-bottom: 30px;
    font-size : 15px;
    border: 1px solid #8D7B68;
}
#send{
    height: 30px;
    background-color: #8D7B68;
    border: none;
    width: 50px;
    color: white;
    margin-top: 5px;
    border-radius: 15px;
}
</style>
</head>
<body>
<!-- <div id="chatAll"> -->
<div id= "chatName"><span id="chatNameView">${chatroom.chatname }</span></div>

<div id="chat">
<c:forEach var="list" items="${chatMessages }">
<c:choose>
	<c:when test="${list.sendId eq sessionScope.userId }">
	<div class='myMsg'>
		<span class='myName'>${list.sendId }</span>
		
		<span style='font-size:10px; margin-right:15px'><fmt:formatDate value="${list.sendTime }" pattern="a hh:mm"/></span>
		<span class='myMessage'>${list.message }</span>
	</div>	
	</c:when>
	<c:when test="${list.sendId ne sessionScope.userId }">
		<div class='yourMsg'>
		<span class='yourName'>${list.sendId }</span>
		<span class='yourMessage'>${list.message }</span>
		<span style='font-size:10px; margin-left:15px'><fmt:formatDate value="${list.sendTime }" pattern="a hh:mm"/></span>
		</div>		
	</c:when>
</c:choose>
</c:forEach>
</div>
<!-- </div> -->
<div id="inputMessage">
<textarea style="width: 99%; height: 55px;resize: none; outline-color : #8D7B68;" name="chatmessage" id="chatmessage" placeholder="채팅을 입력하세요"></textarea><br>
<div class="sendbutton">
<button id="send" onclick="sendmessage()">전송</button>

</div>
</div>
</body>
</html>