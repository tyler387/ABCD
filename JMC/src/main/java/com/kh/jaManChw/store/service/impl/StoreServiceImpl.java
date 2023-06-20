package com.kh.jaManChw.store.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.dto.ItemQnAQ;
import com.kh.jaManChw.dto.ShoppingBasket;
import com.kh.jaManChw.store.dao.face.StoreDao;
import com.kh.jaManChw.store.service.face.StoreService;
import com.kh.jaManChw.util.Paging;

@Service
public class StoreServiceImpl implements StoreService {

	
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StoreDao storeDao;

	@Override
	public List<Map<String, Object>> getShoppingbasketList(int userno) {
		
		List<Map<String, Object>> map = storeDao.ItemOptionList();
		
		List<Map<String, Object>> map2 = storeDao.selectAllShoppingbasketList(userno);
		
		logger.info("map2 출력 {}", map2);
		logger.info("쇼핑옵션 들어가기직전");
		for(Map<String, Object> m : map2) {
//			if(m.get("ITEM_OPTIONNO") != null || !"".equals(m.get("ITEM_OPTIONNO"))) {
			if(m.get("ITEM_OPTIONNO") != null) {
				logger.info("쇼핑옵션 들어가기직전1");
				logger.info("쇼핑옵션 들어가기직전1 맵에 담긴 옵션 값 {}", m.get("ITEM_OPTIONNO"));
//			int optionno = (int)m.get("ITEM_OPTIONNO");
			logger.info("쇼핑옵션 들어가기직전2");
//			logger.info("optionno 출력 {}", optionno);
			m.put("ITEM_OPTION", storeDao.selectOptionByOptionno(m.get("ITEM_OPTIONNO")));
			logger.info("map2 출력 {}", map2);
			}
		}
		
//		logger.info("아이템옵션 목록 {}", map);
		logger.info("장바구니 목록 {}", map2);
//		logger.info("아이템옵션 목록 {}");
		return map2;
		
	}

	@Override
	public void SbUpdate(Map<String, String> map) {
		
		storeDao.updateSbUpdate(map);
		
	}

	@Override
	public Paging getPage(String curPage) {
		int noCurPage=0;
		if(curPage !=null && !"".equals(curPage)) {
			noCurPage = Integer.parseInt(curPage);
		}
		logger.info("ServiceCurPage : {}", noCurPage);

		return new Paging(noCurPage, storeDao.selectCurPage(noCurPage), 8, 10);
	}
	
	@Override
	public List<Map<String, Object>> showAllGoods(String type, String searchData, Paging paging ) {
		
		//if (type.equals("goods") || type.equals("material"))
		//검색어 없이 그냥 전체 조회를 했을 때
		if (type.equals("goods")&& searchData == null) {	
			
			return storeDao.selectAllItem(type, paging);
		}
		//검색어가 존재했을 때 검색어로 조회하기
		else if(type.equals("goods")&& searchData != null){
			
			return storeDao.selectSerchItem(searchData, paging);
			
		}
		//goods키워드를 제외한 즉, 세부 카테고리 전체 보기
		return storeDao.selectCateSectrion(type, paging);
	}

	@Override
	public Map<String, Object> showDetailItem(int itemno) {

		//각자에 맞는 List<DTO>를 맵으로 넣으라
		
		List<ItemOption> itemOptionDetailList = storeDao.selectItemOptionDetail(itemno);
		List<ItemFile> itemFileDetailList = storeDao.selectItemFileDetail(itemno);
		Item itemDetail = storeDao.selectItemDetail(itemno);
		
		Map<String, Object> detailItem = new HashMap<>();
		
		detailItem.put("itemDetail", itemDetail);
		detailItem.put("itemOptionDetailList", itemOptionDetailList);
		detailItem.put("itemFileDetailList", itemFileDetailList);

		return detailItem;
	}


	@Override
	public List<ShoppingBasket> getsbListParam(String[] itemOptionno, String[] sbItemCount, int itemno, int userno) {
		
		List<ShoppingBasket> sbList = new ArrayList<>();
		
		for(var i = 0 ; i < itemOptionno.length; i++) {
			ShoppingBasket sb = new ShoppingBasket();
			sb.setItemno(itemno);
			sb.setUserno(userno);
			sb.setSbItemCount(Integer.parseInt(sbItemCount[i]));
			sb.setItemOptionno(Integer.parseInt(itemOptionno[i]));
			
			sbList.add(sb);
		}
		
		return sbList;
	}
	
	@Override
	public void writeShoppingBasket(List<ShoppingBasket> sbList) {
		for(ShoppingBasket sb : sbList) {
			
			storeDao.insertShoppingBasket(sb);
			
		}
	}

	@Override
	public void writeItemQnA(String modalTitle, String modalContent, int itemno, HttpSession session) {

		//문의 테이블에 내용 넣어 주기
		
		ItemQnAQ itemQnAQ = new ItemQnAQ();
		
		itemQnAQ.setItemno(itemno);
		itemQnAQ.setUserno((int)session.getAttribute("userno"));
		logger.info("유저번호{}", (int)session.getAttribute("userno"));
		itemQnAQ.setIqTitle(modalTitle);
		itemQnAQ.setIqContent(modalContent);
		
		//굳 원하는 값 잘 가지고 들어 옴
		logger.info("아이템QnAQ의 값: {}", itemQnAQ );
		
		storeDao.insertItemQnA(itemQnAQ);
		
	}
	 
	@Override
	public void Shoppingbasketerase(Map<String, String> map) {
		
		storeDao.DeleteShoppingBasket(map);
	}
	
	@Override
	public List<Map<String, String>> getbasketno(int abc) {
		return storeDao.selectBaskteno(abc);
	}
	@Override
	public List<Map<String, String>> getBuyList(String userno) {
		return storeDao.selectAllBuyList(userno);
	}
	
	@Override
	public List<Map<String, String>> getBuyDetail(Map<String, String> map) {
		
		return storeDao.selectAllBuyDetail(map);
	}

	@Override
	public Map<String, Object> getCommentDetail(ItemQnAQ itemQnAQ) {

		return storeDao.selectItemQnaQ(itemQnAQ);
	}
	
}
