package com.kh.jaManChw.admin.itemmanage.service.face;

import java.util.Map;

import com.kh.jaManChw.dto.QnAA;

public interface ItemQnAAService {

	/**
	 * 상품 문의에 대한 답변을 DB에 등록한다 
	 * 
	 * @param qnAAParam 상품 문의 답변 정보를 담아올 DTO객체
	 */
	public void writeItemQnAA(QnAA qnAAParam);

	/**
	 * 상품 문의 번호(itemQnano), 상품 문의 답변 번호(mgrItemno)를 통해
	 * 이전에 작성한 상품 문의 답변에 대한 수정을 위해 상품 문의글, 작성했던 상품 문의 답변의 상세정보를 가져온다
	 * 
	 * @param qnAAParam - 상품 문의 정보와 상품문의 답변 번호를 가져올 DTO객체 
	 * @return 상품 문의글, 상품 문의 답변글의 상세정보
	 */
	public Map<String, Map<String, Object>> reviseItemQnAQ(QnAA qnAAParam);

	/**
	 * 상품 문의 답변 번호(mgrItemno)를 통해 해당 글의 상태를 "delete"로 변경한다
	 * 
	 * @param mgrItemno 상품 문의 답변 번호
	 */
	public void eraseItemQnAQ(int mgrItemno);

}
