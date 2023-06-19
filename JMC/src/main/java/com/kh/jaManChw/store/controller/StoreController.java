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

import com.kh.jaManChw.dto.ShoppingBasket;
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
	
	@RequestMapping("/shoppingbasket")
	public void PostStoreShoppingbasket(Model model, HttpSession session) {
		
		int userno = (Integer)session.getAttribute("userno");
		logger.info("세션 유저 넘버 {}", userno);
		List<Map<String, Object>> list = storeService.getShoppingbasketList(userno);
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
      	
      	storeService.Shoppingbasketerase(map);
		 return "redirect:/store/shoppingbasket";
	}
	
	
	
	//칵테일 용품 카테고리로 이동 후 goods 리스트를 DESC순으로 불러오기 + Paging
	//+ goods관련 카테고리를 클릭하면 해당 카테고리 리스트만 불러온다.
	@RequestMapping("/goodsAll")
	public void goodsAll(String type, String searchData, String curPage,  Model model) {
		
		logger.info("검색 데이터: {}", searchData);
		
		Paging paging = storeService.getPage(curPage);
		
		logger.info("Paging {}", paging);
		
		logger.info("칵테일 용품 카테고리 메인");
		logger.info("type값 Goods로 가지고 오는지 : {}", type);
		logger.info("curPage : {}", curPage);
		
		//세션으로 가지고 가는 것도 방법이나 잘 모르겠음
		//logger.info("goods: {}", session.getAttribute("goodsAll"));

		List<Map<String, Object>> list = storeService.showAllGoods(type, searchData, paging);
		
		logger.info("용품의 리스트: {}", list);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}
	
	@RequestMapping("/itemDetail")
	public void itemDetail(int itemno, String curPage, Model model) {
		logger.info("아이템 번호! : {}", itemno);
		
		Map<String, Object> allItemDetail = storeService.showDetailItem(itemno);
		
		logger.info("상품에 대한 자세한 정보: {}", allItemDetail);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("allItemDetail", allItemDetail);
	}
	
	@RequestMapping("/storeBoard")
	public void storeBoard() {
		
	}
	
	@RequestMapping("/boardWrite2")
	public void boardWrite() {
		
	}
	@RequestMapping("/buynow")
	public String Itembuynow(@RequestParam Map<String, String> map,
			String[] itemOptionno
			,String[] sbItemCount
			,HttpSession session
			,int itemno
			,Model model
			) {
		
		logger.info("가져왓나요?: {}",itemOptionno[0]);
		logger.info("가져왓나요?: {}",sbItemCount[0]);
		
		List<ShoppingBasket> sbList = storeService.getsbListParam(itemOptionno,sbItemCount, itemno, (Integer)session.getAttribute("userno"));
		logger.info("what:{}",sbList);
		storeService.writeShoppingBasket(sbList);
		int basketno = storeService.getbasketno();
		
		logger.info("맵출력 map{}", map);
//		return "redirect:../shoppingbasket"
		return "redirect:/payment/main?itemno="+map.get("itemno")+"&basketno="+basketno;
	}

	@PostMapping("/write/basket")
	public String shoppingBasketPage(
			String[] itemOptionno
			,String[] sbItemCount
			,HttpSession session
			,int itemno
			,Model model
			) {
		
		logger.info("가져왓나요?: {}",itemOptionno[0]);
		logger.info("가져왓나요?: {}",sbItemCount[0]);
		
		List<ShoppingBasket> sbList = storeService.getsbListParam(itemOptionno,sbItemCount, itemno, (Integer)session.getAttribute("userno"));
		logger.info("what:{}",sbList);
		storeService.writeShoppingBasket(sbList);
		
		return "redirect:../shoppingbasket";
		
	}
	
	@RequestMapping("/buylist")
	public void storeBuyList(HttpSession session, Model model) {
		
		String userno = String.valueOf(session.getAttribute("userno"));
		List<Map<String,String>> map = storeService.getBuyList(userno);
		logger.info("바이리스트 출력{}", map);
		model.addAttribute("buylist", map);
	}
	@RequestMapping("/detail")
	public void storeBuyDetail(HttpSession session, Model model, @RequestParam Map<String, String> map) {
		logger.info("바이리스트 출력{}", map);
		
		String userno = String.valueOf(session.getAttribute("userno"));
		map.put("userno", userno);
		List<Map<String,String>> list = storeService.getBuyDetail(map);
		logger.info("바이리스트 출력{}", list);
		model.addAttribute("buylist", list);
	}
}
