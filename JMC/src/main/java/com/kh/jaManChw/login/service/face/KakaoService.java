package com.kh.jaManChw.login.service.face;


import com.kh.jaManChw.dto.Users;

public interface KakaoService {
	
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
	public Users getUserInfo(String access_Token);

	/**
	 * 카카오 로그인 로그아웃(세션 지우기)
	 * @param attribute
	 */
	public void kakaoLogout(String attribute);

}
