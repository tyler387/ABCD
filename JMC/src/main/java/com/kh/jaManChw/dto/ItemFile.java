package com.kh.jaManChw.dto;

public class ItemFile {

	private int itemViewFileno;
	private int itemno;
	private String iOriginName;
	private String iStoredName;
	private double filesize;
	
	public ItemFile() {}

	public ItemFile(int itemViewFileno, int itemno, String iOriginName, String iStoredName, double filesize) {
		super();
		this.itemViewFileno = itemViewFileno;
		this.itemno = itemno;
		this.iOriginName = iOriginName;
		this.iStoredName = iStoredName;
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "ItemFile [itemViewFileno=" + itemViewFileno + ", itemno=" + itemno + ", iOriginName=" + iOriginName
				+ ", iStoredName=" + iStoredName + ", filesize=" + filesize + "]";
	}

	public int getItemViewFileno() {
		return itemViewFileno;
	}

	public void setItemViewFileno(int itemViewFileno) {
		this.itemViewFileno = itemViewFileno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getiOriginName() {
		return iOriginName;
	}

	public void setiOriginName(String iOriginName) {
		this.iOriginName = iOriginName;
	}

	public String getiStoredName() {
		return iStoredName;
	}

	public void setiStoredName(String iStoredName) {
		this.iStoredName = iStoredName;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	
}
