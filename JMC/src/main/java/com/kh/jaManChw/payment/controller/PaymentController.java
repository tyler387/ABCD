package com.kh.jaManChw.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/end")
	public void PaymentEnd() {

	}

}
