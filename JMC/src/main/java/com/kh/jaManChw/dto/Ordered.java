package com.kh.jaManChw.dto;

import java.util.Date;

public class Ordered {

	private int orderno;
	private int userno;
	private int buyno;
	private String orderStatus;
	private Date statusDate;
	
	public Ordered() {}

	public Ordered(int orderno, int userno, int buyno, String orderStatus, Date statusDate) {
		super();
		this.orderno = orderno;
		this.userno = userno;
		this.buyno = buyno;
		this.orderStatus = orderStatus;
		this.statusDate = statusDate;
	}

	@Override
	public String toString() {
		return "Ordered [orderno=" + orderno + ", userno=" + userno + ", buyno=" + buyno + ", orderStatus="
				+ orderStatus + ", statusDate=" + statusDate + "]";
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getBuyno() {
		return buyno;
	}

	public void setBuyno(int buyno) {
		this.buyno = buyno;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	
}
