package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAADao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAAService;
import com.kh.jaManChw.dto.QnAA;

@Service
public class ItemQnAAServiceImpl implements ItemQnAAService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemQnAADao itemQnAADao;
	
	@Override
	public void writeItemQnAA(QnAA qnAAParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Map<String, Object>> reviseItemQnAQ(QnAA qnAAParam) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void eraseItemQnAQ(int mgrItemno) {
		// TODO Auto-generated method stub
		
	}
}
