package com.kh.jaManChw.admin.usermanage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserManageService userManageService;
	
	@RequestMapping("/mg")
	public void user() {
		logger.info("abc");
		
		List<Users> users = userManageService.UserMgPage();
		logger.info("{}", users);
	}
	
	
}
