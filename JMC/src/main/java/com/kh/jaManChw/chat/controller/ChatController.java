package com.kh.jaManChw.chat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.jaManChw.chat.service.face.ChatService;
import com.kh.jaManChw.dto.ChatMessage;
import com.kh.jaManChw.dto.ChatRoom;

@Controller
public class ChatController {

	
	
	@Autowired ChatService chatService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//채팅방에 입장하는 컨트롤러
	@RequestMapping("/chat/chatroom")
	public String chatRoom(String chatno,Model model, HttpSession session) {
		// roomid가 없을 경우 list로 redirect 해야한다
		if(chatno==null) return "redirect:/chat/chatroomlist";
		
		int chatnum = Integer.parseInt(chatno);
		
		if(session.getAttribute("userId")==null) {
			return "redirect:/chat/chatroomlist";
		}
		
		// DB에 참여한 roomid를 가져와 비교해보고 있으면 chatroom으로 !
		List<ChatRoom> list = chatService.getChatRoomAll(session);
		for(ChatRoom cr : list) {
			if(cr.getChatno()==chatnum) {
				//채팅방 정보
				ChatRoom chatroom = chatService.getChatRoomInfo(chatnum);
				List<ChatMessage> chatMessages = chatService.getHistory(chatnum);
				model.addAttribute("chatMessages",chatMessages);
				//closeday 비교 해서 그 기간이 넘어가면 넘어가지 못하게 할것! (아직안함)
				model.addAttribute("chatroom",chatroom);
				model.addAttribute("chatno",chatno);
				return "/chat/chatroom";
			}
		}
		
		// DB에 참여한 roomid가 없을경우 리다이렉트
		// alert를 띄어주는게 좋을까!?
	
		
		return "redirect:/chat/chatroomlist";
	}
	
	@RequestMapping("/chat/chatroomlist")
	public String chatRoomList(Model model, HttpSession session) {
		// 처음 버튼을 눌렀을때 보여줄 창
		// 로그인 상태가 아니라면 ? 로그인 후 이용 가능하다
		logger.info("session{}",session.getAttribute("userId"));
		if(session.getAttribute("userId")==null) {
			return "/chat/chatroomlist";
		}
		
		//내가 참여한 채팅방 chat_user
		List<ChatRoom> list = chatService.getChatRoomAll(session);
		logger.info("test!!{},",list);
		model.addAttribute("list", list);
		return "/chat/chatroomlist";
		
	}
	
	@RequestMapping("/chat/chatbutton")
	public void chatButton() {
		
	}
	@RequestMapping("/chat/load")
	@ResponseBody
	public List<ChatMessage> chatHistory(ChatMessage chatMessage) {
		logger.info("ajax test chatno{}",chatMessage);
		List<ChatMessage> list = chatService.loadMessage(chatMessage);
		logger.info("ajax list {}",list);
		return list;
	}
	@RequestMapping("/chat/test")
	public void test() {
		
	}
	
}
