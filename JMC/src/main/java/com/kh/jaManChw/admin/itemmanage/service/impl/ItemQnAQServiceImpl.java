package com.kh.jaManChw.admin.itemmanage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAQDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAQService;

@Service
public class ItemQnAQServiceImpl implements ItemQnAQService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemQnAQDao itemQnAQDao;
	
}
