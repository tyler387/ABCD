package com.kh.jaManChw.dto;

import java.util.Date;

public class QnAA {

	private int answerno;
	private int questionno;
	private int userno;
	private String aContent;
	private String aStatus;
	private Date writeDate;
	
	public QnAA() {}

	public QnAA(int answerno, int questionno, int userno, String aContent, String aStatus, Date writeDate) {
		super();
		this.answerno = answerno;
		this.questionno = questionno;
		this.userno = userno;
		this.aContent = aContent;
		this.aStatus = aStatus;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "QnAA [answerno=" + answerno + ", questionno=" + questionno + ", userno=" + userno + ", aContent="
				+ aContent + ", aStatus=" + aStatus + ", writeDate=" + writeDate + "]";
	}

	public int getAnswerno() {
		return answerno;
	}

	public void setAnswerno(int answerno) {
		this.answerno = answerno;
	}

	public int getQuestionno() {
		return questionno;
	}

	public void setQuestionno(int questionno) {
		this.questionno = questionno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
