package com.kh.jaManChw.dto;

import java.util.Date;

public class ChatMessage {

	private int messageno;
	private int chatno;
	private int userno;
	private String message;
	private Date sendTile;
	
	public ChatMessage() {}

	public ChatMessage(int messageno, int chatno, int userno, String message, Date sendTile) {
		super();
		this.messageno = messageno;
		this.chatno = chatno;
		this.userno = userno;
		this.message = message;
		this.sendTile = sendTile;
	}

	@Override
	public String toString() {
		return "ChatMessage [messageno=" + messageno + ", chatno=" + chatno + ", userno=" + userno + ", message="
				+ message + ", sendTile=" + sendTile + "]";
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
		return sendTile;
	}

	public void setSendTile(Date sendTile) {
		this.sendTile = sendTile;
	}
	
}
