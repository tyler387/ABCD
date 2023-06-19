package com.kh.jaManChw.login.dao.face;

import org.springframework.ui.Model;

import com.kh.jaManChw.dto.ProfileFile;
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

	/**
	 * 이름과 이메일로 아이디 조회하기
	 * @param users
	 * @return userId
	 */
	public Users selectIdByUserNameEmail(Users users);

	/**
	 * 아이디 행조회
	 * @param users
	 * @return userId
	 */
	public int selectcheckCntByUserId(Users users);
	
	/**
	 * 아이디로 유저 이름 조회하기
	 * @param users
	 * @return userName
	 */
	public Users selectUserNameByUserId(Users users);

	/**
	 * 비밀번호 재설정
	 * @param users
	 * @return 
	 */
	public int updateByUserPw(Users users);

	/**
	 * userid로 유저 블랙리스트 조회
	 * @param users
	 * @return 블랙리스트 유저
	 */
	public int selectStatusbyUserId(Users users);

	/**
	 * userId로 탈퇴유저 조회
	 * @param users
	 * @return 탈퇴유저
	 */
	public int selectLeaveUserByUserId(Users users);

	/**
	 * 네이버 소셜 로그인을 처음 한 경우 네이버에서 전달해준 정보를 통해 회원가입을 한다
	 *  부족한 정보는 "naver"로 삽입하여 저장한다
	 *  
	 * @param userInfo - 네이버에서 전달한 개인정보를 담은 DTO
	 */
	public void insertNaverUser(Users userInfo);

	



	

	




	
	
	

}
