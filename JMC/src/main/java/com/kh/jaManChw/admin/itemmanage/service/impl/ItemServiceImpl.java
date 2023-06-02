package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;
import com.kh.jaManChw.util.Paging;

@Service
public class ItemServiceImpl implements ItemService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemDao itemDao;
	
	@Override
	public void writeItem(Map<String, String> itemParam) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Paging getItemPaging(String curPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> shewItemListAll(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Paging getItemFilterPaging(Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> showItemListByFilter(Paging itemFilterPaging, Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void showItemDetail(int itemno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void reviseItem(Map<String, String> itemParam) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eraseItem(int itemno) {
		// TODO Auto-generated method stub
		
	}
}
