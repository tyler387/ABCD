package com.kh.jaManChw.dto;

public class ItemOption {

	private int itemOptionno;
	private int itemno;
	
	//Option이 배열값을 받는 경우가 있기에 - 멤버 필드를 배열로 받고자함
	//뭔가 문제점이 많음...그냥 Controller에서 받을때 배열로 만들고 
	// controller에서 나눠서 리스트로된 DTO를 만블어보자..!
	private String optionContent;
	private int optionCount;
	private int extraCharge;
	
	public ItemOption() {}

	public ItemOption(int itemOptionno, int itemno, String optionContent, int optionCount, int extraCharge) {
		super();
		this.itemOptionno = itemOptionno;
		this.itemno = itemno;
		this.optionContent = optionContent;
		this.optionCount = optionCount;
		this.extraCharge = extraCharge;
	}

	@Override
	public String toString() {
		return "ItemOption [itemOptionno=" + itemOptionno + ", itemno=" + itemno + ", optionContent=" + optionContent
				+ ", optionCount=" + optionCount + ", extraCharge=" + extraCharge + "]";
	}

	public int getItemOptionno() {
		return itemOptionno;
	}

	public void setItemOptionno(int itemOptionno) {
		this.itemOptionno = itemOptionno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public int getOptionCount() {
		return optionCount;
	}

	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}

	public int getExtraCharge() {
		return extraCharge;
	}

	public void setExtraCharge(int extraCharge) {
		this.extraCharge = extraCharge;
	}

}
