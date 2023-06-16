package com.kh.jaManChw.dto;

import java.util.Date;

public class OrderDetail {


	private int orderDetailno;
	private int userno;
	private int orderno;
	private int itemno;
	private String itemName;
	private String itemCount;
	private String itemOption;
	private double itemTotalPrice;
	private String orderStatus;
	private Date statusDate;
	private int add1;
	private String add2;
	private String add3;
	private String name;
	private String phone;
	private int oncetrypayno;
	
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}


	public OrderDetail(int orderDetailno, int userno, int orderno, int itemno, String itemName, String itemCount,
			String itemOption, double itemTotalPrice, String orderStatus, Date statusDate, int add1, String add2,
			String add3, String name, String phone, int oncetrypayno) {
		super();
		this.orderDetailno = orderDetailno;
		this.userno = userno;
		this.orderno = orderno;
		this.itemno = itemno;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemOption = itemOption;
		this.itemTotalPrice = itemTotalPrice;
		this.orderStatus = orderStatus;
		this.statusDate = statusDate;
		this.add1 = add1;
		this.add2 = add2;
		this.add3 = add3;
		this.name = name;
		this.phone = phone;
		this.oncetrypayno = oncetrypayno;
	}


	@Override
	public String toString() {
		return "OrderDetail [orderDetailno=" + orderDetailno + ", userno=" + userno + ", orderno=" + orderno
				+ ", itemno=" + itemno + ", itemName=" + itemName + ", itemCount=" + itemCount + ", itemOption="
				+ itemOption + ", itemTotalPrice=" + itemTotalPrice + ", orderStatus=" + orderStatus + ", statusDate="
				+ statusDate + ", add1=" + add1 + ", add2=" + add2 + ", add3=" + add3 + ", name=" + name + ", phone="
				+ phone + ", oncetrypayno=" + oncetrypayno + "]";
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


	public int getAdd1() {
		return add1;
	}


	public void setAdd1(int add1) {
		this.add1 = add1;
	}


	public String getAdd2() {
		return add2;
	}


	public void setAdd2(String add2) {
		this.add2 = add2;
	}


	public String getAdd3() {
		return add3;
	}


	public void setAdd3(String add3) {
		this.add3 = add3;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getOncetrypayno() {
		return oncetrypayno;
	}


	public void setOncetrypayno(int oncetrypayno) {
		this.oncetrypayno = oncetrypayno;
	}
	
	
}
