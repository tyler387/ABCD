package com.kh.jaManChw.dto;

public class Applicant {

	private int meetingno;
	private int userno;
	private String applicantContent;
	private String agree;
	private int trialNumber;
	
	public Applicant() {}

	public Applicant(int meetingno, int userno, String applicantContent, String agree, int trialNumber) {
		super();
		this.meetingno = meetingno;
		this.userno = userno;
		this.applicantContent = applicantContent;
		this.agree = agree;
		this.trialNumber = trialNumber;
	}

	@Override
	public String toString() {
		return "Applicant [meetingno=" + meetingno + ", userno=" + userno + ", applicantContent=" + applicantContent
				+ ", agree=" + agree + ", trialNumber=" + trialNumber + "]";
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

	public String getApplicantContent() {
		return applicantContent;
	}

	public void setApplicantContent(String applicantContent) {
		this.applicantContent = applicantContent;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public int getTrialNumber() {
		return trialNumber;
	}

	public void setTrialNumber(int trialNumber) {
		this.trialNumber = trialNumber;
	}
	
}
