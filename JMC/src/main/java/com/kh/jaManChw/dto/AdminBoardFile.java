package com.kh.jaManChw.dto;

public class AdminBoardFile {

	private int adminFileno;
	private int adminBoardno;
	private String abfOriginName;
	private String abfStoredName;
	private double filesize;
	
	public AdminBoardFile() {}

	public AdminBoardFile(int adminFileno, int adminBoardno, String abfOriginName, String abfStoredName,
			double filesize) {
		super();
		this.adminFileno = adminFileno;
		this.adminBoardno = adminBoardno;
		this.abfOriginName = abfOriginName;
		this.abfStoredName = abfStoredName;
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "AdminBoardFile [adminFileno=" + adminFileno + ", adminBoardno=" + adminBoardno + ", abfOriginName="
				+ abfOriginName + ", abfStoredName=" + abfStoredName + ", filesize=" + filesize + "]";
	}

	public int getAdminFileno() {
		return adminFileno;
	}

	public void setAdminFileno(int adminFileno) {
		this.adminFileno = adminFileno;
	}

	public int getAdminBoardno() {
		return adminBoardno;
	}

	public void setAdminBoardno(int adminBoardno) {
		this.adminBoardno = adminBoardno;
	}

	public String getAbfOriginName() {
		return abfOriginName;
	}

	public void setAbfOriginName(String abfOriginName) {
		this.abfOriginName = abfOriginName;
	}

	public String getAbfStoredName() {
		return abfStoredName;
	}

	public void setAbfStoredName(String abfStoredName) {
		this.abfStoredName = abfStoredName;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	
}
	
