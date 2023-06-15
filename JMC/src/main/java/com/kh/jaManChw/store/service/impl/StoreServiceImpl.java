package com.kh.jaManChw.store.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.store.dao.face.StoreDao;
import com.kh.jaManChw.store.service.face.StoreService;
import com.kh.jaManChw.util.Paging;

@Service
public class StoreServiceImpl implements StoreService {

	
	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired StoreDao storeDao;

	@Override
	public List<Map<String, String>> getShoppingbasketList(int userno) {
		
		return storeDao.selectAllShoppingbasketList(userno);
		
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



	
	
	
	
}
