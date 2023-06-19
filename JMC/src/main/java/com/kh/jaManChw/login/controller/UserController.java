package com.kh.jaManChw.login.controller;

import java.util.Map;

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

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.login.service.face.NaverService;
import com.kh.jaManChw.login.service.face.UsersService;
import com.kh.jaManChw.mypage.service.face.MypageService;

@Controller
@RequestMapping("/login")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired UsersService usersService;
	@Autowired MypageService mypageService;
	@Autowired NaverService naverService;

	@RequestMapping("/main")
	public void mainPage() {}

	// 로그인 페이지 이동
	@GetMapping("/login")
	public void loginPage(HttpSession session) {
		//JSP에 정보를 입력하기에는 노출의 위험이 있기에 controller에서 선처리 후 보낸다
		Map<String, String> naverMap = naverService.getNaverApiInfo();
		
		session.setAttribute("apiURL", naverMap.get("apiURL"));
	}

	// 로그인 - true or false
	@PostMapping("/login")
	public String userlogin(HttpSession session, Users users,Model model) {
		logger.info("{}", users);
		

		
		//탈퇴 유저 로그인 방지
		boolean leaveUser = usersService.leaveLogin(users);
		
		if(leaveUser) {
			session.invalidate();
			return "redirect:/login/login";
		}
		
		//block 유저 로그인 방지
		boolean block = usersService.blackLogin(users);
		
		if(block) {
			session.invalidate();			
			return "redirect:/login/login";
		}

		//유저 정보 가져오기
		Users info = usersService.getuserInfo(users);
		logger.info("info:{}",info);
		model.addAttribute("info",info);
		
		// 프로필 정보 가져오기
		ProfileFile profile = mypageService.fileInfo(info);	
		if(profile !=null) {session.setAttribute("profile", profile);}
		logger.info("profile:{}",profile);		
		
		// 로그인 인증
		boolean isLogin = usersService.login(users);	
		
		if (isLogin) {		
			logger.info("userlogin() - 로그인 성공");
			
			
			
			
			// 세션에 파라미터 값 저장
			session.setAttribute("login", isLogin);
			session.setAttribute("userno", info.getUserno());
			session.setAttribute("userId", info.getUserId());
			session.setAttribute("role", info.getRole());
			session.setAttribute("social",info.getSocialNum());
			session.setAttribute("status", info.getStatus());
			session.setAttribute("platFormOption", info.getPlatFormOption());
			
			
			logger.info("social:{}",info.getSocialNum());
			logger.info("userno : {}",info.getUserno());
			logger.info("userrole : {}",info.getRole());

			// 메인 페이지로 리다이렉트
			return "redirect:/login/main";
		} else {
			logger.info("userlogin() - 로그인 실패");

			// 세션 삭제
			//session.invalidate();		
			return "/login/login";
		} // if(isLogin)문 end		
	} // userlogin() end


	// 회원가입 페이지 이동
	@GetMapping("/join")
	public void joinPage() {}

	// 홈페이지 내에서 회원가입, 완료 후 메인페이지로이동
	@PostMapping("/join")
	public String userJoin(Users users) {
		logger.info("{}",users);
		
		//회원가입 메소드 호출
		usersService.join(users);
		
		
		logger.info("회원가입 성공");

		return "redirect:/login/login";
	} // userJoin() end
	

//	@RequestMapping("/login/idcheck")
//	@ResponseBody
//	public String idCheck(@RequestParam("userId") String userId) {
//		
//		logger.info("idcheck()-실행");
//		
//		int res = usersService.IdCheck(userId);
//		
//		if(res!=0) {
//			logger.info("join() - 중복아이디있음");
//			return "fail";
//		}else {
//			logger.info("join() - 중복아이디 없음");	
//			return "true";
//		}
//	
//		
//	} // idchdck() end
	
	@RequestMapping("/idcheck")
	@ResponseBody
	public int idCheck(@RequestParam("userId") String userId) {
		int res = usersService.IdCheck(userId);
		
		if(res>0) {
			logger.info("join() - 중복아이디있음");
		}else {
			logger.info("join() - 중복아이디 없음");		
		}
		return res;
	} // idchdck() end

	
	
	// 아이디찾기 페이지 이동
	@GetMapping("/searchId")
	public void searchIdPage() {}
	
	// 이메일로 아이디 찾기
	@PostMapping("/searchId")
	public String findIdByemail(Users users,Model model,HttpSession session) {
		
		Users result = usersService.searchName(users);
		
		if(result==null) {
			logger.info("조회된 이름 없음");
			return "/login/searchResultId";
		}else {
			logger.info("조회된 이름 있음");
			model.addAttribute("result", result);
			model.addAttribute("userName",result.getUserName() );
			model.addAttribute("userId",result.getUserId() );
			session.setAttribute("userno", result.getUserno());
		}
		return "/login/searchResultId";
	} // findIdByemail() end
	
	// 찾은 아이디 보여주는 페이지 이동
	@GetMapping("/searchResultId")
	public void searchResultIdPage() {}
	
	
	// 비밀번호 찾기 페이지
	@GetMapping("/searchPw")
	public void searchPwPage() {}
	
	@PostMapping("/searchPw")		
	public String searchPw(Users users,Model model,HttpSession session) {
		Users res = usersService.searchId(users);
		
		if(res==null) {
			logger.info("조회된 아이디 없음");
			session.invalidate();	
			return "/login/searchPw";
		}else {
			logger.info("조회된 아이디 있음");
			model.addAttribute("res", res);
			model.addAttribute("userId",res.getUserId() );
			session.setAttribute("userno", res.getUserno());
		}
		return "/login/searchResultPw";
	}
	

	// 찾는 비밀번호 페이지
	@GetMapping("/searchResultPw")
	public void searchResultPwPage() {}
	
	// 비밀번호 재설정
	@PostMapping("/searchResultPw")
	public String searchResultPw(Users users,HttpSession session) {

		
		int result = usersService.modifyPw(users);
		if(result>0) {
			logger.info("비밀번호 변경 성공");	
			return "/login/login";
		}
		else {		
			logger.info("비밀번호 변경 실패");
			session.invalidate();			
			return "/login/searchPw";
		}
	}
	
} //userController() end 
