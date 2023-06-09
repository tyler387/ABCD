package com.kh.jaManChw.store.service.face;

import java.util.List;
import java.util.Map;

public interface StroeService {
	
	/**
	 * 유저번호로 장바구니 조회
	 * 
	 * @param userno
	 * @return 
	 */
	List<Map<String, String>> getShoppingbasketList(int userno);
	
	/**
	 * 수정된 수량 숫자와 장바구니번호를 받아서 수정
	 * 
	 * @param map
	 */
	void SbUpdate(Map<String, String> map);

}
