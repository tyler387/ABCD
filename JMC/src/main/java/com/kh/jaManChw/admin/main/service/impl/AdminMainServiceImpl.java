package com.kh.jaManChw.admin.main.service.impl;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.main.dao.face.AdminMainDao;
import com.kh.jaManChw.admin.main.service.face.AdminMainService;
import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;

@Service
public class AdminMainServiceImpl implements AdminMainService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminMainDao adminMainDao;
	
	@Override
	public Map<String, Object> getAllInfo() {

		//오늘 날짜를 형식에 맞게 가져오는 작업
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
		String today = sdf.format(gc.getTime());
		
		logger.info(today);
		
//		int idx = 0;
		
		Map<String, Object> allInfoMap = new HashMap<>();
		
		//오늘 회원 가입한 회원 정보 조회
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayJoinUsersCnt", adminMainDao.selectCntTodayJoinUsers(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayJoinUsers", adminMainDao.selectTodayJoinUsers(today));
//		logger.info("왜 종료하지?:{}", idx++);
		
		//오늘 작성된 게시글 정보 조회
		allInfoMap.put("todayWriteBoardsCnt", adminMainDao.selectCntTodayWriteBoards(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteBoards", adminMainDao.selectTodayWriteBoards(today));
//		logger.info("왜 종료하지?:{}", idx++);
		
		//오늘 작성된 신고글(게시글) 정보 조회
		allInfoMap.put("todayWriteReportBoardsCnt", adminMainDao.selectCntTodayWriteReportBoards(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteReportBoards", adminMainDao.selectTodayWriteReportBoards(today));

		//오늘 작성된 신고글(계정) 정보 조회
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteReportUsersCnt", adminMainDao.selectCntTodayWriteReportUsers(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteReportUsers", adminMainDao.selectTodayWriteReportUsers(today));
		
		//오늘 작성된 신고글(모임) 정보 조회
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteReportMeetingsCnt", adminMainDao.selectCntTodayWriteReportMeetings(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteReportMeetings", adminMainDao.selectTodayWriteReportMeetings(today));
//		logger.info("왜 종료하지?:{}", idx++);
		
		//오늘 생성된 모임 정보 조회
		allInfoMap.put("todayWriteMeetingsCnt", adminMainDao.selectCntTodayWriteMeetings(today));
//		logger.info("왜 종료하지?:{}", idx++);
		allInfoMap.put("todayWriteMeetings", adminMainDao.selectTodayWriteMeetings(today));
		
//		logger.info("왜 종료하지?:{}", idx++);
		logger.info("allInfoMap: {}", allInfoMap);
//		logger.info("왜 종료하지?:{}", idx++);
		
		//추가할것 추가하기!
		


		
		return allInfoMap;
	}
}
