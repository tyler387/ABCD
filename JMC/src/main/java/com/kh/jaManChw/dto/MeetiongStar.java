package com.kh.jaManChw.dto;

public class MeetiongStar {

	private int starno;
	private int meetingno;
	private int userno;
	private double star;
	
	public MeetiongStar() {}

	public MeetiongStar(int starno, int meetingno, int userno, double star) {
		super();
		this.starno = starno;
		this.meetingno = meetingno;
		this.userno = userno;
		this.star = star;
	}

	@Override
	public String toString() {
		return "MeetiongStar [starno=" + starno + ", meetingno=" + meetingno + ", userno=" + userno + ", star=" + star
				+ "]";
	}

	public int getStarno() {
		return starno;
	}

	public void setStarno(int starno) {
		this.starno = starno;
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

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}
	
}
