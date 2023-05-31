package com.kh.jaManChw.admin.itemmanage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAADao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAAService;

@Service
public class ItemQnAAServiceImpl implements ItemQnAAService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemQnAADao itemQnAADao;
	
}
