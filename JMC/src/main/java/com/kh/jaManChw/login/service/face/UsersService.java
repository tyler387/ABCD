package com.kh.jaManChw.login.service.face;

import org.springframework.ui.Model;

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


	/**
	 * 아이디 행 조회
	 * @param users
	 * @return 
	 */
	public int searchCntId(Users users);

	/**
	 * 유저 이름 조회하기
	 * @param users
	 * @return userName
	 */
	public Users searchName(Users users);
	
	/**
	 * 비밀번호 수정 성공 실패 확인
	 * @param users
	 * @return 1 : 수정성공 , 0 : 수정실패
	 */
	public int modifyPw(Users users);

	/**
	 * 아이디 조회하기
	 * @param users
	 * @return userId
	 */
	public Users searchId(Users users);


	

	


	



	




	

	

}
