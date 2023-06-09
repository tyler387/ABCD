package com.kh.jaManChw.dto;

import java.util.Date;

public class ChatRoom {

	private int chatno;
	private int meetingno;
	private String chatname;
	private Date chatcloseday;
	
	public ChatRoom() {}

	public ChatRoom(int chatno, int meetingno, String chatname, Date chatcloseday) {
		super();
		this.chatno = chatno;
		this.meetingno = meetingno;
		this.chatname = chatname;
		this.chatcloseday = chatcloseday;
	}

	@Override
	public String toString() {
		return "Chatroom [chatno=" + chatno + ", meetingno=" + meetingno + ", chatname=" + chatname + ", chatcloseday="
				+ chatcloseday + "]";
	}

	public int getChatno() {
		return chatno;
	}

	public void setChatno(int chatno) {
		this.chatno = chatno;
	}

	public int getMeetingno() {
		return meetingno;
	}

	public void setMeetingno(int meetingno) {
		this.meetingno = meetingno;
	}

	public String getChatname() {
		return chatname;
	}

	public void setChatname(String chatname) {
		this.chatname = chatname;
	}

	public Date getChatcloseday() {
		return chatcloseday;
	}

	public void setChatcloseday(Date chatcloseday) {
		this.chatcloseday = chatcloseday;
	}
	
}