package com.kh.jaManChw.dto;

public class ChatUser {
	
	private int chatJoinno;
	private int chatno;
	private int userno;
	
	public ChatUser() {}

	public ChatUser(int chatJoinno, int chatno, int userno) {
		super();
		this.chatJoinno = chatJoinno;
		this.chatno = chatno;
		this.userno = userno;
	}

	@Override
	public String toString() {
		return "ChatUser [chatJoinno=" + chatJoinno + ", chatno=" + chatno + ", userno=" + userno + "]";
	}

	public int getChatJoinno() {
		return chatJoinno;
	}

	public void setChatJoinno(int chatJoinno) {
		this.chatJoinno = chatJoinno;
	}

	public int getChatno() {
		return chatno;
	}

	public void setChatno(int chatno) {
		this.chatno = chatno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}
	
}
