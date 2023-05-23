package com.kh.jaManChw.dto;

public class ItemReviewRecommend {

	private int reviewRecommendno;
	private int reviewno;
	private int userno;
	
	public ItemReviewRecommend() {}

	public ItemReviewRecommend(int reviewRecommendno, int reviewno, int userno) {
		super();
		this.reviewRecommendno = reviewRecommendno;
		this.reviewno = reviewno;
		this.userno = userno;
	}

	@Override
	public String toString() {
		return "ItemReviewRecommend [reviewRecommendno=" + reviewRecommendno + ", reviewno=" + reviewno + ", userno="
				+ userno + "]";
	}

	public int getReviewRecommendno() {
		return reviewRecommendno;
	}

	public void setReviewRecommendno(int reviewRecommendno) {
		this.reviewRecommendno = reviewRecommendno;
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
	
	
}
