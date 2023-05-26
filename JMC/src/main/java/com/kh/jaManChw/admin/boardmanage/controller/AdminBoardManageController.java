package com.kh.jaManChw.admin.boardmanage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAQService;
import com.kh.jaManChw.dto.AdminBoard;
import com.kh.jaManChw.util.Paging;

@Controller
@RequestMapping("/admin")
public class AdminBoardManageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private AdminBoardService adminBoardService;
	@Autowired private QnAAService qnAAService;
	@Autowired private QnAQService qnAQService;
	
	//관리자 게시글 관리 페이지로 이동
	@GetMapping("/board/list")
	public void adminBoardPage(
				String boardOption,
				String curPage,
				HttpSession session,
				Model model
			) {
		
		session.setAttribute("boardOption", boardOption);
		
		Paging page = adminBoardService.getBoardPaging(curPage, boardOption);
		
		List<Map<String, String>> boardList = adminBoardService.showAdminBoardListByBoardOption(boardOption, page);
		
		logger.info("session:{}",session.getAttribute("boardOption"));
		model.addAttribute("boardOption", session.getAttribute("boardOption"));
		model.addAttribute("paging", page);
		model.addAttribute("boardList",boardList);
		
	}
	
	//관리자 게시글 등록 페이지로 이동
	@GetMapping("/board/noticeWrite")
	public void adminBoardWritePage() {
	}
	

	//관리자 게시글 내용 파일 저장
	@PostMapping(value ="/board/writeFileupload" , produces = "application/json; charset=utf8")
	public @ResponseBody JSONObject adminBoardContentFileupload(
//			@RequestParam("files") MultipartFile multipartFile
			@RequestParam("file") MultipartFile multipartFile
			) {

		JSONObject jo = adminBoardService.manageFile(multipartFile);
		
		logger.info(jo.toString());
		
		//*** 응답으로 image url 필요 [ex. /upload/저장파일명]
		return jo; 
	}
	
	//관리자 게시글 등록
	@PostMapping(value = "/board/write",  produces = "application/json; charset=utf8")
	public String adminBoardWrite(
			
			//폼필드를 받는 DTO
			AdminBoard adminBoardParam,
			
			//파일을 받는 file변수
			MultipartFile[] file,
			
			//BoardOption을 담고 있을 session객체
			HttpSession session
			) {
		logger.info("adminBoardParam: {}", adminBoardParam);
		logger.info("files: {}", file);
		logger.info("session.boardOption: {}", session.getAttribute("boardOption"));
		
		adminBoardService.writeAdminBoard(session,adminBoardParam, file);
		
		return "board/list";
	}
	
}
