package com.kh.jaManChw.admin.itemmanage.service.face;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.ItemQnAA;
import com.kh.jaManChw.dto.QnAA;

public interface ItemQnAAService {

	/**
	 * 상품 문의에 대한 답변을 DB에 등록한다 
	 * 
	 * @param qnAAParam 상품 문의 답변 정보를 담아올 DTO객체
	 */
	public void writeItemQnAA(ItemQnAA itemQnAAParam);

	/**
	 * 상품 문의 번호(itemQnano), 상품 문의 답변 번호(mgrItemno)를 통해
	 * 이전에 작성한 상품 문의 답변에 대한 수정을 위해 상품 문의글, 작성했던 상품 문의 답변의 상세정보를 가져온다
	 * 
	 * @param itemQnAAParam - 상품 문의 정보와 상품문의 답변 번호를 가져올 DTO객체 
	 * @return 상품 문의글, 상품 문의 답변글의 상세정보
	 */
	public Map<String, Map<String, Object>> showItemQnAAllDetail(ItemQnAA itemQnAAParam);

	/**
	 * session에 담긴 userno를 itemQnAAParam에 넣어 완전한 DTO를 만들어 반환한다
	 * 
	 * @param itemQnAAParam - userno가 비어있는 DTO
	 * @param session - userno를 담고 있는 세션 객체
	 */
	public ItemQnAA getCompleteItemQnAA(ItemQnAA itemQnAAParam, HttpSession session);

	/**
	 * 수정 입력된 상품 문의 답변을 DB에 수정한다
	 * 
	 * @param itemQnAAParam - 수정 입력된 상품 문의 답변
	 */
	public void reviseItemQnAA(ItemQnAA itemQnAAParam);

	/**
	 * 상품 문의 답변 번호(mgrItemno)를 통해 해당 글의 상태를 "delete"로 변경하고
	 * 상품 문의 번호(itemQnano)를 통해 상품 문의의 상태를 "unprocessed"로 변경한다
	 * 
	 * @param itemQnAAParam 상품 문의, 상품 문의 답변 번호
	 */
	public void eraseItemQnAA(ItemQnAA itemQnAAParam);


	
}
