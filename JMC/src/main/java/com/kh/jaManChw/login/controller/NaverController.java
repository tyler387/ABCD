package com.kh.jaManChw.login.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.JsonObject;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.login.service.face.NaverService;
import com.kh.jaManChw.login.service.face.UsersService;

@Controller
public class NaverController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private NaverService naverService;
	@Autowired private UsersService usersService;
		
	
	@GetMapping("/naverlogincallback")
	public String naverloginCall(String code, String state, HttpSession session) {
		
		JsonObject naverToken = naverService.getNaverCallbackToken(code, state);
		
		String access_Token = naverToken.get("access_token").getAsString();
		logger.info("access_Token : {}", access_Token);
	
		Users userInfo = naverService.getUserInfoFromNaver(naverToken);
		
		if(usersService.isNaverUser(userInfo.getUserId()) >0) {
			logger.debug("회원정보 존재"); 
			
			Users info = usersService.getuserInfo(userInfo);
			session.setAttribute("login", true);
			session.setAttribute("userno", info.getUserno());
			session.setAttribute("usernick", info.getUserNick());
			session.setAttribute("access_Token", access_Token);
			session.setAttribute("userId", info.getUserId());
			session.setAttribute("email", info.getEmail());
			session.setAttribute("role", info.getRole());
			session.setAttribute("social",info.getSocialNum());
			session.setAttribute("status", info.getStatus());
			
			return "redirect:/login/main";
		} else {
			logger.debug("회원정보 존재 X");

			usersService.joinUsersNaver(userInfo);
			
			return "/login/main";
		}
	}
	
}
