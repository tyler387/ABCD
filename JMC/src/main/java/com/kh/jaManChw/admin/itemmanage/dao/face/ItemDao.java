package com.kh.jaManChw.admin.itemmanage.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.util.Paging;

public interface ItemDao {

	/**
	 * itemno를 조회하여 반환한다
	 * 
	 *@return - itemno
	 */
	public int getItemno();

	/**
	 * 판매 글 작성시 item DTO를 통해 전달된 데이터를 DB에 저장한다
	 * 
	 * @param item - 판매 상품 정보
	 */
	public void insertItem(Item item);

	/**
	 * 판매 글 작성시 옵션을 추가 했을때 itemOption DTO를 통해 전달된 데이터를 DB에 저장한다
	 * 
	 * @param itemOption - 판매 상품의 옵션 정보
	 */
	public void insertItemOption(ItemOption itemOption);

	/**
	 * 판매 글 작성시 상품의 대표 사진에 대한 정보를 DB에 저장한다
	 * 
	 * @param itemFile - 판매 상품의 대표 사진 정보
	 */
	public void insertItemFile(ItemFile itemFile);

	/**
	 * 전체 판매 게시글의 갯수를 조회한다
	 * 
	 * @return - 전페 판매 게시글의 수 
	 */
	public int selectCntAllItem();

	/**
	 * 수정, 삭제 페이지에 보여질 전체 판매글을 페이징하여 반환한다
	 * 
	 * @param paging - 판매글을 페이지네이션할 페이징 객체
	 * @return 패이징된 전체 판매글
	 */
	public List<Map<String, Object>> selectItemAll(Paging paging);

	/**
	 * 검색을 통해 필터링된 판매글의 갯수를 조회한다
	 * 
	 * @param filterMap - 입력한 필터링 조건
	 * @return 필터링된 판매글의 수 
	 */
	public int selectCntFilterItem(Map<String, String> filterMap);

	/**
	 * 검색을 통해 필터링된 전체 판매글을 페이징하여 반환한다
	 * 
	 * @param fpMap - 페이징 객체와 필터링 맵을 가져올 맵객체
	 * @return 필터링된 판매글을 페이징한 리스트
	 */
	public List<Map<String, Object>> selectItemByFilter(Map<String, Object> fpMap);

	/**
	 * itemno를 통해 itemOption테이블을 조회한다 
	 * 
	 * @param itemno - 판매 상품 번호
	 * @return 상품 옵션의 상세 정보
	 */
	public List<ItemOption> selectItemOptionDetail(int itemno);

	/**
	 * itemno를 통해 item테이블을 조회한다 
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
	 * item DTO를 통해 item테이블의 정보를 수정한다
	 * 
	 * @param itemParam - 수정할 정보를 가져올 item DTO
	 */
	public void updateItem(Item itemParam);

	/**
	 * itemno를 통해 itemOption의 정보를 DB에서 삭제한다
	 * 
	 * @param itemno - 판매 상품 정보
	 */
	public void deleteItemOption(int itemno);

	/**
	 * itemno를 통해 DB에 itemFile의 정보를 DB에서 삭제한다
	 * 
	 * @param itemno - 판매 상품 번호
	 */
	public void deleteItemFile(int itemno);

	/**
	 * itemno를 통해 DB에 판매 상품 삭제
	 * 
	 * @param itemno - 판매 상품 번호
	 */
	public void deleteItem(int itemno);

	/**
	 * itemno를 통해 DB에 상품 상태를 'delete로 변경한다'
	 * 
	 * @param itemno - 판매 상품 번호
	 */
	public void updateItemStatus(int itemno);


	



}
