//package com.kh.jaManChw.chat.hendler;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.apache.catalina.SessionListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.kh.jaManChw.chat.service.face.ChatService;
//import com.kh.jaManChw.dto.ChatMessage;
//
//
//
//
////Stomp 를 사용하여 이제 사용할일 없음
////stompcontroller 를 이용하여 메세지 전송 
//public class ChatHendler extends TextWebSocketHandler{
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired ChatService chatService;
//	private Map<String,List<WebSocketSession>> map = new ConcurrentHashMap<String, List<WebSocketSession>>();
//	
//	private List<WebSocketSession> sessionlist = new ArrayList<WebSocketSession>();
//
//	
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		logger.info("test");
//		String roomId = session.getUri().toString().split("/")[4];
//		session.getAttributes().put("roomId", roomId);
//		
//		
//		logger.info("session : {}",session);
//		if(!map.containsKey(roomId)) {
//			sessionlist = new ArrayList<WebSocketSession>();
//			sessionlist.add(session);
//			map.put(roomId, sessionlist);
//		}else {
//		sessionlist.add(session);
//		}
//
//	
//	}
//	
//	@Override
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		String roomid = session.getUri().toString().split("/")[4];
//		logger.info("{}",message.getPayload());
//		logger.info("{}",map);
//		chatService.chatMessage(roomid,message);
//		
//		for(WebSocketSession se : map.get(roomid)) {
//			logger.info("{}",map.get(roomid));
//			se.sendMessage(message);
//		}
//		
//		
//	}
//	
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		
//		logger.info("끊김");
//		sessionlist.remove(session);
//		//연결이 끊겼을 경우 map에 저장된 session값을 지워준다
//		//새로고침 햇을 경우 웹소켓 세션이 끊기고 연결될때 동일한 세션이 들어와 이미 끊긴 세션을 다시 불러들여 닫힌 세션을 호출하게 되는 느낌?// 동일한 세션 안들어오는데 ? 웹소켓세션이 닫혀?
//		//나중에 연결이 끊겻을 경우 remove를 해주고 다시 확아ㅣㄴ한다
//		
//	}
//}
