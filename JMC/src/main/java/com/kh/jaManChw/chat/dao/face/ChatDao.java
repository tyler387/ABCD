package com.kh.jaManChw.chat.dao.face;

import java.util.List;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.ChatMessage;
import com.kh.jaManChw.dto.ChatUser;
import com.kh.jaManChw.dto.ChatRoom;

public interface ChatDao {

	public void insertMessage(ChatMessage chatMessage);

	public List<ChatRoom> selectAllChatno(ChatUser chatUser);

	public List<ChatMessage> selectAllMessage(int chatno);

	public void insertMyMessage(ChatMessage message);

	public ChatRoom selectChatRoomByChatno(int chatno);

	public List<ChatMessage> selectChatMessageLoad(ChatMessage chatMessage);

	public int selectNextChatno();

	public void insertChatRoom(ChatRoom chatRoom);

	public void insertChatUser(ChatUser chatUser);

	public void insertChatUserAgree(Applicant applicant);

}
