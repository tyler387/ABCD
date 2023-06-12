package com.kh.jaManChw.login.service.face;

import org.springframework.ui.Model;

import com.kh.jaManChw.dto.ProfileFile;
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

	/**
	 * 블랙리스트 유저로그인 
	 * @param users
	 * @return true : 로그인 차단 
	 */
	public boolean blackLogin(Users users);

	/**
	 * 탈퇴 유저 로그인
	 * @param users
	 * @return true : 로그인 차단
	 */
	public boolean leaveLogin(Users users);

	/**
	 * 네이버 소셜로 로그인한 경우 회원가입 되어 있는 회원인지 확인한다
	 * 
	 * @param userId - 소셜로그인을 시도 했을때 처음에 생성된 유저의 id값
	 * @return 1 : 이미 소셜로그인을 시도한적이 있는 회원, 0: 소셜로그인을 처음 시도하는 회원
	 */
	public int isNaverUser(String userId);

	/**
	 * 네이버 소셜로 로그인 한 경우 회원가입 되어 있지 않다면 회원가입을 진행한다
	 * 
	 * @param userInfo - 회원가입할 정보를 가져올 DTO
	 */
	public void joinUsersNaver(Users userInfo);




	

	


	



	




	

	

}
