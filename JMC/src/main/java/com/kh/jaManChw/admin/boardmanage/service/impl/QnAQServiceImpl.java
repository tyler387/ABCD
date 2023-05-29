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
}
