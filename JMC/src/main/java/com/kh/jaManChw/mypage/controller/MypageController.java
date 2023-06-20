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
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.kh.jaManChw.board.service.face.BoardService;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.FriendList;

import com.kh.jaManChw.dto.Applicant;

import com.kh.jaManChw.dto.Meeting;


import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.service.face.MeetingService;
import com.kh.jaManChw.mypage.service.face.MypageService;
import com.kh.jaManChw.util.MeetingPaging;
import com.kh.jaManChw.util.Paging;


@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MypageService mypageService;
	
	@Autowired MeetingService meetingService;
	
	//서블릿 컨텍스트 객체
	@Autowired ServletContext context;
	@Autowired BoardService boardService;
	
	// 마이페이지 메인
	@GetMapping("/main")
	public void mypageMain(Users users,Model model,HttpSession session,ProfileFile profileFile,String curPage) {
		
		// 세션에서 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		logger.info("users main:{}",users);
		
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);

		
		//유저 정보 가져오기 - 메인에서 로그인한 유저 정보 조회
		Users loginInfo = mypageService.getloginInfo(users);
		model.addAttribute("loginInfo", loginInfo);	
		logger.info("loginInfo main : {}", loginInfo);	
		
		//친구목록 불러오기
		List<Map<String, Object>> list = mypageService.getFriendList(users);
		model.addAttribute("list", list);
		logger.info("list-친구목록:{}",list);
		
		//모임 목록 불러오기
		MeetingPaging paging = meetingService.getMyMeetingCount(curPage,session);
		List<Map<String,Object>> map= meetingService.getMyMeeting(session,paging);
		model.addAttribute("map",map);
		model.addAttribute("paging",paging);
		
		
	}

	// 마이페이지 정보수정
	@GetMapping("/userInfo")
	public void userInfoPage(Model model,Users users,HttpSession session) {
		
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		
		Users loginInfo = mypageService.getloginInfo(users);
		model.addAttribute("loginInfo", loginInfo);
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		

		
	}
	
	// 유저 정보 수정
	@PostMapping("/userInfo")
	public String changeInfo(Users users,HttpSession session) {
		
		int res = mypageService.changeInfo(users);
		
		if(res>0) {
			logger.info("정보수정 성공");
			return "redirect:/mypage/main";
			
		}else {
			logger.info("정보수정 실패");
			
			return "redirect:/mypage/userInfo";
		}
		
	}
	
//-----------------------------------------------------------
	// 회원탈퇴 페이지
	@GetMapping("/delete")
	public void deletePage(Users users,HttpSession session,Model model) {
		//세션에 저장된 userno 가져오기
		int userno = (Integer)session.getAttribute("userno");
		users.setUserno(userno);
		
		model.addAttribute("user", users);
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		
	
		
	}
	
	// 회원탈퇴
	@PostMapping("/delete")
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
	@GetMapping("/profile")
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
	@PostMapping("/profile")
	public String uploadProfile(MultipartFile file, HttpSession session,ProfileFile profileFile,Model model,Users users) {

		logger.info("file:{}",file);

		// userno 세션에서 가져오기
		profileFile.setUserno((Integer)session.getAttribute("userno"));
		
		// 파일이 있으면 -> 업로드할 파일이 있으면
		if(!file.isEmpty()) {	
			
			// 프로필 저장
			ProfileFile profile = mypageService.profileSave(file, profileFile);
			
			// 파일의 저장이름 세션에 저장
			session.setAttribute("profile", profile);
			
		}else {
			return "/mypage/profile";
		}
		
		return "redirect:/mypage/main";

	}
	

//-----------------------------------------------------------	
	//유저 검색 기능	
	@GetMapping("/search")
	public String getuserSearchList(String type, String keyword,Model model,HttpSession session, Users users){
		
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
		
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("type: {}, keyword: {}", type, keyword);
		
		// 유저 list 모델값에 저장 - 키워드로 찾을 수 있는 값들
		List<Users> list = mypageService.getSearchLists(type,keyword);	
		model.addAttribute("list",list);

		logger.info("userList:{}",list);
		return "/mypage/friendfind";
	}
	
	// 친구 추가
	@GetMapping("/friendfind")
	public void friendfindPage(FriendList friendList,HttpSession session,Users users,Model model) {
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
	}
	
	// 친구 추가
	@PostMapping("/friendfind")
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
	

	//---------------------------------------------
	//내가 등록한 모임
	@RequestMapping("/mymeeting")
	public void myMeetingList(HttpSession session,String curPage, Model model,Users users) {
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
		
		MeetingPaging paging = meetingService.getMyMeetingCount(curPage,session);
		
		List<Map<String,Object>> map= meetingService.getMyMeeting(session,paging);
		
		model.addAttribute("map",map);
		model.addAttribute("paging",paging);
		
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		
		
	}
	
	
	//마이페이지 모임
	@GetMapping("/meeting")
	public String myMeeting(HttpSession session, Model model,String curPage,Users users) {
		
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		
		if(session.getAttribute("userno")==null) {
			return "redirect:/login/login";
		}
		MeetingPaging paging = meetingService.getPaging(curPage,session);
		List<Map<String,Object>>map2 = meetingService.getApplicantAll(session, paging);

		model.addAttribute("map",map2);
		model.addAttribute("paging",paging);
		return "/mypage/meeting";
	}
	@GetMapping("/agree")
	public String agree(Applicant applicant,Model model) {
		if(applicant.getAgree().equals("yes")) {
			//정원 수 초과시 true
			boolean countChk = meetingService.chkHeadCount(applicant);
			if(countChk) {
				model.addAttribute("message","정원초과하여 자동 거절");
				model.addAttribute("url","/mypage/meeting");
				applicant.setAgree("no");
				//모집인원 남아있을 경우 
			}else {
				model.addAttribute("message","모집인원 추가");
				model.addAttribute("url","/mypage/meeting");
			}
		}else {
				model.addAttribute("message","모집인원 거절");
				model.addAttribute("url","/mypage/meeting");
				
		}
		meetingService.updateApplicant(applicant);
		return "./layout/alert";
	}
	//내가 신청한 내역
	@RequestMapping("/myapplication")
	public String application(HttpSession session,String curPage,Model model,Users users) {
		
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		
		MeetingPaging paging = meetingService.getappliPaging(curPage,session);
		List<Map<String,Object>> map = meetingService.getMyapplicant(session,paging);
		
		model.addAttribute("map",map);
		model.addAttribute("paging",paging);
		
		return "/mypage/myapplication";
	}
	
	// 친구목록
	@GetMapping("/friendList")
	public void friendPage(Model model,HttpSession session,Users users) {
		
		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);
		
		List<Map<String, Object>> list = mypageService.getFriendList(users);
		model.addAttribute("list", list);
		logger.info("list-친구목록:{}",list);
		
	}

	@PostMapping("/friendList")
	public void friendRemove(int userno, HttpSession session) {
		logger.info("userno :{}",userno);
		mypageService.removeFriend(userno);
		
	}
//-------------------------------------------------------------------
	//내가 쓴 게시글 조회
	@GetMapping("/myBoarddetail")
	public void myboardPage(Model model,HttpSession session,Users users ) {

		//세션에 저장된 userno 가져오기
		users.setUserno((Integer)session.getAttribute("userno"));
		
		//내가 올린 사진게시물 가져오기
		List<BoardFile> list = mypageService.getMyboardFile(users);

		// view로 가져갈 list값 모델에 담기
		model.addAttribute("list", list);
		
		//담아온 세션으로 파일 저장된 이름 불러오기
		ProfileFile profile =  mypageService.fileInfo(users);
	
		//파일 정보 모델에 넣기 가져오기	
		model.addAttribute("profile", profile);
		logger.info("profile 수정:{}",profile);


		
	}


	
}
