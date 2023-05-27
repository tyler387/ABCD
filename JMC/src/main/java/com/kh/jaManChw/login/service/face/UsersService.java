package com.kh.jaManChw.login.service.face;

import com.kh.jaManChw.dto.Users;

public interface UsersService {

	/**
	 * 로그인 성공 유무
	 * @param users
	 * @return true : 로그인 성공 / false : 로그인 실패
	 */
	public boolean login(Users users);

	/**
	 * 신규 회원가입
	 * @param users
	 * @return 
	 */
	public int IdCheck(String userId);

	/**
	 * 유저 정보 가져오기
	 * @param users
	 */
	public Users getuserInfo(Users users);

	/**
	 * 회원가입 하기
	 * @param users
	 */
	public void join(Users users);

	




	

	

}
