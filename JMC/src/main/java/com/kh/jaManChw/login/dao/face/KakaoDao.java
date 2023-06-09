package com.kh.jaManChw.login.dao.face;

import java.util.HashMap;


import com.kh.jaManChw.dto.Users;

public interface KakaoDao {

	/**
	 * 카카오 정보 있는지 저장
	 * @param userInfo
	 * @return userInfo
	 */
	public Users findKakaoInfo(HashMap<String, Object> userInfo);

	/**
	 * 카카오 정보 삽입
	 * @param userInfo
	 */
	public void insertKakaoInfo(HashMap<String, Object> userInfo);

	

}
