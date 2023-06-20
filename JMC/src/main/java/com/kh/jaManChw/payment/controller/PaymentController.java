package com.kh.jaManChw.payment.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Encoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.jaManChw.dto.ShoppingBasket;
import com.kh.jaManChw.payment.service.face.PaymentService;


@RequestMapping("/payment")
@Controller
public class PaymentController {
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired PaymentService paymentService;
	
	@RequestMapping("/start")
	public void PaymentStart() {
		
	}
	
	@RequestMapping("/tossstart")
	public void PaymenttossStart() {
		
	}
	
	@RequestMapping("/end")
	public void PaymentEnd() {

	}
	
	@RequestMapping("/fail")
	public void PaymentFail() {

	}

	
	@RequestMapping("/success")
	public void PaymentSuccess(@RequestParam Map<String, Object> map) {
		logger.info("{}", map);
		logger.info("{}", map.get("orderId"));
		logger.info("{}", map.get("paymentKey"));
		
	}
	
	@RequestMapping("/main")
	public void PaymentMain(
			@RequestParam Map<String, Object> map,  HttpSession session,
			 int[] basketno, Model model
			) {
		logger.info("결제할 상품들 출력 맵 {}", map);
		logger.info("결제할 상품들 출력 바스켓넘버{}", basketno);
		String userno = String.valueOf(session.getAttribute("userno"));
		List<Map<String, Object>> sbList = paymentService.getParamList(basketno);
		Map<String, String> user = paymentService.getuserinfo(userno);
		logger.info("sbListsbListsbListsbList = {}", sbList);
//		logger.info("sbList splite : {}", user.get("PHONE").split(",")[1]);
		logger.info("useruser = {}", user);
		logger.info("bbsssb = {}", sbList);
		
		logger.info("결제할 상품들 출력{}", sbList);
		model.addAttribute("sbList", sbList);
		model.addAttribute("user", user);
		model.addAttribute("basketno", basketno);
	}
	

	@RequestMapping("/paysuccess")
	public String paysuccess(HttpServletRequest request, HttpSession session,
			@RequestParam Map<String, Object> map, int[] basketno, String[] itemTitle) {
		logger.info("맵 = {}", map);
		logger.info("바스켓넘버 = {}", basketno);
		logger.info("itemTitle = {}", itemTitle);
		logger.info("세션유저넘버 = {}", session.getAttribute("userno"));
		String userno = String.valueOf(session.getAttribute("userno"));
		logger.info("세션 유저넘버", userno);
		map.put("userno", userno);
		logger.info(" 원래 담긴 맵", map);
		
		JSONObject jsonObject = paymentService.paymentInfo(request, map, basketno, itemTitle, session);
		
		//paymentKey 이걸로 주문 취소 등 해야함
		logger.info("{}", jsonObject);
		logger.info("{}", jsonObject.get("orderId"));
		
		 return "redirect:/store//buylist";
//		 return "forward:/payment/end";
	}
	
	@RequestMapping("/shoppingBasketList")
	public ModelAndView SbUpdate(int basketno, int sbItemCount, ModelAndView mav) {
		
//	      mav.addObject("basketno", basketno);
	      logger.info("바스켓 넘버 {} --- {}",basketno, sbItemCount);
	      logger.info("상품수량 갯수 {}", sbItemCount);
		
	      //모델값 지정	-> 응답 데이터 JSON 변환
//		mav.addObject();
		
		//뷰네임 지정	-> jsonView 적용
		mav.setViewName("/store/shoppingBasketList.jsp");
	      
	      return mav;
	}
}
