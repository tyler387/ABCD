package com.kh.jaManChw.admin.boardmanage.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

public interface QnAQDao {

	/**
	 * QnA_Q 테이블의 전체 게시글 수를 조회한다(totalCount로 사용하기 위해)
	 *  
	 * @return 전체 게시글의 수
	 */
	public int selectCntQnAQ();

	/**
	 * 전체 QnA문의 리스트를 조회한다
	 * 
	 * @param paging - QnA문의글에 대한 페이징을 하는 페이징 객체 
	 * @return - 전체 QnA문의 리스트
	 */
	public List<Map<String, Object>> selectQnAQAll(Paging paging);


}
