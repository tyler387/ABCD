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


}
