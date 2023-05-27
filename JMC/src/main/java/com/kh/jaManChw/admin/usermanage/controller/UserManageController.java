package com.kh.jaManChw.admin.usermanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserManageService userManageService;
	
	@RequestMapping("/mg/list")
	public void user(
			Model model,
			String curPage
			) {
		logger.info("user list");
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Users> users = userManageService.UserMgPage(paging);
		logger.info("{}", users);
		model.addAttribute("users", users);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/mg/filter")
	public void userfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) {
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
	}
	
	@RequestMapping("/mg/filter1")
	@ResponseBody
	public boolean userfiltering1(
			Model model, String curPage,
			@RequestBody Map<String, Object> map
			) {
		logger.info("에이잭스 출력 : {}", map);
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
//		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
		return true;
	}
	
	@GetMapping("/mg/update")
	public void UserMgUpdate(int userno, Model model) {
		logger.info("user update");
		
		logger.info("{}", userno);
		
		Users users = userManageService.getUserData(userno);
		
		logger.info("유저 담긴 정보 {}", users);
		model.addAttribute("users", users);
		
	}
	@PostMapping("/mg/update")
	public String UserMgUpdate2(@RequestParam HashMap<String, String> hashmap) {		
		logger.info("post update 들어옴");
		logger.info("수정될 유저 정보{}", hashmap);
		
//		userManageService.reviseUserMgUpdate(users);
		return "redirect:/admin/user/mg/list";
	}
	@RequestMapping("/mg/withdraw")
	public String UserMgWithdraw(int userno) {
		
		userManageService.reviseUserMgWithdraw(userno);
		return "redirect:/admin/user/mg/list";
	}
	
	@RequestMapping("/black/list")
	public void UserBlackPage(
			Model model,
			String curPage) {
		logger.info("user list");
		String ccurpage = curPage;
		Paging paging = userManageService.getpaging(ccurpage);
		logger.info("{}",paging);
		List<Users> users = userManageService.UserMgPage(paging);
		logger.info("{}", users);
		model.addAttribute("users", users);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/black/filter")
	public void blackfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) { 
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/black/update")
	public String BlackUpdate(int userno) {
		
		return "redirect:/admin/user/black/list";
	}
	
	@RequestMapping("/black/userstop")
	public String BlackStop(int userno) {
		
		return "redirect:/admin/user/black/list";
	}
	
}
