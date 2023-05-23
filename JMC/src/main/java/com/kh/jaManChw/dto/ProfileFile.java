package com.kh.jaManChw.dto;

public class ProfileFile {

	private int profileno;
	private int userno;
	private String profileOriginName;
	private String profileStoredName;
	private String profilesize;
	
	public ProfileFile() {}

	public ProfileFile(int profileno, int userno, String profileOriginName, String profileStoredName,
			String profilesize) {
		super();
		this.profileno = profileno;
		this.userno = userno;
		this.profileOriginName = profileOriginName;
		this.profileStoredName = profileStoredName;
		this.profilesize = profilesize;
	}

	@Override
	public String toString() {
		return "ProfileFile [profileno=" + profileno + ", userno=" + userno + ", profileOriginName=" + profileOriginName
				+ ", profileStoredName=" + profileStoredName + ", profilesize=" + profilesize + "]";
	}

	public int getProfileno() {
		return profileno;
	}

	public void setProfileno(int profileno) {
		this.profileno = profileno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getProfileOriginName() {
		return profileOriginName;
	}

	public void setProfileOriginName(String profileOriginName) {
		this.profileOriginName = profileOriginName;
	}

	public String getProfileStoredName() {
		return profileStoredName;
	}

	public void setProfileStoredName(String profileStoredName) {
		this.profileStoredName = profileStoredName;
	}

	public String getProfilesize() {
		return profilesize;
	}

	public void setProfilesize(String profilesize) {
		this.profilesize = profilesize;
	}

}
