package com.kh.jaManChw.admin.boardmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAQService;

@Controller
@RequestMapping("/admin")
public class AdminBoardManageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminBoardService adminBoardService;
	@Autowired private QnAAService qnAAService;
	@Autowired private QnAQService qnAQService;
	
	//관리자 게시글 관리 페이지로 이동
	@GetMapping("/boardPage")
	public void adminBoardPage() {
		
	}
	
	
}
