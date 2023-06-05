package com.kh.jaManChw.admin.itemmanage.dao.face;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;

public interface ItemDao {

	/**
	 * itemno를 조회하여 반환한다
	 * 
	 *@return - itemno
	 */
	public int getItemno();

	/**
	 * 판매 글 작성시 item DTO를 통해 전달된 데이터를 DB에 저장한다
	 * 
	 * @param item - 판매 상품 정보
	 */
	public void insertItem(Item item);

	/**
	 * 판매 글 작성시 옵션을 추가 했을때 itemOption DTO를 통해 전달된 데이터를 DB에 저장한다
	 * 
	 * @param itemOption - 판매 상품의 옵션 정보
	 */
	public void insertItemOption(ItemOption itemOption);

	/**
	 * 판매 글 작성시 상품의 대표 사진에 대한 정보를 DB에 저장한다
	 * 
	 * @param itemFile - 판매 상품의 대표 사진 정보
	 */
	public void insertItemFile(ItemFile itemFile);

}
