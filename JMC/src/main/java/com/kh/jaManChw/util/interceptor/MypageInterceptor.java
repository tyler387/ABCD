package com.kh.jaManChw.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MypageInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("+ + + + 마이페이지 인터셉터 발동 + + + +");
		
		//로그인 시 정보를 저장하는 Session 객체 선언 
		HttpSession session = request.getSession();

		//기존에 잘못된 경로로 접근하여  세션에 접근에대한 값이 존재한다면
		// 모두 삭제한다
		session.removeAttribute("loginAccess");
		session.removeAttribute("adminAccess");
		session.removeAttribute("statusAccess");
		
		
		if (session.getAttribute("login") == null) {
			
			//1. 비로그인 상태
			logger.info("접속 불가 =>> 비로그인 상태입니다, 세션을 확인하세요");
			
			//1-1. 비로그인시 로그인 페이지로 이동시킨다
			
			session.setAttribute("loginAccess", true);

			response.sendRedirect("/login/login");
			
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("+ + + + 마이페이지 인터셉터 종료 + + + +");
	}
}
