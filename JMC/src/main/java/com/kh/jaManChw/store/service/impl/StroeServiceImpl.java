package com.kh.jaManChw.store.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.store.dao.face.StroeDao;
import com.kh.jaManChw.store.service.face.StroeService;

@Service
public class StroeServiceImpl implements StroeService {

	
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StroeDao stroeDao;

	@Override
	public List<Map<String, String>> getShoppingbasketList(int userno) {
		
		return stroeDao.selectAllShoppingbasketList(userno);
		
	}
	
	
	
	
}
