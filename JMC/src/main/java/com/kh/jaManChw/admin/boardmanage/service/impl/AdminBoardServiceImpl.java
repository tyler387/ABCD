package com.kh.jaManChw.admin.boardmanage.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.boardmanage.dao.face.AdminBoardDao;
import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.dto.AdminBoard;
import com.kh.jaManChw.dto.AdminBoardFile;
import com.kh.jaManChw.util.Paging;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminBoardDao adminBoardDao;
	@Autowired private ServletContext context;
	
	@Override
	public Paging getBoardPaging(String curPage, String boardOption) {
		
		//현재 페이지 보정
		int thisCurPage = 0;
		logger.info("현재 페이지스1:{}", curPage);
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

	
	//공지사항, 이벤트 글쓰기시 summernote에 추가되는 사진들에 대한 저장
	@Override
	public JSONObject manageFile(MultipartFile multipartFile) {

		JSONObject jsonObject = new JSONObject();
		
		if(multipartFile.getSize() <= 0) {
			return null;
		}
		
		String storedPath = context.getRealPath("summerfile"); //저장될 외부 파일 경로
		logger.info("RealPath: {}", storedPath);
		
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		File dest = null;
		
		String storedFileName = null;
		
		do {
			String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
			storedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
			
			dest = new File(storedFolder, storedFileName);
		} while (dest.exists());

		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, dest);	//파일 저장

			//파일의 경로가 URL이 아니라 절대 경로로 이미지의 위치가 나오고 있어서 이미지를 불러오지 못했음
//			jsonObject.put("url", dest.toString());
			
			//이미지 파일의 이름을 url으로 보내줘야 외부에서 접근이 가능함
			//url은 서버의 파이 존재하는 이름부터 시작하는 경로...(루트부터 시작해서 찾게 됨..)
			//이렇게 하고도 외부에서 정적 파일에 접근하기 위해서는 servlet-context에서 
			//외부 접근을 허가하는 태그를 추가해줘야함..!
			jsonObject.put("url", "/"+"summerfile"+"/"+storedFileName);
			jsonObject.put("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(dest);	//저장된 파일 삭제
			jsonObject.put("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	@Override
	public void writeAdminBoard(HttpSession session, AdminBoard adminBoardParam, MultipartFile[] files) {

		//adminBoardno를 생성하고 바로 adminBoardParam에 삽입
		adminBoardParam.setAdminBoardno(adminBoardDao.selectCreateAdminBoardno());
		
		//adminBoardParam에 입력 받은 정보 외에 부족한 정보를 추가
		//로그인 기능을 통해서 session에 userno를 추가되면서 추가될 코드
		//현재 미구현
		adminBoardParam.setUserno((Integer)session.getAttribute("userno"));
		adminBoardParam.setAbOption(String.valueOf(session.getAttribute("boardOption")));
		
		//임시로 userno저장 - 세션에서 값 받아오면 삭제해야함!
//		adminBoardParam.setUserno(5);

		//파일 업로드 이전에 게시글이 작성되어야함
		adminBoardDao.insertAdminBoard(adminBoardParam);
		
		//파일 업로드(다중 파일일 경우를 위해 for-each구문으로 구성)
		for(MultipartFile file : files) {
			if(file.getSize()<=0) {
				return;
			}
		
			//파일 저장 경로 확인
			String storedPath = context.getRealPath("adminBoardFile"+adminBoardParam.getAbOption());
			logger.info("storedPath: {}",storedPath);
			
			//파일 저장
			File storedFolder = new File(storedPath);
			storedFolder.mkdir();
			
			File dest = null;
			
			String storedFileName = null;
			
			do {
				storedFileName = UUID.randomUUID().toString().split("-")[0];
				dest = new File(storedFolder, storedFileName);
			} while (dest.exists());
			
			try {
				file.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
//			logger.info("파일 이름: {}", file.getOriginalFilename()); 
//			logger.info("adminBoardParam: {}", adminBoardParam); 
			
			//저장된 파일 정보 DB에 삽입 
			adminBoardDao.insertAdminBoardFile(new AdminBoardFile(0, adminBoardParam.getAdminBoardno(), file.getOriginalFilename(), storedFileName, file.getSize()));
		}
		
	}
	
	@Override
	public AdminBoard showAdminBoardDetail(AdminBoard adminBoardParam) {
		
		return adminBoardDao.selectAdminBoardDetail(adminBoardParam);
	}
	
	@Override
	public void reviseAdminBoard(AdminBoard adminBoardParam) {
		adminBoardDao.updateAdminBoard(adminBoardParam);
	}
	
	@Override
	public void eraseAdminBoardStatus(int adminBoardno) {
		adminBoardDao.updateAdminBoarStatus(adminBoardno);
	}
	
	//--------------------관리자 게시글 끝----------------------------
	
	
}
