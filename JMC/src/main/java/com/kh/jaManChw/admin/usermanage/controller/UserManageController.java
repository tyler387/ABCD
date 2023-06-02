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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserManageService userManageService;
	
//	@GetMapping("/mg/main")
	@GetMapping("/mg/list")
	public void user(
			Model model,
			String curPage
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
	
	
	@PostMapping("/mg/list")
	public @ResponseBody ModelAndView userfiltering23(
			ModelAndView mav, String curPage,
			@RequestParam Map<String, Object> map
			) {
		logger.info("filter1 에이잭스 출력 : {}", map);
		String ccurpage = curPage;
		logger.info("11111111");
		Paging paging = userManageService.getpaging(ccurpage);
		logger.info("2222222222");
		map.put("paging", paging);
		logger.info("3333333333333");
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("444444444444444444");
		
		//모델값 지정	-> 응답 데이터 JSON 변환
		mav.addObject("userfilter", userfilter);
		mav.addObject("paging", paging);
		
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping("/mg/filter")
	public void userfiltering(
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) {
		logger.info("filter1 에이잭스 출력 : {}", map);
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(curPage, map);
		logger.info("페이징 {}", paging);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
		model.addAttribute("paging", paging);
		model.addAttribute("pagetype", "filter");
		model.addAttribute("map", map);
		
	}
	
//	@RequestMapping(value = "/mg/filter1", method = { RequestMethod.POST })
//	public @ResponseBody ModelAndView userfiltering2(
//			ModelAndView mav, String curPage,
//			@RequestParam Map<String, Object> map
//			) {
//		logger.info("filter1 에이잭스 출력 : {}", map);
//		String ccurpage = curPage;
//		logger.info("11111111");
//		Paging paging = userManageService.getpaging(ccurpage);
//		logger.info("2222222222");
//		map.put("paging", paging);
//		logger.info("3333333333333");
//		List<Users> userfilter = userManageService.getUserMgFiltering(map);
//		logger.info("444444444444444444");
//		//모델값 지정	-> 응답 데이터 JSON 변환
//		mav.addObject("userfilter", userfilter);
//		mav.addObject("paging", paging);
//		logger.info("mav 내용 {}", mav);
//		//뷰네임 지정	-> jsonView 적용
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}
	
//	@RequestMapping(value = "/mg/filter1", method = { RequestMethod.POST })
//	@RequestMapping("/mg/filter1")
//	public String userfiltering2(
//			Model model, String curPage,
//			@RequestParam Map<String, Object> map
//			) {
//		logger.info("filter1 에이잭스 출력 : {}", map);
//		String ccurpage = curPage;
//		Paging paging = userManageService.getFilterPaging(curPage, map);
//		logger.info("페이징 {}", paging);
//		map.put("paging", paging);
//		List<Users> userfilter = userManageService.getUserMgFiltering(map);
//		logger.info("{}", userfilter);
//		model.addAttribute("userfilter", userfilter);
//		model.addAttribute("paging", paging);
//		logger.info("모델값 {}", model);
////		return "/admin/user/mg/filter";
//	}
//	
//	@RequestMapping(value = "/mg/filter1", method = { RequestMethod.POST })
	@ResponseBody
	@RequestMapping("/mg/filter1")
	public ModelAndView userfiltering2(
			ModelAndView mav,
			String curPage,
			@RequestParam Map<String, Object> map
			) {
		logger.info("filter1 에이잭스 출력 : {}", map);
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(curPage, map);
		logger.info("페이징 {}", paging);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		
	      mav.addObject("userfilter", userfilter);
	      mav.addObject("paging", paging);
	      
	      mav.setViewName("/admin/user/mg/list");
	 	return mav;
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
	public String UserMgUpdate2(@RequestParam Map<String, Object> map) {		
		logger.info("post update 들어옴");
		logger.info("수정될 유저 정보{}", map);
		String curPage = (String) map.get("curPage");
		logger.info("페이지정보{}: ", curPage);
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
			Model model,
			String curPage) {
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
			Model model, String curPage,
			@RequestParam Map<String, Object> map
			) { 
		String ccurpage = curPage;
		Paging paging = userManageService.getFilterPaging(ccurpage, map);
		map.put("paging", paging);
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("users", userfilter);
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
