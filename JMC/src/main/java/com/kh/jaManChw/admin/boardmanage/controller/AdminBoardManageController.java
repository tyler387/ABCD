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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.boardmanage.service.face.AdminBoardService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAQService;
import com.kh.jaManChw.dto.AdminBoard;
import com.kh.jaManChw.dto.QnAA;
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
				String curPage,
				@SessionAttribute(name ="boardOption") String boardOption,
				Model model
			) {
		logger.info("boardOption: {}", boardOption);
		Paging page = adminBoardService.getBoardPaging(curPage, boardOption);
		
		List<Map<String, String>> boardList = adminBoardService.showAdminBoardListByBoardOption(boardOption, page);
		
		logger.info("boardOption:{}",boardOption);
		model.addAttribute("paging", page);
		model.addAttribute("boardList",boardList);
		
	}
	
	//관리자 게시글 등록 페이지로 이동
	@GetMapping("/board/write")
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
			
			String curPage,
			
			//폼필드를 받는 DTO
			AdminBoard adminBoardParam,
			
			//파일을 받는 file변수
			MultipartFile[] file,
			
			//BoardOption, userno을 담고 있을 session객체
			HttpSession session
			) {
		logger.info("adminBoardParam: {}", adminBoardParam);
		logger.info("files: {}", file);
		logger.info("session.boardOption: {}", session.getAttribute("boardOption"));
		logger.info("curPage: {}",curPage );
		
		adminBoardService.writeAdminBoard(session,adminBoardParam, file);
		
		return "redirect:./list";
	}
	
	@GetMapping("/board/update")
	public void adminBoardRevisePage(
			String curPage,
			HttpSession session,
			AdminBoard adminBoardParam,
			Model model
			) {
		
		logger.info("session - boardOption : {}", session.getAttribute("boardOption"));
		logger.info("session - userno : {}", session.getAttribute("userno"));
		logger.info("adminBoardParam: {}", adminBoardParam);
		
		
		//보드넘버를 통해 해당 게시글을 조회한다
		//	ㄴ모델값으로 보내기 위한 정보, 접근한 사용자가 적절한 접근을 하고 있는지 확인
		AdminBoard detailAdminBoard = adminBoardService.showAdminBoardDetail(adminBoardParam);
		
		//로그인 기능시 생성될 userno, 임의로 세션에 삽입해서 Test한다
//		session.setAttribute("userno", 10);
		
//		if((Integer)session.getAttribute("userno")!=adminBoardParam.getUserno()) {
//			model.addAttribute("notAccess", false);	
//			return "./list"+boardOption+"adminBoard";
//		}
		
		logger.info("detailAdminBoard: {}", detailAdminBoard);
		
		model.addAttribute("detail", detailAdminBoard);
		model.addAttribute("curPage", curPage);
		
	}
	
	@PostMapping("/board/update")
	public String adminBoardRevise(
			String curPage,
			HttpSession session,
			AdminBoard adminBoardParam
			) {
		
		logger.info("POST adminBoardParam: {}", adminBoardParam);
		logger.info("POST adminBoardParam boardOption: {}", session.getAttribute("boardOption"));
		
		adminBoardService.reviseAdminBoard(adminBoardParam);
		
		return "redirect:./list?curPage="+curPage;
	}
	
	@RequestMapping("/board/delete")
	public String adminBoardErase(
			String curPage,
			int adminBoardno
			) {
		logger.info("adminBoardno : {}", adminBoardno);
		adminBoardService.eraseAdminBoardStatus(adminBoardno);
		
		return "redirect:./list?curPage="+curPage;
	}

	//-----------------------------관리자 게시글 관리 끝----------------------------------------
	
	@GetMapping("/qna/list")
	public void qnAPage(
			String curPage,
			Paging paging,
			Model model
			) {
		
		paging = qnAQService.getPaging(curPage);
		List<Map<String, Object>> qnAQList = qnAQService.showQnAList(paging);

		
		logger.info("상태:{}",qnAQList);
		
		model.addAttribute("qnAQList",qnAQList);
		model.addAttribute("paging",paging);
	}
	
	@PostMapping("qna/filter")
	public String qnAQFilter(
			@RequestParam Map<String, Object> filterAndPagingMap,
			Model model
			) {
		
		logger.info("filterM k: {}", filterAndPagingMap);
		
		Paging paging = qnAQService.getQnAPaging(filterAndPagingMap);
		
		List<Map<String, Object>> filterAndPagingList = qnAQService.showQnAQListByFilter(filterAndPagingMap, paging);
		
		logger.info("filterL : {}", filterAndPagingList);
		
		model.addAttribute("qnAQList", filterAndPagingList);
		model.addAttribute("paging", paging );
		
		return "admin/qna/filter";
	}
	
	@GetMapping("qna/write")
	public void qnAAWritePage(
			String curPage,
			int questionno,
			Model model
			) {
		
		Map<String, String> qnAQDetail = qnAQService.showQnAQDetail(questionno);
		
		model.addAttribute("curPage",curPage);
		model.addAttribute("qnAQDetail",qnAQDetail);
	}
	
	@PostMapping("qna/write")
	public String qnAAWrite(
			String curPage,
			HttpSession session,
			QnAA qnAAParam,
			Model model
			) {
		//임시로 유저정보 삽입
		session.setAttribute("userno", 99);
		
		qnAAService.writeQnAA(qnAAService.getCompleteParam(session, qnAAParam));
		
		return "redirect:./list?curPage="+curPage;
	}
	
	@GetMapping("qna/update")
	public void qnAARevisePage(
			String curPage,
			QnAA qnAAParam,
			Model model
			) {
		Map<String, Map<String, String>> qnAQADetail = qnAAService.showQnAADetail(qnAAParam);
		
		model.addAttribute("curPage",curPage);
		model.addAttribute("qnAQADetail",qnAQADetail);
	}
	
	@PostMapping("/qna/update")
	public String qnAARevise(
			String curPage,
			QnAA qnAAParam
			) {
		
		qnAAService.reviseQnAA(qnAAParam);
		
		return "redirect:./list?curPage="+curPage;
	}
	
	@GetMapping("/qna/delete")
	public String qnAAErase(
			String curPage,
			QnAA qnAAParam
			) {
		
		qnAAService.eraseQnAAStatus(qnAAParam);
		
		return "redirect:./list?curPage="+curPage;
	}
}
