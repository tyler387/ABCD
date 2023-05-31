package com.kh.jaManChw.admin.boardmanage.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

public interface QnAQService {

	/**
	 * QnA문의에 대한 페이징을 생성한다
	 * 
	 * @param curPage - 현재 페이지를 가져올 변수
	 * @return 페이징을 하는 페이징 객체
	 */
	public Paging getPaging(String curPage);

	/**
	 * 전체 QnA문의를 조회한다
	 * 
	 * @param paging - QnA문의글에 대한 페이징을 하는 페이징 객체 
	 * @return 전체 QnA문의
	 */
	public List<Map<String, Object>> showQnAList(Paging paging);

	/**
	 * 필터링을 통해 QnA 문의 리스트를 조회한다
	 * 
	 * @param filterAndPagingMap - 필터링 조건과 검색값을 전달할 맵
	 * @param paging - 페이징을 위한 페이징 객체
	 * @return 필터링된 QnA 문의 리스트
	 */
	public List<Map<String, Object>> showQnAQListByFilter(Map<String, Object> filterAndPagingMap, Paging paging);

	/**
	 * 필터링에 대한 페이징 객체를 생성해 반환한다
	 * 
	 * @param filterAndPagingMap - 필터링 조건값
	 * @return - 필터링에 대한 페이징 객체
	 */
	public Paging getQnAPaging(Map<String, Object> filterAndPagingMap);

	/**
	 * 해당 문의글 번호를 통해서 문의글의 상세정보를 반환한다
	 * 
	 * @param questionno -문의글 번호 
	 * @return 해당 문의글의 상세정보
	 */
	public Map<String, String> showQnAQDetail(int questionno);


}
