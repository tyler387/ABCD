package com.kh.jaManChw.admin.itemmanage.dao.face;

import java.util.Map;

import com.kh.jaManChw.dto.ItemQnAA;
import com.kh.jaManChw.dto.QnAA;

public interface ItemQnAADao {

	/**
	 * 입력한 상품 문의 답변을 DB에 저장한다
	 * 
	 * @param qnAAParam - 입력받은 상품 문의 답변 정보
	 */
	public void insertItemQnAA(ItemQnAA itemQnAAParam);

	/**
	 * 기존에 입력했던 상품 문의 답변을 조회하여 반환한다
	 * 
	 * @param mgrItemno - 상품 문의 답변 번호
	 * @return 기존의 상품 문의 답변 
	 */
	public Map<String, Object> selectItemQnAADetail(int mgrItemno);

	/**
	 * 수정 입력된 상품 문의 답변을 DB에 수정한다
	 * 
	 * @param itemQnAAParam - 수정 입력된 상품 문의 답변
	 */
	public void updateItemQnAA(ItemQnAA itemQnAAParam);

	/**
	 * 상품 문의 답변 번호(mgrItemno)를 통해 해당 글의 상태를 "delete"로 변경한다
	 * 
	 * @param mgrItemno 상품 문의 답변 번호
	 */
	public void updateItemQnAAStatus(int mgrItemno);

}
