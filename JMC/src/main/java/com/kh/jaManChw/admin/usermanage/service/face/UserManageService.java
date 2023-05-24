package com.kh.jaManChw.admin.usermanage.service.face;

import java.util.List;

import com.kh.jaManChw.dto.Users;

public interface UserManageService {


	/**
	 * 수정할 회원 전체 목록 조회
	 * 
	 * @return 회원 목록
	 */
	public List<Users> UserMgPage();

}
