package com.kh.jaManChw.customerService.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

public interface CSService {

	/**
	 * 공지사항에 대한 페이징 객체를 반환한다
	 * 
	 * @param curPage - 현재 페이지 번호
	 * @return 공지사항 페이징 객체
	 */
	public Paging getNoticePaging(String curPage);

	/**
	 * 전체 공지사항에 대한 리스트를 반환한다
	 * 
	 * @param paging - 공지사항 페이징 객체
	 * @return 전체 공지사항 리스트
	 */
	public List<Map<String, Object>> showNoticeList(Paging paging);

	/**
	 * 선택한 공지사항에 대한 상세정보를 반환한다
	 *
	 * @param adminBoardno - 관리자 게시글 번호
	 * @return 선택한 공지사항 상세정보
	 */
	public Map<String, Object> showNoticeDetail(int adminBoardno);

	/**
	 * 이벤트에 대한 페이징 객체를 반환한다
	 * 
	 * @param curPage - 현재 페이지 번호
	 * @return 이벤트 페이징 객체 
	 */
	public Paging getEventPaging(String curPage);
	
	/**
	 * 전체 이벤트에 대한 리스트를 반환한다
	 * 
	 * @param paging - 이벤트 페이징 객체 
	 * @return 전체 이벤트 리스트	 */
	public List<Map<String, Object>> showEventList(Paging paging);

	/**
	 * 선택한 이벤트에 대한 상세 정보를 반환한다
	 * 
	 * @param adminBoardno  - 관리자 게시글 번호
	 * @return 선택한 이벤트 상세정보
	 */
	public Map<String, Object> showEventDetail(int adminBoardno);
	
	/**
	 * Q&A에 대한 페이징 객체를 반환한다
	 * 
	 * @param curPage - 현재 페이지 번호
	 * @return Q&A 페이징 객체
	 */
	public Paging getQnAPaging(String curPage);
	
	/**
	 * 전체 Q&A에 대한 리스트를 반환한다 
	 * 
	 * @param paging - 이벤트 페이징 객체 
	 * @return 전체 Q&A 리스트
	 */
	public List<Map<String, Object>> showQnAList(Paging paging);

	/**
	 * 선택한 Q&A에 대한 상세정보를 반환한다
	 * 
	 * @param questionno - 선택한 Q&A 문의번호
	 * @return 선택한 Q&A에 대한 상세정보
	 */
	public Map<String, Object> showQnADetail(int questionno);
	
	/**
	 * 세션에 담긴 userno와 작성한 글을 통해 완성된 QnAQ DTO를 만들어 반환한다
	 * 
	 * @param session - userno가 담긴 세션 객체
	 * @param qnAQ - 작성된 글을 담은 DTO
	 * @return 완성된 QnAQ DTO
	 */
	public QnAQ getCompleteQnAQ(HttpSession session, QnAQ qnAQ);

	/**
	 * DTO를 통해 QnA문의를 DB에 삽입한다
	 * 
	 * @param completeQnAQ - 문의글을 담아올 DTO객체
	 */
	public void writeQnAQ(QnAQ completeQnAQ);

	/**
	 * Q&A문의 수정 정보를 받아 DB에 수정한다
	 * 
	 * @param qnAQ Q&A 문의 수정 정보
	 */
	public void reviseQnAQ(QnAQ qnAQ);

	/**
	 * 문의글 번호를 통해 문의 글을 삭제한다
	 * 
	 * @param questionno - 문의글 번호
	 */
	public void eraseQnAQ(int questionno);

	/**
	 * 답변이 달렸는지 조회한다
	 * 
	 * @param questionno - 문의글 번호
	 * @return true - 답변이 존재함, false - 답변이 되지 않음
	 */
	public boolean isAnswered(int questionno);

	/**
	 * 답변이 달린 답변글을 보여준다
	 * 
	 * @param questionno - 문의글 번호
	 * @return 답변 상세글
	 */
	public Map<String, Object> showQnAADetail(int questionno);









	
	
	
	
}
