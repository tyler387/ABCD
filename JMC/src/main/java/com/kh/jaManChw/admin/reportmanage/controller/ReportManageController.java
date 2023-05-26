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
			Model model,
			String curPage
			) {
		logger.info("post list");
		String ccurpage = curPage;
		Paging paging = reportManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Map<String, Object>> reportB = reportManageService.reportPostPage(paging);
		logger.info("report B : {}", reportB);
		model.addAttribute("reportB", reportB);
		model.addAttribute("paging", paging);
		
	}
	
	@RequestMapping("/post/filter")
	public void userfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) {
		String ccurpage = curPage;
		Paging paging = reportManageService.getpaging(ccurpage);
		map.put("paging", paging);
		List<Map<String, Object>> reportpost = reportManageService.getReportPostFiltering(map);
		logger.info("{}", reportpost);
		model.addAttribute("userfilter", reportpost);
	}
	
	@RequestMapping("/post/postview")
	public void ReportPostView(Model model, @RequestParam String reportno) {
		logger.info("boardno : {}", reportno);
		
		List<Map<String, Object>> reportView = reportManageService.getReportPostView(reportno);
		logger.info("boardno : {}", reportView);
		
		model.addAttribute("reportView", reportView);
		
	}
	
	
	@RequestMapping("/user/list")
	public void ReportUserList(
			Model model,
			String curPage
			) {
		logger.info("user list");
		String ccurpage = curPage;
		Paging paging = reportManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Map<String, Object>> reportU = reportManageService.reportUserPage(paging);
		logger.info("report U : {}", reportU);
		model.addAttribute("reportU", reportU);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/user/userview")
	public void ReportUserView(Model model, @RequestParam String reportno) {
		logger.info("boardno : {}", reportno);
		
		List<Map<String, Object>> userView = reportManageService.getReportUserView(reportno);
		logger.info("userview : {}", userView);
		
		model.addAttribute("userView", userView);
		
	}
	
}
