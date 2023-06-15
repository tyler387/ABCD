package com.kh.jaManChw.store.service.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.util.Paging;

public interface StoreService {
	
	/**
	 * 유저번호로 장바구니 조회
	 * 
	 * @param userno
	 * @return 
	 */
	public List<Map<String, String>> getShoppingbasketList(int userno);
	
	/**
	 * 수정된 수량 숫자와 장바구니번호를 받아서 수정
	 * 
	 * @param map
	 */
	public void SbUpdate(Map<String, String> map);

	/**
	 * 페이징 하기 
	 * @param curPage
	 * @return
	 */
	public Paging getPage(String curPage);

	/**
	 * goods 상품에 대한 리스트를 가지고 온다.
	 * @param type - goods를 필터해주기 위한 타입
	 * @param searchData 검색어 값
	 * @param paging  페이징
	 * @return goods리스트를 반환한다.
	 */
	public List<Map<String, Object>> showAllGoods(String type, String searchData, Paging paging);

	/**
	 * 해당 아이템에 대한 상세 정보를 가지고 온다.
	 * @param itemno - 아이템번호
	 * @return 아이템에 대한 상세 정보들
	 */
	public Map<String, Object> showDetailItem(int itemno);




}
