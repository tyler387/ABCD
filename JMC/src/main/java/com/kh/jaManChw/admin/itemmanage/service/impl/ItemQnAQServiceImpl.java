package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.util.HashMap;
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
		
		int itemQnAQCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemQnAQCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(itemQnAQCurPage, itemQnAQDao.selectCntAllQnAQ());
	}
	
	@Override
	public List<Map<String, Object>> showItemQnAQList(Paging itemQnAQPaging) {
		return itemQnAQDao.selectItemQnAQAll(itemQnAQPaging);
	}
	
	@Override
	public Paging getItemQnAQFilterPaging(Map<String, String> filterMap, String curPage) {

		int itemQnAQCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemQnAQCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(itemQnAQCurPage, itemQnAQDao.selectCntFilterQnAQ(filterMap));
	}
	
	@Override
	public List<Map<String, Object>> showItemQnAQListByFilter(Paging paging, Map<String, String> filterMap) {
		
		//필터링 맵과 페이징 객체를 같이 가져가기 위한 맵 선언
		Map<String, Object> fpMap = new HashMap<>();
		
		fpMap.put("paging", paging);
		fpMap.put("filter", filterMap);
		
		return itemQnAQDao.selectItemQnAQListByFilter(fpMap);
	}
	
	@Override
	public Map<String, Object> showItemQnAQDetail(int itemQnano) {
		return itemQnAQDao.selectItemQnAQDetail(itemQnano);
	}

	//**기훈 작성, 상위 showItemQnAQList와 동일하나 매개변수에 itemno 추가 됨
	@Override
	public List<Map<String, Object>> showItemQnAQList2(Paging itemQnAQPaging, int itemno) {

		
		return itemQnAQDao.selectItemQnAQAll2(itemQnAQPaging, itemno);
	}
	
	
	
}
