package com.kh.jaManChw.dto;

public class Preference {

	private int preferenceno;
	private int meetingno;
	private String gender;
	private int minage;
	private int maxage;
	private String smoke;
	private String friend;
	
	public Preference() {}

	@Override
	public String toString() {
		return "Preference [preferenceno=" + preferenceno + ", meetingno=" + meetingno + ", gender=" + gender
				+ ", minage=" + minage + ", maxage=" + maxage + ", smoke=" + smoke + ", friend=" + friend + "]";
	}

	public int getPreferenceno() {
		return preferenceno;
	}

	public void setPreferenceno(int preferenceno) {
		this.preferenceno = preferenceno;
	}

	public int getMeetingno() {
		return meetingno;
	}

	public void setMeetingno(int meetingno) {
		this.meetingno = meetingno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMinage() {
		return minage;
	}

	public void setMinage(int minage) {
		this.minage = minage;
	}

	public int getMaxage() {
		return maxage;
	}

	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public Preference(int preferenceno, int meetingno, String gender, int minage, int maxage, String smoke,
			String friend) {
		super();
		this.preferenceno = preferenceno;
		this.meetingno = meetingno;
		this.gender = gender;
		this.minage = minage;
		this.maxage = maxage;
		this.smoke = smoke;
		this.friend = friend;
	}

	
}
