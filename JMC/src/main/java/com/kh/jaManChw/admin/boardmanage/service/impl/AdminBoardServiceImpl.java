package com.kh.jaManChw.admin.boardmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.boardmanage.dao.face.AdminBoardDao;
import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.util.Paging;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminBoardDao adminBoardDao;
	
	@Override
	public Paging getBoardPaging(String curPage, String boardOption) {
		
		//현재 페이지 보정
		int thisCurPage = 0;
		if(curPage != null && !"".equals(curPage)) {
			thisCurPage = Integer.parseInt(curPage);
		}

		logger.info("bo:{}",boardOption);
		
		//전체 게시글 갯수 조회 및 페이징 객체 생성
		Paging page = new Paging(thisCurPage, adminBoardDao.selectAllCnt(boardOption));
		
		return page;
	}

	@Override
	public List<Map<String, String>> showAdminBoardListByBoardOption(String boardOption, Paging page) {



		Map<String, Object> selectMap = new HashMap<>();
		selectMap.put("boardOption", boardOption);
		selectMap.put("paging", page);
		
		logger.info("paging: {}", page);
		
		List<Map<String, String>> abList = adminBoardDao.selectAdminBoardAllByBoardOption(selectMap);
		logger.info("abList: {}",abList);
		
		return abList ;
	}
	
}
