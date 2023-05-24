package com.kh.jaManChw.admin.boardmanage.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

public interface AdminBoardService {

	/**
	 * 게시판에 대한 페이징 객체 반환
	 * 
	 * @param curPage - 현재 페이지
	 * @param boardOption - 게시판 옵션
	 * @return 게시판에 대한 페이징 객체 반환
	 */
	public Paging getBoardPaging(String curPage, String boardOption);

	/**
	 * 관리자 게시판 옵션에 따라 공지사항/이벤트 게시판에 대한 게시글을 조회한다
	 * 
	 * @param boardOption - notice: 공지사항 게시판 관리, event: 이벤트 게시판 관리
	 * @param page - 페이징 객체
	 * @return 조회한 게시판의 전체 게시글
	 */
	public List<Map<String, String>> showAdminBoardListByBoardOption(String boardOption, Paging page);


}
