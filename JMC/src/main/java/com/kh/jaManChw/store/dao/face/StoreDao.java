package com.kh.jaManChw.store.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.util.Paging;

public interface StoreDao {

	List<Map<String, String>> selectAllShoppingbasketList(int userno);

	void updateSbUpdate(Map<String, String> map);

	/**
	 * 페이징 하기 
	 * @param curPage
	 * @return
	 */
	public int selectCurPage(int noCurPage);
	
	/**
	 * goods 상품에 대한 리스트를 가지고 온다.
	 * @param type - goods를 필터해주기 위한 타입
	 * @param paging 
	 * @return goods리스트를 반환한다.
	 */
	public List<Map<String, Object>> selectAllItem(@Param("type") String type,@Param("paging") Paging paging);

	
	/**
	 * 
	 * @param type - 카테고리 값
	 * @param paging - 페이징
	 * @return       - 해당 카테고리 값의 리스트를 반환한다.
	 */
	List<Map<String, Object>> selectCateSectrion(@Param("type") String type, @Param("paging") Paging paging);


}
