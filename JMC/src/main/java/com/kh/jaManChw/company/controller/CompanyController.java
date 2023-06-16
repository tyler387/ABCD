package com.kh.jaManChw.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/company/info")
	public void getInfo() {
		
		
	}
	
	
}
