package com.kh.jaManChw.admin.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminMainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/admin/main")
	public void adminmain() {
		logger.info("어드민 메인 접속");
	}
	
}
