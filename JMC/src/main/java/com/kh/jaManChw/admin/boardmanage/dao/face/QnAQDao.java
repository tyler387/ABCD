package com.kh.jaManChw.admin.boardmanage.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.QnAA;
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

	/**
	 * 필터링한 QnA_Q테이블의 전체 게시글 수를 조회한다
	 * 
	 * @param filterMap - 필터링 조건을 가져올 맵
	 * @return
	 */
	public int selectCntQnAQFilterAll(Map<String, Object> filterMap);

	/**
	 * 필터링을 통해 QnA 문의 리스트를 조회한다
	 * 
	 * @param filterMap - 필터링 조건과 검색값을 전달할 맵
	 * @return 필터링된 QnA 문의 리스트
	 */
	public List<Map<String, Object>> selectQnAQByFilter(Map<String, Object> filterMap);

	/**
	 * 해당 문의글 번호를 통해서 문의글의 상세정보를 반환한다
	 * 
	 * @param questionno -문의글 번호 
	 * @return 해당 문의글의 상세정보
	 */
	public Map<String, String> selectQnAQDetail(int questionno);

	/**
	 * QnA답변 삭제시 전달받는 questionno를 통해 처리상태를 "unprocessed"로 변경한다
	 * 
	 * @param qnAAParam - questionno를 가져올 dto객체
	 */
	public void updateQnAQStatus(QnAA qnAAParam);



 
}
