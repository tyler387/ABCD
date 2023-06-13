package com.kh.jaManChw.store.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.store.dao.face.StoreDao;
import com.kh.jaManChw.store.service.face.StoreService;
import com.kh.jaManChw.util.Paging;

@Service
public class StoreServiceImpl implements StoreService {

	
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StoreDao storeDao;

	@Override
	public List<Map<String, String>> getShoppingbasketList(int userno) {
		
		return storeDao.selectAllShoppingbasketList(userno);
		
	}

	@Override
	public void SbUpdate(Map<String, String> map) {
		
		storeDao.updateSbUpdate(map);
		
	}

	@Override
	public Paging getPage(String curPage) {
		int noCurPage=0;
		if(curPage !=null && !"".equals(curPage)) {
			noCurPage = Integer.parseInt(curPage);
		}
		logger.info("ServiceCurPage : {}", noCurPage);

		return new Paging(noCurPage, storeDao.selectCurPage(noCurPage), 8, 10);
	}
	
	@Override
	public List<Map<String, Object>> showAllGoods(String type, Paging paging ) {
		
		return storeDao.selectAllItem(type, paging);
	}

	@Override
	public List<Map<String, Object>> showCateGoods(String type, Paging paging) {
		
		return storeDao.selectCateSectrion(type, paging);
	}

	
	
	
	
}
