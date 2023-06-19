package com.kh.jaManChw.board.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.BoardLike;
import com.kh.jaManChw.util.Paging;

public interface BoardService {

	/**
	 * 현재 페이지와 카테고리값에 대한 페이징 객체를 조회
	 * @param curPage - 현재 페이지 
	 * @param boardOptionno - 카테고리 값 
	 * @return
	 */
	public Paging getPage(String curPage, int boardOptionno);

	/**
	 * 보드 파일에 있는 사진들을 모두 조회하고 가지고 온다.
	 * 
	 * @param page 페이지를 제한할 페이징 객체
	 * @return 보드 파일의 사진
	 */
	public List<BoardFile> showAllFile(Paging page);

	/**
	 * startPage=1인 것의 글, 사진, 좋아요 수, 댓글 수, 사진 가지고 오기
	 * @return 글, 사진, 좋아요 수, 댓글 수, 사진 가지고 오기
	 */
	public Map<String, Object> showAllDetail(int boardno);

	
	/**
	 * boardno에 맞는 댓글 리스트를 가지고 온다.
	 * @param boardno 에 해당하는 boardno
	 * @return boardno에 관련된 댓글 리스트
	 */
	public List<BoardComment> showAllComment(int boardno);

	/**
	 * 덧글을 INSERT
	 * @param bComment - boardno와 cContet값이 담김(추후 댓글작성자 정보도 담아야 할 듯)
	 */
	public void commentInput(BoardComment bComment);

	/**
	 * 수정한 댓글을 DB에 업데이트 한다. 
	 * @param boardComment -boardComment에는 commentno와 수정한 댓글 내용이 담김
	 */
	public void reviseUserBoardComment(BoardComment boardComment);

	
	/**
	 * 삭제 버튼에 따른 commentno를 가지고 가서 db에서 삭제한다.
	 * @param boardComment - 입력된 commentno 값
	 */
	public void eraseUserBoardComment(BoardComment boardComment);

	/**
	 * boardOtionno에 맞는 사진들을 다 가지고 온다.
	 * @param paging
	 * @param boardOtionno
	 * @return
	 */
	public List<Map<String, Object>> showCateAllFile(Paging paging, int boardOptionno);

	/**
	 * 작성한 글과 사진들을 DB에 insert한다.
	 * @param boardWrite   작성된 글
	 * @param file          첨부한 파일
	 * @param session 
	 */
	public void writeBoard(String category, String boardWrite, List<MultipartFile> file, HttpSession session);
	
	/**
	 * 좋아요를 누른다.
	 * @param boardno 게시글 번호
	 * @param session 세션
	 * @return
	 */
	public Map<String, Integer> recoBoard(int boardno, HttpSession session);

//	/**
//	 * @param boardno
//	 * @param session
//	 * @return
//	 */
//	public Map<String, Integer> recoBoardJoHuye(int boardno, HttpSession session);

	/**
	 * 검색 결과에 따른 결과 보여주기
	 * @param searchData - 검색어
	 * @return	검색어와 일치하는 fileList
	 */
	public List<Map<String, Object>> searchBoardFile(Board board, String searchData);

	/**
	 * 해당 게시글에 로그인 한 사용자가 좋아요를 눌렀는지 조회한다.
	 * @param boardno
	 * @param userno
	 * @return
	 */
	public int chkReco(int boardno, int userno);

	



	
	

}
