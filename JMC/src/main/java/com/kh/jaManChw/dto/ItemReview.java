package com.kh.jaManChw.dto;

public class ItemReview {

	private int reviewno;
	private int userno;
	private int itemno;
	private int buyno;
	private String reviewContent;
	private String reviewStar;
	
	public ItemReview() {}

	public ItemReview(int reviewno, int userno, int itemno, int buyno, String reviewContent, String reviewStar) {
		super();
		this.reviewno = reviewno;
		this.userno = userno;
		this.itemno = itemno;
		this.buyno = buyno;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
	}

	@Override
	public String toString() {
		return "ItemReview [reviewno=" + reviewno + ", userno=" + userno + ", itemno=" + itemno + ", buyno=" + buyno
				+ ", reviewContent=" + reviewContent + ", reviewStar=" + reviewStar + "]";
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public int getBuyno() {
		return buyno;
	}

	public void setBuyno(int buyno) {
		this.buyno = buyno;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}
	
	
}
