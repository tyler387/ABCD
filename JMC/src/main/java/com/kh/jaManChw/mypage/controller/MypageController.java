package com.kh.jaManChw.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.mypage.service.face.MypageService;

@Controller
public class MypageController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MypageService mypageService;
	
	// 마이페이지 메인
	@GetMapping("/mypage/main")
	public void mypageMain(Users users,Model model,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		users.setUserno((int)session.getAttribute("userno"));
		Users loginInfo = mypageService.getloginInfo(users);
		model.addAttribute("loginInfo", loginInfo);
		
		logger.info("users :{}",users);
		logger.info("loginInfo : {}", loginInfo);	
		
	}

	// 마이페이지 정보수정
	@GetMapping("/mypage/userInfo")
	public void userInfoPage() {}
	
	// 유저 정보 수정
	@PostMapping("/mypage/userInfo")
	public String changeInfo(Users users,HttpSession session) {
		
		int res = mypageService.changeInfo(users);
		
		if(res>0) {
			logger.info("정보수정 성공");
			return "redirect:/mypage/main";
			
		}else {
			logger.info("정보수정 실패");
			session.invalidate();
			return "redirect:/mypage/userInfo";
		}
		
	}
	
	
	@GetMapping("/mypage/delete")
	public void deletePage() {}
	
	@PostMapping("/mypage/delete")
	public String deleteUser(Users users,HttpSession session) {
		int res = mypageService.deleteUser(users);
		
		if(res>0) {
			logger.info("회원탈퇴 성공");
			return "redirect:/login/logout";
		}else {
			logger.info("회원탈퇴 실패");
			session.invalidate();
			return "redirect:/mypage/userInfo";
		}
	}
	
	@GetMapping("/mypage/profile")
	public void profilePage() {}
	
	@PostMapping("/mypage/profile")
	public String uploadProfile(MultipartFile file,ProfileFile profileFile) {

		// 프로필 저장
		mypageService.profileSave(file,profileFile);
		
		logger.info("file:{}",file);
		logger.info("profileFile:{}",profileFile);

		return "redirect:/mypage/profile";
	
	}
	
	@GetMapping("/mypage/friendList")
	public void friendPage() {}


}
