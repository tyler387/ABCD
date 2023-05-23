package com.kh.jaManChw.dto;

public class Preference {

	private int preferenceno;
	private int meetingno;
	private String gender;
	private int age;
	private String smoke;
	private String friend;
	
	public Preference() {}

	public Preference(int preferenceno, int meetingno, String gender, int age, String smoke, String friend) {
		super();
		this.preferenceno = preferenceno;
		this.meetingno = meetingno;
		this.gender = gender;
		this.age = age;
		this.smoke = smoke;
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "Preference [preferenceno=" + preferenceno + ", meetingno=" + meetingno + ", gender=" + gender + ", age="
				+ age + ", smoke=" + smoke + ", friend=" + friend + "]";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
}
