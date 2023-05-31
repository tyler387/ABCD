package com.kh.jaManChw.admin.itemmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAAService;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAQService;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;

@Controller
@RequestMapping("/admin")
public class ItemManageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemService itemService;
	@Autowired private ItemQnAQService itemQnAQService;
	@Autowired private ItemQnAAService itemQnAAService;
	
	
}
