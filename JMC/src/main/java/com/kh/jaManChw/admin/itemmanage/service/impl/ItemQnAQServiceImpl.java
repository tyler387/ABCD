package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemQnAQDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAQService;
import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

@Service
public class ItemQnAQServiceImpl implements ItemQnAQService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemQnAQDao itemQnAQDao;
	
	@Override
	public Paging getItemQnAQPaging(String curPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> showItemQnAQList(Paging itemQnAQPaging) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Paging getItemQnAQFilterPaging(Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> showItemQnAQListByFilter(Paging paging, Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QnAQ showItemQnAQDetail(int itemQnano) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
