package com.kh.jaManChw.dto;

import java.util.Date;

public class Meeting {

	private int meetingno;
	private int userno;
	private String mname;
	private String loc;
	private Date meetingDate;
	private Date meetiongTime;
	private double fee;
	private String introduce;
	private int headCount;
	private String status;
	
	public Meeting() {}

	public Meeting(int meetingno, int userno, String mname, String loc, Date meetingDate, Date meetiongTime, double fee,
			String introduce, int headCount, String status) {
		super();
		this.meetingno = meetingno;
		this.userno = userno;
		this.mname = mname;
		this.loc = loc;
		this.meetingDate = meetingDate;
		this.meetiongTime = meetiongTime;
		this.fee = fee;
		this.introduce = introduce;
		this.headCount = headCount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Meeting [meetingno=" + meetingno + ", userno=" + userno + ", mname=" + mname + ", loc=" + loc
				+ ", meetingDate=" + meetingDate + ", meetiongTime=" + meetiongTime + ", fee=" + fee + ", introduce="
				+ introduce + ", headCount=" + headCount + ", status=" + status + "]";
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

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getMeetiongTime() {
		return meetiongTime;
	}

	public void setMeetiongTime(Date meetiongTime) {
		this.meetiongTime = meetiongTime;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getHeadCount() {
		return headCount;
	}

	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
