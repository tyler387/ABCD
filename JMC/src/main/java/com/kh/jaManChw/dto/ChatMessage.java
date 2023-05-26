package com.kh.jaManChw.dto;

import java.util.Date;

public class ChatMessage {

	private int messageno;
	private int chatno;
	private int userno;
	private String message;
	private Date sendTime;
	
	public ChatMessage() {}

	public ChatMessage(int messageno, int chatno, int userno, String message, Date sendTile) {
		super();
		this.messageno = messageno;
		this.chatno = chatno;
		this.userno = userno;
		this.message = message;
		this.sendTime = sendTile;
	}

	@Override
	public String toString() {
		return "ChatMessage [messageno=" + messageno + ", chatno=" + chatno + ", userno=" + userno + ", message="
				+ message + ", sendTile=" + sendTime + "]";
	}

	public int getMessageno() {
		return messageno;
	}

	public void setMessageno(int messageno) {
		this.messageno = messageno;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendTile() {
		return sendTime;
	}

	public void setSendTile(Date sendTile) {
		this.sendTime = sendTile;
	}
	
}
