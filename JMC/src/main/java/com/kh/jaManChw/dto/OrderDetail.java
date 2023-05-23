package com.kh.jaManChw.dto;

public class OrderDetail {

	private int orderDetailno;
	private int userno;
	private int orderno;
	private int itemno;
	private String itemName;
	private String itemCount;
	private String itemOption;
	private double itemTotalPrice;
	
	public OrderDetail() {}

	public OrderDetail(int orderDetailno, int userno, int orderno, int itemno, String itemName, String itemCount,
			String itemOption, double itemTotalPrice) {
		super();
		this.orderDetailno = orderDetailno;
		this.userno = userno;
		this.orderno = orderno;
		this.itemno = itemno;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemOption = itemOption;
		this.itemTotalPrice = itemTotalPrice;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailno=" + orderDetailno + ", userno=" + userno + ", orderno=" + orderno
				+ ", itemno=" + itemno + ", itemName=" + itemName + ", itemCount=" + itemCount + ", itemOption="
				+ itemOption + ", itemTotalPrice=" + itemTotalPrice + "]";
	}

	public int getOrderDetailno() {
		return orderDetailno;
	}

	public void setOrderDetailno(int orderDetailno) {
		this.orderDetailno = orderDetailno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemOption() {
		return itemOption;
	}

	public void setItemOption(String itemOption) {
		this.itemOption = itemOption;
	}

	public double getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(double itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}
	
}
