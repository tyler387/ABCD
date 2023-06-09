package com.kh.jaManChw.dto;

import java.sql.Date;

public class ReportMeeting {
	
	public int rmReportno;
	public int meetingno;
	public int userno;
	public String rmTitle;
	public String rmContent;
	public String rmStatus;
	public String rmOption;
	public Date writeDate;
	
	
	public ReportMeeting() { }


	@Override
	public String toString() {
		return "ReportMeeting [rmReportno=" + rmReportno + ", meetingno=" + meetingno + ", userno=" + userno
				+ ", rmTitle=" + rmTitle + ", rmContent=" + rmContent + ", rmStatus=" + rmStatus + ", rmOption="
				+ rmOption + ", writeDate=" + writeDate + "]";
	}


	public int getRmReportno() {
		return rmReportno;
	}


	public void setRmReportno(int rmReportno) {
		this.rmReportno = rmReportno;
	}


	public int getMeetingno() {
		return meetingno;
	}


	public void setMeetingno(int meetingno) {
		this.meetingno = meetingno;
	}


	public int getUserno() {
		return userno;
	}


	public void setUserno(int userno) {
		this.userno = userno;
	}


	public String getRmTitle() {
		return rmTitle;
	}


	public void setRmTitle(String rmTitle) {
		this.rmTitle = rmTitle;
	}


	public String getRmContent() {
		return rmContent;
	}


	public void setRmContent(String rmContent) {
		this.rmContent = rmContent;
	}


	public String getRmStatus() {
		return rmStatus;
	}


	public void setRmStatus(String rmStatus) {
		this.rmStatus = rmStatus;
	}


	public String getRmOption() {
		return rmOption;
	}


	public void setRmOption(String rmOption) {
		this.rmOption = rmOption;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}


	public ReportMeeting(int rmReportno, int meetingno, int userno, String rmTitle, String rmContent, String rmStatus,
			String rmOption, Date writeDate) {
		super();
		this.rmReportno = rmReportno;
		this.meetingno = meetingno;
		this.userno = userno;
		this.rmTitle = rmTitle;
		this.rmContent = rmContent;
		this.rmStatus = rmStatus;
		this.rmOption = rmOption;
		this.writeDate = writeDate;
	}
	
	
	
	
	
	
}
