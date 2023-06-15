package com.kh.jaManChw.dto;

import java.util.Date;

public class BoardComment {

	private int commentno;
	private int boardno;
	private int userno;
	private String cContent;
	private Date writeDate;
	private String cStatus; 
	
	public BoardComment() {}

	public BoardComment(int commentno, int boardno, int userno, String cContent, String cStatus, Date writeDate) {
		super();
		this.commentno = commentno;
		this.boardno = boardno;
		this.userno = userno;
		this.cContent = cContent;
		this.cStatus = cStatus;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "BoardComment [commentno=" + commentno + ", boardno=" + boardno + ", userno=" + userno + ", cContent="
				+ cContent + ", cStatus=" + cStatus + ", writeDate=" + writeDate + "]";
	}

	public int getCommentno() {
		return commentno;
	}

	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getcStatus() {
		return cStatus;
	}

	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
