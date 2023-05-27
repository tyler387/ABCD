package com.kh.jaManChw.login.dao.face;

import com.kh.jaManChw.dto.Users;

public interface UsersDao {

	/**
	 * DB에 일치하는 아이디 비밀번호 찾기
	 * @param users
	 * @return userid,userpw
	 */
	public int selectCntByUserIdPw(Users users);

	/**
	 * DB에서 role 조회하기
	 * @param users
	 * @return role
	 */
	public String selectroleByuseridpw(Users users);

	/**
	 * 중복 아이디 검사
	 * @param users
	 * @return
	 */
	public int selectCntByUserId(String userId);
	/**
	 * 신규 유저 회원가입
	 * @param users
	 */
	public void insertUsers(Users users);

	/**
	 * 로그인한 유저 아이디로 유저 정보 조회
	 * @return usersinfo
	 */
	public Users selectuserByUserId(Users users);



	
	
	

}
