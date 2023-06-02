package com.kh.jaManChw.board.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.BoardComment;
import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.util.Paging;

public interface BoardDao {

	/**
	 * 페이징 하기 
	 * @param curPage
	 * @return
	 */
	public int selectCurPage(int noCurPage);

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

}
