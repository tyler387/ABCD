package com.kh.jaManChw.admin.boardmanage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAQService;
import com.kh.jaManChw.util.Paging;

@Controller
@RequestMapping("/admin")
public class AdminBoardManageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminBoardService adminBoardService;
	@Autowired private QnAAService qnAAService;
	@Autowired private QnAQService qnAQService;
	
	@GetMapping("/main")
	public void adminPage(){		
	}
	
	//관리자 게시글 관리 페이지로 이동
	@GetMapping("/board/list")
	public void adminBoardPage(
				String boardOption,
				String curPage,
				HttpSession session,
				Model model
			) {
		
		session.setAttribute("boardOption", boardOption);
		
		Paging page = adminBoardService.getBoardPaging(curPage, boardOption);
		
		List<Map<String, String>> boardList = adminBoardService.showAdminBoardListByBoardOption(boardOption, page);
		
		logger.info("session:{}",session.getAttribute("boardOption"));
		model.addAttribute("boardOption", session.getAttribute("boardOption"));
		model.addAttribute("paging", page);
		model.addAttribute("boardList",boardList);
		
	}
	
	
}
