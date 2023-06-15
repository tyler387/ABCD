package com.kh.jaManChw.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChatMessage {

	private int messageno;
	private int chatno;
	private String message;
	private Date sendTime;
	private String sendId;
	
	public ChatMessage() {}
	
	public ChatMessage(int messageno, int chatno, String sendId, String message, Date sendTime) {
		super();
		this.messageno = messageno;
		this.chatno = chatno;
		this.sendId = sendId;
		this.message = message;
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "ChatMessage [messageno=" + messageno + ", chatno=" + chatno + ", sendId=" + sendId + ", message="
				+ message + ", sendTime=" + sendTime + "]";
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
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	
}