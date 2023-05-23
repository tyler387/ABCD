package com.kh.jaManChw.dto;

import java.util.Date;

public class ReportBoard {

	private int bReportno;
	private int boardno;
	private int userno;
	private String rTitle;
	private String rContent;
	private String rStatus;
	private String rOption;
	private Date writeDate;
	
	public ReportBoard() {}

	public ReportBoard(int bReportno, int boardno, int userno, String rTitle, String rContent, String rStatus,
			String rOption, Date writeDate) {
		super();
		this.bReportno = bReportno;
		this.boardno = boardno;
		this.userno = userno;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rStatus = rStatus;
		this.rOption = rOption;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "ReportBoard [bReportno=" + bReportno + ", boardno=" + boardno + ", userno=" + userno + ", rTitle="
				+ rTitle + ", rContent=" + rContent + ", rStatus=" + rStatus + ", rOption=" + rOption + ", writeDate="
				+ writeDate + "]";
	}

	public int getbReportno() {
		return bReportno;
	}

	public void setbReportno(int bReportno) {
		this.bReportno = bReportno;
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

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public String getrOption() {
		return rOption;
	}

	public void setrOption(String rOption) {
		this.rOption = rOption;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
