package com.kh.jaManChw.admin.itemmanage.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

public interface ItemQnAQService {

	/**
	 * 전체 상품 문의에 대한 페이징을 하는 페이징 객체를 생성해 반환한다
	 * 
	 * @param curPage - 현재 페이지
	 * @return 전체 상품 문의 페이징 객체
	 */
	public Paging getItemQnAQPaging(String curPage);

	/**
	 * 페이징 된 전체 상품 문의글 리스트를 조회하여 반환한다
	 * 
	 * @param itemQnAQPaging - 페이징 객체
	 * @return 페이징된 전체 상품 문의글 리스트
	 */
	public List<Map<String, Object>> showItemQnAQList(Paging itemQnAQPaging);

	/**
	 * 필터링된 상품 문의에 대한 페이징 하는 객체를 생성해 반환한다 
	 * 
	 * @param filterMap - 필터링 조건을 가진 맵
	 * @param curPage - 현재 페이지
	 * @return 필터링된 상품 문의글에 대한 객체
	 */
	public Paging getItemQnAQFilterPaging(Map<String, String> filterMap, String curPage);

	/**
	 * 필터링 후 페이징한 상품 문의글 리스트를 조회하여 반환한다
	 * 
	 * @param filterMap - 필터링 조건을 가진 맵
	 * @param paging  - 패이징 객체
	 * 
	 * @return - 필터링후 페이징한 판매 문의글 
	 */
	public List<Map<String, Object>> showItemQnAQListByFilter(Paging paging, Map<String, String> filterMap);

	/**
	 * itemQnano를 통해 상세 상품문의 정보를 조회하여 반환한다
	 * 
	 * @param itemQnano 상품을 조회할  상품 번호
	 * @return 상세 상품 정보
	 */
	public Map<String, Object> showItemQnAQDetail(int itemQnano);

	/**
	 * 기훈 작성 : 아이템 페이지에서 해당 아이템 QnA목록을 반환 한다.
	 * @param itemQnAQPaging 페이징
	 * @param itemno         해당 아이템 번호
	 * @return        아이템 페이지에서 해당 아이템 QnA목록을 반환 한다.  
	 */
	public List<Map<String, Object>> showItemQnAQList2(Paging itemQnAQPaging, int itemno);

}
