package com.kh.jaManChw.customerService.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.customerService.dao.face.CSDao;
import com.kh.jaManChw.customerService.service.face.CSService;

@Service
public class CSServiceImpl implements CSService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private CSDao cSDao;
	

}
