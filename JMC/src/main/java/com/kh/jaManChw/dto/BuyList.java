package com.kh.jaManChw.dto;

import java.util.Date;

public class BuyList {

	private int buyno;
	private int userno;
	private String itemName;
	private double totalPrice;
	private String buyOption;
	private Date buyDate;
	
	public BuyList() {}

	public BuyList(int buyno, int userno, String itemName, double totalPrice, String buyOption, Date buyDate) {
		super();
		this.buyno = buyno;
		this.userno = userno;
		this.itemName = itemName;
		this.totalPrice = totalPrice;
		this.buyOption = buyOption;
		this.buyDate = buyDate;
	}

	@Override
	public String toString() {
		return "BuyList [buyno=" + buyno + ", userno=" + userno + ", itemName=" + itemName + ", totalPrice="
				+ totalPrice + ", buyOption=" + buyOption + ", buyDate=" + buyDate + "]";
	}

	public int getBuyno() {
		return buyno;
	}

	public void setBuyno(int buyno) {
		this.buyno = buyno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBuyOption() {
		return buyOption;
	}

	public void setBuyOption(String buyOption) {
		this.buyOption = buyOption;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	
}
