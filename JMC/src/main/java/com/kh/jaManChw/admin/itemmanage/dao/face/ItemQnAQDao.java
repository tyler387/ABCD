package com.kh.jaManChw.admin.itemmanage.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.dto.ItemQnAA;
import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

public interface ItemQnAQDao {

	/**
	 * 페이징을 위해 전체 판매 문의글 갯수를 조회한다
	 * 
	 * @return - 전체 판매 문의글 수 
	 */
	public int selectCntAllQnAQ();

	/**
	 * 페이징한 전체 판매 문의글 리스트를 반환한다
	 * 
	 * @param itemQnAQPaging - 패이징 객체
	 * @return - 페이징된 전체 판매 문의글 리스트
	 */
	public List<Map<String, Object>> selectItemQnAQAll(Paging itemQnAQPaging);

	/**
	 * 필터링된 판매문의글의 페이징을 위해 글의 갯수를 조회한다
	 * 
	 * @param filterMap - 필터링 정보를 가져올 맵
	 * @return - 필터링된 판매문의 글의 갯수
	 */
	public int selectCntFilterQnAQ(Map<String, String> filterMap);

	/**
	 * 필터링 후 페이징한 상품 문의글 리스트를 조회하여 반환한다
	 * 
	 * @param fpMap - 패이징 객체, 필터링 조건을 가진 맵
	 * 
	 * @return - 필터링후 페이징한 판매 문의글 
	 */
	public List<Map<String, Object>> selectItemQnAQListByFilter(Map<String, Object> fpMap);

	/**
	 * 상품 문의 번호를 통해 상문 문의 상세 정보를 조회한다
	 * 
	 * @param itemQnano - 상품 문의 번호
	 * @return 상품 상세 정보
	 */
	public Map<String, Object> selectItemQnAQDetail(int itemQnano);

	/**
	 * 상품 문의에 답변을 하면 ITEM_QnA_Q의 상태가 "done"으로 변경된다
	 * 
	 * @param itemQnAAParam - 상품 문의 번호를 담은 DTO객체
	 */
	public void updateItemQnAQ(ItemQnAA itemQnAAParam);

	/**
	 * 상품 문의 답변을 삭제 하면 해당 상품 문의의 상태가 "unprocessed"으로 변경된다
	 * 
	 * @param itemQnAAParam - 상품 문의 번호를 담은 DTO객체
	 */
	public void updateItemQnAQUnprocessed(ItemQnAA itemQnAAParam);

	/**
	 * 기훈 작성 : 아이템 페이지에서 해당 아이템 QnA목록을 반환 한다.
	 * @param itemQnAQPaging 페이징
	 * @param itemno         해당 아이템 번호
	 * @return        아이템 페이지에서 해당 아이템 QnA목록을 반환 한다.  
	 */
	public List<Map<String, Object>> selectItemQnAQAll2(@Param("itemQnAQPaging") Paging itemQnAQPaging, @Param("itemno") int itemno);



}
