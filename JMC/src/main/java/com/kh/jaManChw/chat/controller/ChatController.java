package com.kh.jaManChw.chat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.chat.service.face.ChatService;
import com.kh.jaManChw.dto.ChatRoom;

@Controller
public class ChatController {

	
	
	@Autowired ChatService chatService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/chat/chatroom")
	public String chatRoom(String roomid,Model model) {
		// roomid가 없을 경우 list로 redirect 해야한다
		if(roomid==null) {
			return "redirect:/chat/chatroomlist";
		}
		
		
		model.addAttribute("roomid",roomid);
		
		return "/chat/chatroom";
	}
	
	@RequestMapping("/chat/chatroomlist")
	public String chatRoomList(Model model, HttpSession session) {
		
		List<ChatRoom> list = chatService.getChatRoomAll(session);
		logger.info("{}",list);
		model.addAttribute(list);
		return "/chat/chatroomlist";
		
	}
}
