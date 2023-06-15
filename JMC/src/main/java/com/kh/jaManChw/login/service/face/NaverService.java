package com.kh.jaManChw.login.service.face;

import java.util.Map;

import com.google.gson.JsonObject;
import com.kh.jaManChw.dto.Users;

public interface NaverService {

	/**
	 * 네이버 로그인 API를 사용하기 위해 필요한 정보들을 가져온다
	 *  
	 * @return - ClentID, redirectURI 등을 포함한 apiURL을 가지고 있는 맵 객체
	 */
	public Map<String, String> getNaverApiInfo();

	/**
	 * 네이버 로그인 콜백 페이지로 이동시 콜백되면서 발생되는 code와 state를 가져온다
	 * 
	 * @param code - 콜백시 생성되는 파라미터 code
	 * @param state - 콜백시 생성되는 파라미터 state
	 * @return 완성된 토큰
	 */
	public JsonObject getNaverCallbackToken(String code, String state);

	/**
	 * 토큰을 통해서 네이버에 유저 정보를 받아온다
	 * 
	 * @param naverToken - 로그인시 생성된 토큰
	 * @return 네이버에서 받아온 유저 정보를 담은 DTO
	 */
	public Users getUserInfoFromNaver(JsonObject naverToken);

}
