package com.kh.jaManChw.customerService.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.customerService.dao.face.CSDao;
import com.kh.jaManChw.customerService.service.face.CSService;
import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

@Service
public class CSServiceImpl implements CSService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private CSDao cSDao;
	
	@Override
	public Paging getNoticePaging(String curPage) {

		int nowCurPage = 1;
		
		if (curPage != null && !"".equals(curPage)) {
			nowCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(nowCurPage, cSDao.selectCntTotalNotice() );
	}
	
	@Override
	public Paging getEventPaging(String curPage) {
		
		int nowCurPage = 1;
		
		if (curPage != null && !"".equals(curPage)) {
			nowCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(nowCurPage, cSDao.selectCntTotalEvent() );
	}

	@Override
	public Paging getQnAPaging(String curPage) {
		
		int nowCurPage = 1;
		
		if (curPage != null && !"".equals(curPage)) {
			nowCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(nowCurPage, cSDao.selectCntTotalQnA() );
	}
	
	@Override
	public List<Map<String, Object>> showNoticeList(Paging paging) {
		return cSDao.selectNoticeList(paging);
	}
	
	@Override
	public Map<String, Object> showNoticeDetail(int adminBoardno) {
		return cSDao.selectNoticeDetail(adminBoardno);
	}
	
	@Override
	public List<Map<String, Object>> showEventList(Paging paging) {
		return cSDao.selectEventList(paging);
	}
	
	@Override
	public Map<String, Object> showEventDetail(int adminBoardno) {
		// TODO Auto-generated method stub
		return cSDao.selectEventDetail(adminBoardno);
	}
	
	@Override
	public List<Map<String, Object>> showQnAList(Paging paging) {
		return cSDao.selectQnAList(paging);
	}
	
	@Override
	public Map<String, Object> showQnADetail(int questionno) {
		return cSDao.selectQnADetail(questionno); 
	}

	@Override
	public boolean isAnswered(int questionno) {
		if(cSDao.selectCntAnswer(questionno)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Map<String, Object> showQnAADetail(int questionno) {
		return cSDao.selectQnAADetail(questionno);
	}

	@Override
	public QnAQ getCompleteQnAQ(HttpSession session, QnAQ qnAQ) {

		qnAQ.setUserno((Integer)session.getAttribute("userno"));
		return qnAQ;
	}
	
	@Override
	public void writeQnAQ(QnAQ completeQnAQ) {
		cSDao.insertQnAQ(completeQnAQ);
	}
	
	@Override
	public void reviseQnAQ(QnAQ qnAQ) {
		cSDao.updateQnAQ(qnAQ);
	}
	
	@Override
	public void eraseQnAQ(int questionno) {
		cSDao.deleteQnAQ(questionno);
	}
	
}
