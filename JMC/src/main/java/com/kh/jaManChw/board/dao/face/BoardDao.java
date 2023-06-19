package com.kh.jaManChw.board.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.dto.Board;
import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.BoardLike;
import com.kh.jaManChw.util.Paging;

public interface BoardDao {

	/**
	 * 카테고리값에 대한 페이징 객체를 조회
	 * 
	 * @param boardOptionno - 카테고리 값 
	 * @return
	 */
	public int selectCurPage(int boardOptionno);

	/**
	 * 보드 파일에 있는 사진들을 모두 조회하고 가지고 온다.
	 * 
	 * @param page - 페이징을 통해 조회 정보를 조절하기 위한 페이징 객체
	 * @return 보드 파일의 사진
	 */
	public List<BoardFile> selectAllFile(Paging page);

	/**
	 * startPage=1인 것의 글, 사진, 좋아요 수, 댓글 수, 사진 가지고 오기
	 * @return 글, 사진, 좋아요 수, 댓글 수, 사진 가지고 오기
	 */
	public Map<String, Object> selectAllDetail(int boardno);

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
	public void writeUserBoardComment(BoardComment bComment);

	/**
	 * 수정한 댓글을 DB에 업데이트 한다. 
	 * @param boardComment -boardComment에는 commentno와 수정한 댓글 내용이 담김
	 */
	public void updateUserBoardComment(BoardComment boardComment);

	/**
	 * 삭제 버튼에 따른 commentno를 가지고 가서 db에서 삭제한다.
	 * @param boardComment - 입력된 commentno 값
	 * 	맵퍼에 값은 실제 깃에 올리면 수정해야 함!!!!!!
	 */
	public void eraseUserBoardComment(BoardComment boardComment);

	/**
	 * boardOtionno에 맞는 사진들을 다 가지고 온다.
	 * @param pagingAndBoardOptionno - 
	 * @return
	 */
	public List<Map<String, Object>> selectCateAllFile(Map<String, Object> pagingAndBoardOptionno);

	/**
	 * 글 쓰기 전에 다음 boardno값을 조회하기 위한 메서드(seq.nextval)
	 * @return 다음 boardno값
	 */
	public int selectCreateBoardno();

	/**
	 * 글 쓰기 시에 작성한 내용을 삽입한다.
	 * @param board - 게시글 번호, 게시판 분류 번호, 내용  
	 * 			추후 유저번호 받아야 함....
	 */
	public void insertBoard(Board board);

	/**
	 * 
	 * @param boardFile 글 쓰기 시에 첨부했던 파일 정보
	 */
	public void insertBoardFile(BoardFile boardFile);

	/**
	 * 좋아요를 기존에 눌렀는지 조회한다.
	 * @param like
	 * @return
	 */
	public int selectReco(BoardLike like);

	public void insertReco(BoardLike like);

	public void deleteReco(BoardLike like);

	/**
	 * 전체 좋아요 개수를 조회한다 
	 * 
	 * @param boardno - 게시글 번호
	 * @return 게시글의 전체 좋아요 개수
	 */
	public int selectCntLikeAll(int boardno);

	
	/**
	 * 검색 결과에 따른 결과 보여주기
	 * @param board - boardOptionno를 담은 객체
	 * @param searchData - 검색어
	 * @return 검색어와 일치하고 boardOptionno에 일치하는 리스트 반환
	 */
	public List<Map<String, Object>> selectBoardFile(@Param("board") Board board, @Param("searchData")String searchData);





	
}
