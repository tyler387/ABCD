package com.kh.jaManChw.admin.itemmanage.service.face;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.util.Paging;

public interface ItemService {

	/**
	 * 판매글에 대한 옵션을 DTO로 추가하여 반환한다
	 * 
	 * @param optionContent - 옵션의 내용을 담아오는 배열
	 * @param optionCount - 해당 옵션의 재고수를 담아오는 배열
	 * @param extraCharge - 해당 옵션의 추가 가격을 담아오는 배열
	 * @return - 판매글에 대한 옵션 리스트
	 */
	public List<ItemOption> getItemOptionParam(String[] optionContent, int[] optionCount, int[] extraCharge);
	
	/**
	 * 입력받은 판매글 정보를 가져와 DB에 저장한다
	 * 
	 * @param itemParam - 입력받은 판매글 정보를 가져올 DTO 객체
	 * @param itemOptionParam - 입력받은 상품 옵션 정보를 가져올 List
	 * @param file - 파일을 저장할 변수
	 * @return 등록한 판매 상품 번호
	 */
	public int writeItem(Item itemParam, List<ItemOption> itemOptionParam , MultipartFile[] file);

	/**
	 * 현재 페이지를 입력받아 전체 판매글을 페이징 하는 객체를 반환한다
	 * 
	 * @param curPage - 현재 페이지를 가져올 변수
	 * @return - 판매글에 대한 페이지네이션 설정값을 가진 페이징 객체
	 */
	public Paging getItemPaging(String curPage);

	/**
	 * 수정, 삭제 페이지에 보여질 전체 판매글을 페이징하여 반환한다
	 * 
	 * @param paging - 판매글을 페이지네이션할 페이징 객체
	 * @return 패이징된 전체 판매글
	 */
	public List<Map<String, Object>> showItemListAll(Paging paging);

	/**
	 * 필터링한 결과에 대한 페이징을 할 페이징 객체를 생성한다
	 * 
	 * @param filterMap - 필터링에 대한 페이징을 하기 위한 필터링 값 
	 * @param curPage - 현재 페이지
	 * @return 생성된 페이징 객체
	 */
	public Paging getItemFilterPaging(Map<String, String> filterMap, String curPage);

	/**
	 * 필터링값과 페이징객체를 통해 필터링된 판매글의 전체 리스트를 반환한다
	 * 
	 * @param itemFilterPaging - 페이징할 페이징 객체
	 * @param filterMap - 필터링할 맵
	 * @return 
	 */
	public List<Map<String, Object>> showItemListByFilter(Paging itemFilterPaging, Map<String, String> filterMap);

	/**
	 * 판매글 번호를 통해 판매글, 판매옵션, 판매 사진의 상세 정보를 조회한다
	 * 
	 * @param itemno - 판매글 번호
	 */
	public Map<String, Object> showItemDetail(int itemno);

	/**
	 * 판매글 번호를 통해 판매글, 판매옵션, 판매 사진의 정보를 변경한다
	 * 수정된 판매글 정보를 가지 
	 * 
	 * @param itemParam - 판매글 정보
	 * @param itemOptionParam - 상품 옵션 정보
	 * @param file - 파일 정보
	 * 
	 */
	public void reviseItem(Item itemParam, List<ItemOption> itemOptionParam, MultipartFile[] itemFileParam);

	/**
	 * 판매글 번호를 통해 판매글, 판매 옵션, 판매 사진의 정보를 삭제한다
	 * 
	 * @param itemno - 판매글 번호
	 */
	public void eraseItem(int itemno);

	/**
	 * 판매 상품의 상세 정보에 삽입된 사진을 저장하고
	 * 사진을 url형태로 반환한다
	 * 
	 * @param file 상세 정보에 삽입된 사진
	 * @return
	 */
	public JSONObject itemContentPic(MultipartFile file);




}
