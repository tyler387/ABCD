package com.kh.jaManChw.admin.itemmanage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemDao itemDao;
	
}
