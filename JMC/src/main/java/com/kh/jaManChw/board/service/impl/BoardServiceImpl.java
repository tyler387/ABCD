package com.kh.jaManChw.board.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.jaManChw.board.dao.face.BoardDao;
import com.kh.jaManChw.board.service.face.BoardService;
import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired BoardDao boardDao;

	@Autowired ServletContext context;
	
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

	@Override
	public void writeBoard(String boardWrite, List<MultipartFile> file) {
		if(( (MultipartFile) file).getSize() <= 0) {
			logger.info("파일 크기가 0이다. 처리 중단!");
			
			return;
		}
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		String storedPath = context.getRealPath("upload");
		logger.info("storedPath: {}", storedPath);
		
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@");
		File dest = null;
		String storedName = null;
		
		do {
			//저장할 파일 이름 생성하기
			storedName = ((MultipartFile) file).getOriginalFilename(); //원본 파일명
			storedName += UUID.randomUUID().toString().split("-")[0]; //UUID 추가
			logger.info("storedName : {}", storedName);
			dest = new File(storedFolder, storedName);
			
			Board board = new Board();
			BoardFile boardFile = new BoardFile();
			
			//??????파일이 여러개면 어떻게 함...?List로 받아야 하는뎅...?
			board.setcontent(boardWrite);
			boardFile.setStoredName(storedName);
			boardFile.setOriginName(((MultipartFile) file).getOriginalFilename());	
			
			boardDao.insertBoardFile(boardFile);
			boardDao.insertBoard(board);
		}while(dest.exists());
		try {
			//업로드 된 파일을 upload폴더에 저장하기
			((MultipartFile) file).transferTo(dest);
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	@Override
	public void writeBoard(MultipartHttpServletRequest request) {
		 List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		    
		    // input file 에 아무것도 없을 경우 (파일을 업로드 하지 않았을 때 처리)
		    if(request.getFiles("file").get(0).getSize() != 0){
		    	fileList = request.getFiles("file");
		    }
		        
		    String path = context.getRealPath("upload");
		    
		    File fileDir = new File(path);
		    
		    if (!fileDir.exists()) {
		    	fileDir.mkdirs();
			}
		    
		    long time = System.currentTimeMillis();
		    
		    for (MultipartFile mf : fileList) {
		    
		    	String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		        String saveFileName = String.format("%d_%s", time, originFileName);
		        
				Board board = new Board();
				BoardFile boardFile = new BoardFile();
				
				boardFile.setOriginName(originFileName);
				boardDao.insertBoardFile(boardFile);
		        
		        try {
		        	// 파일생성
		            mf.transferTo(new File(path, saveFileName));    		
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
		     }
	}

}
