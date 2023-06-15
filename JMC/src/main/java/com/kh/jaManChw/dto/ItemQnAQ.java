package com.kh.jaManChw.dto;

import java.util.Date;

public class ItemQnAQ {

	private int itemQnano;
	private int itemno;
	private int userno;
	private String iqTitle;
	private String iqContent;
	private String iqOption;
	private String iqStatus;
	private Date iqWriteDate;
	
	public ItemQnAQ() {}

	public ItemQnAQ(int itemQnano, int itemno, int userno, String iqTitle, String iqContent, String iqOption,
			String iqStatus, Date iqWriteDate) {
		super();
		this.itemQnano = itemQnano;
		this.itemno = itemno;
		this.userno = userno;
		this.iqTitle = iqTitle;
		this.iqContent = iqContent;
		this.iqOption = iqOption;
		this.iqStatus = iqStatus;
		this.iqWriteDate = iqWriteDate;
	}

	@Override
	public String toString() {
		return "ItemQnAQ [itemQnano=" + itemQnano + ", itemno=" + itemno + ", userno=" + userno + ", iqTitle=" + iqTitle
				+ ", iqContent=" + iqContent + ", iqOption=" + iqOption + ", iqStatus=" + iqStatus + ", iqWriteDate="
				+ iqWriteDate + "]";
	}

	public int getItemQnano() {
		return itemQnano;
	}

	public void setItemQnano(int itemQnano) {
		this.itemQnano = itemQnano;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getIqTitle() {
		return iqTitle;
	}

	public void setIqTitle(String iqTitle) {
		this.iqTitle = iqTitle;
	}

	public String getIqContent() {
		return iqContent;
	}

	public void setIqContent(String iqContent) {
		this.iqContent = iqContent;
	}

	public String getIqOption() {
		return iqOption;
	}

	public void setIqOption(String iqOption) {
		this.iqOption = iqOption;
	}

	public String getIqStatus() {
		return iqStatus;
	}

	public void setIqStatus(String iqStatus) {
		this.iqStatus = iqStatus;
	}

	public Date getIqWriteDate() {
		return iqWriteDate;
	}

	public void setIqWriteDate(Date iqWriteDate) {
		this.iqWriteDate = iqWriteDate;
	}
	
}
