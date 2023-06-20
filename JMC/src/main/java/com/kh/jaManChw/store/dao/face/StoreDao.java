package com.kh.jaManChw.store.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.dto.ItemQnAQ;
import com.kh.jaManChw.dto.ShoppingBasket;
import com.kh.jaManChw.util.Paging;

public interface StoreDao {

	public List<Map<String, Object>> selectAllShoppingbasketList(int userno);

	public void updateSbUpdate(Map<String, String> map);

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
	public List<Map<String, Object>> selectCateSectrion(@Param("type") String type, @Param("paging")Paging paging);

	/**
	 * 검색어에 따른 리스트를 가지고 온다.
	 * @param searchData - 검색어
	 * @param paging - 페이징
	 * @return       검색어에 따른 리스트
	 */
	public List<Map<String, Object>> selectSerchItem(@Param("searchData") String searchData, @Param("paging") Paging paging);

	
	/**
	 * itemno를 통해 itemOption테이블을 조회한다 
	 * 
	 * @param itemno - 판매 상품 번호
	 * @return 상품 옵션의 상세 정보
	 */
	public List<ItemOption> selectItemOptionDetail(int itemno);

	/**
	 * itemno를 통해 itemFile테이블을 조회한다 
	 * 
	 * @param itemno - 판매 상품 번호
	 * @return 상품 파일의 상세 정보
	 */
	public List<ItemFile> selectItemFileDetail(int itemno);

	/**
	 * itemno를 통해 item테이블을 조회한다 
	 * 
	 * @param - 판매 상품 번호
	 * @return 상품 파일의 상세 정보
	 */
	public Item selectItemDetail(int itemno);

	/**
	 * 
	 * @param itemQnAQ	QnAQ시에 필요한 모든 정보 값!
	 */
	public void insertItemQnA(ItemQnAQ itemQnAQ);

	/**
	 * 전달받은 파라미터를 통해 장바구니 DB에 삽입한다
	 * 
	 * @param sb - 파라미터를 받아올 DTO 객체
	 */
	public void insertShoppingBasket(ShoppingBasket sb);
	
	public void DeleteShoppingBasket(Map<String, String> map);


	
	/**
	 * 아이템 옵션 목록 출력
	 * 
	 * @return
	 */
	public List<Map<String, Object>> ItemOptionList();
	
	
	public Map<String, Object> selectOptionByOptionno(Object object);

	public List<Map<String, String>> selectBaskteno(int abc);

	public List<Map<String, String>> selectAllBuyList(String userno);

	public List<Map<String, String>> selectAllBuyDetail(Map<String, String> map);

	public Map<String, Object> selectItemQnaQ(ItemQnAQ itemQnAQ);
	


}
