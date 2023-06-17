package com.kh.jaManChw.admin.usermanage.service.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

public interface UserManageService {


	/**
	 * 수정할 회원 전체 목록 조회
	 * @param paging 
	 * @return 회원 목록
	 */
	public List<Users> UserMgPage(Paging paging);

	/**
	 * 필터를 통해 회원 검색
	 * @param map 
	 * 
	 * @return
	 */
	public List<Users> getUserMgFiltering(Map<String, Object> map);

	/**
	 * 페이징 수 가져오기
	 * @param curPage
	 * @return
	 */
	public Paging getpaging(String ccurpage);

	/**
	 * 회원 수정 하기전에 회원 정보 가져오기
	 * @param userno
	 * @return 
	 */
	public Map<String, String> getUserData(int userno);
	
	/**
	 * userno로 해당 회원 탈퇴처리
	 * 	
	 * @param userno
	 */
	public void reviseUserMgWithdraw(int userno);
	
	/**
	 * 필터된 페이지 목록 조회
	 * @param ccurpage
	 * @return
	 */
	public Paging getFilterPaging(String ccurpage, Map<String, Object> map);
	
	/**
	 * 회원 블랙리스트 설정
	 * @param userno
	 */
	public void reviseUserBlackUpdate(int userno);

	/** 
	 * 회원 정지 설정
	 * @param userno
	 */
	public void reviseUserBlackStop(int userno);

	/**
	 * 해당 유저 정보 수정
	 * 
	 * @param hashmap
	 */
	public void reviseUserMgUpdate(Map<String, Object> map);
	

}
