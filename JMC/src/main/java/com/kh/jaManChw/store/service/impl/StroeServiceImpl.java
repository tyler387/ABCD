package com.kh.jaManChw.store.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.store.dao.face.StroeDao;
import com.kh.jaManChw.store.service.face.StroeService;
import com.kh.jaManChw.util.Paging;

@Service
public class StroeServiceImpl implements StroeService {

	
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StroeDao stroeDao;

	@Override
	public List<Map<String, String>> getShoppingbasketList(int userno) {
		
		return stroeDao.selectAllShoppingbasketList(userno);
		
	}

	@Override
	public void SbUpdate(Map<String, String> map) {
		
		stroeDao.updateSbUpdate(map);
		
	}

	@Override
	public List<Map<String, Object>> showAllGoods(String type) {
		
		return stroeDao.selectAllItem(type);
	}

	@Override
	public Paging getPage(String curPage) {
		int noCurPage=0;
		if(curPage !=null && !"".equals(curPage)) {
			noCurPage = Integer.parseInt(curPage);
		}
		logger.info("ServiceCurPage : {}", noCurPage);
		
		
		return new Paging(noCurPage, stroeDao.selectCurPage(noCurPage), 8, 10);
	}
	
	@Override
	public void Shoppingbasketerase(Map<String, String> map) {
		
		stroeDao.DeleteShoppingBasket(map);
	}
	
	
}
