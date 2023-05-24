package com.kh.jaManChw.login.service.face;

import java.util.HashMap;

import com.kh.jaManChw.dto.Users;

public interface UsersService {

	/**
	 * 로그인 성공 유무
	 * @param users
	 * @return true : 로그인 성공 / false : 로그인 실패
	 */
	public boolean login(Users users);

//	/**
//	 * 
//	 * @param code
//	 * @return
//	 */
//	public String getAccessToken(String code);
//
//	/**
//	 * 
//	 * @param access_Token
//	 * @return
//	 */
//	public HashMap<String, Object> getUserInfo(String access_Token);
//
//	/**
//	 * 
//	 * @param attribute
//	 */
//	public void kakaoLogout(String attribute);
	

	

}
