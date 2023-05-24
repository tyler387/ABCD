package com.kh.jaManChw.login.dao.face;

import com.kh.jaManChw.dto.Users;

public interface UsersDao {

	/**
	 * DB에 일치하는 아이디 비밀번호 찾기
	 * @param users
	 * @return userid,userpw
	 */
	public int selectCntByUserIdPw(Users users);
	
	

}
