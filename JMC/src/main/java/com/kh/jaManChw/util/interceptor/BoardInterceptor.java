package com.kh.jaManChw.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BoardInterceptor implements HandlerInterceptor{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(" + + + 게시글 인터셉터 시작 + + +");
		
		//로그인 시 정보를 저장하는 Session 객체 선언 
		HttpSession session = request.getSession();
		
		//기존에 잘못된 경로로 접근하여  세션에 접근에대한 값이 존재한다면
		// 모두 삭제한다
		session.removeAttribute("loginAccess");
		session.removeAttribute("adminAccess");
		session.removeAttribute("statusAccess");
		
		//세션에 담겨 있는 로그인 정보를 통해 
		// 1. 로그인이 되어 있지 않다면 글을 쓸수 없게 
		// 2. 아이디 상태가 활성화가 되어 있는 상태일때만 글을 쓸수 있게(블랙리스트..등 안됨)
		if (session.getAttribute("login") == null) {
			
			//1. 비로그인 상태
			logger.info("접속 불가 =>> 비로그인 상태입니다, 세션을 확인하세요");
			
			// 1-1. 세션에 접근 불가능함을 보내고 경고창을 띄운다 
			request.setAttribute("loginAccess", true);
			
			//1-2. 비로그인시 AJAX기에 return하지 않는다
			
			//1-3. 컨트롤러 접근 차단
			return false; //컨트롤러 접근 차단

		}else if(!"active".equals(session.getAttribute("status"))) {
			
			//2. 접속 상태가 "active"가 아닌 경우
			logger.info("접속 불가 =>> 아이디가 활성화 상태가 아닙니다, 아이디 상태를 확인하세요");
			
			//2. 세션에 접근 불가능함을 보내고 경고창을 띄운다
			request.setAttribute("statusAccess", true);
			
			//2-2. 접속 상태가 "active"가 아닌 경우, AJAX기에 return하지 않는다.

			//2-3. 컨트롤러 접근 차단
			return false; //컨트롤러 접근 차단
		}
		
		
		logger.info(">> 접속 허가 : 사용자 로그인 상태");
		return true; //컨트롤러 접근 허용
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
			logger.info(" + + + 게시글 인터셉터 종료 + + +");
	
	}
}