package com.kh.jaManChw.admin.reportmanage.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

public interface ReportManageService {

	public Paging getpaging(String ccurpage, String type);
	
	/**
	 * 신고 게시글 목록 조회
	 * 
	 * @param paging
	 * @return
	 */
	public List<Map<String, Object>> reportPostPage(Paging paging);
	
	/**
	 * 
	 * 신고글 제목 클릭하여 상세조회
	 * 
	 * @param rbreportno
	 * @return
	 */
	public List<Map<String, Object>> getReportPostView(String reportno);

	/**
	 * 신고 유저 목록 조회
	 * 
	 * @param paging
	 * @return
	 */
	public List<Map<String, Object>> reportUserPage(Paging paging);

	
	/**
	 * 
	 * 신고글 제목 클릭하여 상세조회
	 * 
	 * @param rbreportno
	 * @return
	 */
	public List<Map<String, Object>> getReportUserView(String reportno);

	/**
	 * 필터를 통해 회원 검색
	 * @param map 
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getReportPostFiltering(Map<String, Object> map);
	
	/**
	 *  신고 게시글에서 승인 클릭시
	 * @param username
	 * @param type 
	 */
	public void reviseReportPostSate(Map<String, Object> map);
	
	/**
	 * 미팅 신고 전체 조회
	 * 
	 * @param paging
	 * @return
	 */
	public List<Map<String, Object>> reportMeetingPage(Paging paging);
	
	/**
	 * 미팅 신고 상세 조회
	 * 
	 * @param reportno
	 * @return
	 */
	public List<Map<String, Object>> getReportPostMeeting(String reportno);
	
	/**
	 * 신고글 관련 보드에 작성된 게시글 삭제
	 * @param map
	 */
	public void eraseReportPost(Map<String, Object> map);
	
	/**
	 * 미팅 신고글 반려, 승인 처리
	 * 
	 * @param map
	 */
	public void reviseReportMeetingState(Map<String, Object> map);
	
	/**
	 * 미팅 신고글을 통해 미팅 상태 삭제 처리
	 * 
	 * @param map
	 */
	public void eraseReportMeeting(Map<String, Object> map);
	
	/**
	 * 필터링에서 사용할 페이징 수 계산
	 * 
	 * @param ccurpage
	 * @param map
	 * @return
	 */
	public Paging getFilterPaging(String ccurpage, Map<String, Object> map);


}
