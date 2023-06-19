package com.kh.jaManChw.customerService.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

public interface CSDao {

	/**
	 * 관리자 게시글중 공지사항(notice)에 대한 총 게시글 숫자를 반환한다
	 * 
	 * @return 총 공지사항 글 수
	 */
	public int selectCntTotalNotice();

	/**
	 * 전체 공지사항에 대한 리스트를 반환한다
	 * 
	 * @param paging - 공지사항 페이징 객체
	 * @return 전체 공지사항 리스트
	 */
	public List<Map<String, Object>> selectNoticeList(Paging paging);

	/**
	 * 선택한 공지사항에 대한 상세정보를 반환한다
	 *
	 * @param adminBoardno - 관리자 게시글 번호
	 * @return 선택한 공지사항 상세정보
	 */
	public Map<String, Object> selectNoticeDetail(int adminBoardno);

	/**
	 * 관리자 게시글중 이벤트(event)에 대한 총 게시글 숫자를 반환한다 
	 * 
	 * @return 총 이벤트 글 수
	 */
	public int selectCntTotalEvent();
	
	/**
	 * 전체 이벤트에 대한 리스트를 반환한다
	 * 
	 * @param paging - 이벤트 페이징 객체 
	 * @return 전체 이벤트 리스트
	 */
	public List<Map<String, Object>> selectEventList(Paging paging);

	/**
	 * 선택한 이벤트에 대한 상세 정보를 반환한다
	 * 
	 * @param adminBoardno  - 관리자 게시글 번호
	 * @return 선택한 이벤트 상세정보
	 */
	public Map<String, Object> selectEventDetail(int adminBoardno);

	/**
	 * 전체 문의 게시글의 숫자를 반환한다 
	 * 
	 * @return 총 문의 게시글 수 
	 */
	public int selectCntTotalQnA();
	
	/**
	 * 전체 Q&A에 대한 리스트를 반환한다 
	 * 
	 * @param paging - 이벤트 페이징 객체 
	 * @return 전체 Q&A 리스트
	 */
	public List<Map<String, Object>> selectQnAList(Paging paging);

	/**
	 * 선택한 Q&A에 대한 상세정보를 반환한다
	 * 
	 * @param questionno - 선택한 Q&A 문의번호
	 * @return 선택한 Q&A에 대한 상세정보
	 */
	public Map<String, Object> selectQnADetail(int questionno);
	
	/**
	 * DTO를 통해 QnA문의를 DB에 삽입한다
	 * 
	 * @param completeQnAQ - 문의글을 담아올 DTO객체
	 */
	public void insertQnAQ(QnAQ completeQnAQ);

	/**
	 * Q&A문의 수정 정보를 받아 DB에 수정한다
	 * 
	 * @param qnAQ Q&A 문의 수정 정보
	 */
	public void updateQnAQ(QnAQ qnAQ);

	/**
	 * Q&A문의번호를 받아 문의글을 삭제한다
	 * 
	 * @param questionno - 문의번호
	 */
	public void deleteQnAQ(int questionno);

	//여기까지함
	
	/**
	 * 문의 글에 대한 상태가 q_status가 "undelete"인 답변의 갯수를 구한다
	 * 
	 * @param questionno - 문의번호
	 * @return 답글 갯수
	 */
	public int selectCntAnswer(int questionno);

	/**
	 * 문의 글에 답변한 답변글의 상세 정보를 가져온다
	 * 
	 * @param questionno - 문의번호
	 * @return 답변 상세 정보
	 */
	public Map<String, Object> selectQnAADetail(int questionno);
	
	
	
	
	

}
