package com.kh.jaManChw.admin.usermanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/mg")
	public void user() {
		logger.info("abc");
	}
	
	
}
