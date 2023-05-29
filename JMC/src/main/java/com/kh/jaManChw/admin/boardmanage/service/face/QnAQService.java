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


}
