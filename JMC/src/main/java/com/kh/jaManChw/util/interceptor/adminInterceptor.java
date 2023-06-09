package com.kh.jaManChw.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class adminInterceptor implements HandlerInterceptor{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(" + + + 관리자 인터셉터 시작 + + +");
		
		//로그인 시 정보를 저장하는 Session 객체 선언 
		HttpSession session = request.getSession();
		
		//세션에 담겨 있는 로그인 정보를 통해 
		// 1. 로그인이 되어 있는지 , 2. 관리자가 맞는지, 3. 아이디 상태가 활성화가 되어 있는 상태인지
		if (session.getAttribute("isLogin") == null) {
			
			//1. 비로그인 상태
			logger.info("접속 불가 =>> 비로그인 상태 ");
			
		}else if( session.getAttribute("role") != "admin") {
			
			//2. 접속자가 관리자가 아닌 경우
			logger.info("접속 불가 =>> 관리자가 아닙니다");
			
		}else if(session.getAttribute("status") != "active") {
			
			//3. 접속자가 관리자가 아닌 경우
			logger.info("접속 불가 =>> 관리자가 아닙니다");
			
		}
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
