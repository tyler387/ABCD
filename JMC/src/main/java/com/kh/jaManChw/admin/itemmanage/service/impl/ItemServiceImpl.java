package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;
import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.util.Paging;

@Service
public class ItemServiceImpl implements ItemService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemDao itemDao;
	@Autowired private ServletContext context;
	
	@Override
	public int writeItem(Map<String, String> itemParam, MultipartFile file) {

		
		//itemno 생성
		int itemno = itemDao.getItemno();
		
		logger.info("itemno: {}",itemno);
		
		//itemParam에 담긴 정보를 각 DTO로 분리해 저장한다
		// 1. item DTO
		Item item = new Item();
		item.setItemno(itemno);
		item.setItemTitle(itemParam.get("itemTitle"));
		item.setAllItemCount(Integer.parseInt(itemParam.get("allItemCount")));
		item.setItemType(itemParam.get("itemType"));
		item.setItemPrice(Integer.parseInt(itemParam.get("itemPrice")));
		item.setItemContent(itemParam.get("itemContent"));		
		
		//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
		itemDao.insertItem(item);
		
		ItemOption itemOption = null;
		
		// 2. itemOption DTO - 만약 옵션값을 넣는다면...
		if (itemParam.get("OptionContent")!=null && !"".equals(itemParam.get("OptionContent"))) {
			itemOption = new ItemOption();
			itemOption.setItemno(itemno);
			itemOption.setOptionContent(itemParam.get("OptionContent"));
			itemOption.setOptionCount(Integer.parseInt(itemParam.get("optionCount")));
			itemOption.setExtraCharge(Integer.parseInt(itemParam.get("extraCharge")));
		}
		
		//itemOption이 있는 경우는 itemOption DTO에 담긴 정보를 DB의 item테이블에 저장한다
		if (itemOption != null) {
			itemDao.insertItemOption(itemOption);
		}
		
		// 3. itemFile DTO
		ItemFile itemFile = new ItemFile();
		itemFile.setItemno(itemno);
		
		if(file.getSize()<=0) {
			return 0;
		}
		
		String storedPath = context.getRealPath("itemfile");
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		File dest = null;
		String storedFileName = null;
		
		do {
			storedFileName = UUID.randomUUID().toString().split("-")[4]+UUID.randomUUID().toString().split("-")[0];
			dest = new File(storedFolder, storedFileName);
		}while(dest.exists());
			

			
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		itemFile.setiOriginName(file.getOriginalFilename());
		itemFile.setiStoredName(storedFileName);
		itemFile.setFilesize(file.getSize());
		
		//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
		itemDao.insertItemFile(itemFile);
		
		logger.info("item: {}",item);
		logger.info("itemOption: {}",itemOption);
		logger.info("itemFile: {}",itemFile);
		
		
		return itemno;
	}
	
	@Override
	public Paging getItemPaging(String curPage) {

		int itemCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(itemCurPage, itemDao.selectCntAllItem());
	}
	
	@Override
	public List<Map<String, Object>> showItemListAll(Paging paging) {
		return itemDao.selectItemAll(paging);
	}
	
	@Override
	public Paging getItemFilterPaging(Map<String, String> filterMap, String curPage) {
		
		int itemCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemCurPage = Integer.parseInt(curPage);
		}
		
		logger.info("filterMap:{}", filterMap);
		
		return new Paging(itemCurPage, itemDao.selectCntFilterItem(filterMap));
	}
	
	@Override
	public List<Map<String, Object>> showItemListByFilter(Paging itemFilterPaging, Map<String, String> filterMap) {
		
		//필터링 맵과 페이징 객체를 같이 가져가기 위한 맵 선언
		Map<String, Object> fpMap = new HashMap<>();
		
		fpMap.put("paging", itemFilterPaging);
		fpMap.put("filter", filterMap);
		
		return itemDao.selectItemByFilter(fpMap);
	}
	
	@Override
	public void showItemDetail(int itemno) {

		//itemno를 통해  item, itemOption, itemFile테이블을 조회한다 
		//itemOption가 itemFile은 Detail이라도 하더라도 다수의 row가 존재할수 있기에
		//join하기엔 적합하지 않다고 판단이 되나, 분리하여 반환하는 경우는 
		//반환값이 여러개가 존재하게 하거나 List로 담아서 반환하는데 
		//List내부에서 item을 어느 map에 담은지 확인이 불가능하기에
		//모든 맵에 item의 정보를 가지고 있으나 그중 하나만 사용하고 
		//List는 option과 file을 위해서 만사용하는 방법을 사용하려고 한다
		List<Map<String, Object>> itemDetailList = itemDao.selectItemDetail(itemno);
		
	}
	
	@Override
	public void reviseItem(Map<String, String> itemParam) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eraseItem(int itemno) {
		// TODO Auto-generated method stub
		
	}
}
