package com.kh.jaManChw.store.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.ShoppingBasket;
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

	/**
	 * 배열로 된 파라미터 쌍으로 DTO에 한번씩 담아 DTO List를 반환한다
	 * 
	 * @param itemOptionno - 상품 옵션 번호
	 * @param sbItemCount - 상품 옵션 주문 갯수
	 * @param itemno - 상품 번호
	 * @param userno - 유저 번호 
	 * @return
	 */
	public List<ShoppingBasket> getsbListParam(String[] itemOptionno, String[] sbItemCount, int itemno, int userno);

	/**
	 * 전달받은 파라미터를 통해 장바구니 DB에 삽입한다
	 * 
	 * @param sbList - 파라미터를 받아올 List객체
	 */
	public void writeShoppingBasket(List<ShoppingBasket> sbList);




}
