package com.kh.jaManChw.admin.boardmanage.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

public interface AdminBoardDao {

	/**
	 * 관리자 게시판 옵션에 따라 전체 게시판의 글수를 조회한다
	 * 
	 * @param boardOption - notice: 공지사항 게시판 관리, event: 이벤트 게시판 관리
	 * @return 조회한 게시판의 전체 게시글 갯수
	 */
	public int selectAllCnt(String boardOption);

	/**
	 * 관리자 게시판 옵션에 따라 공지사항/이벤트 게시판에 대한 게시글을 조회한다
	 * 
	 * @param selectMap - notice: 공지사항 게시판 관리, event: 이벤트 게시판 관리
	 * @return 조회한 게시판의 전체 게시글
	 */
	public List<Map<String, String>> selectAdminBoardAllByBoardOption(Map<String, Object> selectMap);



}
