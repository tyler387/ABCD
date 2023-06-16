package com.kh.jaManChw.admin.reportmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.reportmanage.dao.face.ReportManageDao;
import com.kh.jaManChw.admin.reportmanage.service.face.ReportManageService;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@Service
public class ReportManageServiceImpl implements ReportManageService {

	@Autowired ReportManageDao reportManageDao;
	@Override
	public Paging getpaging(String ccurpage,  String type) {
		//전달파라미터 curPage 추출
		
		String param = ccurpage;
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] BoardService - getPaging() : curPage값이 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = reportManageDao.selectCntAll(type);
		
		//페이징 객체
//		Paging paging = new Paging(totalCount, curPage, 30, 5); //listCount:30, pageCount:5
		Paging paging = new Paging(curPage, totalCount);
		
		return paging;
	}

	@Override
	public List<Map<String, Object>> reportPostPage(Paging paging) {
		
		return reportManageDao.selectReportPost(paging);
	}
	@Override
	public List<Map<String, Object>> getReportPostView(String reportno) {
		
		return reportManageDao.selectReportPostView(reportno);
	}

	@Override
	public List<Map<String, Object>> reportUserPage(Paging paging) {
		
		return reportManageDao.selectUserPost(paging);
	}
	@Override
	public List<Map<String, Object>> getReportUserView(String reportno) {
		return reportManageDao.selectReportUserView(reportno);
	}
	
	@Override
	public List<Map<String, Object>> getReportPostFiltering(Map<String, Object> map) {
		
		return reportManageDao.selectReportPostFiltering(map);
	}
	
	@Override
	public void reviseReportPostSate(Map<String, Object> map) {
		
		reportManageDao.updateReportPostState(map);
		
	}
	
	@Override
	public List<Map<String, Object>> reportMeetingPage(Paging paging) {
		
		return reportManageDao.selectReportMeeting(paging);
	}
	
	@Override
	public List<Map<String, Object>> getReportPostMeeting(String reportno) {
		return reportManageDao.selectReportMeetingView(reportno);
	}
	@Override
	public void eraseReportPost(Map<String, Object> map) {
		reportManageDao.deleteReportPostBoard(map);
	}
	
	@Override
	public void reviseReportMeetingState(Map<String, Object> map) {
		
		reportManageDao.updateReportMeeting(map);
	}
	
	@Override
	public void eraseReportMeeting(Map<String, Object> map) {
		reportManageDao.deleteReportMeeting(map);
	}
	
	@Override
	public Paging getFilterPaging(String ccurpage, Map<String, Object> map) {
		//전달파라미터 curPage 추출
		
		String param = ccurpage;
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] BoardService - getPaging() : curPage값이 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = reportManageDao.selectFilterCntAll(map);
		
		//페이징 객체
//		Paging paging = new Paging(totalCount, curPage, 30, 5); //listCount:30, pageCount:5
		Paging paging = new Paging(curPage, totalCount);
		
		return paging;
	}
}
