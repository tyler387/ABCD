package com.kh.jaManChw.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Users {

	private int userno;
	private String userId;
	private String userPw;
	private String userNick;
	private String userName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String gender;
	private String email;
	private String phone;
	private int addr1;
	private String addr2;
	private String addr3;
	private String grade; //당근마켓 온도같은 역할하는 것
	private int warnCount;
	private String status;
	private String role;
	private String platFormOption;
	private Date joinDate;
	private String socialNum;
	
	
	public Users() {}


	public Users(int userno, String userId, String userPw, String userNick, String userName, Date birth, String gender,
			String email, String phone, int addr1, String addr2, String addr3, String grade, int warnCount,
			String status, String role, String platFormOption, Date joinDate, String socialNum) {
		super();
		this.userno = userno;
		this.userId = userId;
		this.userPw = userPw;
		this.userNick = userNick;
		this.userName = userName;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.grade = grade;
		this.warnCount = warnCount;
		this.status = status;
		this.role = role;
		this.platFormOption = platFormOption;
		this.joinDate = joinDate;
		this.socialNum = socialNum;
	}


	@Override
	public String toString() {
		return "Users [userno=" + userno + ", userId=" + userId + ", userPw=" + userPw + ", userNick=" + userNick
				+ ", userName=" + userName + ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", phone="
				+ phone + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", grade=" + grade
				+ ", warnCount=" + warnCount + ", status=" + status + ", role=" + role + ", platFormOption="
				+ platFormOption + ", joinDate=" + joinDate + ", socialNum=" + socialNum + "]";
	}


	public int getUserno() {
		return userno;
	}


	public void setUserno(int userno) {
		this.userno = userno;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAddr1() {
		return addr1;
	}


	public void setAddr1(int addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getAddr3() {
		return addr3;
	}


	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getWarnCount() {
		return warnCount;
	}


	public void setWarnCount(int warnCount) {
		this.warnCount = warnCount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPlatFormOption() {
		return platFormOption;
	}


	public void setPlatFormOption(String platFormOption) {
		this.platFormOption = platFormOption;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public String getSocialNum() {
		return socialNum;
	}


	public void setSocialNum(String socialNum) {
		this.socialNum = socialNum;
	}
	
}
	
	