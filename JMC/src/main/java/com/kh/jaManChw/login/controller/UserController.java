package com.kh.jaManChw.login.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.login.service.face.UsersService;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UsersService usersService;
	
	@RequestMapping("/login/main")
	public void mainPage() {}
	
	// 로그인 페이지 이동
	@GetMapping("/login/login")
	public void loginPage() {}
	
	// 로그인 - true or false
	@PostMapping("/login/login")
	public String userlogin(HttpSession session,Users users) {
		logger.info("{}",users);
		
		// 로그인 인증
		boolean isLogin = usersService.login(users);
		
		if(isLogin) {			
			logger.info("userlogin() - 로그인 성공");
			
			// 세션에 파라미터 값 저장
			session.setAttribute("login", isLogin);
			session.setAttribute("userId", users.getUserId());
			session.setAttribute("userPw", users.getUserPw());
			
			// 메인 페이지로 리다이렉트
			return "redirect:/login/main";
		}else {
			logger.info("userlogin() - 로그인 실패");
			
			// 세션 삭제
			session.invalidate();
			
			// 로그인실패시 로그인 페이지로 리다이렉트
			return "redirect:/login/login";
		}
	}
	
	@RequestMapping("/logout")
	public String userLogout(HttpSession session) {
		
		logger.info("userLogout() - 로그아웃 성공");
		
		// 세션 삭제
		session.invalidate();
		
		// 메인페이지로 리다이렉트
		return "redirect:/login/main";
	}
	
	
	// 회원가입 페이지 이동
	@GetMapping("/login/join")
	public void joinPage() {}
	

	// 홈페이지 내에서 회원가입, 완료 후 메인페이지로이동
	@PostMapping("/login/join")
	public String userJoin(Users users) {
		logger.info("{}",users);

		return "/login/main";
	}
}
