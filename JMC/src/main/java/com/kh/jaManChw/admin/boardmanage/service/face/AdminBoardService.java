package com.kh.jaManChw.admin.boardmanage.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.AdminBoard;
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

	/**
	 * Summernote내부에 사진을 넣을 때 Ajax로 파일을 서버의 "summerfile"에 저장하고
	 * basic 64형식이 아닌 image태그로 반환한다
	 * 
	 * @param multipartFile - 이미지 파일
	 */
	public JSONObject manageFile(MultipartFile multipartFile);

	/**
	 * 관리자 게시글 글쓰기
	 * 	폼필드는 DB로 저장하고 파일은 adminBoardFile+boardOption에 저장한다
	 * 
	 * @param session - userno와 abOption을 가져올 세션 객체
	 * @param adminBoardParam - 폼필드를 담아올 DTO객체
	 * @param files - 첨부파일을 담아올 변수
	 */
	public void writeAdminBoard(HttpSession session, AdminBoard adminBoardParam, MultipartFile[] files);

	/**
	 * 가져온 게시글 번호를 통해서 게시글의 상세 정보를 조회하여 반환한다
	 * 
	 * @param adminBoardParam - 게시글 번호를 가져갈 DTO객체
	 * @return 게시글의 전체 상세정보를 담아올 DTO객체
	 */
	public AdminBoard showAdminBoardDetail(AdminBoard adminBoardParam);

	/**
	 * 입력받은 정보로 해당 게시글의 정보를 수정한다
	 * 
	 * @param adminBoardParam - 수정을 위해 입력받은 정보를 담은 DTO객체
	 */
	public void reviseAdminBoard(AdminBoard adminBoardParam);

	/**
	 * 삭제버튼을 누르면 해당 게시글의 번호가 전달되고
	 *  해당 게시글의 [상태]를 "delete" 로 변경한다
	 * 
	 * @param adminBoardno - 상태를 변경할 게시글의 번호를 지정한다
	 */
	public void eraseAdminBoardStatus(int adminBoardno);


}
