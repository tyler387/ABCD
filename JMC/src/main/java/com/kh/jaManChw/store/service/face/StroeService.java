package com.kh.jaManChw.store.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

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

	/**
	 * goods 상품에 대한 리스트를 가지고 온다.
	 * @param type - goods를 필터해주기 위한 타입
	 * @return goods리스트를 반환한다.
	 */
	List<Map<String, Object>> showAllGoods(String type);

	/**
	 * 페이징 하기 
	 * @param curPage
	 * @return
	 */
	Paging getPage(String curPage);

}
