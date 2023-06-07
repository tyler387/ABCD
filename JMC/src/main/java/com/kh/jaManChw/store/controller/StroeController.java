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
	public ModelAndView SbUpdate(int basketno, int sbItemCount, ModelAndView mav) {
		
//	      mav.addObject("basketno", basketno);
	      logger.info("바스켓 넘버 {} --- {}",basketno, sbItemCount);
	      logger.info("상품수량 갯수 {}", sbItemCount);
		
	      //모델값 지정	-> 응답 데이터 JSON 변환
//		mav.addObject();
		
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("/store/shoppingBasketList");
	      
	      return mav;
	}

}
