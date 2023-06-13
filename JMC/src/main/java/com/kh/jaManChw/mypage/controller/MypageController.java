package com.kh.jaManChw.mypage.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.FriendList;
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
	public void mypageMain(Users users,Model model,HttpSession session,ProfileFile profileFile) {
		
		// 세션에서 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		logger.info("users main:{}",users);
		
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile = mypageService.fileInfo(users);
		//ProfileFile profile= mypageService.getFileName(profileFile);
		
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);

		// profile 모델값에 담기
		model.addAttribute("profile", profile);
		logger.info("profile:{}",profile);
		
		//유저 정보 가져오기 - 메인에서 로그인한 유저 정보 조회
		Users loginInfo = mypageService.getloginInfo(users);
		model.addAttribute("loginInfo", loginInfo);	
		logger.info("loginInfo main : {}", loginInfo);	
		
		//친구목록 불러오기
		List<FriendList> list = mypageService.getFriendList(users);
		model.addAttribute("list", list);
		logger.info("list-친구목록:{}",list);
	}

	// 마이페이지 정보수정
	@GetMapping("/mypage/userInfo")
	public void userInfoPage(Model model,Users users,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		
		Users loginInfo = mypageService.getloginInfo(users);
		model.addAttribute("loginInfo userInfo", loginInfo);
		
	}
	
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
	// 프로필사진수정 페이지
	@GetMapping("/mypage/profile")
	public void profilePage(HttpSession session,ProfileFile profileFile,Model model,Users users) {
		
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		logger.info("users 수정:{}",users);
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile = mypageService.fileInfo(users);
		//ProfileFile profile= mypageService.getFileName(profileFile);
		
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);

				
	}
	
	// 프로필사진 수정
	@PostMapping("/mypage/profile")
	public String uploadProfile(MultipartFile file, HttpSession session,ProfileFile profileFile,Model model,Users users) {

		logger.info("file:{}",file);

		// userno 세션에서 가져오기
		profileFile.setUserno((Integer)session.getAttribute("userno"));
		
		// 파일이 있으면 -> 업로드할 파일이 있으면
		if(!file.isEmpty()) {	
			
			// 프로필 저장
			ProfileFile profile = mypageService.profileSave(file, profileFile);
			
			// 파일의 저장이름 세션에 저장
			session.setAttribute("profile", profile.getProfileStoredName());
			
		}
		
		return "redirect:/mypage/main";

	}
	

//-----------------------------------------------------------	
	//유저 검색 기능	
	@GetMapping("/mypage/search")
	public String getuserSearchList(String type, String keyword,Model model){
		
		logger.info("type: {}, keyword: {}", type, keyword);
		
		// 유저 list 모델값에 저장 - 키워드로 찾을 수 있는 값들
		List<Users> list = mypageService.getSearchLists(type,keyword);	
		model.addAttribute("list",list);

		logger.info("userList:{}",list);
		return "/mypage/friendfind";
	}
	
	// 친구 추가
	@GetMapping("/mypage/friendfind")
	public void friendfindPage(FriendList friendList,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		//int userno = (Integer)session.getAttribute("userno");
		//friendList.setUserno(userno);
		
		logger.info("friendList:{}",friendList);
	}
	
	// 친구 추가
	@PostMapping("/mypage/friendfind")
	@ResponseBody
	public Map<String, Object> friendfind(String userno,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		int myno = (Integer)session.getAttribute("userno");
		
		FriendList friendList = new FriendList();
		friendList.setUserno(myno);
		friendList.setFriendUserno(Integer.parseInt(userno));
		
		logger.info("friendList:{}",friendList);
		
		mypageService.friendAdd(friendList);
		
		Map<String, Object> returnMap = new HashMap<>();
		
		returnMap.put("result", true);
		
		return returnMap; 
	}

	// 친구목록
	@GetMapping("/mypage/friendList")
	public void friendPage(Model model,HttpSession session,Users users) {
		
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		logger.info("userno - 친구목록 :{} ",userno);
		users.setUserno(userno);
		
		List<FriendList> list = mypageService.getFriendList(users);
		model.addAttribute("list", list);
		logger.info("list-친구목록:{}",list);
	}

//-------------------------------------------------------------------
	//내가 쓴 게시글 조회
	@GetMapping("/mypage/myBoard")
	public void myboardPage() {}
	
	//게시글 상세 페이지
	@GetMapping("/mypage/myBoarddetail")
	public void myboarddetailPage() {}

}
