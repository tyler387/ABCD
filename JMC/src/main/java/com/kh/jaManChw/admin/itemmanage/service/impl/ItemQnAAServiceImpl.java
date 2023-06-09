package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAADao;
import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAQDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAAService;
import com.kh.jaManChw.dto.ItemQnAA;

@Service
public class ItemQnAAServiceImpl implements ItemQnAAService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemQnAADao itemQnAADao;
	@Autowired private ItemQnAQDao itemQnAQDao;
	
	@Override
	public ItemQnAA getCompleteItemQnAA(ItemQnAA itemQnAAParam, HttpSession session) {
		itemQnAAParam.setUserno((Integer)session.getAttribute("userno"));;
		return itemQnAAParam;
	}
	
	@Override
	public void writeItemQnAA(ItemQnAA itemQnAAParam) {
		itemQnAADao.insertItemQnAA(itemQnAAParam);
		itemQnAQDao.updateItemQnAQ(itemQnAAParam);
		
	}

	@Override
	public Map<String, Map<String, Object>> showItemQnAAllDetail(ItemQnAA itemQnAAParam) {
		
		Map<String, Map<String, Object>> itemQnAAllMap = new HashMap<>();
		
				
		itemQnAAllMap.put("itemQnAQ",itemQnAQDao.selectItemQnAQDetail(itemQnAAParam.getItemQnano()));
		itemQnAAllMap.put("itemQnAA",itemQnAADao.selectItemQnAADetail(itemQnAAParam.getMgrItemno()));
		
		return itemQnAAllMap;
	}
	
	@Override
	public void reviseItemQnAA(ItemQnAA itemQnAAParam) {
		itemQnAADao.updateItemQnAA(itemQnAAParam);
	}
	
	@Override
	public void eraseItemQnAA(ItemQnAA itemQnAAParam) {
		itemQnAADao.updateItemQnAAStatus(itemQnAAParam.getMgrItemno());
		itemQnAQDao.updateItemQnAQUnprocessed(itemQnAAParam);
	}
}
