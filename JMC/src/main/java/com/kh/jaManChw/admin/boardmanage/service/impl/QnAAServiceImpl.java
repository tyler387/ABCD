package com.kh.jaManChw.admin.boardmanage.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.boardmanage.dao.face.QnAADao;
import com.kh.jaManChw.admin.boardmanage.dao.face.QnAQDao;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;
import com.kh.jaManChw.dto.QnAA;

@Service
public class QnAAServiceImpl implements QnAAService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private QnAADao qnAADao;
	@Autowired private QnAQDao qnAQDao;
	
	@Override
	public QnAA getCompleteParam(HttpSession session, QnAA qnAAParam) {
		qnAAParam.setUserno((Integer)session.getAttribute("userno"));
		return qnAAParam;
	}
	
	@Override
	public void writeQnAA(QnAA qnAAParam) {
		logger.info("처리했나?1: {}", qnAAParam);
		qnAADao.insertQnAA(qnAAParam);
		logger.info("처리했나?2: {}", qnAAParam);
		qnAADao.upadateQnAQStatus(qnAAParam);
		
	}
	
	@Override
	public Map<String, Map<String, String>> showQnAADetail(QnAA qnAAParam) {

		Map<String, Map<String, String>> qnAQADetail = new HashMap<>();
		
//		Map<String, String> map1 = qnAADao.selectQnAADetail(qnAAParam);
//		logger.info("여기까진가?1:{}", map1);
		
//		Map<String, String> map2 = qnAQDao.selectQnAQDetail(qnAAParam.getQuestionno());
//		logger.info("여기까진가?2:{}", map2);

		qnAQADetail.put("qnAADetail",qnAADao.selectQnAADetail(qnAAParam));
		logger.info("여기까진가?1:{}", qnAQADetail);
		qnAQADetail.put("qnAQDetail",qnAQDao.selectQnAQDetail(qnAAParam.getQuestionno()));
		logger.info("여기까진가?2:{}", qnAQADetail);

//		qnAQADetail.put("qnAQList",map1);
//		qnAQADetail.put("qnAAList",map2);
//		logger.info("여기까진가?2:{}", qnAQADetail);
		
		return qnAQADetail;
	}
	
	@Override
	public void reviseQnAA(QnAA qnAAParam) {
		qnAADao.updateQnAA(qnAAParam);
	}
	
	@Override
	public void eraseQnAAStatus(QnAA qnAAParam) {
		logger.info("처리되엇는가1?");
		qnAADao.updateQnAAStatus(qnAAParam);
		logger.info("처리되엇는가2?");
		qnAQDao.updateQnAQStatus(qnAAParam);
		logger.info("처리되엇는가3?");
	}
}
