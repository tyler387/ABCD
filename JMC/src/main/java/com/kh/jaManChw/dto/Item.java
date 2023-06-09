package com.kh.jaManChw.dto;

import java.util.Date;

public class Item {

	public int itemno;
	public String itemTitle;
	public String itemContent;
	public int itemPrice;
	public String itemType;
	public String itemStatus;
	public Date writeDate;
	public int allItemCount;
	
	public Item() {}
	
	public Item(int itemno, String itemTitle, String itemContent, int itemPrice, String itemType, String itemStatus,
			Date writeDate, int allItemCount) {
		super();
		this.itemno = itemno;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemStatus = itemStatus;
		this.writeDate = writeDate;
		this.allItemCount = allItemCount;
	}

	@Override
	public String toString() {
		return "Item [itemno=" + itemno + ", itemTitle=" + itemTitle + ", itemContent=" + itemContent + ", itemPrice="
				+ itemPrice + ", itemType=" + itemType + ", itemStatus=" + itemStatus + ", writeDate=" + writeDate
				+ ", allItemCount=" + allItemCount + "]";
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getAllItemCount() {
		return allItemCount;
	}

	public void setAllItemCount(int allItemCount) {
		this.allItemCount = allItemCount;
	}
	
}
