package com.kh.jaManChw.admin.usermanage.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.mypage.service.face.MypageService;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserManageService userManageService;
	@Autowired MypageService mypageService;
	
//	@GetMapping("/mg/main")
	@GetMapping("/mg/list")
	public void user(
			Model model, String curPage
			) {
		logger.info("user list 처음 ");
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Users> userfilter = userManageService.UserMgPage(paging);
		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
		model.addAttribute("paging", paging);
		model.addAttribute("pagetype", "list");
	}
	
	
	@RequestMapping("/mg/filter")
	public String userfiltering(
			Model model, String curPage, @RequestParam Map<String, Object> map
			) {
		logger.info("filter1 에이잭스 출력 : {}", map);
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(curPage, map);
		logger.info("페이징 {}", paging);
		logger.info("상태 {}", map.get("status"));
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("filterListStatus", true);
		model.addAttribute("userfilter", userfilter);
		model.addAttribute("paging", paging);
		model.addAttribute("filter", map);
		model.addAttribute("pagetype", "filter");
		
		return "admin/user/mg/filter";
	}
	
	
	@GetMapping("/mg/update")
	public void UserMgUpdate(int userno, Model model) {
		logger.info("{}", userno);
		
		Map<String, String> map = userManageService.getUserData(userno);
		
		logger.info("유저 담긴 정보 {}", map);
		model.addAttribute("users", map);
		
	}
	@PostMapping("/mg/update")
	public String UserMgUpdate2(@RequestParam Map<String, Object> map, MultipartFile file, ProfileFile profileFile) {		
		logger.info("post update 들어옴");
		logger.info("file {}", file);
		logger.info("수정될 유저 정보{}", map);
		String curPage = (String) map.get("curPage");
		logger.info("페이지정보{}: ", curPage);
		int userno = Integer.valueOf((String) map.get("userno"));
		// userno 세션에서 가져오기
		profileFile.setUserno(userno);
		
		// 파일이 있으면 -> 업로드할 파일이 있으면
		if(!file.isEmpty()) {	
			
			// 프로필 저장
			ProfileFile profile = mypageService.profileSave(file, profileFile);
			// 파일의 저장이름 세션에 저장
//			session.setAttribute("profile", profile);
		}
		userManageService.reviseUserMgUpdate(map);
		return "redirect:/admin/user/mg/list?curPage="+curPage;
	}
	
	
	@RequestMapping("/mg/withdraw")
	public String UserMgWithdraw(int userno, String curPage) {
		
		userManageService.reviseUserMgWithdraw(userno);
		return "redirect:/admin/user/mg/list?curPage="+curPage;
	}
	
	@GetMapping("/black/list")
//	@RequestMapping("/black/main2")
	public void UserBlackPage(
			Model model, String curPage) {
		logger.info("user list");
		logger.info("curPage: {}", curPage);
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Users> users = userManageService.UserMgPage(paging);
		logger.info("{}", users);
		model.addAttribute("users", users);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/black/filter")
	public String blackfiltering(
			Model model, String curPage, @RequestParam Map<String, Object> map
			) { 
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("filterListStatus", true);
		model.addAttribute("userfilter", userfilter);
		model.addAttribute("users", userfilter);
		model.addAttribute("filter", map);
		model.addAttribute("paging", paging);
		
		return "/admin/user/black/filter";

	}
	
	@RequestMapping("/black/update")
	public String BlackUpdate(int userno, String curPage) {
		logger.info("유저번호 입력 받은 거 : {}", userno);
		userManageService.reviseUserBlackUpdate(userno);
		
		return "redirect:/admin/user/black/list";
	}
	
	@RequestMapping("/black/stop")
	public String BlackStop(int userno, String curPage) {
		logger.info("유저번호 입력 받은 거 : {}", userno);
		logger.info("현재페이지 입력 받은 거 : {}", curPage);
		
		userManageService.reviseUserBlackStop(userno);
		
		//url이 변경됨 인서트 및 딜리트 
		return "forward:/admin/user/black/list";
	}
	
	
}
