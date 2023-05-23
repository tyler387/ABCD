package com.kh.jaManChw.dto;

import java.util.Date;

public class QnAQ {

	private int questionno;
	private int userno;
	private String qTitle;
	private String qContent;
	private String qStatus;
	private Date writeDate;
	
	public QnAQ() {}

	public QnAQ(int questionno, int userno, String qTitle, String qContent, String qStatus, Date writeDate) {
		super();
		this.questionno = questionno;
		this.userno = userno;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qStatus = qStatus;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "QnAQ [questionno=" + questionno + ", userno=" + userno + ", qTitle=" + qTitle + ", qContent=" + qContent
				+ ", qStatus=" + qStatus + ", writeDate=" + writeDate + "]";
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

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqStatus() {
		return qStatus;
	}

	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
