package com.kh.jaManChw.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MeetingInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("+ + + + 모임(비 로그인) 인터셉터 발동 + + + +");
		
		//로그인 시 정보를 저장하는 Session 객체 선언 
		HttpSession session = request.getSession();
		
		//기존에 잘못된 경로로 접근하여  세션에 접근에대한 값이 존재한다면
		// 모두 삭제한다
		session.removeAttribute("loginAccess");
		session.removeAttribute("adminAccess");
		session.removeAttribute("statusAccess");
		
		if (session.getAttribute("login") == null) {
			
			//비로그인 상태
			logger.info("접속 불가 =>> 비로그인 상태입니다, 세션을 확인하세요");

			//비로그인 상태일시 세션에 접근 불가능함을 보내고 경고창을 띄운다
			session.setAttribute("loginAccess", true);
			
			//비로그인시 로그인 페이지로 이동시킨다
			response.sendRedirect("/login/login");
			
			return false;
		}else if (!"active".equals(session.getAttribute("status"))) {
			//2. 접속 상태가 "active"가 아닌 경우
			logger.info("접속 불가 =>> 아이디가 활성화 상태가 아닙니다, 아이디 상태를 확인하세요");

			session.setAttribute("statusAccess", true);
			
			response.sendRedirect("/login/main");
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("+ + + + 모임 인터셉터 종료 + + + +");
	}
}
