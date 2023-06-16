package com.kh.jaManChw.dto;

public class ShoppingBasket {

	private int basketno;
	private int itemno;
	private int itemOptionno;
	private int userno;
	private int sbItemCount;
	
	public ShoppingBasket() {}

	public ShoppingBasket(int basketno, int itemno, int itemOptionno, int userno, int sbItemCount) {
		super();
		this.basketno = basketno;
		this.itemno = itemno;
		this.itemOptionno = itemOptionno;
		this.userno = userno;
		this.sbItemCount = sbItemCount;
	}

	@Override
	public String toString() {
		return "ShoppingBasket [basketno=" + basketno + ", itemno=" + itemno + ", itemOptionno=" + itemOptionno
				+ ", userno=" + userno + ", sbItemCount=" + sbItemCount + "]";
	}

	public int getBasketno() {
		return basketno;
	}

	public void setBasketno(int basketno) {
		this.basketno = basketno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public int getItemOptionno() {
		return itemOptionno;
	}

	public void setItemOptionno(int itemOptionno) {
		this.itemOptionno = itemOptionno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getSbItemCount() {
		return sbItemCount;
	}

	public void setSbItemCount(int sbItemCount) {
		this.sbItemCount = sbItemCount;
	}
}
