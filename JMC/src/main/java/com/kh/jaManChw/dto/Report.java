package com.kh.jaManChw.dto;

import java.util.Date;

public class Report {

	private int reportno;
	private int userno;
	private int ruserno;
	private int boardno;
	private int meetingno;
	private String title;
	private String content;
	private String status;
	private String reportOption;
	private Date writeDate;
	private String reportType;
		
	public Report() {
	}

	@Override
	public String toString() {
		return "Report [reportno=" + reportno + ", userno=" + userno + ", ruserno=" + ruserno + ", boardno=" + boardno
				+ ", meetingno=" + meetingno + ", title=" + title + ", content=" + content + ", status=" + status
				+ ", reportOption=" + reportOption + ", writeDate=" + writeDate + ", reportType=" + reportType + "]";
	}

	public int getReportno() {
		return reportno;
	}

	public void setReportno(int reportno) {
		this.reportno = reportno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getRuserno() {
		return ruserno;
	}

	public void setRuserno(int ruserno) {
		this.ruserno = ruserno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getMeetingno() {
		return meetingno;
	}

	public void setMeetingno(int meetingno) {
		this.meetingno = meetingno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReportOption() {
		return reportOption;
	}

	public void setReportOption(String reportOption) {
		this.reportOption = reportOption;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Report(int reportno, int userno, int ruserno, int boardno, int meetingno, String title, String content,
			String status, String reportOption, Date writeDate, String reportType) {
		super();
		this.reportno = reportno;
		this.userno = userno;
		this.ruserno = ruserno;
		this.boardno = boardno;
		this.meetingno = meetingno;
		this.title = title;
		this.content = content;
		this.status = status;
		this.reportOption = reportOption;
		this.writeDate = writeDate;
		this.reportType = reportType;
	}

	
	
	
	
}
