package com.kh.jaManChw.admin.itemmanage.dao.face;

import java.util.List;
import java.util.Map;

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

}
