package com.kh.jaManChw.chat.dao.face;

import java.util.List;

import com.kh.jaManChw.dto.ChatMessage;
import com.kh.jaManChw.dto.ChatUser;
import com.kh.jaManChw.dto.ChatRoom;

public interface ChatDao {

	public void insertMessage(ChatMessage chatMessage);

	public List<ChatRoom> selectAllChatno(ChatUser chatUser);

}
