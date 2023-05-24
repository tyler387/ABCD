package com.kh.jaManChw.dto;

import java.util.Date;

public class Meeting {

	private int meetingno;
	private int userno;
	private String mname;
	private String loc;
	private String loc1;
	private String loc2;
	private String loc3;
	private String meetingDate;
	private double fee;
	private String introduce;
	private int headCount;
	private String status;
	
	public Meeting() {}

	@Override
	public String toString() {
		return "Meeting [meetingno=" + meetingno + ", userno=" + userno + ", mname=" + mname + ", loc=" + loc
				+ ", loc1=" + loc1 + ", loc2=" + loc2 + ", loc3=" + loc3 + ", meetingDate=" + meetingDate + ", fee="
				+ fee + ", introduce=" + introduce + ", headCount=" + headCount + ", status=" + status + "]";
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

	public String getLoc1() {
		return loc1;
	}

	public void setLoc1(String loc1) {
		this.loc1 = loc1;
	}

	public String getLoc2() {
		return loc2;
	}

	public void setLoc2(String loc2) {
		this.loc2 = loc2;
	}

	public String getLoc3() {
		return loc3;
	}

	public void setLoc3(String loc3) {
		this.loc3 = loc3;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
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

	public Meeting(int meetingno, int userno, String mname, String loc, String loc1, String loc2, String loc3,
			String meetingDate, double fee, String introduce, int headCount, String status) {
		super();
		this.meetingno = meetingno;
		this.userno = userno;
		this.mname = mname;
		this.loc = loc;
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.loc3 = loc3;
		this.meetingDate = meetingDate;
		this.fee = fee;
		this.introduce = introduce;
		this.headCount = headCount;
		this.status = status;
	}

	
}
