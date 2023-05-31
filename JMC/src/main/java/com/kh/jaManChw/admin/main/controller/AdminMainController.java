package com.kh.jaManChw.admin.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	@RequestMapping("/main")
	public void adminmain() {
		logger.info("어드민 메인 접속");
	}
	
	//관리자 게시글 구분 세션 추가
	@RequestMapping("/main/boardCategory")
	public String adminBoardOptionSession(HttpSession session, String boardOption) {
		session.setAttribute("boardOption", boardOption);
		
		return "redirect:../board/list";
	}
}
