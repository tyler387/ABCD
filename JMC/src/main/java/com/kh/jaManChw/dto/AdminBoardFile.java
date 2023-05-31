package com.kh.jaManChw.dto;

public class AdminBoardFile {

	private int adminFileno;
	private int adminBoardno;
	private String abf_origin_name;
	private String abf_stored_name;
	private double filesize;
	
	public AdminBoardFile() {}

	public AdminBoardFile(int adminFileno, int adminBoardno, String abf_origin_name, String abf_stored_name,
			double filesize) {
		super();
		this.adminFileno = adminFileno;
		this.adminBoardno = adminBoardno;
		this.abf_origin_name = abf_origin_name;
		this.abf_stored_name = abf_stored_name;
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "AdminBoardFile [adminFileno=" + adminFileno + ", adminBoardno=" + adminBoardno + ", abf_origin_name="
				+ abf_origin_name + ", abf_stored_name=" + abf_stored_name + ", filesize=" + filesize + "]";
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

	public String getAbf_origin_name() {
		return abf_origin_name;
	}

	public void setAbf_origin_name(String abf_origin_name) {
		this.abf_origin_name = abf_origin_name;
	}

	public String getAbf_stored_name() {
		return abf_stored_name;
	}

	public void setAbf_stored_name(String abf_stored_name) {
		this.abf_stored_name = abf_stored_name;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}


	
}
	
