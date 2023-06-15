package com.kh.jaManChw.store.dao.face;

import java.util.List;
import java.util.Map;

public interface StroeDao {

	List<Map<String, String>> selectAllShoppingbasketList(int userno);

	void updateSbUpdate(Map<String, String> map);

	/**
	 * goods 상품에 대한 리스트를 가지고 온다.
	 * @param type - goods를 필터해주기 위한 타입
	 * @return goods리스트를 반환한다.
	 */
	public List<Map<String, Object>> selectAllItem(String type);

	/**
	 * 페이징 하기 
	 * @param curPage
	 * @return
	 */
	public int selectCurPage(int noCurPage);

	void DeleteShoppingBasket(Map<String, String> map);

}
