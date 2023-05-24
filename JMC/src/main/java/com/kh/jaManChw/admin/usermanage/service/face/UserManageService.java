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
	public List<Users> getUserMgFiltering(Map<String, String> map);

	/**
	 * 페이징 수 가져오기
	 * @param curPage
	 * @return
	 */
	public Paging getpaging(String ccurpage);

}
