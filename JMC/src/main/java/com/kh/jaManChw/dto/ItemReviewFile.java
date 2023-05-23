package com.kh.jaManChw.dto;

public class ItemReviewFile {

	private int reviewFileno;
	private int reviewno;
	private String originName;
	private String storedName;
	private double filesize;
	
	public ItemReviewFile() {}

	public ItemReviewFile(int reviewFileno, int reviewno, String originName, String storedName, double filesize) {
		super();
		this.reviewFileno = reviewFileno;
		this.reviewno = reviewno;
		this.originName = originName;
		this.storedName = storedName;
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "ItemReviewFile [reviewFileno=" + reviewFileno + ", reviewno=" + reviewno + ", originName=" + originName
				+ ", storedName=" + storedName + ", filesize=" + filesize + "]";
	}

	public int getReviewFileno() {
		return reviewFileno;
	}

	public void setReviewFileno(int reviewFileno) {
		this.reviewFileno = reviewFileno;
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getStoredName() {
		return storedName;
	}

	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	
}
