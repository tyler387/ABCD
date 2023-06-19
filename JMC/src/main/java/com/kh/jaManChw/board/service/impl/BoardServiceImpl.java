package com.kh.jaManChw.board.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.board.dao.face.BoardDao;
import com.kh.jaManChw.board.service.face.BoardService;
import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.BoardLike;
import com.kh.jaManChw.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardDao boardDao;

	@Autowired ServletContext context;
	
	@Override
	public Paging getPage(String curPage, int boardOptionno) {
		
		int noCurPage=0;
		if(curPage !=null && !"".equals(curPage)) {
			noCurPage = Integer.parseInt(curPage);
		}
		logger.info("ServiceCurPage : {}", noCurPage);
		
		
		return new Paging(noCurPage, boardDao.selectCurPage(boardOptionno), 9, 10);
	}

	@Override
	public List<BoardFile> showAllFile(Paging page) {
		
//		List<BoardFile> makeList = boardDao.selectAllFile(page); 
		
//		List<BoardFile> completeList = new ArrayList<>();
//
//		int boardFileboardno = 0;
//		
//		for(BoardFile bf: makeList) {
//
//			if(bf.getBoardno() == boardFileboardno) {
//				continue;
//			}
//			
//			boardFileboardno = bf.getBoardno();
//			
//			completeList.add(bf);
//		}
		
		
		
//		return completeList;
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
	

	@Override
	public void writeBoard(String category, String boardWrite, List<MultipartFile> file, HttpSession session) {
		
		logger.info("-------범인 색출-------");
		
		for (MultipartFile mf : file) {
			if(mf.getSize() <= 0) {
				logger.info("파일 크기가 0이다. 처리 중단!");
				
				return;
			}
		}

		Board board = new Board();

		//BOARDNO를 생성하는 메서드 
		int boardno = boardDao.selectCreateBoardno();

//		//SQL문
//		SELECT 해당 보드넘버를 생성하는 시퀀스 FROM dual

//		//BOARDNO를 DTO에 삽입
		board.setBoardno(boardno);
//		
		//게시글의 boardOptionNo를 삽입하는 메서드
		
		board.setBoardOptionno(Integer.parseInt(category));
//		//본문을 DB에 삽입하는 메서드
		board.setcontent(boardWrite);


		for (MultipartFile mfile : file) {
		
			String storedPath = context.getRealPath("boardFileUpload");
			logger.info("storedPath: {}", storedPath);
			
			File storedFolder = new File(storedPath);
			storedFolder.mkdir();
			File dest = null;
			String storedName = null;
			

			
			
			do {
				//저장할 파일 이름 생성하기
				storedName = UUID.randomUUID().toString().split("-")[0]+UUID.randomUUID().toString().split("-")[4]; //UUID 추가
				logger.info("storedName : {}", storedName);
				dest = new File(storedFolder, storedName);
	
			}while(dest.exists());
			try {
				//업로드 된 파일을 boardFileUpload폴더에 저장하기
				mfile.transferTo(dest);
				

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//DB에 파일에 대한 정보를 삽입하는 메서드
			BoardFile boardFile = new BoardFile();
	
			//Q : 파일이 여러개면 어떻게 함...?List로 받아야 하는뎅...?
			//A : for문으로 돌려서 진행함!
			boardFile.setStoredName(storedName);
			boardFile.setOriginName(mfile.getOriginalFilename());	
			boardFile.setBoardno(boardno);	
			
		
			logger.info("보드에 대한 정보 값: {}", board);
			logger.info("보드 파일에 대한 정보 값: {}", boardFile);

			board.setUserno((int)session.getAttribute("userno"));	
			logger.info("보드에 대한 정보 값2222: {}", board);
			boardDao.insertBoard(board);
			boardDao.insertBoardFile(boardFile);
			
		}	
	}

	@Override
	public Map<String, Integer> recoBoard(int boardno, HttpSession session) {
		
		BoardLike like = new BoardLike();
		like.setUserno((int)session.getAttribute("userno"));
		like.setBoardno(boardno);
		int chk = boardDao.selectReco(like);
		
		int myLike = 0;
		
		if(chk==0) {
			boardDao.insertReco(like);
			myLike = 1;
		}else {
			boardDao.deleteReco(like);
			myLike = 0;
		}
		
		int allCount = boardDao.selectCntLikeAll(boardno);
		
		Map<String, Integer> likeMap = new HashMap<>();
		
		likeMap.put("chkReco", myLike);
		likeMap.put("allCount", allCount);
		
		
		return likeMap;
	}

//	@Override
//	public Map<String, Integer> recoBoardJoHuye(int boardno, HttpSession session) {
//		
//		BoardLike like = new BoardLike();
//		like.setUserno((int)session.getAttribute("userno"));
//		like.setBoardno(boardno);
//		int chk = boardDao.selectReco(like);
//		
//		int allCount = boardDao.selectCntLikeAll(boardno);
//		
//		Map<String, Integer> likeMap = new HashMap<>();
//		
//		likeMap.put("chkReco", chk);
//		likeMap.put("allCount", allCount);
//		
//		
//		return likeMap;
//	}
	
	

	@Override
	public List<Map<String, Object>> searchBoardFile(Board board, String searchData) {
		return boardDao.selectBoardFile(board, searchData);
	}

	@Override
	public int chkReco(int boardno, int userno) {
		BoardLike boardLike = new BoardLike();
		boardLike.setBoardno(boardno);
		boardLike.setUserno(userno);
		return boardDao.selectReco(boardLike);
	}



}
