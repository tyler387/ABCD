package com.kh.jaManChw.login.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jaManChw.login.service.face.UsersService;

@Controller
public class KakaoController {
	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired UsersService usersService; 
//	
//	@RequestMapping("/oauth/kakao")
//    public String login(@RequestParam("code") String code, HttpSession session) {
//    	
//    	// accessToken : 사용자 인증과 카카오 api 호출 권한부여 : 6시간 만료
//    	// 사용자에 대한 정보가 담겨있다.
//    	// 토큰에 담겨있는 정보가 해당 사용자의 정보가 맞는지 확인하고 회원가입 or로그인 시키고 DB에 저장한다.
//        String access_Token = usersService.getAccessToken(code);
//        logger.info("Controller access_Token: {}",access_Token);
//       
//        // 해쉬맵을 사용해서 유저의 정보를 가져옴 => access_Token 이용해서 가져올 수 있다.
//        // 실제 구현할 때는 
//        // 닉네임(profile_nickname), 프로필사진(profile_image), 이메일(	account_email),성별(gender), 연령대(age_range) 가져와야함.
//        HashMap<String, Object> userInfo = usersService.getUserInfo(access_Token);
//        
//        logger.info("loginController :{}",userInfo);
//        logger.info("userid: {}", userInfo.get("email"));
//        
//        
//        //  클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
//        if (userInfo.get("email") != null) {
//            session.setAttribute("userId", userInfo.get("email"));
//            session.setAttribute("access_Token", access_Token);
//        }
//        return "/login/login";
//    }
//
//	// 발급받은 토큰을 만료시켜 로그아웃 시킨다
//	// 리턴은 메인페이지로
//    @RequestMapping(value="/logout")
//    public String logout(HttpSession session) {
//    	usersService.kakaoLogout((String)session.getAttribute("access_Token"));
//        session.removeAttribute("access_Token");
//        session.removeAttribute("userId");
//        
//        logger.info("로그아웃");
//        return "/login/main";
//    }

}
