package com.kh.jaManChw.store.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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
import com.kh.jaManChw.store.service.face.StoreService;
import com.kh.jaManChw.util.Paging;

@RequestMapping("/store")
@Controller
public class StoreController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StoreService storeService;
	
	@RequestMapping("/main")
	public void StoreMain() {
		logger.info("판매사이트 메인");
	}
	
	@GetMapping("/shoppingbasket")
	public void GetStoreShoppingbasket() {
		
	}
	
	@PostMapping("/shoppingbasket")
	public void PostStoreShoppingbasket(int userno, Model model) {
		
		List<Map<String, String>> list = storeService.getShoppingbasketList(userno);
		logger.info("장바구니 조회결과{}", list);
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/shoppingBasketList")
	public ModelAndView SbUpdate(
			@RequestParam Map<String, String> map, 
			ModelAndView mav) {
		
			int userno = 256;
	      logger.info("상품수량 갯수 {}", map);
		
	      storeService.SbUpdate(map);
	      //유저 번호 받아야함
	      List<Map<String, String>> list = storeService.getShoppingbasketList(userno);
	      mav.addObject("list", list);
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("/store/shoppingBasketList");
	      
	      return mav;
	}
	
	
	
	//칵테일 용품 카테고리로 이동 후 goods 리스트를 DESC순으로 불러오기 + Paging
	@RequestMapping("/goodsAll")
	public void goodsAll(String type, String curPage,  Model model) {
		
		Paging paging = storeService.getPage(curPage);
		
		logger.info("Paging {}", paging);
		
		logger.info("칵테일 용품 카테고리 메인");
		logger.info("type값 Goods로 가지고 오는지 : {}", type);
		logger.info("curPage : {}", curPage);
		
		//세션으로 가지고 가는 것도 방법이나 잘 모르겠음
		//logger.info("goods: {}", session.getAttribute("goodsAll"));

		List<Map<String, Object>> list = storeService.showAllGoods(type, paging);
		
		//logger.info("용품의 리스트: {}", list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

	//카테고리별로 물건을 보여준다.
	@RequestMapping("/itemDetailSection")
	public void itemDetailSection(String type, String curPage, Model model) {
		
		logger.info("칵테일 카테고리 값 : {}", type);
		
		Paging paging = storeService.getPage(curPage);
		
		logger.info("curPage : {}", curPage);
		
		List<Map<String, Object>> list = storeService.showCateGoods(type, paging);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
	}

}
