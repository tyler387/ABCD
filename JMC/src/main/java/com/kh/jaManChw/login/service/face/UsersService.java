package com.kh.jaManChw.login.service.face;

import java.util.HashMap;
import java.util.List;

import com.kh.jaManChw.dto.Users;

public interface UsersService {

	/**
	 * 로그인 성공 유무
	 * @param users
	 * @return true : 로그인 성공 / false : 로그인 실패
	 */
	public boolean login(Users users);

	/**
	 * accessToken발급받기
	 * @param code
	 * @return accessToken
	 */
	public String getAccessToken(String code);

	/**
	 * 발급받은 accessToken으로 유저정보 가져오기
	 * @param access_Token
	 * @return userInfo
	 */
	public HashMap<String, Object> getUserInfo(String access_Token);

	/**
	 * 카카오 로그인 로그아웃(세션 지우기)
	 * @param attribute
	 */
	public void kakaoLogout(String attribute);

	/**
	 * 신규 회원가입
	 * @param users
	 * @return 
	 */
	public boolean IdCheck(Users users);

	/**
	 * 유저 정보 가져오기
	 * @param users
	 */
	public Users getuserInfo(Users users);




	

	

}
