package com.kh.jaManChw.admin.usermanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/admin/user")
@Controller
public class UserManageController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserManageService userManageService;
	
	@RequestMapping("/mg")
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
	
	@RequestMapping("/filter")
	public void userfiltering(
			Model model,
			@RequestParam Map<String,String> map
			) {
		
		List<Users> userfilter = userManageService.getUserMgFiltering(map);
		logger.info("{}", userfilter);
		model.addAttribute("userfilter", userfilter);
		
	}
	
}
