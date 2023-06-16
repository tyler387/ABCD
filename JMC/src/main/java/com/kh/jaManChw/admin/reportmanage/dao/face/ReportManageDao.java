package com.kh.jaManChw.admin.reportmanage.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

public interface ReportManageDao {

	public int selectCntAll(String type);

	public List<Map<String, Object>> selectReportPost(Paging paging);

	public List<Map<String, Object>> selectReportPostView(String reportno);

	public List<Map<String, Object>> selectUserPost(Paging paging);

	public List<Map<String, Object>> selectReportUserView(String reportno);

	public List<Map<String, Object>> selectReportPostFiltering(Map<String, Object> map);

	public void updateReportPostState(Map<String, Object> map);

	public List<Map<String, Object>> selectReportMeeting(Paging paging);

	public List<Map<String, Object>> selectReportMeetingView(String reportno);

	public void deleteReportPostBoard(Map<String, Object> map);

	public void updateReportMeeting(Map<String, Object> map);

	public void deleteReportMeeting(Map<String, Object> map);

	public int selectFilterCntAll(Map<String, Object> map);



}
