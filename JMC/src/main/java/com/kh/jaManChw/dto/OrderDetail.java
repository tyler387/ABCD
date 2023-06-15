package com.kh.jaManChw.dto;

public class OrderDetail {

	private String orderno;
	private String userno;
	private String itemno;
	private String item_name;
	private String item_count;
	private String item_option;
	private String item_total_price;
	private String order_status;
	private String status_date;
	private String add1;
	private String add2;
	private String add3;
	private String name;
	private String phone;
	private String oncetrypayno;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String orderno, String userno, String itemno, String item_name, String item_count,
			String item_option, String item_total_price, String order_status, String status_date, String add1,
			String add2, String add3, String name, String phone, String oncetrypayno) {
		super();
		this.orderno = orderno;
		this.userno = userno;
		this.itemno = itemno;
		this.item_name = item_name;
		this.item_count = item_count;
		this.item_option = item_option;
		this.item_total_price = item_total_price;
		this.order_status = order_status;
		this.status_date = status_date;
		this.add1 = add1;
		this.add2 = add2;
		this.add3 = add3;
		this.name = name;
		this.phone = phone;
		this.oncetrypayno = oncetrypayno;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderno=" + orderno + ", userno=" + userno + ", itemno=" + itemno + ", item_name="
				+ item_name + ", item_count=" + item_count + ", item_option=" + item_option + ", item_total_price="
				+ item_total_price + ", order_status=" + order_status + ", status_date=" + status_date + ", add1="
				+ add1 + ", add2=" + add2 + ", add3=" + add3 + ", name=" + name + ", phone=" + phone + ", oncetrypayno="
				+ oncetrypayno + "]";
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_count() {
		return item_count;
	}

	public void setItem_count(String item_count) {
		this.item_count = item_count;
	}

	public String getItem_option() {
		return item_option;
	}

	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}

	public String getItem_total_price() {
		return item_total_price;
	}

	public void setItem_total_price(String item_total_price) {
		this.item_total_price = item_total_price;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getStatus_date() {
		return status_date;
	}

	public void setStatus_date(String status_date) {
		this.status_date = status_date;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
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

	public String getOncetrypayno() {
		return oncetrypayno;
	}

	public void setOncetrypayno(String oncetrypayno) {
		this.oncetrypayno = oncetrypayno;
	}
	
}
