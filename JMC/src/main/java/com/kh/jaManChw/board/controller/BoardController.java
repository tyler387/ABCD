package com.kh.jaManChw.board.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.kh.jaManChw.board.service.face.BoardService;
import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.util.Paging;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired ServletContext context;
	@Autowired BoardService boardService;
	
	//게시글 클릭시 자동으로 9개의 사진을 역순으로 가지고 오기 (1)
		@GetMapping("/allFile")
		public void boardAllFile(
				Model model, 
				String curPage,
				@RequestParam(name = "boardOptionno", required = false, defaultValue = "0") int boardOptionno
				){
			logger.info("board/allFile   [GET]");
			logger.info("curPage : {}", curPage);
			
			Paging paging = boardService.getPage(curPage, boardOptionno);
			
			logger.info("Paging {}", paging);
			
			List<BoardFile> list = boardService.showAllFile(paging);
			
			logger.info("list : {}", list.get(0).getStoredName());	//저장된 이미지의 이름을 가지고 온다.
			logger.info("첫 게시글: {}",list.get(0).getBoardno());

			Map<String, Object> map  = new HashMap<>();
			map = boardService.showAllDetail(list.get(0).getBoardno());

			logger.info("map : {}" , map);

			model.addAttribute("paging", paging);
			model.addAttribute("list", list);
			model.addAttribute("map", map);
		}
		
		
		
	//게시글의 글, 사진, 좋아요 수, 덧글수 등을 가지고 온다.
		@GetMapping("/allFile2")
		public void boardDdtail(@RequestParam int boardno, Model model,HttpSession session) {
			Map<String, Object> map  = new HashMap<>();
			
			int chkreco;
			if(session.getAttribute("userno")==null) {
				chkreco = 0;
			}else {
				int userno = (int)session.getAttribute("userno");
				chkreco = boardService.chkReco(boardno,userno);
			}
			map = boardService.showAllDetail(boardno);
			logger.info("map의 정보는 뭘까용ㅇㅇㅇㅇㅇㅇ : {}" , map);
			model.addAttribute("map", map);
			model.addAttribute("chkReco",chkreco);
		}
		
		//사진들을 클릭 했을 때 해당 글, 사진, 좋아요 수, 댓글 수 등을 가져온다.
		@ResponseBody
		@GetMapping("/abacabc")
		public ModelAndView boardclickViewDetail(int boardno, ModelAndView mav,HttpSession session) {
//			System.out.println(boardno);
			int chkreco;
			if(session.getAttribute("userno")==null) {
				chkreco = 0;
			}else {
				int abc = (int)session.getAttribute("userno");
				chkreco = boardService.chkReco(boardno,abc);
			}
			
			Map<String, Object> map  = new HashMap<>();
			map = boardService.showAllDetail(boardno);
			logger.info("map값 : {}", map);
			mav.addObject("chkReco",chkreco);
			mav.addObject("map",map);
			mav.setViewName("/board/allFile2");
			
			return mav;
			
//			System.out.println("test");
		}
		
		
		//댓글 리스트를 가지고 오기!
		//만약에 유저 nick:댓글 내용이라면
		//list가 아니라 Map<String, Objcet>로 받아오고
		// SQL문도 조금 다르게 써야겠징
		@ResponseBody
		@GetMapping("/commentList")
		public ModelAndView boardComment(int boardno, ModelAndView mav, HttpSession session) {
			
			
			
			List<BoardComment> list = boardService.showAllComment(boardno);
			
			logger.info("commentList: {}" , list);
			
			mav.addObject("list", list);
			mav.addObject("boardno", boardno);
			mav.setViewName("/board/comment");
			
			
			return mav;
		}
		
		@ResponseBody
		@PostMapping("/commentWrite")
		public ModelAndView boardCommnetWrite(String data, int boardno, ModelAndView mav, HttpSession session) {
			logger.info("commentWrite");
			logger.info("boardComment : {}", data);
			
			logger.info("boardno {}", boardno);
			
			
			
			BoardComment bComment = new BoardComment();
			bComment.setUserno((int)session.getAttribute("userno"));
			bComment.setcContent(data);
			bComment.setBoardno(boardno);
			
			logger.info("bComment: {}", bComment);
			
			boardService.commentInput(bComment);
			
			List<BoardComment> list = boardService.showAllComment(boardno);
			
			mav.addObject("list", list);
			mav.addObject("boardno", boardno);
			mav.setViewName("/board/comment");
			
			return mav;
		}
		
		@ResponseBody
		@PostMapping("/reviseComment")
		public void boardCommentReviseReq(int commentno, String data) {
			logger.info("comment Data : {} ", data);
			logger.info("commentno : {}", commentno);
			
			BoardComment boardComment= new BoardComment();
			
			boardComment.setCommentno(commentno);
			boardComment.setcContent(data);
			
			logger.info("보드코멘트 : {} ", boardComment);
			
			boardService.reviseUserBoardComment(boardComment);
			
		}
		
		@ResponseBody
		@GetMapping("/deleteComment")
		public ModelAndView boardCommentErase(int commentno, int boardno, ModelAndView mav) {
			logger.info("delete Commentno : {} ", commentno);
			
			BoardComment boardComment = new BoardComment();
			boardComment.setCommentno(commentno);
			
			boardService.eraseUserBoardComment(boardComment);
			
			List<BoardComment> list = boardService.showAllComment(boardno);
			
			logger.info("commentList: {}" , list);
			
			mav.addObject("list", list);
			mav.addObject("boardno", boardno);
			mav.setViewName("/board/commentContent");
			
			return mav;
		}
		
		//게시글의 글, 사진, 좋아요 수, 덧글수 등을 다시 가지고 온다.
		@GetMapping("/coCountLikeCount")
		public String coCountLikeCount(@RequestParam int boardno, Model model) {
			Map<String, Object> map  = new HashMap<>();
			map = boardService.showAllDetail(boardno);
			logger.info("map : {}" , map);
			model.addAttribute("map", map);
			
			return "board/coCountLikeCount";
		}
		
//		//전체 카테고리로 가면 curPage 가장 마지막 글을 보여줌
//		@GetMapping("/allFilepage")
//		public String allFilepage(Model model, String curPage){
//			logger.info("board/allFile   [GET]");
//			logger.info("curPage : {}", curPage);
//			
//			Paging paging = boardService.getPage(curPage);
//			
//			logger.info("Paging {}", paging);
//			
//			List<BoardFile> list = boardService.showAllFile(paging);
//			
//			logger.info("list : {}", list.get(0).getStoredName());	//저장된 이미지의 이름을 가지고 온다.
//			logger.info("첫 게시글: {}",list.get(0).getBoardno());
//
//			Map<String, Object> map  = new HashMap<>();
//			map = boardService.showAllDetail(list.get(0).getBoardno());
//
//			logger.info("map : {}" , map);
//
//			model.addAttribute("paging", paging);
//			model.addAttribute("list", list);
//			model.addAttribute("map", map);
//			
//			return "board/allFile";
//		}
		
		
		//카테고리로 가면 해당 카테고리의 curPage 가장 마지막 글을 보여줌
		@ResponseBody
		@RequestMapping("/cateFilepage")
		public Map<String, Object> cateFilepage(
				Model model
				, String curPage
				, @RequestParam(name = "boardOptionno", required = false, defaultValue = "0") int boardOptionno){
			logger.info("board/allFile11   [GET]");
			logger.info("curPage11 : {}", curPage);
			
			Paging paging = boardService.getPage(curPage, boardOptionno);
			
			logger.info("Paging11 {}", paging);
			logger.info("해치웠나?1");

			logger.info(	context.getRealPath("/upload"));
			logger.info("해치웠나?2");
			List<Map<String, Object>> list = boardService.showCateAllFile(paging, boardOptionno);
			logger.info("해치웠나?3");
			logger.info("list:123123 {}", list);
			
//			logger.info("list11 : {}", list.get(0).get("STOREDNAME"));	//저장된 이미지의 이름을 가지고 온다.
			logger.info("첫 게시글: {}",list.get(0).get("BOARDNO"));

			Map<String, Object> map  = new HashMap<>();
//			logger.info("해치웠나?4");
			
			logger.info("범인인가?: {}", list.get(0).get("BOARDNO"));
//			logger.info("해치웠나?4-1");
			
			Object boardNoObject = list.get(0).get("BOARDNO");
			BigDecimal boardNoBigDecimal = (BigDecimal) boardNoObject;
		    String boardNoString = boardNoBigDecimal.toString();
			int boardNo = Integer.parseInt(boardNoString);
			
//			int boardno = Integer.parseInt((String)list.get(2).get("BOARDNO"));
//			logger.info("해치웠나?4-2");
			
			map = boardService.showAllDetail(boardNo);

			Map<String, Object> allMap = new HashMap<>();

			allMap.put("list", list);
			allMap.put("paging", paging);
			
			logger.info("map : {}" , map);

			logger.info("map-stoaredName:{}", map.get("STORED_NAME"));

			model.addAttribute("paging", paging);

			model.addAttribute("list", list);

			model.addAttribute("map", map);

			
			return allMap; 
		}
		
		@ResponseBody
		@GetMapping("/firstPage")
		public Map<String, Object> cateFirstFileno(
				int boardno
				){
			
			Map<String, Object> firstFileno = boardService.showAllDetail(boardno);
			return firstFileno;
		}
		

		@GetMapping("/write")
		public ModelAndView boardWrite(ModelAndView mav) {
			
			logger.info("boardWrite컨트롤러!");

			
//			mav.addObject("boardO	ptionno", boardOptionno);
			mav.setViewName("/board/write");		
			
			return mav;
			
		}
		
	
		
		
		
		
		//MeSSION
		//1. 보드 옵션NO가지고 오게 하기
		
		//게시글 작성 + 이미지 첨부 값 가지고 오기
		@PostMapping("/write")
		public @ResponseBody String boardWrite(String category, String boardWrite, @RequestParam(value = "file") List<MultipartFile> file, HttpSession session) {
			//카테고리 값은 도대체 어떻게 가지고 오는 가...
		    logger.info("카테고리 값: {}", category);
		    logger.info("글 작성 내용: {}", boardWrite);
		    logger.info("파일 첨부 값: {}", file);
		    
		    
		    boardService.writeBoard(category, boardWrite, file, session);
		    
//		    Paging paging = boardService.getPage(curPage);
//		    
//		    List<BoardFile> list = boardService.showAllFile(paging);
//	
//			Map<String, Object> map  = new HashMap<>();
//			map = boardService.showAllDetail(list.get(0).getBoardno());
//
//			logger.info("map : {}" , map);
//
// 			model.addAttribute("paging", paging);
//			model.addAttribute("list", list);
//			model.addAttribute("map", map);
		    
		    return "success";
		    		
		}

		
		@RequestMapping("/boardReco")
		@ResponseBody
		public Map<String, Integer> boardReco(int boardno, HttpSession session, Model model) {
			
			Map<String, Integer> allLikeInfo = boardService.recoBoard(boardno,session);
			

			return allLikeInfo;
		}
		
//		@RequestMapping("/boardRecoJoHuye")
//		@ResponseBody
//		public Map<String, Integer> boardRecoJoHuye(int boardno, HttpSession session, Model model) {
//			
//			Map<String, Integer> allLikeInfo = boardService.recoBoardJoHuye(boardno,session);
//			
//			
//			return allLikeInfo;
//		}
		
		@RequestMapping("/search")
		@ResponseBody
		public List<Map<String, Object>> boardSearch(@RequestParam(name = "boardOptionno", required = false, defaultValue = "0") int boardOptionno, String searchData, Model model) {
			
			logger.info("보드옵션 번호 {}", boardOptionno);
			
			Board board= new Board();
			board.setBoardOptionno(boardOptionno);
			
			logger.info("board: {}", board);

			List<Map<String, Object>> searchList = boardService.searchBoardFile(board, searchData);
			
			logger.info("검색어로 가져온 list: {}", searchList);
	
			logger.info("첫 게시글: {}", searchList.get(0).get("BOARDNO"));

			Map<String, Object> map  = new HashMap<>();

		
			
			Object boardNoObject = searchList.get(0).get("BOARDNO");
			BigDecimal boardNoBigDecimal = (BigDecimal) boardNoObject;
		    String boardNoString = boardNoBigDecimal.toString();
			int boardNo = Integer.parseInt(boardNoString);
			
			map = boardService.showAllDetail(boardNo);
			
//			int boardno = Integer.parseInt((String)list.get(2).get("BOARDNO"));
//			logger.info("해치웠나?4-2");
			
			map = boardService.showAllDetail(boardNo);


			logger.info("map : {}" , map);

			logger.info("map-stoaredName:{}", map.get("STORED_NAME"));

			model.addAttribute("searchList", searchList);

			model.addAttribute("map", map);

			
			return searchList; 


		}
		
		//AJAX를 통해 페이징 객체를 받아 페이지 네이션 페이지를 반환한다 
		@RequestMapping("/getPaging")
		public String getPagnation(
				Paging paging
				,Model model
				) {
			logger.info("페이징 객체: {}", paging);
			model.addAttribute("paging", paging);
			
			return "/board/paging";
		}
		
}
