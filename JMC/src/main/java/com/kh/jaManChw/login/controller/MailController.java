package com.kh.jaManChw.login.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.jaManChw.login.service.face.MailService;


@Controller
@ResponseBody
public class MailController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MailService mailService;
	

	// 이메일 인증 버튼 클릭
	@GetMapping("/login/mailCheck")
	public String emailCheck(String email) {
		logger.info("email 옵니다~");	
		logger.info("email 주소 : {}",email);

		return mailService.emailAuth(email);
	} // emailCheck() end
} // MailController() end
