package com.kh.jaManChw.admin.reportmanage.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jaManChw.admin.reportmanage.service.face.ReportManageService;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/admin/report")
@Controller
public class ReportManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired ReportManageService reportManageService;
	
	@RequestMapping("/post/list")
	public void ReportPost(
			Model model,String curPage
			) {
		logger.info("post list");
		String ccurpage = curPage;
		String type = "board";
		Paging paging = reportManageService.getpaging(ccurpage, type);
		logger.info("{}",paging);
		List<Map<String, Object>> reportB = reportManageService.reportPostPage(paging);
		logger.info("report B : {}", reportB);
		model.addAttribute("reportB", reportB);
		model.addAttribute("paging", paging);
		
	}
	
	
	@RequestMapping("/post/filter")
	public String ReportPostfiltering(
			Model model, String curPage, @RequestParam Map<String, Object> map
			) {
		logger.info("map 출력 {}", map);
		String ccurpage = curPage;
		map.put("type", "board");
		Paging paging = reportManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		logger.info("map 출력 {}", map.get("status"));
//		if(map.get("status") == null) {
//			logger.info("상태값 없음, 필터만 검색");
//			model.addAttribute("filterList", true);
//		}else if(map.get("status") != null && map.get("content") == null){
//			logger.info("상태값 있음, 상태만 검색");
//			model.addAttribute("filterStatus", true);
//		}else if(map.get("status") != null) {
//			logger.info("상태값만 있고 필터 X, 상태만 검색");
//			model.addAttribute("filterStatus", true);
//		}else if(map.get("status") != null &&  map.get("content") != null) {
//			logger.info("상태값, 필터 모두 검색");
//			model.addAttribute("filterListStatus", true);
//		}
		List<Map<String, Object>> reportpost = reportManageService.getReportPostFiltering(map);
		logger.info("map 출력 {}", map);
		model.addAttribute("filterListStatus", true);
		logger.info("reportpost {}", reportpost);
		model.addAttribute("reportB", reportpost);
		model.addAttribute("paging", paging);
		model.addAttribute("filter", map);
		return "/admin/report/post/filter";
	}
	
	@RequestMapping("/post/postview")
	public void ReportPostView(Model model, @RequestParam String reportno) {
		logger.info("boardno : {}", reportno);
		
		List<Map<String, Object>> reportView = reportManageService.getReportPostView(reportno);
		logger.info("boardno : {}", reportView);
		
		model.addAttribute("reportView", reportView);
	}
	
	@RequestMapping("/post/state")
	public String ReportPostState(@RequestParam Map<String, Object> map) {
		logger.info("승인, 반려 타입 {}", map);
		reportManageService.reviseReportPostSate(map);
		
		return "redirect:/admin/report/post/list";
	}
	
	@RequestMapping("/user/state")
	public String ReportUserState(@RequestParam Map<String, Object> map) {
		logger.info("승인, 반려 타입 {}", map);
		reportManageService.reviseReportPostSate(map);
		
		return "redirect:/admin/report/user/list";
	}
	
	@RequestMapping("/post/boarddelete")
	public String ReportPostBoardDelete(@RequestParam Map<String, Object> map) {
		logger.info("게시글 삭제 하게 받아온 값들 : {}", map);
		
		reportManageService.eraseReportPost(map);
		
		return "redirect:/admin/report/post/list";
		}
	
	
	@RequestMapping("/user/list")
	public void ReportUserList(
			Model model,String curPage
			) {
		logger.info("user list");
		String type = "user";
		String ccurpage = curPage;
		Paging paging = reportManageService.getpaging(ccurpage, type);
		logger.info("{}",paging);
		List<Map<String, Object>> reportU = reportManageService.reportUserPage(paging);
		logger.info("report U : {}", reportU);
		model.addAttribute("reportU", reportU);
		model.addAttribute("paging", paging);
	}
	
	
	@RequestMapping("/user/filter")
	public String ReportUserfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) {
		logger.info("map 출력 {}", map);
		String ccurpage = curPage;
		map.put("type", "user");
		Paging paging = reportManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		logger.info("map 출력 {}", map.get("status"));
		List<Map<String, Object>> reportpost = reportManageService.getReportPostFiltering(map);
		logger.info("map 출력 {}", map);
		model.addAttribute("filterListStatus", true);
		logger.info("reportpost {}", reportpost);
		model.addAttribute("reportB", reportpost);
		model.addAttribute("paging", paging);
		model.addAttribute("filter", map);
		return "/admin/report/post/filter";
	}
	
	@RequestMapping("/user/userview")
	public void ReportUserView(Model model, @RequestParam String reportno) {
		logger.info("boardno : {}", reportno);
		
		List<Map<String, Object>> userView = reportManageService.getReportUserView(reportno);
		logger.info("userview : {}", userView);
		
		model.addAttribute("userView", userView);
		
	}
	
	@RequestMapping("/meeting/list")
	public void ReportMeetingList(
			Model model,
			String curPage
			) {
		logger.info("post list");
		String ccurpage = curPage;
		String type = "meeting";
		Paging paging = reportManageService.getpaging(ccurpage, type);
		logger.info("{}",paging);
		List<Map<String, Object>> reportB = reportManageService.reportMeetingPage(paging);
		logger.info("report B : {}", reportB);
		model.addAttribute("reportB", reportB);
		model.addAttribute("paging", paging);
	}
	@RequestMapping("/meeting/filter")
	public String ReportMeetingfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) {
		logger.info("map 출력 {}", map);
		String ccurpage = curPage;
		map.put("type", "meeting");
		Paging paging = reportManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		logger.info("map 출력 {}", map.get("status"));
		List<Map<String, Object>> reportpost = reportManageService.getReportPostFiltering(map);
		logger.info("map 출력 {}", map);
		model.addAttribute("filterListStatus", true);
		logger.info("reportpost {}", reportpost);
		model.addAttribute("reportB", reportpost);
		model.addAttribute("paging", paging);
		model.addAttribute("filter", map);
		return "/admin/report/post/filter";
	} 
	
	@RequestMapping("/meeting/meetingview")
	public void ReportMeetingView(Model model, @RequestParam String reportno) {
		logger.info("boardno : {}", reportno);
		
		List<Map<String, Object>> meetingView = reportManageService.getReportPostMeeting(reportno);
		logger.info("boardno : {}", meetingView);
		
		model.addAttribute("meetingView", meetingView);
	}
	
	@RequestMapping("/meeting/meetingdelete")
	public String ReportMeetingDelete(@RequestParam Map<String, Object> map) {
		logger.info("게시글 삭제 하게 받아온 값들 : {}", map);
		
		reportManageService.eraseReportMeeting(map);
		
		return "redirect:/admin/report/meeting/list";
	}
	
	@RequestMapping("/meeting/state")
	public String ReportMeetingState(@RequestParam Map<String, Object> map) {
		logger.info("승인, 반려 타입 {}", map);
		reportManageService.reviseReportMeetingState(map);
		
		return "redirect:/admin/report/meeting/list";
	}
}
