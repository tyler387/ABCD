package com.kh.jaManChw.dto;

import java.util.Date;

public class AdminBoard {

	private int adminBoardno;
	private int userno;
	private String title;
	private String content;
	private String abOption;
	private String abStatus;
	private Date writeDate;
	private Date lastUpdateDate;
	
	public AdminBoard() {}

	public AdminBoard(int adminBoardno, int userno, String title, String content, String abOption, String abStatus,
			Date writeDate, Date lastUpdateDate) {
		super();
		this.adminBoardno = adminBoardno;
		this.userno = userno;
		this.title = title;
		this.content = content;
		this.abOption = abOption;
		this.abStatus = abStatus;
		this.writeDate = writeDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "AdminBoard [adminBoardno=" + adminBoardno + ", userno=" + userno + ", title=" + title + ", content="
				+ content + ", abOption=" + abOption + ", abStatus=" + abStatus + ", writeDate=" + writeDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	public int getAdminBoardno() {
		return adminBoardno;
	}

	public void setAdminBoardno(int adminBoardno) {
		this.adminBoardno = adminBoardno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
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

	public String getAbOption() {
		return abOption;
	}

	public void setAbOption(String abOption) {
		this.abOption = abOption;
	}

	public String getAbStatus() {
		return abStatus;
	}

	public void setAbStatus(String abStatus) {
		this.abStatus = abStatus;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
