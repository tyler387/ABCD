package com.kh.jaManChw.chat.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketMessage;

import com.kh.jaManChw.chat.dao.face.ChatDao;
import com.kh.jaManChw.chat.service.face.ChatService;
import com.kh.jaManChw.dto.ChatMessage;
import com.kh.jaManChw.dto.ChatUser;
import com.kh.jaManChw.dto.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired ChatDao chatDao;
	
	@Override
	public void chatMessage(String roomid, WebSocketMessage<?> message) {
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setChatno(Integer.parseInt(roomid));
		chatMessage.setMessage((String)message.getPayload());
		
		chatDao.insertMessage(chatMessage);
		
	}

	@Override
	public List<ChatRoom> getChatRoomAll(HttpSession session) {
		ChatUser chatUser = new ChatUser();
		chatUser.setUserno((int)session.getAttribute("userno"));
		
		return chatDao.selectAllChatno(chatUser);
	}

	@Override
	public List<ChatMessage> getHistory(int chatno) {
		
		return chatDao.selectAllMessage(chatno);
	}

	@Override
	public void insertMessage(ChatMessage message) {
		
		chatDao.insertMyMessage(message);
	}

	@Override
	public ChatRoom getChatRoomInfo(int chatno) {
		return chatDao.selectChatRoomByChatno(chatno);
	}

	@Override
	public List<ChatMessage> loadMessage(ChatMessage chatMessage) {
		return chatDao.selectChatMessageLoad(chatMessage);
	}

}
