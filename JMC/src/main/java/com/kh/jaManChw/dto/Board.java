package com.kh.jaManChw.dto;

import java.util.Date;

public class Board {

	private int boardno;
	private int boardOptionno;
	private int userno;
	private String cotent;
	private String status;
	private Date writeDate;
	private Date updateDate;
	
	public Board() {}

	public Board(int boardno, int boardOptionno, int userno, String cotent, String status, Date writeDate,
			Date updateDate) {
		super();
		this.boardno = boardno;
		this.boardOptionno = boardOptionno;
		this.userno = userno;
		this.cotent = cotent;
		this.status = status;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", boardOptionno=" + boardOptionno + ", userno=" + userno + ", cotent="
				+ cotent + ", status=" + status + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getBoardOptionno() {
		return boardOptionno;
	}

	public void setBoardOptionno(int boardOptionno) {
		this.boardOptionno = boardOptionno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getCotent() {
		return cotent;
	}

	public void setCotent(String cotent) {
		this.cotent = cotent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
