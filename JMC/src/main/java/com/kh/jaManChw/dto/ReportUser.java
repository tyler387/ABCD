package com.kh.jaManChw.dto;

import java.util.Date;

public class ReportUser {

	private int ruReportno;
	private int userno;
	private String ruTitle;
	private String ruContent;
	private String ruStatus;
	private String ruOption;
	private Date writeDate;
	
	public ReportUser() {}

	public ReportUser(int ruReportno, int userno, String ruTitle, String ruContent, String ruStatus, String ruOption,
			Date writeDate) {
		super();
		this.ruReportno = ruReportno;
		this.userno = userno;
		this.ruTitle = ruTitle;
		this.ruContent = ruContent;
		this.ruStatus = ruStatus;
		this.ruOption = ruOption;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "ReportUser [ruReportno=" + ruReportno + ", userno=" + userno + ", ruTitle=" + ruTitle + ", ruContent="
				+ ruContent + ", ruStatus=" + ruStatus + ", ruOption=" + ruOption + ", writeDate=" + writeDate + "]";
	}

	public int getRuReportno() {
		return ruReportno;
	}

	public void setRuReportno(int ruReportno) {
		this.ruReportno = ruReportno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getRuTitle() {
		return ruTitle;
	}

	public void setRuTitle(String ruTitle) {
		this.ruTitle = ruTitle;
	}

	public String getRuContent() {
		return ruContent;
	}

	public void setRuContent(String ruContent) {
		this.ruContent = ruContent;
	}

	public String getRuStatus() {
		return ruStatus;
	}

	public void setRuStatus(String ruStatus) {
		this.ruStatus = ruStatus;
	}

	public String getRuOption() {
		return ruOption;
	}

	public void setRuOption(String ruOption) {
		this.ruOption = ruOption;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
