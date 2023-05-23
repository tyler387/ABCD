package com.kh.jaManChw.dto;

import java.util.Date;

public class Users {

	private int userno;
	private String userId;
	private String userPw;
	private String userName;
	private String userNick;
	private Date birth;
	private String gentder;
	private String email;
	private String phone;
	private String addr1;
	private String addr2;
	private String addr3;
	private String grade; //당근마켓 온도같은 역할하는 것
	private int warnCount;
	private String profileImgUrl;
	private String status;
	private String role;
	private String platFormOption;
	
	public Users() {}

	public Users(int userno, String userId, String userPw, String userName, String userNick, Date birth, String gentder,
			String email, String phone, String addr1, String addr2, String addr3, String grade, int warnCount,
			String profileImgUrl, String status, String role, String platFormOption) {
		super();
		this.userno = userno;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userNick = userNick;
		this.birth = birth;
		this.gentder = gentder;
		this.email = email;
		this.phone = phone;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.grade = grade;
		this.warnCount = warnCount;
		this.profileImgUrl = profileImgUrl;
		this.status = status;
		this.role = role;
		this.platFormOption = platFormOption;
	}

	@Override
	public String toString() {
		return "Users [userno=" + userno + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userNick=" + userNick + ", birth=" + birth + ", gentder=" + gentder + ", email=" + email
				+ ", phone=" + phone + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", grade=" + grade
				+ ", warnCount=" + warnCount + ", profileImgUrl=" + profileImgUrl + ", status=" + status + ", role="
				+ role + ", platFormOption=" + platFormOption + "]";
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGentder() {
		return gentder;
	}

	public void setGentder(String gentder) {
		this.gentder = gentder;
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

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
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

	public String getProfileImgUrl() {
		return profileImgUrl;
	}

	public void setProfileImgUrl(String profileImgUrl) {
		this.profileImgUrl = profileImgUrl;
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
	
}