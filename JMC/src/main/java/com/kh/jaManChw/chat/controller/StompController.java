package com.kh.jaManChw.chat.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.kh.jaManChw.chat.service.face.ChatService;
import com.kh.jaManChw.dto.ChatMessage;

@Controller
public class StompController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private ChatService chatService;
	
	@MessageMapping(value = "/chat/join/{roomid}")
	public void join(ChatMessage message) {
		logger.info("joinStomp");
		logger.info("joinchatno{}",message.getChatno());
		List<ChatMessage> chatHistory = chatService.getHistory(message.getChatno());
		logger.info("chatHistory : {} ", chatHistory);
		template.convertAndSend("/sub/chat/join/"+message.getChatno(),chatHistory);
	}
	
	
	@MessageMapping(value = "/chat/test/{roomid}")
	public void test(ChatMessage message) {
		logger.info("stompController");
		logger.info("{}",message);
		String a = "test";
		chatService.insertMessage(message);
		
		template.convertAndSend("/sub/chat/test/" + message.getChatno(),message);
	}
	
}
