package com.kh.jaManChw.chat.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
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
	
	@MessageMapping(value = "/chat/join/{chatno}/{userid}")
	public void join(ChatMessage message,StompHeaderAccessor accessor) {
		template.convertAndSend("/sub/chat/test/"+message.getChatno(),message);
	}
	
	
	@MessageMapping(value = "/chat/test/{chatno}")
	public void test(ChatMessage message) {
		logger.info("sendTime{}",message.getSendTime());
		message.setSendTime(new Date());
		chatService.insertMessage(message);
		template.convertAndSend("/sub/chat/test/" + message.getChatno(),message);
	}
	
	@MessageMapping(value = "/chat/out/{chatno}")
	public void chatOut(ChatMessage message) {
		logger.info("out!!");
		message.setMessage("test");
		template.convertAndSend("/sub/chat/test/"+message.getChatno(),message);
	}
	
}
