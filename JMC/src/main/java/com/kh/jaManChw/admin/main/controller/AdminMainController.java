package com.kh.jaManChw.admin.main.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.admin.main.service.face.AdminMainService;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminMainService adminMainService;
	

	@RequestMapping("/main")
	public String adminmain(Model model) {
		logger.info("어드민 메인 접속");
		
		//관리자가 한눈에 알아볼 전체 정보를 출력한다
		Map<String, Object> allInfoMap = adminMainService.getAllInfo();
		
		model.addAttribute("allInfoMap",allInfoMap);
		
		return "admin/mainContent";
	}
	
	//관리자 게시글 구분 세션 추가
	@RequestMapping("/main/boardCategory")
	public String adminBoardOptionSession(HttpSession session, String boardOption ) {
		session.setAttribute("boardOption", boardOption);
		
		return "redirect:/admin/board/boardview/list";
	}
}
