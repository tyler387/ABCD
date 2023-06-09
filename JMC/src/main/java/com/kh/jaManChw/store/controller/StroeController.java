package com.kh.jaManChw.store.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.kh.jaManChw.store.service.face.StroeService;

@RequestMapping("/store")
@Controller
public class StroeController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StroeService stroeService;
	
	@RequestMapping("/main")
	public void StoreMain() {
		logger.info("판매사이트 메인");
	}
	
	@GetMapping("/shoppingbasket")
	public void GetStoreShoppingbasket() {
		
	}
	
	@PostMapping("/shoppingbasket")
	public void PostStoreShoppingbasket(int userno, Model model) {
		
		List<Map<String, String>> list = stroeService.getShoppingbasketList(userno);
		logger.info("장바구니 조회결과{}", list);
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/shoppingBasketList")
	public ModelAndView SbUpdate(
			@RequestParam Map<String, String> map, 
			ModelAndView mav) {
		
			int userno = 256;
	      logger.info("상품수량 갯수 {}", map);
		
	      stroeService.SbUpdate(map);
	      //유저 번호 받아야함
	      List<Map<String, String>> list = stroeService.getShoppingbasketList(userno);
	      mav.addObject("list", list);
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("/store/shoppingBasketList");
	      
	      return mav;
	}

}
