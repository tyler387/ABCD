package com.kh.jaManChw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.dto.Users;

@Controller
@RequestMapping("/login")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// 회원가입 페이지 이동
	@RequestMapping("")
	public void joinPage() {}
	

	// 홈페이지 내에서 회원가입, 완료 후 메인페이지로이동
	@RequestMapping("/join")
	public void userJoin(Users users) {
		
		logger.info("/login/join [POST]");
		
	
	}
}
