package com.kh.jaManChw.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.board.dao.face.BoardDao;
import com.kh.jaManChw.board.service.face.BoardService;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardDao boardDao;

	@Override
	public Paging getPage(String curPage) {
		
		int noCurPage=0;
		if(curPage !=null && !"".equals(curPage)) {
			noCurPage = Integer.parseInt(curPage);
		}
		logger.info("ServiceCurPage : {}", noCurPage);
		
		
		return new Paging(noCurPage, boardDao.selectCurPage(noCurPage), 9, 10);
	}

	@Override
	public List<BoardFile> showAllFile(Paging page) {
		
		return boardDao.selectAllFile(page);
	}

	@Override
	public Map<String, Object> showAllDetail(int boardno) {
		return boardDao.selectAllDetail(boardno);
	}

	@Override
	public List<BoardComment> showAllComment(int boardno) {
		return boardDao.showAllComment(boardno);
	}

	@Override
	public void commentInput(BoardComment bComment) {
		boardDao.writeUserBoardComment(bComment);
		
	}

	@Override
	public void reviseUserBoardComment(BoardComment boardComment) {
		boardDao.updateUserBoardComment(boardComment);
		
	}

	@Override
	public void eraseUserBoardComment(BoardComment boardComment) {
		boardDao.eraseUserBoardComment(boardComment);
		
	}

	@Override
	public List<Map<String, Object>> showCateAllFile(Paging paging, int boardOptionno) {

		Map<String, Object> pagingAndBoardOptionMap = new HashMap<>();
		
		pagingAndBoardOptionMap.put("paging", paging);
		pagingAndBoardOptionMap.put("boardOptionno", boardOptionno);
		
		return boardDao.selectCateAllFile(pagingAndBoardOptionMap);
	}

}
