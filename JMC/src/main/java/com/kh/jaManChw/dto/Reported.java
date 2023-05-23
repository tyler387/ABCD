package com.kh.jaManChw.dto;

public class Reported {

	private int reportedno;
	private int userno;
	private int b_reportno;
	private int u_reportno;
	
	public Reported() {}

	public Reported(int reportedno, int userno, int b_reportno, int u_reportno) {
		super();
		this.reportedno = reportedno;
		this.userno = userno;
		this.b_reportno = b_reportno;
		this.u_reportno = u_reportno;
	}

	@Override
	public String toString() {
		return "Reported [reportedno=" + reportedno + ", userno=" + userno + ", b_reportno=" + b_reportno
				+ ", u_reportno=" + u_reportno + "]";
	}

	public int getReportedno() {
		return reportedno;
	}

	public void setReportedno(int reportedno) {
		this.reportedno = reportedno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getB_reportno() {
		return b_reportno;
	}

	public void setB_reportno(int b_reportno) {
		this.b_reportno = b_reportno;
	}

	public int getU_reportno() {
		return u_reportno;
	}

	public void setU_reportno(int u_reportno) {
		this.u_reportno = u_reportno;
	}
	
}
