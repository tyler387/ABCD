package com.kh.jaManChw.admin.boardmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.boardmanage.dao.face.QnAQDao;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAQService;
import com.kh.jaManChw.util.Paging;

@Service
public class QnAQServiceImpl implements QnAQService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private QnAQDao qnAQDao;
	
	@Override
	public Paging getPaging(String curPage) {

		int qnACurPage = 0;
		if(curPage != null && !("").equals(curPage)) {
			qnACurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(qnACurPage,qnAQDao.selectCntQnAQ());
	}
	
	@Override
	public List<Map<String, Object>> showQnAList(Paging paging) {

		return qnAQDao.selectQnAQAll(paging);
	}
	
	@Override
	public Paging getQnAPaging(Map<String, Object> filterAndPagingMap) {

		int filterQnACurPage = 0;
		
		if(filterAndPagingMap.get("curPage") != null && !"".equals(filterAndPagingMap.get("curPage"))) {
			String curPage = (String)filterAndPagingMap.get("curPage");
			
			filterQnACurPage = Integer.parseInt(curPage);  
		}
		
		return new Paging(filterQnACurPage,qnAQDao.selectCntQnAQFilterAll(filterAndPagingMap));
	}
	
	@Override
	public List<Map<String, Object>> showQnAQListByFilter(Map<String, Object> filterAndPagingMap, Paging paging) {

		logger.info("filterMap k: {}",filterAndPagingMap.get("filter"));
		logger.info("filterMap v: {}",filterAndPagingMap.get("content"));
		
		filterAndPagingMap.put("paging", paging);
		
		return qnAQDao.selectQnAQByFilter(filterAndPagingMap);
	}
	
	@Override
	public Map<String, String> showQnAQDetail(int questionno) {

		return qnAQDao.selectQnAQDetail(questionno);
	}
}
