package com.kh.jaManChw.mypage.controller;


import javax.servlet.ServletContext;
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
	
	//서블릿 컨텍스트 객체
	@Autowired ServletContext context;
	
	// 마이페이지 메인
	@GetMapping("/mypage/main")
	public void mypageMain(Users users,Model model,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		//users.setUserno(((Integer) session.getAttribute("userno")).intValue());
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
	
//-----------------------------------------------------------
	// 회원탈퇴 페이지
	@GetMapping("/mypage/delete")
	public void deletePage() {}
	
	// 회원탈퇴
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
//-----------------------------------------------------------
	// 프로필사진수정 메인페이지
	@GetMapping("/mypage/profileMain")
	public void profileMainPage() {}
	
	// 프로필사진수정 페이지
	@GetMapping("/mypage/profile")
	public void profilePage() {}
	
	// 프로필사진 수정
	@PostMapping("/mypage/profile")
	public void uploadProfile(MultipartFile file, HttpSession session,ProfileFile profileFile,Model model) {

		logger.info("file:{}",file);

		int userno = (Integer)session.getAttribute("userno");
		profileFile.setUserno(userno);
		
		//파일 유무
		if(!file.isEmpty()) {
			// 프로필 저장
			mypageService.profileSave(file,session,profileFile);
			logger.info("file:{}",file);
		}
		
		//파일 정보 가져오기
		ProfileFile profile = mypageService.fileInfo(profileFile,model);
		
		model.addAttribute("profile", profile);
		model.addAttribute("profileStoredName", profile.getProfileStoredName());
		
		
		logger.info("profile",profile);
		
		//logger.info("sesion:{}",session.getAttribute("userno"));

	}
	
	// 프로필 삭제
	@PostMapping("/mypage/remove")
	public void deleteProfile(ProfileFile profileFile) {
		
		// db에 저장된 프로필 삭제
		mypageService.removeProfile(profileFile);

	}

//-----------------------------------------------------------	
	//친구목록 페이지 페이징
	@GetMapping("/mypage/friendList")
	public void friendPage() {}
	
	



}
