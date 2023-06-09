package com.kh.jaManChw.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/login/main")
	public void mainPage() {
			
		logger.info("/login/main [GET]");
		
	}
	
}
