package com.kh.jaManChw.store.controller;

import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.kh.jaManChw.store.service.face.StroeService;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/store")
@Controller
public class StroeController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StroeService stroeService;
	
	
	
	@RequestMapping("/shoppingBasketList")
	public ModelAndView SbUpdate(
			@RequestParam Map<String, String> map, 
			ModelAndView mav, HttpSession session) {
			int userno = (Integer)session.getAttribute("userno");
			logger.info("세션 유저 넘버 {}", userno);
	      logger.info("상품수량 갯수 {}", map);
	      map.put("userno", Integer.toString(userno));
	      stroeService.SbUpdate(map);
	      //유저 번호 받아야함
	      List<Map<String, String>> list = stroeService.getShoppingbasketList(userno);
	      mav.addObject("list", list);
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("/store/shoppingBasketList");
	      
	      return mav;
	}
	
	@RequestMapping("/main")
	public void StoreMain() {
		logger.info("판매사이트 메인");
	}
	
//	@GetMapping("/shoppingbasket")
//	public void GetStoreShoppingbasket() {
//		
//	}
	
	@RequestMapping("/shoppingbasket")
	public void PostStoreShoppingbasket(Model model, HttpSession session) {
		
		int userno = (Integer)session.getAttribute("userno");
		logger.info("세션 유저 넘버 {}", userno);
		List<Map<String, String>> list = stroeService.getShoppingbasketList(userno);
		logger.info("장바구니 조회결과{}", list);
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/shoppingBasketDelete")
	public String StoreShoppingbasketDelete(@RequestParam Map<String, String> map, HttpSession session) {
		int userno = (Integer)session.getAttribute("userno");
		logger.info("세션 유저 넘버 {}", userno);
		logger.info("상품수량 갯수 {}", map);
      	map.put("userno", Integer.toString(userno));
      	logger.info("유저넘버 받아서 맵값 확인하기 {}", map);
      	
		stroeService.Shoppingbasketerase(map);
		 return "redirect:/store/shoppingbasket";
	}
	
	
	//칵테일 용품 카테고리로 이동 후 goods 리스트를 DESC순으로 불러오기
	@RequestMapping("/goodsAll")
	public void goodsAll(String type, Model model, String curPage) {
		
		Paging paging = stroeService.getPage(curPage);
		
		logger.info("Paging {}", paging);
		
		logger.info("칵테일 용품 카테고리 메인");
		logger.info("칵테일 용품 카테고리 메인 {}", type);
		
		//세션으로 가지고 가는 것도 방법이나 잘 모르겠음
		//logger.info("goods: {}", session.getAttribute("goodsAll"));

		List<Map<String, Object>> list = stroeService.showAllGoods(type);
		
		//logger.info("용품의 리스트: {}", list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		
	}


}
